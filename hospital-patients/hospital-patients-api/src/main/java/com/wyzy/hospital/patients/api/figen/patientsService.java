package com.wyzy.hospital.patients.api.figen;

import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Author shixiaoyan
 * Date on 2021/4/14  10:00
 * @Function: 病人服务远程调用
 */
@FeignClient(contextId = "patientsService", value = ServiceNameConstants.PATIENTS_HOSPITAL)
public interface patientsService {
	@GetMapping("/name/{name}/{iphone}")
	R<String> getMedicalRecords(@RequestParam("name") String name,@RequestParam("iphone") String iphone);
}
