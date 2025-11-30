package com.wyzy.hospital.admin.api.dto.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/5/24  16:58
 * @Function: 图片上传返回实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadFile {
    private String bucketName;
    private String fileName;
    private String url;
}
