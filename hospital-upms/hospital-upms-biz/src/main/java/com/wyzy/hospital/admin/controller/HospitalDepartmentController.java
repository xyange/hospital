

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.HospitalDepartment;
import com.wyzy.hospital.admin.service.HospitalDepartmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-17 09:26:01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/hosdepdetail" )
@Api(value = "hosdepdetail", tags = "医院科室详情管理")
public class HospitalDepartmentController {

    private final HospitalDepartmentService hospitalDepartmentService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param hospitalDepartment 医院科室详情
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_hosdepdetail_view')" )
    public R getHosdepDetailPage(Page page, HospitalDepartment hospitalDepartment) {
        return R.ok(hospitalDepartmentService.page(page, Wrappers.query(hospitalDepartment)));
    }


    /**
     * 通过id查询医院科室详情
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_hosdepdetail_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(hospitalDepartmentService.getById(id));
    }

    /**
     * 新增医院科室详情
     * @param hospitalDepartment 医院科室详情
     * @return R
     */
    @ApiOperation(value = "新增医院科室详情", notes = "新增医院科室详情")
    @SysLog("新增医院科室详情" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_hosdepdetail_add')" )
    public R save(@RequestBody HospitalDepartment hospitalDepartment) {
        return R.ok(hospitalDepartmentService.save(hospitalDepartment));
    }

    /**
     * 修改医院科室详情
     * @param hospitalDepartment 医院科室详情
     * @return R
     */
    @ApiOperation(value = "修改医院科室详情", notes = "修改医院科室详情")
    @SysLog("修改医院科室详情" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_hosdepdetail_edit')" )
    public R updateById(@RequestBody HospitalDepartment hospitalDepartment) {
        return R.ok(hospitalDepartmentService.updateById(hospitalDepartment));
    }

    /**
     * 通过id删除医院科室详情
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除医院科室详情", notes = "通过id删除医院科室详情")
    @SysLog("通过id删除医院科室详情" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_hosdepdetail_del')" )
    public R removeById(Long id) {
        return R.ok(hospitalDepartmentService.removeById(id));
    }



    /**
     * 根据医院科室表中科室ID查询医院科室表信息
     * @param
     * @return R
     */
    @ApiOperation(value = "根据医院科室表中科室ID查询医院科室表信息", notes = "根据医院科室表中科室ID查询医院科室表信息")
    @GetMapping("/departmentsId" )
    @PreAuthorize("@pms.hasPermission('admin_hosdepdetail_view')" )
    public R getHosdepDetailBydepartmentsId(Long departmentsId) {
        return R.ok(hospitalDepartmentService.getHosdepDetailBydepartmentsId(departmentsId));
    }

    /**
     * 通过科室departments_id删除医院科室详情
     * @param departmentsId 科室id
     * @return R
     */
    @ApiOperation(value = "通过科室id删除医院科室详情", notes = "通过科室id删除医院科室详情")
    @SysLog("通过id删除医院科室详情" )
    @DeleteMapping("/{departmentsId}" )
    @PreAuthorize("@pms.hasPermission('admin_hosdepdetail_del')" )
    public R removeBydepartmentsId(@PathVariable Long departmentsId) {
        return R.ok(hospitalDepartmentService.removeBydepartmentsId(departmentsId));
    }

}
