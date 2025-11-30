

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmInternalDTO;
import com.wyzy.hospital.tcm.dto.TcmSortDTO;
import com.wyzy.hospital.tcm.entity.TcmInternal;
import com.wyzy.hospital.tcm.kit.TcmSortKitService;
import com.wyzy.hospital.tcm.service.TcmInternalService;
import com.wyzy.hospital.tcm.service.TcmSortService;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import com.wyzy.hospital.tcm.vo.TcmSortVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 内科学表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:38
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcminternal" )
@Api(value = "apptcminternal", tags = "内科学表APP管理")
public class AppTcmInternalController {

    private final  TcmInternalService tcmInternalService;
    private final TcmSortKitService tcmSortKitService;

	/**
	 * 通过Id查询内科学表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过Id查询内科学表", notes = "通过Id查询内科学表")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<TcmInternalDTO> getById(@PathVariable("id" ) Long id) {
		TcmInternalDTO byId = tcmInternalService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 查询内科学一级分类
	 * 添加二级分类是，需要先选择一级分类
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return R
	 */
	@ApiOperation(value = "查询内科学一级分类", notes = "查询内科学一级分类")
	@GetMapping("/tcmSortOneList" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmSortDTO>> getTcmSortOneList() {
		Integer type = 3 ;
		List<TcmSortDTO> tcmSortOneList = tcmSortKitService.getTcmSortOneList(type);
		if (tcmSortOneList == null || tcmSortOneList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmSortOneList);
	}

	/**
	 * 根据内科学一级分类ID查询二级分类及数据表列表
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * sortId 一级分类ID
	 * @return R
	 */
	@ApiOperation(value = "根据内科学一级分类ID查询二级分类及数据表列表", notes = "根据内科学一级分类ID查询二级分类及数据表列表")
	@GetMapping("/tcmSortVO" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmSortVO>> returnSecondaryData(Long sortId) {
		Integer type = 3 ;
		List<TcmSortVO> tcmSortVOList = tcmSortKitService.returnSecondaryData(type, sortId);
		if (tcmSortVOList== null || tcmSortVOList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmSortVOList);
	}
}
