package com.wyzy.hospital.tcm.controller;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmMeridiansDTO;
import com.wyzy.hospital.tcm.entity.TcmMeridians;
import com.wyzy.hospital.tcm.service.TcmMeridiansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 经脉表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmmeridians" )
@Api(value = "apptcmmeridians", tags = "经脉表APP管理")
public class AppTcmMeridiansController {

    private final  TcmMeridiansService tcmMeridiansService;

	/**
	 * 通过id查询经脉表
	 * @param meridiansId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{meridiansId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<TcmMeridiansDTO> getById(@PathVariable("meridiansId" ) Long meridiansId) {
		TcmMeridiansDTO byId = tcmMeridiansService.getById(meridiansId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过经络contextId查询
	 * @param contextId 查询
	 * @return R
	 */
	@ApiOperation(value = "通过经络contextId及经络名称查询", notes = "通过经络contextId及经络名称查询")
	@GetMapping("/contextId" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<TcmMeridiansDTO> getBycontextId(Long contextId,String meridiansName) {
		TcmMeridiansDTO bycontextId = tcmMeridiansService.getBycontextId(contextId,meridiansName);
		if (bycontextId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(bycontextId);
	}
}
