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

package com.wyzy.hospital.department.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.department.entity.Departments;
import com.wyzy.hospital.department.service.DepartmentsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    private final  DepartmentsService departmentsService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param departments 科室表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('department_departments_view')" )
    public R getDepartmentsPage(Page page, Departments departments) {
		LambdaQueryWrapper<Departments> likeQuery = new LambdaQueryWrapper<Departments>()
				.like(StringUtils.isNotBlank(departments.getDepartmentName()),
						Departments::getDepartmentName, departments.getDepartmentName());
        return R.ok(departmentsService.page(page, likeQuery));
    }


    /**
     * 通过id查询科室表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('department_departments_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
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
    @PreAuthorize("@pms.hasPermission('department_departments_add')" )
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
    @PreAuthorize("@pms.hasPermission('department_departments_edit')" )
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
	@PreAuthorize("@pms.hasPermission('department_departments_view')" )
	public R listDepartmentByName(String name){
		return R.ok( departmentsService.listDepartmentByName(name));
	}


	/**
	 * 通过id查询科室列表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询科室列表", notes = "通过id查询科室列表")
	@GetMapping("/list/{id}" )
	@PreAuthorize("@pms.hasPermission('department_departments_view')" )
	public R getListById(@PathVariable("id" ) Integer id) {
		return R.ok(departmentsService.getListById(id));
	}

	/**
	 * 通过id删除科室表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除科室表", notes = "通过id删除科室表")
	@SysLog("通过id删除科室表" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('department_departments_del')" )
	@Transactional(propagation = Propagation.REQUIRED)
	public R removeListById(@PathVariable Integer id) {
		return R.ok(departmentsService.removeListById(id));
	}

}
