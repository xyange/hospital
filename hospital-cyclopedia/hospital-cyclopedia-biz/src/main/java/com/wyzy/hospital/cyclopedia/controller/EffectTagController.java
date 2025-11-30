

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.EffectTag;
import com.wyzy.hospital.cyclopedia.service.EffectTagService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 功效-标签中间表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:44
 */
@RestController
@AllArgsConstructor
@RequestMapping("/effecttag" )
@Api(value = "effecttag", tags = "功效-标签中间表管理")
public class EffectTagController {

    private final  EffectTagService effectTagService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param effectTag 功效-标签中间表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_effecttag_view')" )
    public R getEffectTagPage(Page page, EffectTag effectTag) {
        return R.ok(effectTagService.page(page, Wrappers.query(effectTag)));
    }


    /**
     * 通过id查询功效-标签中间表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_effecttag_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(effectTagService.getById(id));
    }

    /**
     * 新增功效-标签中间表
     * @param effectTag 功效-标签中间表
     * @return R
     */
    @ApiOperation(value = "新增功效-标签中间表", notes = "新增功效-标签中间表")
    @SysLog("新增功效-标签中间表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_effecttag_add')" )
    public R save(@RequestBody EffectTag effectTag) {
        return R.ok(effectTagService.save(effectTag));
    }

    /**
     * 修改功效-标签中间表
     * @param effectTag 功效-标签中间表
     * @return R
     */
    @ApiOperation(value = "修改功效-标签中间表", notes = "修改功效-标签中间表")
    @SysLog("修改功效-标签中间表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_effecttag_edit')" )
    public R updateById(@RequestBody EffectTag effectTag) {
        return R.ok(effectTagService.updateById(effectTag));
    }

    /**
     * 通过id删除功效-标签中间表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除功效-标签中间表", notes = "通过id删除功效-标签中间表")
    @SysLog("通过id删除功效-标签中间表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_effecttag_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(effectTagService.removeById(id));
    }

}
