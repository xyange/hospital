

package com.wyzy.hospital.doctor.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.doctor.entity.Doctor;
import com.wyzy.hospital.doctor.service.DoctorService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-12 16:50:44
 */
@RestController
@AllArgsConstructor
@RequestMapping("/pc/doctor" )
@Api(value = "doctor", tags = "医生管理")
public class DoctorController {

    private final  DoctorService doctorService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param doctor 医生
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('doctor_doctor_view')" )
    public R getDoctorPage(Page page, Doctor doctor) {
        return R.ok(doctorService.page(page, Wrappers.query(doctor)));
    }


    /**
     * 通过id查询医生
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('doctor_doctor_view')" )
    public R getById(@PathVariable("doctorId" ) Long doctorId) {
        return R.ok(doctorService.getById(doctorId));
    }

    /**
     * 新增医生
     * @param doctor 医生
     * @return R
     */
    @ApiOperation(value = "新增医生", notes = "新增医生")
    @SysLog("新增医生" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('doctor_doctor_add')" )
    public R save(@RequestBody Doctor doctor) {
        return R.ok(doctorService.save(doctor));
    }

    /**
     * 修改医生
     * @param doctor 医生
     * @return R
     */
    @ApiOperation(value = "修改医生", notes = "修改医生")
    @SysLog("修改医生" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('doctor_doctor_edit')" )
    public R updateById(@RequestBody Doctor doctor) {
        return R.ok(doctorService.updateById(doctor));
    }

    /**
     * 通过id删除医生
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id删除医生", notes = "通过id删除医生")
    @SysLog("通过id删除医生" )
    @DeleteMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('doctor_doctor_del')" )
    public R removeById(@PathVariable Long doctorId) {
        return R.ok(doctorService.removeById(doctorId));
    }

}
