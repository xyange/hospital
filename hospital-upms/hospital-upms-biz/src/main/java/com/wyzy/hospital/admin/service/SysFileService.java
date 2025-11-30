

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.file.UploadFile;
import com.wyzy.hospital.admin.api.entity.SysFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件管理
 *
 * @author Luckly
 * @date 2019-06-18 17:18:42
 */
public interface SysFileService extends IService<SysFile> {

	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	UploadFile uploadFile(MultipartFile file);

	/**
	 * 读取文件
	 * @param bucket 桶名称
	 * @param fileName 文件名称
	 * @param response 输出流
	 */
	void getFile(String bucket, String fileName, HttpServletResponse response);

	/**
	 * 删除文件
	 * @param id
	 * @return
	 */
	Boolean deleteFile(Long id);

	/**
	 * 删除文件
	 * @param fileName
	 * @return
	 */
	Boolean removeFile(@RequestParam String fileName);

}
