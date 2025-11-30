

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.DoctorDetail;
import com.wyzy.hospital.psychology.service.DoctorDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理医生详情表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctordetail" )
@Api(value = "doctordetail", tags = "心理医生详情表管理")
public class DoctorDetailController {

    private final  DoctorDetailService doctorDetailService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param doctorDetail 心理医生详情表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_doctordetail_view')" )
    public R getDoctorDetailPage(Page page, DoctorDetail doctorDetail) {
        return R.ok(doctorDetailService.page(page, Wrappers.query(doctorDetail)));
    }


    /**
     * 通过id查询心理医生详情表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctordetail_view')" )
    public R<DoctorDetail> getById(@PathVariable("doctorId" ) Long doctorId) {
        return R.ok(doctorDetailService.getById(doctorId));
    }

    /**
     * 新增心理医生详情表
     * @param doctorDetail 心理医生详情表
     * @return R
     */
    @ApiOperation(value = "新增心理医生详情表", notes = "新增心理医生详情表")
    @SysLog("新增心理医生详情表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctordetail_add')" )
    public R<Boolean> save(@RequestBody DoctorDetail doctorDetail) {
        return R.ok(doctorDetailService.saveDoctorDetail(doctorDetail));
    }

    /**
     * 修改心理医生详情表
     * @param doctorDetail 心理医生详情表
     * @return R
     */
    @ApiOperation(value = "修改心理医生详情表", notes = "修改心理医生详情表")
    @SysLog("修改心理医生详情表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctordetail_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorDetail doctorDetail) {
        return R.ok(doctorDetailService.updateById(doctorDetail));
    }

    /**
     * 通过id删除心理医生详情表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生详情表", notes = "通过id删除心理医生详情表")
    @SysLog("通过id删除心理医生详情表" )
    @DeleteMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctordetail_del')" )
    public R<Boolean> removeById(@PathVariable Long doctorId) {
        return R.ok(doctorDetailService.removeById(doctorId));
    }

}
