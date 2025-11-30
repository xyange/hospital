package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.psychology.api.dto.DoctorAdeptDTO;
import com.wyzy.hospital.psychology.api.entity.DoctorAdept;
import com.wyzy.hospital.psychology.service.DoctorAdeptService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理医生擅长表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:14
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctoradept" )
@Api(value = "doctoradept", tags = "心理医生擅长表管理")
public class DoctorAdeptController {

    private final  DoctorAdeptService doctorAdeptService;

    /**
     * 分页查询
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_doctoradept_view')" )
    public R<IPage<DoctorAdeptDTO>> getDoctorAdeptPage(Query query) {
        return R.ok(doctorAdeptService.pageDoctorAdept(Condition.getPage(query)));
    }


    /**
     * 通过id查询心理医生擅长表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctoradept_view')" )
    public R<DoctorAdept> getById(@PathVariable("doctorId" ) Long doctorId) {
        return R.ok(doctorAdeptService.getById(doctorId));
    }

    /**
     * 新增心理医生擅长表
     * @param doctorAdept 心理医生擅长表
     * @return R
     */
    @ApiOperation(value = "新增心理医生擅长表", notes = "新增心理医生擅长表")
    @SysLog("新增心理医生擅长表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctoradept_add')" )
    public R<Boolean> save(@RequestBody DoctorAdept doctorAdept) {
        return R.ok(doctorAdeptService.saveDoctorAdept(doctorAdept));
    }

    /**
     * 修改心理医生擅长表
     * @param doctorAdept 心理医生擅长表
     * @return R
     */
    @ApiOperation(value = "修改心理医生擅长表", notes = "修改心理医生擅长表")
    @SysLog("修改心理医生擅长表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctoradept_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorAdept doctorAdept) {
        return R.ok(doctorAdeptService.updateById(doctorAdept));
    }

    /**
     * 通过id删除心理医生擅长表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生擅长表", notes = "通过id删除心理医生擅长表")
    @SysLog("通过id删除心理医生擅长表" )
    @DeleteMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctoradept_del')" )
    public R<Boolean> removeById(@PathVariable Long doctorId) {
        return R.ok(doctorAdeptService.removeById(doctorId));
    }

}
