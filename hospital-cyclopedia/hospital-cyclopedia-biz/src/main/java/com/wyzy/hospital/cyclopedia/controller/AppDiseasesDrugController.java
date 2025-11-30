

package com.wyzy.hospital.cyclopedia.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.service.DiseasesDrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 药品_疾病表
 *
 * @author hospital code generator
 * @date 2021-05-06 09:31:00
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/diseasesdrug" )
@Api(value = "diseasesdrug", tags = "App药品_疾病表管理")
public class AppDiseasesDrugController {

    private final  DiseasesDrugService diseasesDrugService;


	/**
	 * 通过疾病eid查询药品,显示疾病下的药品(分页可)
	 * @param eid eid
	 * @return R
	 */
	@ApiOperation(value = "通过疾病eid查询药品,显示疾病下的药品", notes = "通过eid查询")
	@GetMapping("/AppQueryByDiseasesDrug/{eid}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R queryByDiseasesDrug(@PathVariable("eid" ) Long eid) {
		return R.ok(diseasesDrugService.queryByDiseasesDrug(eid));
	}



}
