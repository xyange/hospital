package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.service.DepartmentDiseaseService;
import com.wyzy.hospital.common.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 科室疾病信息
 *
 * @author wrk
 * @date 2021/05/10 11:09
 **/
@RestController
@AllArgsConstructor
@RequestMapping("departmentsDisease" )
@Api(value = "departments", tags = "科室疾病信息")
public class DepartmentDiseaseController {
    private final DepartmentDiseaseService departmentDiseaseService;
    /**
     * 查科室以及内的疾病（一级科室）全部
     * @return R
     */
    @ApiOperation(value = "科室疾病", notes = "查询科室疾病")
    @GetMapping("/listDepartmentDisease" )
    @PreAuthorize("@pms.hasPermission('admin_departments_disease')" )
    public R listDepartmentDisease(){
        return R.ok(departmentDiseaseService.listDepartmentDisease());
    }
}
