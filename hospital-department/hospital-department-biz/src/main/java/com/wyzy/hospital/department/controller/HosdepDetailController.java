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

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.department.entity.HosdepDetail;
import com.wyzy.hospital.department.service.HosdepDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-13 08:30:05
 */
@RestController
@AllArgsConstructor
@RequestMapping("/hosdepdetail" )
@Api(value = "hosdepdetail", tags = "医院科室详情管理")
public class HosdepDetailController {

    private final  HosdepDetailService hosdepDetailService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param hosdepDetail 医院科室详情
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('department_hosdepdetail_view')" )
    public R getHosdepDetailPage(Page page, HosdepDetail hosdepDetail) {
        return R.ok(hosdepDetailService.page(page, Wrappers.query(hosdepDetail)));
    }


    /**
     * 通过id查询医院科室详情
     * @param departmentsId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{departmentsId}" )
    @PreAuthorize("@pms.hasPermission('department_hosdepdetail_view')" )
    public R getById(@PathVariable("departmentsId" ) Integer departmentsId) {
        return R.ok(hosdepDetailService.getById(departmentsId));
    }

	/**
	 * 新增医院科室详情
	 * @param hosdepDetail 医院科室详情
	 * @return R
	 */
	@ApiOperation(value = "新增医院科室详情", notes = "新增医院科室详情")
	@SysLog("新增医院科室详情" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('department_hosdepdetail_add')" )
	public R save(@RequestBody HosdepDetail hosdepDetail) {
		return R.ok(hosdepDetailService.saveHosdepDetail(hosdepDetail));
	}

    /**
     * 修改医院科室详情
     * @param hosdepDetail 医院科室详情
     * @return R
     */
    @ApiOperation(value = "修改医院科室详情", notes = "修改医院科室详情")
    @SysLog("修改医院科室详情" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('department_hosdepdetail_edit')" )
    public R updateById(@RequestBody HosdepDetail hosdepDetail) {
        return R.ok(hosdepDetailService.updateById(hosdepDetail));
    }

    /**
     * 通过id删除医院科室详情
     * @param departmentsId id
     * @return R
     */
    @ApiOperation(value = "通过id删除医院科室详情", notes = "通过id删除医院科室详情")
    @SysLog("通过id删除医院科室详情" )
    @DeleteMapping("/{departmentsId}" )
    @PreAuthorize("@pms.hasPermission('department_hosdepdetail_del')" )
    public R removeById(@PathVariable Integer departmentsId) {
        return R.ok(hosdepDetailService.removeById(departmentsId));
    }

	/**
	 * 通过HosdepDetail的字段查询医院科室详情
	 * @param hosdepDetail hosdepDetail
	 * @return R
	 */
	@ApiOperation(value = "通过字段模糊查询", notes = "通过字段模糊查询")
	@GetMapping("/list" )
	@PreAuthorize("@pms.hasPermission('department_hosdepdetail_view')" )
	public R getByHosdepDetail(@RequestBody HosdepDetail hosdepDetail) {
		return R.ok(hosdepDetailService.getByHosdepDetail(hosdepDetail));
	}
}
