package com.wyzy.hospital.admin.api.feign;

import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Administrator
 */
@FeignClient(contextId = "remotePsychologyDoctorService", value = ServiceNameConstants.UPMS_SERVICE)
public interface RemotePsychologyDoctorService {

	/**
	 * 查心理医生ids
	 * @author wrk
	 * @date 2021/06/03 17:27
	 * @return java.lang.String
	 */
	@GetMapping("/app/psychologyDoctor/getPsychologyDoctorIds")
	R<List<Doctor>> getPsychologyDoctorIds(@RequestParam("sex") Integer sex, @RequestParam("area") String area);

	/**
	 * 根据医生ID查询医生信息
	 * @author wrk
	 * @date 2021/06/03 17:27
	 * @return java.lang.String
	 */
	@GetMapping("/app/psychologyDoctor/getPsychologyByDoctorId")
	R<Doctor> getPsychologyByDoctorId(@RequestParam("doctorId") Long doctorId);
}
