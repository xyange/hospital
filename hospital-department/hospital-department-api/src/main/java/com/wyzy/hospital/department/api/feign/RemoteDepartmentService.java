package com.wyzy.hospital.department.api.feign;

import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 科室信息远程调用
 * @author wrk
 */
@FeignClient(contextId = "remoteDepartmentService", value = ServiceNameConstants.DEPARTMENT_HOSPITAL)
public interface RemoteDepartmentService {

	/**
	 * 模糊查询科室
	 *
	 * @param name 科室名称
	 * @return Result<XxxxDO>
	 */
	@GetMapping("/listDepartmentByName")
	R<String> listDepartmentByName(@RequestParam("name") String name);

	/**
	 * 通过id查询科室列表
	 * @param id id
	 * @return R
	 */
	@GetMapping("/list/{id}" )
	R<Integer> getListById(@RequestParam("id" ) Integer id);
}
