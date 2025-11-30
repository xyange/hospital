

package com.wyzy.hospital.doctor.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.doctor.entity.DoctorService;
import com.wyzy.hospital.doctor.service.DoctorServiceService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctorservice" )
@Api(value = "doctorservice", tags = "医生服务关系表管理")
public class DoctorServiceController {

    private final  DoctorServiceService doctorServiceService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param doctorService 医生服务关系表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('doctor_doctorservice_view')" )
    public R getDoctorServicePage(Page page, DoctorService doctorService) {
        return R.ok(doctorServiceService.page(page, Wrappers.query(doctorService)));
    }


    /**
     * 通过id查询医生服务关系表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('doctor_doctorservice_view')" )
    public R getById(@PathVariable("doctorId" ) Long doctorId) {
        return R.ok(doctorServiceService.getById(doctorId));
    }

    /**
     * 新增医生服务关系表
     * @param doctorService 医生服务关系表
     * @return R
     */
    @ApiOperation(value = "新增医生服务关系表", notes = "新增医生服务关系表")
    @SysLog("新增医生服务关系表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('doctor_doctorservice_add')" )
    public R save(@RequestBody DoctorService doctorService) {
        return R.ok(doctorServiceService.save(doctorService));
    }

    /**
     * 修改医生服务关系表
     * @param doctorService 医生服务关系表
     * @return R
     */
    @ApiOperation(value = "修改医生服务关系表", notes = "修改医生服务关系表")
    @SysLog("修改医生服务关系表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('doctor_doctorservice_edit')" )
    public R updateById(@RequestBody DoctorService doctorService) {
        return R.ok(doctorServiceService.updateById(doctorService));
    }

    /**
     * 通过id删除医生服务关系表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id删除医生服务关系表", notes = "通过id删除医生服务关系表")
    @SysLog("通过id删除医生服务关系表" )
    @DeleteMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('doctor_doctorservice_del')" )
    public R removeById(@PathVariable Long doctorId) {
        return R.ok(doctorServiceService.removeById(doctorId));
    }

}
