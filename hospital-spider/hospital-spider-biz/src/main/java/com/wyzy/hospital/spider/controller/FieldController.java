

package com.wyzy.hospital.spider.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.spider.entity.Field;
import com.wyzy.hospital.spider.service.FieldService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 爬虫字段
 *
 * @author aqie
 * @date 2021-06-02 17:36:13
 */
@RestController
@AllArgsConstructor
@RequestMapping("/field" )
@Api(value = "field", tags = "爬虫字段管理")
public class FieldController {

    private final  FieldService fieldService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param field 爬虫字段
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('spider_field_view')" )
    public R getFieldPage(Page page, Field field) {
        return R.ok(fieldService.page(page, Wrappers.query(field)));
    }


    /**
     * 通过id查询爬虫字段
     * @param fieldId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{fieldId}" )
    @PreAuthorize("@pms.hasPermission('spider_field_view')" )
    public R getById(@PathVariable("fieldId" ) Integer fieldId) {
        return R.ok(fieldService.getById(fieldId));
    }

    /**
     * 新增爬虫字段
     * @param field 爬虫字段
     * @return R
     */
    @ApiOperation(value = "新增爬虫字段", notes = "新增爬虫字段")
    @SysLog("新增爬虫字段" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('spider_field_add')" )
    public R save(@RequestBody Field field) {
        return R.ok(fieldService.save(field));
    }

    /**
     * 修改爬虫字段
     * @param field 爬虫字段
     * @return R
     */
    @ApiOperation(value = "修改爬虫字段", notes = "修改爬虫字段")
    @SysLog("修改爬虫字段" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('spider_field_edit')" )
    public R updateById(@RequestBody Field field) {
        return R.ok(fieldService.updateById(field));
    }

    /**
     * 通过id删除爬虫字段
     * @param fieldId id
     * @return R
     */
    @ApiOperation(value = "通过id删除爬虫字段", notes = "通过id删除爬虫字段")
    @SysLog("通过id删除爬虫字段" )
    @DeleteMapping("/{fieldId}" )
    @PreAuthorize("@pms.hasPermission('spider_field_del')" )
    public R removeById(@PathVariable Integer fieldId) {
        return R.ok(fieldService.removeById(fieldId));
    }

}
