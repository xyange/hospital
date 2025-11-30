package com.wyzy.hospital.tcm.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmCmDTO;
import com.wyzy.hospital.tcm.dto.TcmSortDTO;
import com.wyzy.hospital.tcm.kit.TcmSortKitService;
import com.wyzy.hospital.tcm.service.TcmCmService;
import com.wyzy.hospital.tcm.service.TcmSortService;
import com.wyzy.hospital.tcm.vo.TcmSortVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:46
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmcm" )
@Api(value = "apptcmcm", tags = "中药表APP管理")
public class AppTcmCmController {

    private final  TcmCmService tcmCmService;
	private final TcmSortKitService tcmSortKitService;
	/**
	 * 查询中药一级分类列表
	 * @return R
	 */
	@ApiOperation(value = "查询中药一级分类列表", notes = "查询中药一级分类列表")
	@GetMapping("/tcmcmOneList" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmSortDTO>> getTcmSortOneList() {
		Integer type = 2;
		List<TcmSortDTO> tcmSortOneList = tcmSortKitService.getTcmSortOneList(type);
		if (tcmSortOneList == null || tcmSortOneList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}else {
			return R.ok(tcmSortOneList);
		}
	}

	/**
	 * 通过一级中药分类onelevelId查询中药表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过Id查询中药", notes = "通过Id查询中药")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<TcmCmDTO> getById(@PathVariable("id" ) Long id) {
		TcmCmDTO byId = tcmCmService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 根据一级分类ID查询二级分类及数据表列表
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表
	 * sortId 一级分类ID
	 * @return R
	 */
	@ApiOperation(value = "根据一级分类ID查询二级分类及数据表列表", notes = "根据一级分类ID查询二级分类及数据表列表")
	@GetMapping("/tcmSortVO" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmSortVO>> returnSecondaryData(Long sortId) {
		Integer type = 2;
		List<TcmSortVO> tcmSortVOList = tcmSortKitService.returnSecondaryData(type, sortId);
		if (tcmSortVOList == null || tcmSortVOList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmSortVOList);
	}
}
