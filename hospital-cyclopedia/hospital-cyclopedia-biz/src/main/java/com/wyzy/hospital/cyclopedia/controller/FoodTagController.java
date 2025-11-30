

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.FoodTag;
import com.wyzy.hospital.cyclopedia.service.FoodTagService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 食物标签中间表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/foodtag" )
@Api(value = "foodtag", tags = "食物标签中间表管理")
public class FoodTagController {

    private final  FoodTagService foodTagService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param foodTag 食物标签中间表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodtag_view')" )
    public R getFoodTagPage(Page page, FoodTag foodTag) {
        return R.ok(foodTagService.page(page, Wrappers.query(foodTag)));
    }


    /**
     * 通过id查询食物标签中间表
     * @param foodTagId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{foodTagId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodtag_view')" )
    public R getById(@PathVariable("foodTagId" ) Long foodTagId) {
        return R.ok(foodTagService.getById(foodTagId));
    }

    /**
     * 新增食物标签中间表
     * @param foodTag 食物标签中间表
     * @return R
     */
    @ApiOperation(value = "新增食物标签中间表", notes = "新增食物标签中间表")
    @SysLog("新增食物标签中间表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodtag_add')" )
    public R save(@RequestBody FoodTag foodTag) {
        return R.ok(foodTagService.save(foodTag));
    }

    /**
     * 修改食物标签中间表
     * @param foodTag 食物标签中间表
     * @return R
     */
    @ApiOperation(value = "修改食物标签中间表", notes = "修改食物标签中间表")
    @SysLog("修改食物标签中间表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodtag_edit')" )
    public R updateById(@RequestBody FoodTag foodTag) {
        return R.ok(foodTagService.updateById(foodTag));
    }

    /**
     * 通过id删除食物标签中间表
     * @param foodTagId id
     * @return R
     */
    @ApiOperation(value = "通过id删除食物标签中间表", notes = "通过id删除食物标签中间表")
    @SysLog("通过id删除食物标签中间表" )
    @DeleteMapping("/{foodTagId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodtag_del')" )
    public R removeById(@PathVariable Long foodTagId) {
        return R.ok(foodTagService.removeById(foodTagId));
    }

}
