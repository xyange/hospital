

package com.wyzy.hospital.cyclopedia.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.dto.CyDepartmentDTO;
import com.wyzy.hospital.cyclopedia.dto.CyOneDepartmentDTO;
import com.wyzy.hospital.cyclopedia.service.CyDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 百科科室表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:05:20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/cydepartment" )
@Api(value = "cydepartment", tags = "App百科科室表管理")
public class AppCyDepartmentController {

    private final  CyDepartmentService cyDepartmentService;


	/**
	 * 查一级科室
	 * @return
	 */
	@ApiOperation(value = "查一级科室", notes = "查一级科室")
	@GetMapping("/queryOneDepartment" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R <List<CyDepartmentDTO>>queryOneDepartment() {
		return R.ok(cyDepartmentService.queryOneDepartment());
	}


	/**
	 * 根据一级查疾病
	 * @param aid
	 * @return
	 */
	@ApiOperation(value = "根据一级查疾病", notes = "根据一级查疾病")
	@GetMapping("/queryOneDiseases/{aid}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R <List<CyOneDepartmentDTO>> queryOneDiseases(@PathVariable("aid" ) Long aid) {
		return R.ok(cyDepartmentService.queryOneDiseases(aid));
	}
}
