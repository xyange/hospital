

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.DoctorEducation;
import com.wyzy.hospital.psychology.service.DoctorEducationService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 心理医生教育学历表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:40
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctoreducation" )
@Api(value = "doctoreducation", tags = "心理医生教育学历表管理")
public class DoctorEducationController {

    private final  DoctorEducationService doctorEducationService;

    /**
     * 通过id查询心理医生教育学历表列表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过doctorId查询", notes = "通过doctorId查询")
    @GetMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctoreducation_view')" )
    public R<List<DoctorEducation>> getDoctorEducationByDoctorId(@PathVariable("doctorId" ) Long doctorId) {
        return R.ok(doctorEducationService.getDoctorEducationByDoctorId(doctorId));
    }

    /**
     * 新增心理医生教育学历表
     * @param doctorEducation 心理医生教育学历表
     * @return R
     */
    @ApiOperation(value = "新增心理医生教育学历表", notes = "新增心理医生教育学历表")
    @SysLog("新增心理医生教育学历表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctoreducation_add')" )
    public R<Boolean> save(@RequestBody DoctorEducation doctorEducation) {
        return R.ok(doctorEducationService.saveDoctorEducation(doctorEducation));
    }

    /**
     * 修改心理医生教育学历表
     * @param doctorEducation 心理医生教育学历表
     * @return R
     */
    @ApiOperation(value = "修改心理医生教育学历表", notes = "修改心理医生教育学历表")
    @SysLog("修改心理医生教育学历表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctoreducation_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorEducation doctorEducation) {
        return R.ok(doctorEducationService.updateById(doctorEducation));
    }

    /**
     * 通过id删除心理医生教育学历表
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生教育学历表", notes = "通过id删除心理医生教育学历表")
    @SysLog("通过id删除心理医生教育学历表" )
    @DeleteMapping("/doctorEducation" )
    @PreAuthorize("@pms.hasPermission('psychology_doctoreducation_del')" )
    public R<Boolean> removeById(Long id) {
        return R.ok(doctorEducationService.removeById(id));
    }

}
