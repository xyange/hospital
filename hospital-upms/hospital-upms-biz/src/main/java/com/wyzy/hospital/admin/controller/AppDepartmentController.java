package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.dto.DepartmentsDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentTreeDTO;
import com.wyzy.hospital.admin.kit.DepartmentKitService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/20  8:51
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/departments" )
@Api(value = "departments", tags = "App科室")
public class AppDepartmentController {
    private final DepartmentKitService departmentsKitService;

    /**
     * 按科室找医院 展示九个科室
     */
    @ApiOperation(value = "展示首页九个科室", notes = "展示首页九个科室")
    @GetMapping("homeDepartments")
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<DepartmentsDTO>> getHomeDepartments(int current, int size) {
        List<DepartmentsDTO> list = departmentsKitService.getHomeDepartments(current, size);
        return R.ok(list);
    }


    /**
     * @author aqie
     * @Function 查询全部科室树状列表
     * @return
     */
    @ApiOperation(value = "查询全部科室树状列表", notes = "全部的 不属于某个医院")
    @GetMapping("/getTreeDepartment" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")")
    public R<List<DepartmentTreeDTO>> getTreeDepartment() {
        List<DepartmentTreeDTO> treeDepartmentLambda = departmentsKitService.getTreeDepartmentLambda();
        return R.ok(treeDepartmentLambda);
    }

    /**
     * 根据id 查询医院科室详情
     * @param departmentId 科室ID
     * @param hospitalId 医院ID
     * @return R
     */
    @ApiOperation(value = "科室详情", notes = "通过id查询")
    @GetMapping("/detail" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")")
    public R getById(@RequestParam("departmentId" ) Long departmentId, @RequestParam("hospitalId" ) Long hospitalId) {
        return R.ok(departmentsKitService.detail(departmentId, hospitalId));
    }

}
