

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.PsychologyCategory;
import com.wyzy.hospital.psychology.service.PsychologyCategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理分类表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/psychologycategory" )
@Api(value = "psychologycategory", tags = "心理分类表管理")
public class PsychologyCategoryController {

    private final  PsychologyCategoryService psychologyCategoryService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param psychologyCategory 心理分类表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_psychologycategory_view')" )
    public R getPsychologyCategoryPage(Page page, PsychologyCategory psychologyCategory) {
        return R.ok(psychologyCategoryService.page(page, Wrappers.query(psychologyCategory)));
    }


    /**
     * 通过id查询心理分类表
     * @param categoryId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{categoryId}" )
    @PreAuthorize("@pms.hasPermission('psychology_psychologycategory_view')" )
    public R<PsychologyCategory> getById(@PathVariable("categoryId" ) Long categoryId) {
        return R.ok(psychologyCategoryService.getById(categoryId));
    }

    /**
     * 新增心理分类表
     * @param psychologyCategory 心理分类表
     * @return R
     */
    @ApiOperation(value = "新增心理分类表", notes = "新增心理分类表")
    @SysLog("新增心理分类表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_psychologycategory_add')" )
    public R<Boolean> save(@RequestBody PsychologyCategory psychologyCategory) {
        return R.ok(psychologyCategoryService.savePsychologyCategory(psychologyCategory));
    }

    /**
     * 修改心理分类表
     * @param psychologyCategory 心理分类表
     * @return R
     */
    @ApiOperation(value = "修改心理分类表", notes = "修改心理分类表")
    @SysLog("修改心理分类表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_psychologycategory_edit')" )
    public R<Boolean> updateById(@RequestBody PsychologyCategory psychologyCategory) {
        return R.ok(psychologyCategoryService.updateById(psychologyCategory));
    }

    /**
     * 通过id删除心理分类表
     * @param categoryId id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理分类表", notes = "通过id删除心理分类表")
    @SysLog("通过id删除心理分类表" )
    @DeleteMapping("/{categoryId}" )
    @PreAuthorize("@pms.hasPermission('psychology_psychologycategory_del')" )
    public R<Boolean> removeById(@PathVariable Long categoryId) {
        return R.ok(psychologyCategoryService.removePsychologyCategoryById(categoryId));
    }

}
