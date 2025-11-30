

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.Region;
import com.wyzy.hospital.admin.service.RegionService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 行政区划表
 *
 * @author aqie
 * @date 2021-04-10 14:05:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/region" )
@Api(value = "region", tags = "行政区划表管理")
public class RegionController {

    private final  RegionService regionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param region 行政区划表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_region_view')" )
    public R getRegionPage(Page page, Region region) {
        return R.ok(regionService.page(page, Wrappers.query(region)));
    }


    /**
     * 通过id查询行政区划表
     * @param code id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{code}" )
    @PreAuthorize("@pms.hasPermission('admin_region_view')" )
    public R getById(@PathVariable("code" ) String code) {
        return R.ok(regionService.getById(code));
    }

    /**
     * 新增行政区划表
     * @param region 行政区划表
     * @return R
     */
    @ApiOperation(value = "新增行政区划表", notes = "新增行政区划表")
    @SysLog("新增行政区划表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_region_add')" )
    public R save(@RequestBody Region region) {
        return R.ok(regionService.save(region));
    }

    /**
     * 修改行政区划表
     * @param region 行政区划表
     * @return R
     */
    @ApiOperation(value = "修改行政区划表", notes = "修改行政区划表")
    @SysLog("修改行政区划表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_region_edit')" )
    public R updateById(@RequestBody Region region) {
        return R.ok(regionService.updateById(region));
    }

    /**
     * 通过id删除行政区划表
     * @param code id
     * @return R
     */
    @ApiOperation(value = "通过id删除行政区划表", notes = "通过id删除行政区划表")
    @SysLog("通过id删除行政区划表" )
    @DeleteMapping("/{code}" )
    @PreAuthorize("@pms.hasPermission('admin_region_del')" )
    public R removeById(@PathVariable String code) {
        return R.ok(regionService.removeById(code));
    }

}
