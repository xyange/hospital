

package com.wyzy.hospital.cyclopedia.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.service.CyReagentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 公司药品表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:37:00
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/cyreagent" )
@Api(value = "cyreagent", tags = "App百科公司药品表")
public class AppCyReagentController {

	private final CyReagentService cyReagentService;


	/**
	 * 通过rid查询公司药品表
	 *
	 * @param rid rid
	 * @return R
	 */
	@ApiOperation(value = "通过id查询公司药品详情", notes = "通过rid查询")
	@GetMapping("/queryCompanyReagenDetails/{rid}")
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R queryCompanyReagenDetails(@PathVariable("rid") Long rid) {
		return R.ok(cyReagentService.queryCompanyReagenDetails(rid));
	}




}
