
package com.wyzy.hospital.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.app.api.dto.AppEbookDTO;
import com.wyzy.hospital.app.api.dto.ContentDTO;
import com.wyzy.hospital.app.api.dto.EbookDTO;
import com.wyzy.hospital.app.api.entity.Book;
import com.wyzy.hospital.app.api.entity.Chapter;
import com.wyzy.hospital.app.exception.GlobalException;
import com.wyzy.hospital.app.mapper.BookMapper;
import com.wyzy.hospital.app.service.BookService;
import com.wyzy.hospital.app.service.ChapterService;
import com.wyzy.hospital.common.core.util.BeanUtil;
import com.wyzy.hospital.common.core.util.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 电子书
 *
 * @author aqie
 * @date 2021-05-25 16:09:00
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

	@Autowired
	private ChapterService chapterService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean save(EbookDTO ebookDTO) {
		Book book = new Book();
		BeanUtil.copyProperties(ebookDTO, book);
		boolean save;
		try{
			save = save(book);
		} catch (DuplicateKeyException e) {
			throw new GlobalException(CodeMsg.EBOOK_EXIT_ERROR);
		}
		if(save){
			for (ContentDTO contentDTO :ebookDTO.getContentsTree()){
				insertTreeContent(contentDTO,book.getBookId(),0L);
			}
			return true;
		}
		return false;
	}

	@Override
	public EbookDTO detail(Long id) {
		Book book = getById(id);
		EbookDTO dto = new EbookDTO();
		BeanUtil.copyProperties(book, dto);
		/**
		 * 根据图书id 查询章节列表
		 */
		List<Chapter> chapterList = chapterService.getChapterListByBookId(book.getBookId());

		//目标List
		List<ContentDTO> contentVOList=new ArrayList<>();
		// 辅助队列 1
		Queue<ContentDTO> contentVOQueue=new ArrayDeque<>();
		//辅助队列 2
		Queue<Chapter> contentsQueue=new ArrayDeque<>();
		//顶级目录入队
		for (Chapter contents : chapterList) {
			if (contents.getPid() == 0) {
				contentsQueue.add(contents);
				contentVOQueue.add(new ContentDTO());
			}
		}
		while (contentsQueue.size()>0){
//            System.out.println("asd");
			Chapter top=contentsQueue.remove();
			ContentDTO contentVO=contentVOQueue.remove();
			contentVO.setFileName(top.getFileName());
			contentVO.setLabel(top.getLabel());
			contentVO.setText(top.getText());
			contentVO.setPid(top.getPid());
			List<ContentDTO> childrenChapterVoList=new ArrayList<>();
			boolean haschild=false;
			for(Chapter contents : chapterList) {
//                 System.out.println(contents.getPid() +"  :  "+top.getId());
				if(contents.getPid().equals(top.getId())) {
					haschild=true;
					ContentDTO contentVO1=new ContentDTO();
					List<ContentDTO> fakeList=new ArrayList<>();
					contentVO1.setChildren(fakeList);
					childrenChapterVoList.add(contentVO1);
					contentsQueue.add(contents);
					contentVOQueue.add(contentVO1);

				}
			}
			if(haschild||top.getPid().equals(0)){
				contentVO.setChildren(childrenChapterVoList);
				contentVOList.add(contentVO);
			}
		}
		dto.setContentsTree(contentVOList);
		return dto;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteEbookById(Long id) {
		Book one = getBookIdById(id);
		boolean b1 = chapterService.removeChapterById(one.getBookId());
		boolean b = this.removeById(id);
		return b && b1;
	}

	@Override
	public Book getBookIdById(Long id) {
		Book one = this.getOne(new LambdaQueryWrapper<Book>().select(Book::getId, Book::getBookId).eq(Book::getId, id));
		return one;
	}

	@Override
	public IPage<AppEbookDTO> bookPage(IPage<AppEbookDTO> page, AppEbookDTO book) {
		return baseMapper.bookPage(page, book);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean increaseView(Long id) {
		return baseMapper.increaseView(id);
	}

	private void insertTreeContent(ContentDTO contentDTO, String bookId, Long parentId){
		Chapter chapter = new Chapter();
		BeanUtil.copyProperties(contentDTO, chapter);
		chapter.setBookId(bookId);
		chapter.setPid(parentId);
		chapterService.save(chapter);
		if(contentDTO.getChildren().size()>0){
			for(ContentDTO childrenContentDto :contentDTO.getChildren()){
				insertTreeContent(childrenContentDto,bookId,chapter.getId());
			}
		}
	}
}
