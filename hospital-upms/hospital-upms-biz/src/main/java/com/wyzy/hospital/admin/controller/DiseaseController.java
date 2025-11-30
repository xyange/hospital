

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.Disease;
import com.wyzy.hospital.admin.service.DiseaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-19 13:45:04
 */
@RestController
@AllArgsConstructor
@RequestMapping("/disease" )
@Api(value = "disease", tags = "主系统疾病表管理")
public class DiseaseController {

    private final  DiseaseService diseaseService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param disease 疾病表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_disease_view')" )
    public R getDiseasePage(Page page, Disease disease) {
        return R.ok(diseaseService.page(page, Wrappers.query(disease)));
    }


    /**
     * 通过id查询疾病表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_disease_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(diseaseService.getById(id));
    }

    /**
     * 新增疾病表
     * @param disease 疾病表
     * @return R
     */
    @ApiOperation(value = "新增疾病", notes = "新增疾病")
    @SysLog("新增疾病表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_disease_add')" )
    public R save(@RequestBody Disease disease) {
        return R.ok(diseaseService.save(disease));
    }

    /**
     * 修改疾病表
     * @param disease 疾病表
     * @return R
     */
    @ApiOperation(value = "修改疾病", notes = "修改疾病")
    @SysLog("修改疾病表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_disease_edit')" )
    public R updateById(@RequestBody Disease disease) {
        return R.ok(diseaseService.updateById(disease));
    }

    /**
     * 通过id删除疾病表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除疾病", notes = "通过id删除疾病")
    @SysLog("通过id删除疾病表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_disease_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(diseaseService.removeById(id));
    }

}
