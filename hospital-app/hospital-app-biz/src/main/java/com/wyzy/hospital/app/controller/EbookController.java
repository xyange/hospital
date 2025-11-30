package com.wyzy.hospital.app.controller;

import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.file.UploadFile;
import com.wyzy.hospital.admin.api.feign.RemoteFileService;
import com.wyzy.hospital.app.api.dto.ContentDTO;
import com.wyzy.hospital.app.api.dto.EbookDTO;
import com.wyzy.hospital.app.service.BookService;
import com.wyzy.hospital.app.service.FileUploadService;
import com.wyzy.hospital.app.utils.EpubUtil;
import com.wyzy.hospital.common.core.util.Func;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.domain.TOCReference;
import org.apache.commons.io.IOUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.wyzy.hospital.admin.api.Constant.OSS_URL;

/**
 * @author aqie
 */
@Slf4j
@RestController
@RequestMapping("ebook")
@RequiredArgsConstructor
public class EbookController {

	private final RemoteFileService remoteFileService;

	private final FileUploadService fileUploadService;

	private final BookService bookService;

	private String unzipPath = "/app/upload/unzip";

	private String unzipFolder = "D:/upload/unzip/";


	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param book 电子书
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	public R getBookPage(Page page, com.wyzy.hospital.app.api.entity.Book book) {
		return R.ok(bookService.page(page, Wrappers.query(book)));
	}


	/**
	 * 通过id查询电子书
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}")
	public R<EbookDTO> getById(@PathVariable("id" ) Long id) {
		return R.ok(bookService.detail(id));
	}


	/**
	 * 修改电子书
	 * @param book 电子书
	 * @return R
	 */
	@ApiOperation(value = "修改电子书", notes = "修改电子书")
	@SysLog("修改电子书" )
	@PutMapping
	public R updateById(@RequestBody com.wyzy.hospital.app.api.entity.Book book) {
		return R.ok(bookService.updateById(book));
	}


	/**
	 * 上传电子书 并解析
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/uploadEpub")
	public R<EbookDTO> uploadEpub(MultipartFile file) throws Exception{
		String typeName="book";
		if(!(file==null|| Objects.equals(file.getOriginalFilename(), ""))){
			String fileOriginalName = file.getOriginalFilename();
			// upload to oss

			//获取图书存储相对路径
			String saveUrl= fileUploadService.fileUploadOne(file, typeName).getLocalPath();
			if(Func.isBlank(saveUrl)){
				return R.failed("上传失败");
			}
			String filename = saveUrl.substring(saveUrl.lastIndexOf("/")+1);
			String bookId = saveUrl.substring(saveUrl.lastIndexOf('/')+1,saveUrl.lastIndexOf('.'));
			String unzipPathNew = unzipPath + "/" + bookId + "/";

			//解析图书
			Book book=null;
			try{
				book= EpubUtil.getEpubBook(saveUrl);
			}catch (Exception e){
				e.printStackTrace();
				return R.failed("图书解析失败" + e.getMessage());
			}
			EbookDTO bookDTO = new EbookDTO();
			bookDTO.setBookId(bookId);
			Metadata metadata=book.getMetadata();
			bookDTO.setTitle(book.getTitle());
			bookDTO.setOriginalName(fileOriginalName);

			List<Author> authors=metadata.getAuthors();
			StringBuilder stringBuilder=new StringBuilder();
			for (int i=0;i<authors.size();i++){
				Author curAuthor=authors.get(i);
				stringBuilder.append(curAuthor.getFirstname()).append(" ").append(curAuthor.getLastname());
				if(i<authors.size()-1){
					stringBuilder.append(",");
				}
			}
			bookDTO.setAuthor(stringBuilder.toString());

			bookDTO.setLanguage(metadata.getLanguage());
			List<String> publishers=metadata.getPublishers();
			StringBuilder publishersNameBuilder=new StringBuilder();
			for (int i=0;i<publishers.size();i++){
				publishersNameBuilder.append(publishers.get(i));
				if(i<authors.size()-1){
					stringBuilder.append(",");
				}
			}
			bookDTO.setPublisher(publishersNameBuilder.toString());

			bookDTO.setPath(saveUrl);
			bookDTO.setFileName(filename);

			// todo 解压
			ZipUtil.unzip(saveUrl, unzipFolder +  File.separator + bookId);

			bookDTO.setUnzipPath(unzipPathNew);
			// 根文件目录前缀
			String folderPrefix="";
			String opfPath=book.getOpfResource().getHref();
			if (opfPath.indexOf('/')>-1){
				folderPrefix=opfPath.substring(0,opfPath.indexOf('/'));
				folderPrefix+='/';
			}
			if(book.getCoverImage()!=null){
				bookDTO.setCover(unzipPathNew+folderPrefix+book.getCoverImage().getHref());
			}
			bookDTO.setRootFile(unzipPathNew+opfPath);

			//生成目录
			List<ContentDTO> contentVOList=new ArrayList<>();
			List<TOCReference> topTocRefrenceList=book.getTableOfContents().getTocReferences();

			for(TOCReference tocReference : topTocRefrenceList){
				ContentDTO contentVO=new ContentDTO();
				contentVO.setText(unzipPathNew+folderPrefix+tocReference.getCompleteHref());

				contentVO.setLabel(fileOriginalName);
				contentVO.setLabel(tocReference.getTitle());
				contentVO.setFileName(bookDTO.getFileName());
				List<ContentDTO> chidrenContentList=new ArrayList<>();

				if (tocReference.getChildren().size()>0){
					generateContentsTree(tocReference.getChildren(),
							chidrenContentList,
							unzipPathNew,
							folderPrefix,
							bookDTO.getFileName()
					);
				}
				contentVO.setChildren(chidrenContentList);
				contentVOList.add(contentVO);
			}
			bookDTO.setContentsTree(contentVOList);

			// todo 测试新增
			bookService.save(bookDTO);
			return R.ok(bookDTO);

		}else {
			return R.failed("上传失败");
		}
	}

	/**
	 * 新增电子书 + 电子书章节
	 * @param ebookDTO 电子书
	 * @return R
	 */
	@ApiOperation(value = "新增电子书", notes = "新增电子书")
	@SysLog("新增电子书" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('app_book_add')")
	public R<String> save(@RequestBody EbookDTO ebookDTO) {
		boolean save = bookService.save(ebookDTO);
		if (save) {
			return R.ok("新增图书成功");
		} else {
			return R.failed("新增图书失败");
		}
	}


	/**
	 * 根据图书id 删除电子书
	 * @return
	 */
	@DeleteMapping("/{id}")
	public R<Boolean> deleteEbook(@PathVariable("id") Long id){
		boolean b = bookService.deleteEbookById(id);
		return R.ok(b);
	}




	/**
	 * 上传电子书到阿里云 todo 并解析
	 */
	@PostMapping("/uploadEpubToOss")
	public R<Book> uploadEpubToOss(MultipartFile file) throws Exception {
		// upload to oss
		R<UploadFile> uploadResponse = remoteFileService.upload(file);
		if(!uploadResponse.success()){
			return R.failed("上传失败");
		}
		UploadFile uploadFile = uploadResponse.getData();
		//解析图书
		Book book=null;
		try{
			book= EpubUtil.getEpubBookFormOss(OSS_URL + uploadFile.getFileName());
		}catch (Exception e){
			e.printStackTrace();
			return R.failed("图书解析失败" + e.getMessage());
		}
		return R.ok(book);
	}


	private String readJson(String jsonSrc) {
		String json = "";
		try {
			//File jsonFile = ResourceUtils.getFile(jsonSrc);
			//json = FileUtils.re.readFileToString(jsonFile);
			//换个写法，解决springboot读取jar包中文件的问题
			InputStream stream = getClass().getClassLoader().getResourceAsStream(jsonSrc.replace("classpath:", ""));
			json = IOUtils.toString(stream);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		return json;
	}

	private void generateContentsTree(List<TOCReference> tocReferences,
									  List<ContentDTO> contentVOList,
									  String unzipPath,
									  String folderPrefix,
									  String fileName){

		for(TOCReference tocReference :tocReferences){
			ContentDTO contentVO=new ContentDTO();
			List<ContentDTO> childrenContentList=new ArrayList<>();
			contentVO.setLabel(tocReference.getTitle());
			contentVO.setText(unzipPath+folderPrefix+tocReference.getCompleteHref());
			contentVO.setFileName(fileName);
			if (tocReference.getChildren().size()>0){
				generateContentsTree(tocReference.getChildren(),
						childrenContentList,
						unzipPath,
						folderPrefix,
						fileName);
			}
			contentVO.setChildren(childrenContentList);
			contentVOList.add(contentVO);

		}
	}

	public static void main(String[] args) {
		String fileName = "http://192.168.0.126:9999/app/upload/1_1621925501541.jpg";
		System.out.println(fileName.substring(fileName.lastIndexOf("/")+1));
		System.out.println(fileName.substring(fileName.lastIndexOf('/')+1,fileName.lastIndexOf(".")));;
	}
}
