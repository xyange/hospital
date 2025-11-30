package com.wyzy.hospital.app.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/5/25  11:45
 * @Function: 上传文件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadFileInfo {
	private String path;
	private String filename;
	private String localPath;
}
