package com.wyzy.hospital.app.service;

import com.wyzy.hospital.app.api.vo.UploadFileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author aqie
 * Date on 2021/5/25  11:36
 * @Function:
 */
public interface FileUploadService {
	/**
	 * 文件本地上传
	 * @param file
	 * @param fileType
	 * @return
	 */
	UploadFileInfo fileUploadOne(MultipartFile file, String fileType);
}
