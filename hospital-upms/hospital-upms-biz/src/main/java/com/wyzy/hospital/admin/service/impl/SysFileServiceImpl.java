/*
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the wyzy.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author:  wyzy
 */
package com.wyzy.hospital.admin.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.amazonaws.services.s3.model.S3Object;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.file.UploadFile;
import com.wyzy.hospital.admin.api.entity.SysFile;
import com.wyzy.hospital.admin.exception.GlobalException;
import com.wyzy.hospital.admin.mapper.SysFileMapper;
import com.wyzy.hospital.admin.service.SysFileService;
import com.wyzy.hospital.admin.utils.ContentTypeUtil;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.oss.OssProperties;
import com.wyzy.hospital.common.oss.service.OssTemplate;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件管理
 *
 * @author Luckly
 * @date 2019-06-18 17:18:42
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

	private final OssProperties ossProperties;

	private final OssTemplate minioTemplate;

	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@Override
	public UploadFile uploadFile(MultipartFile file) {
		String fileName = IdUtil.simpleUUID() + StrUtil.DOT + FileUtil.extName(file.getOriginalFilename());
		UploadFile uploadFile = UploadFile.builder()
				.fileName(fileName)
				.bucketName(ossProperties.getBucketName())
				.url(String.format("/admin/sys-file/%s/%s", ossProperties.getBucketName(), fileName))
				.build();


		String contentType = ContentTypeUtil.getcontentType(fileName.substring(fileName.lastIndexOf(".")));

		try {
			minioTemplate.putObject(ossProperties.getBucketName(), fileName, file.getInputStream(), contentType);
			// 文件管理数据记录,收集管理追踪文件
			fileLog(file, fileName);
		}
		catch (Exception e) {
			log.error("上传失败", e);
			throw new GlobalException(CodeMsg.UPLOAD_FILE_ERROR);
		}
		return uploadFile;
	}

	/**
	 * 读取文件
	 * @param bucket
	 * @param fileName
	 * @param response
	 */
	@Override
	public void getFile(String bucket, String fileName, HttpServletResponse response) {
		try (S3Object s3Object = minioTemplate.getObject(bucket, fileName)) {
			response.setContentType("application/octet-stream; charset=UTF-8");
			IoUtil.copy(s3Object.getObjectContent(), response.getOutputStream());
		}
		catch (Exception e) {
			log.error("文件读取异常: {}", e.getLocalizedMessage());
		}
	}

	/**
	 * 删除文件 根据id
	 * @param id
	 * @return
	 */
	@Override
	@SneakyThrows
	@Transactional(rollbackFor = Exception.class)
	public Boolean deleteFile(Long id) {
		SysFile file = this.getById(id);
		minioTemplate.removeObject(ossProperties.getBucketName(), file.getFileName());
		return this.removeById(id);
	}

	/**
	 * 根据文件名删除文件
	 * @param fileName
	 * @return
	 */
	@Override
	public Boolean removeFile(String fileName) {
		minioTemplate.removeFile(ossProperties.getBucketName(), fileName);
		return Boolean.TRUE;
	}

	/**
	 * 文件管理数据记录,收集管理追踪文件
	 * @param file 上传文件格式
	 * @param fileName 文件名
	 */
	private void fileLog(MultipartFile file, String fileName) {
		SysFile sysFile = new SysFile();
		sysFile.setFileName(fileName);
		sysFile.setOriginal(file.getOriginalFilename());
		sysFile.setFileSize(file.getSize());
		sysFile.setType(FileUtil.extName(file.getOriginalFilename()));
		sysFile.setBucketName(ossProperties.getBucketName());
		sysFile.setCreateUser(SecurityUtils.getUser().getUsername());
		this.save(sysFile);
	}

}
