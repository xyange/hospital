

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.DoctorHonor;
import com.wyzy.hospital.psychology.service.DoctorHonorService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理医生荣誉名称表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:32
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctorhonor" )
@Api(value = "doctorhonor", tags = "心理医生荣誉名称表管理")
public class DoctorHonorController {

    private final  DoctorHonorService doctorHonorService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param doctorHonor 心理医生荣誉名称表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorhonor_view')" )
    public R getDoctorHonorPage(Page page, DoctorHonor doctorHonor) {
        return R.ok(doctorHonorService.page(page, Wrappers.query(doctorHonor)));
    }


    /**
     * 通过id查询心理医生荣誉名称表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorhonor_view')" )
    public R<DoctorHonor> getById(@PathVariable("id" ) Long id) {
        return R.ok(doctorHonorService.getById(id));
    }

    /**
     * 新增心理医生荣誉名称表
     * @param doctorHonor 心理医生荣誉名称表
     * @return R
     */
    @ApiOperation(value = "新增心理医生荣誉名称表", notes = "新增心理医生荣誉名称表")
    @SysLog("新增心理医生荣誉名称表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorhonor_add')" )
    public R<Boolean> save(@RequestBody DoctorHonor doctorHonor) {
        return R.ok(doctorHonorService.saveDoctorHonor(doctorHonor));
    }

    /**
     * 修改心理医生荣誉名称表
     * @param doctorHonor 心理医生荣誉名称表
     * @return R
     */
    @ApiOperation(value = "修改心理医生荣誉名称表", notes = "修改心理医生荣誉名称表")
    @SysLog("修改心理医生荣誉名称表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorhonor_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorHonor doctorHonor) {
        return R.ok(doctorHonorService.updateById(doctorHonor));
    }

    /**
     * 通过id删除心理医生荣誉名称表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生荣誉名称表", notes = "通过id删除心理医生荣誉名称表")
    @SysLog("通过id删除心理医生荣誉名称表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorhonor_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(doctorHonorService.removeById(id));
    }

}
