package com.wyzy.hospital.tcm.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmRecipesuperDTO;
import com.wyzy.hospital.tcm.service.TcmRecipesuperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmrecipesuper" )
@Api(value = "apptcmrecipesuper", tags = "方剂父级表APP管理")
public class AppTcmRecipesuperController {

    private final  TcmRecipesuperService tcmRecipesuperService;

	/**
	 * 查询方剂父级列表及方剂表集合
	 */
	@ApiOperation(value = "查询方剂父级列表及方剂表集合", notes = "查询方剂父级列表及方剂表集合")
	@GetMapping("/getTcmRecipesuperList" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmRecipesuperDTO>> getTcmRecipesuperList() {
		List<TcmRecipesuperDTO> tcmRecipesuperList = tcmRecipesuperService.getTcmRecipesuperList();
		if (tcmRecipesuperList == null || tcmRecipesuperList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmRecipesuperList);
	}

}
