

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.EnMedicine;
import com.wyzy.hospital.admin.service.EnMedicineService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 药品表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:35
 */
@RestController
@AllArgsConstructor
@RequestMapping("/enmedicine" )
@Api(value = "enmedicine", tags = "药品表管理")
public class EnMedicineController {

    private final  EnMedicineService enMedicineService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param enMedicine 药品表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_enmedicine_view')" )
    public R getEnMedicinePage(Page page, EnMedicine enMedicine) {
        return R.ok(enMedicineService.page(page, Wrappers.query(enMedicine)));
    }


    /**
     * 通过id查询药品表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_enmedicine_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(enMedicineService.getById(id));
    }

    /**
     * 新增药品表
     * @param enMedicine 药品表
     * @return R
     */
    @ApiOperation(value = "新增药品表", notes = "新增药品表")
    @SysLog("新增药品表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_enmedicine_add')" )
    public R save(@RequestBody EnMedicine enMedicine) {
        return R.ok(enMedicineService.save(enMedicine));
    }

    /**
     * 修改药品表
     * @param enMedicine 药品表
     * @return R
     */
    @ApiOperation(value = "修改药品表", notes = "修改药品表")
    @SysLog("修改药品表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_enmedicine_edit')" )
    public R updateById(@RequestBody EnMedicine enMedicine) {
        return R.ok(enMedicineService.updateById(enMedicine));
    }

    /**
     * 通过id删除药品表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除药品表", notes = "通过id删除药品表")
    @SysLog("通过id删除药品表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_enmedicine_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(enMedicineService.removeById(id));
    }

    /**
     * 通过medicineName查询疾病对应药品表
     * @param diseaseName
     * @return R
     */
    @ApiOperation(value = "通过medicineName查询", notes = "通过medicineName查询")
    @GetMapping("/selectMedicine/{diseaseName}" )
    @PreAuthorize("@pms.hasPermission('admin_enmedicine_view')" )
    public R getById(@PathVariable("diseaseName" ) String diseaseName ) {

        return R.ok(enMedicineService.lookEnMedicineByDiseaseName(diseaseName));
    }

}
