

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.DoctorTraining;
import com.wyzy.hospital.psychology.service.DoctorTrainingService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 心理医生培训表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:49
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctortraining" )
@Api(value = "doctortraining", tags = "心理医生培训表管理")
public class DoctorTrainingController {

    private final  DoctorTrainingService doctorTrainingService;

    /**
     * 通过doctorId查询心理医生培训表
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过doctorId查询", notes = "通过doctorId查询")
    @GetMapping("/{doctorId}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctortraining_view')" )
    public R<List<DoctorTraining>> getById(@PathVariable("doctorId" ) Long doctorId) {
        return R.ok(doctorTrainingService.getByDoctorId(doctorId));
    }

    /**
     * 新增心理医生培训表
     * @param doctorTraining 心理医生培训表
     * @return R
     */
    @ApiOperation(value = "新增心理医生培训表", notes = "新增心理医生培训表")
    @SysLog("新增心理医生培训表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctortraining_add')" )
    public R<Boolean> save(@RequestBody DoctorTraining doctorTraining) {
        return R.ok(doctorTrainingService.saveDoctorTraining(doctorTraining));
    }

    /**
     * 修改心理医生培训表
     * @param doctorTraining 心理医生培训表
     * @return R
     */
    @ApiOperation(value = "修改心理医生培训表", notes = "修改心理医生培训表")
    @SysLog("修改心理医生培训表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctortraining_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorTraining doctorTraining) {
        return R.ok(doctorTrainingService.updateById(doctorTraining));
    }

    /**
     * 通过id删除心理医生培训表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生培训表", notes = "通过id删除心理医生培训表")
    @SysLog("通过id删除心理医生培训表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctortraining_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(doctorTrainingService.removeById(id));
    }

}
