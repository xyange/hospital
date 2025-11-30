

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmDiseaseDTO;
import com.wyzy.hospital.tcm.entity.TcmDisease;
import com.wyzy.hospital.tcm.service.TcmDiseaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmdisease" )
@Api(value = "apptcmdisease", tags = "中医疾病表APP管理")
public class AppTcmDiseaseController {

    private final  TcmDiseaseService tcmDiseaseService;

	/**
	 * 通过pojo查询疾病表
	 * @param tcmDisease
	 * @return R
	 */
	@ApiOperation(value = "通过pojo查询", notes = "通过pojo查询")
	@GetMapping("/diseaseName" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<IPage<TcmDiseaseDTO>> getByDiseaseName(Query query,TcmDisease tcmDisease) {
		IPage<TcmDiseaseDTO> tcmDiseaseDTOList = tcmDiseaseService.getByPojo(Condition.getPage(query),tcmDisease);
		if (tcmDiseaseDTOList == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmDiseaseDTOList);
	}
}
