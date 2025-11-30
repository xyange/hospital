

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.DoctorCounsel;
import com.wyzy.hospital.psychology.service.DoctorCounselService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理医生 咨询类型关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:11
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctorcounsel" )
@Api(value = "doctorcounsel", tags = "心理医生 咨询类型关系表管理")
public class DoctorCounselController {

    private final  DoctorCounselService doctorCounselService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param doctorCounsel 心理医生 咨询类型关系表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorcounsel_view')" )
    public R getDoctorCounselPage(Page page, DoctorCounsel doctorCounsel) {
        return R.ok(doctorCounselService.page(page, Wrappers.query(doctorCounsel)));
    }


    /**
     * 通过id查询心理医生 咨询类型关系表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorcounsel_view')" )
    public R<DoctorCounsel> getById(@PathVariable("id" ) Long id) {
        return R.ok(doctorCounselService.getById(id));
    }

    /**
     * 新增心理医生 咨询类型关系表
     * @param doctorCounsel 心理医生 咨询类型关系表
     * @return R
     */
    @ApiOperation(value = "新增心理医生 咨询类型关系表", notes = "新增心理医生 咨询类型关系表")
    @SysLog("新增心理医生 咨询类型关系表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorcounsel_add')" )
    public R<Boolean> save(@RequestBody DoctorCounsel doctorCounsel) {
        return R.ok(doctorCounselService.saveDoctorCounsel(doctorCounsel));
    }

    /**
     * 修改心理医生 咨询类型关系表
     * @param doctorCounsel 心理医生 咨询类型关系表
     * @return R
     */
    @ApiOperation(value = "修改心理医生 咨询类型关系表", notes = "修改心理医生 咨询类型关系表")
    @SysLog("修改心理医生 咨询类型关系表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorcounsel_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorCounsel doctorCounsel) {
        return R.ok(doctorCounselService.updateById(doctorCounsel));
    }

    /**
     * 通过id删除心理医生 咨询类型关系表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生 咨询类型关系表", notes = "通过id删除心理医生 咨询类型关系表")
    @SysLog("通过id删除心理医生 咨询类型关系表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorcounsel_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(doctorCounselService.removeById(id));
    }

}
