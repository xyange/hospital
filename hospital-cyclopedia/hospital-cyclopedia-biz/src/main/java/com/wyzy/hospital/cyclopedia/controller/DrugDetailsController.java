

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.dto.DrugDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugDetails;
import com.wyzy.hospital.cyclopedia.service.DrugDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:56
 */
@RestController
@AllArgsConstructor
@RequestMapping("/drugdetails" )
@Api(value = "drugdetails", tags = "药品详情表管理")
public class DrugDetailsController {

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
	@PreAuthorize("@pms.hasPermission('cyclopedia_drugdetails_view')")
	public R getDrugDetailsPage(Page page, DrugDetails drugDetails) {
		return R.ok(drugDetailsService.page(page, Wrappers.query(drugDetails)));
	}


	/**
	 * 通过id查询药品详情表
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('cyclopedia_drugdetails_view')")
	public R getById(@PathVariable("id") Long id) {
		return R.ok(drugDetailsService.getById(id));
	}

	/**
	 * 新增药品详情表
	 *
	 * @param drugDetails 药品详情表
	 * @return R
	 */
	@ApiOperation(value = "新增药品详情表", notes = "新增药品详情表")
	@SysLog("新增药品详情表")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('cyclopedia_drugdetails_add')")
	public R save(@RequestBody DrugDetails drugDetails) {
		return R.ok(drugDetailsService.save(drugDetails));
	}

	/**
	 * 修改药品详情表
	 *
	 * @param drugDetails 药品详情表
	 * @return R
	 */
	@ApiOperation(value = "修改药品详情表", notes = "修改药品详情表")
	@SysLog("修改药品详情表")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('cyclopedia_drugdetails_edit')")
	public R updateById(@RequestBody DrugDetails drugDetails) {
		return R.ok(drugDetailsService.updateById(drugDetails));
	}

	/**
	 * 通过id删除药品详情表
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除药品详情表", notes = "通过id删除药品详情表")
	@SysLog("通过id删除药品详情表")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('cyclopedia_drugdetails_del')")
	public R removeById(@PathVariable Long id) {
		return R.ok(drugDetailsService.movenDrug(id));
	}

	/**
	 * 通过drugId查询药品试剂
	 *
	 * @param drugId drugId
	 * @return R
	 */
	@ApiOperation(value = "通过drugId查询药品试剂", notes = "通过drugId查询")
	@GetMapping("/queryDrugType/{drugId}")
	@PreAuthorize("@pms.hasPermission('cyclopedia_drugdetails_view')")
	public R<List<DrugDetailsDTO>> queryDrugType(@PathVariable("drugId") Long drugId) {

		return R.ok(drugDetailsService.queryDrugType(drugId));
	}

}
