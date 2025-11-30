package com.wyzy.hospital.admin.api.feign;

import com.wyzy.hospital.admin.api.dto.file.UploadFile;
import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author aqie
 * Date on 2021/5/24  17:12
 * @Function:
 */
@FeignClient(contextId = "remoteFileService", value = ServiceNameConstants.UPMS_SERVICE)
public interface RemoteFileService {

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping(value = "/sys-file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    R<UploadFile> upload(@RequestPart("file") MultipartFile file);
}
