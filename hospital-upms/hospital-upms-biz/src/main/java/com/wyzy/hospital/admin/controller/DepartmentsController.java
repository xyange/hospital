/*
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author:  wyzy
 */
package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.dto.DepartmentsDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentSimpleDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentTreeDTO;
import com.wyzy.hospital.admin.api.entity.Departments;
import com.wyzy.hospital.admin.kit.DepartmentKitService;
import com.wyzy.hospital.admin.service.DepartmentsService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 科室表
 *
 * @author hospital code generator
 * @date 2021-04-12 13:56:39
 */
@RestController
@AllArgsConstructor
@RequestMapping("/departments" )
@Api(value = "departments", tags = "科室表管理")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

	private final DepartmentKitService departmentKitService;

	/**
	 * @Function 获取下级科室
	 * @author aqie
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "获取下级科室", notes = "获取下级科室")
	@GetMapping("/getSubDepartment" )
	@PreAuthorize("@pms.hasPermission('admin_departments_view')" )
	public R<List<DepartmentSimpleDTO>> getSubDepartment(Long id){
		List<DepartmentSimpleDTO> subDepartment = departmentKitService.getSubDepartment(id);
		return R.ok(subDepartment);
	}
    /**
	 * @author aqie
     * @Function 查询全部科室树状列表
     * @return
     */
    @ApiOperation(value = "查询全部科室树状列表", notes = "全部的 不属于某个医院")
    @GetMapping("/getTreeDepartment" )
    @PreAuthorize("@pms.hasPermission('admin_departments_view')" )
    public R<List<DepartmentTreeDTO>> getTreeDepartment() {
		List<DepartmentTreeDTO> treeDepartmentLambda = departmentKitService.getTreeDepartmentLambda();
		return R.ok(treeDepartmentLambda);
    }

	/**
	 * @author aqie
	 * @Function 查询医院全部科室树状列表
	 * @Param hospitalId 医院id
	 * @return
	 */
	@ApiOperation(value = "查询医院全部科室树状列表", notes = "指定医院")
	@GetMapping("/getHospitalTreeDepartment" )
	@PreAuthorize("@pms.hasPermission('admin_departments_view')" )
	public R<List<DepartmentTreeDTO>> getHospitalTreeDepartment(Long hospitalId) {
		List<DepartmentTreeDTO> treeDepartmentLambda = departmentKitService.getTreeListByHospitalId(hospitalId);
		return R.ok(treeDepartmentLambda);
	}


    /**
     * 通过id查询科室表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_departments_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(departmentsService.getById(id));
    }

    /**
     * 新增科室表
     * @param departments 科室表
     * @return R
     */
    @ApiOperation(value = "新增科室表", notes = "新增科室表")
    @SysLog("新增科室表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_departments_add')" )
    public R save(@RequestBody Departments departments) {
        return R.ok(departmentsService.save(departments));
    }

    /**
     * 修改科室表
     * @param departments 科室表
     * @return R
     */
    @ApiOperation(value = "修改科室表", notes = "修改科室表")
    @SysLog("修改科室表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_departments_edit')" )
    public R updateById(@RequestBody Departments departments) {
        return R.ok(departmentsService.updateById(departments));
    }

	/**
	 * 模糊查询科室
	 * @param name 科室名称
	 * @return R
	 */
	@ApiOperation(value = "根据科室名模糊查询科室", notes = "根据科室名模糊查询科室")
	@GetMapping("/listDepartmentByName" )
	@PreAuthorize("@pms.hasPermission('admin_departments_view')" )
	public R listDepartmentByName(String name){
		return R.ok( departmentsService.listDepartmentByName(name));
	}


	/**
	 * 查询科室树状列表
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "查询科室树状列表", notes = "查询科室树状列表")
	@GetMapping("/list" )
	@PreAuthorize("@pms.hasPermission('admin_departments_view')" )
	public R<List<DepartmentsDTO>> getTreeList() {
		return R.ok(departmentKitService.getTreeList());
	}

	/**
	 * 通过id删除科室表
	 * 删除一级表的同时会删除二级表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除一二级科室表", notes = "通过id删除一二级科室表")
	@SysLog("通过id删除科室表" )
	@DeleteMapping("/list/{id}" )
	@PreAuthorize("@pms.hasPermission('admin_departments_del')" )
	@Transactional(propagation = Propagation.REQUIRED)
	public R removeListById(@PathVariable Long id) {
		return R.ok(departmentsService.removeListById(id));
	}

	/**
	 * 通过id删除科室表
	 * 没有下一级表的时候才会删除一级表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除科室", notes = "通过id删除科室")
	@SysLog("通过id删除科室表" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('admin_departments_del')" )
	@Transactional(propagation = Propagation.REQUIRED)
	public R removeById(@PathVariable Integer id) {
		return R.ok(departmentsService.removeById(id));
	}


	/**
	 * 查询一级科室
	 */
	@ApiOperation(value = "查询一级科室列表", notes = "查询一级科室列表")
	@GetMapping("/getOneDepartmentsList" )
	@PreAuthorize("@pms.hasPermission('admin_departments_view')" )
	public R<List<Departments>> getOneDepartmentsList() {
		return R.ok(departmentKitService.getOneDepartmentsList());
	}

}
