

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.dto.DrugDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugDetails;
import com.wyzy.hospital.cyclopedia.service.DrugDetailsService;
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
 * 药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:56
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/drugdetails" )
@Api(value = "drugdetails", tags = "App药品详情表管理")
public class AppDrugDetailsController {

	private final DrugDetailsService drugDetailsService;

	/**
	 * 分页查询
	 *
	 * @param page        分页对象
	 * @param drugDetails 药品详情表
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R getDrugDetailsPage(Page page, DrugDetails drugDetails) {
		return R.ok(drugDetailsService.page(page, Wrappers.query(drugDetails)));
	}


	/**
	 * 通过id查询药品详情表
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "药品详情查一个", notes = "通过id查询")
	@GetMapping("/{id}")
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R getById(@PathVariable("id") Long id) {
		return R.ok(drugDetailsService.getById(id));
	}



	/**
	 * 通过drugId查询药品试剂
	 *
	 * @param drugId drugId
	 * @return R
	 */
	@ApiOperation(value = "查询药品试剂", notes = "通过drugId查询")
	@GetMapping("/queryDrugType/{drugId}")
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<DrugDetailsDTO>> queryDrugType(@PathVariable("drugId") Long drugId) {

		return R.ok(drugDetailsService.queryDrugType(drugId));
	}

}
