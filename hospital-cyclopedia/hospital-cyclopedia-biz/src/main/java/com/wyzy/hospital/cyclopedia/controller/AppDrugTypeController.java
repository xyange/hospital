

package com.wyzy.hospital.cyclopedia.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.service.DrugTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 药剂表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/drugtype" )
@Api(value = "drugtype", tags = "App药剂表管理")
public class AppDrugTypeController {

    private final  DrugTypeService drugTypeService;



    /**
     * 通过id查询药剂表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "药剂表查一个", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(drugTypeService.getById(id));
    }




	/**
	 * 根据试剂查公司药品及制药的公司
	 * @param tid tid
	 * @return R
	 */
	@ApiOperation(value = "根据试剂查公司药品及制药的公司", notes = "通过id查询")
	@GetMapping("/drugTypeCompanyDrug/{tid}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
	public R DrugTypeCompanyDrug(@PathVariable("tid" ) Long tid) {
		return R.ok(drugTypeService.queryDrugTypeCompanyDrug(tid));
	}
}
