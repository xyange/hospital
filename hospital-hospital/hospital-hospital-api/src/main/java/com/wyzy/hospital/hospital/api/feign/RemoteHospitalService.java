package com.wyzy.hospital.hospital.api.feign;

import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author aqie
 * Date on 2021/4/9  16:53
 * @Function: 医生服务远程调用
 */
@FeignClient(contextId = "remoteHospitalService", value = ServiceNameConstants.HOSPITAL_HOSPITAL)
public interface RemoteHospitalService {
	@GetMapping("/test")
	R<String> testHospital(@RequestParam("content") String content);
}
