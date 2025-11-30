

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmBookattrDTO;
import com.wyzy.hospital.tcm.entity.TcmBookattr;
import com.wyzy.hospital.tcm.service.TcmBookattrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 医书属性表
 *
 * @author hospital code generator
 * @date 2021-05-20 09:51:02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmbookattr" )
@Api(value = "apptcmbookattr", tags = "医书属性表APP管理")
public class APPTcmBookattrController {

    private final  TcmBookattrService tcmBookattrService;

	/**
	 * 通过id查询医书属性表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<TcmBookattr> getById(@PathVariable("id" ) Long id) {
		TcmBookattr byId = tcmBookattrService.getById(id);
		if (byId == null) {
			return R.error(CodeMsg.NO_DATA);
		}else {
			return R.ok(byId);
		}
	}

	/**
	 * 查询医书树状列表
	 * @return
	 */
	@ApiOperation(value = "查询医书树状列表", notes = "查询医书树状列表")
	@GetMapping("/list" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List> getTcmBookattrList() {
		List tcmBookattrList = tcmBookattrService.getTcmBookattrList();
		if (tcmBookattrList == null || tcmBookattrList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}else {
			return R.ok(tcmBookattrList);
		}
	}
}
