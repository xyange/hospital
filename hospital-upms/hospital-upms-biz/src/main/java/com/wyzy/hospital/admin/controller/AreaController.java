

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.Area;
import com.wyzy.hospital.admin.service.AreaService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author aqie
 * @date 2021-04-10 10:57:08
 */
@RestController
@AllArgsConstructor
@RequestMapping("/area" )
@Api(value = "area", tags = "区域管理")
public class AreaController {

    private final  AreaService areaService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param area 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_area_view')" )
    public R getAreaPage(Page page, Area area) {
        return R.ok(areaService.page(page, Wrappers.query(area)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_area_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(areaService.getById(id));
    }

    /**
     * 新增
     * @param area 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_area_add')" )
    public R save(@RequestBody Area area) {
        return R.ok(areaService.save(area));
    }

    /**
     * 修改
     * @param area 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_area_edit')" )
    public R updateById(@RequestBody Area area) {
        return R.ok(areaService.updateById(area));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_area_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(areaService.removeById(id));
    }


    /**
     * 通过父id查询
     * @param parentId
     * @return
     */
    @ApiOperation(value = "通过父id查询", notes = "通过父id查询")
    @GetMapping("/listAreaByParentId" )
    @PreAuthorize("@pms.hasPermission('admin_area_view')" )
    public R listAreaByParentId(Integer parentId,String areaName) {
        return R.ok(areaService.listAreaByParentId(parentId,areaName));
    }

}
