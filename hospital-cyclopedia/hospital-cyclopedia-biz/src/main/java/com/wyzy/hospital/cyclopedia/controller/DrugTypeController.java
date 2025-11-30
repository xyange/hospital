

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.DrugType;
import com.wyzy.hospital.cyclopedia.service.DrugTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 药剂表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/drugtype" )
@Api(value = "drugtype", tags = "药剂表管理")
public class DrugTypeController {

    private final  DrugTypeService drugTypeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param drugType 药剂表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_drugtype_view')" )
    public R getDrugTypePage(Page page, DrugType drugType) {
        return R.ok(drugTypeService.page(page, Wrappers.query(drugType)));
    }


    /**
     * 通过id查询药剂表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_drugtype_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(drugTypeService.getById(id));
    }

    /**
     * 新增药剂表
     * @param drugType 药剂表
     * @return R
     */
    @ApiOperation(value = "新增药剂表", notes = "新增药剂表")
    @SysLog("新增药剂表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_drugtype_add')" )
    public R save(@RequestBody DrugType drugType) {
        return R.ok(drugTypeService.save(drugType));
    }

    /**
     * 修改药剂表
     * @param drugType 药剂表
     * @return R
     */
    @ApiOperation(value = "修改药剂表", notes = "修改药剂表")
    @SysLog("修改药剂表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_drugtype_edit')" )
    public R updateById(@RequestBody DrugType drugType) {
        return R.ok(drugTypeService.updateById(drugType));
    }

    /**
     * 通过id删除药剂表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除药剂表", notes = "通过id删除药剂表")
    @SysLog("通过id删除药剂表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_drugtype_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(drugTypeService.removeById(id));
    }

	/**
	 * 根据试剂查公司药品及制药的公司
	 * @param tid tid
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/DrugTypeCompanyDrug/{tid}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_drugtype_view')" )
	public R DrugTypeCompanyDrug(@PathVariable("tid" ) Long tid) {
		return R.ok(drugTypeService.queryDrugTypeCompanyDrug(tid));
	}
}
