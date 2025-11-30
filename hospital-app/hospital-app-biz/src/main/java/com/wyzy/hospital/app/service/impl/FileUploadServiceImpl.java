package com.wyzy.hospital.app.service.impl;

import com.wyzy.hospital.app.service.FileUploadService;
import com.wyzy.hospital.app.api.vo.UploadFileInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Author aqie
 * Date on 2021/5/25  11:36
 * @Function:
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
	//获取文件存储路径
	@Value("${upload.uploadFolder}")
	private String upfilePath;

	@Value("${upload.staticPath}")
	private String staticPath;

	@Value("${upload.serverUrl}")
	private String serverUrl;


	@Override
	public UploadFileInfo fileUploadOne(MultipartFile file, String fileType) {

		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		// 获得原始文件名+格式
		String fileName = file.getOriginalFilename();
		//截取文件名
		String fname = fileName.substring(0, fileName.lastIndexOf("."));
		//截取文件格式
		String format = fileName.substring(fileName.lastIndexOf(".") + 1);
		//获取当前时间(精确到毫秒)
		long MS = System.currentTimeMillis();
		String timeMS = String.valueOf(MS);
		//原文件名+当前时间戳作为新文件名
		String newFileName = fname + "_" + timeMS + "." + format;
		String filelocalPath = "";
		char pathChar = upfilePath.charAt(upfilePath.length() - 1);
		if (pathChar == '/') {
			filelocalPath = upfilePath;
		} else {
			filelocalPath = upfilePath + "/";
		}
		File f = new File(filelocalPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (!file.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream(filelocalPath + newFileName);
				InputStream in = file.getInputStream();
				//InputStream in = request.getInputStream();
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = in.read(bytes)) != -1) {
					fos.write(bytes, 0, len);
				}
				fos.close();
				in.close();
				UploadFileInfo fileInfo = UploadFileInfo.builder().path(serverUrl + staticPath + newFileName)
						.filename(newFileName)
						.localPath(filelocalPath + newFileName).build();


				return fileInfo;
			} catch (Exception e) {

				log.error("ERROR",  e);
			}
		}
		return null;

	}

	/**
	 * 删除单个文件
	 * @param   sPath    被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

}
