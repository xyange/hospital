

package com.wyzy.hospital.cyclopedia.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.Effect;
import com.wyzy.hospital.cyclopedia.service.EffectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 功效表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:13
 */
@RestController
@AllArgsConstructor
@RequestMapping("/effect" )
@Api(value = "effect", tags = "功效表管理")
public class EffectController {

    private final  EffectService effectService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param effect 功效表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_effect_view')" )
    public R getEffectPage(Page page, Effect effect) {
        return R.ok(effectService.page(page, Wrappers.query(effect)));
    }


    /**
     * 通过id查询功效表
     * @param effectId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{effectId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_effect_view')" )
    public R getById(@PathVariable("effectId" ) Long effectId) {
        return R.ok(effectService.getById(effectId));
    }

    /**
     * 新增功效表
     * @param effect 功效表
     * @return R
     */
    @ApiOperation(value = "新增功效表", notes = "新增功效表")
    @SysLog("新增功效表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_effect_add')" )
    public R save(@RequestBody Effect effect) {
        return R.ok(effectService.save(effect));
    }

    /**
     * 修改功效表
     * @param effect 功效表
     * @return R
     */
    @ApiOperation(value = "修改功效表", notes = "修改功效表")
    @SysLog("修改功效表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_effect_edit')" )
    public R updateById(@RequestBody Effect effect) {
        return R.ok(effectService.updateById(effect));
    }

    /**
     * 通过id删除功效表
     * @param effectId id
     * @return R
     */
    @ApiOperation(value = "通过id删除功效表", notes = "通过id删除功效表")
    @SysLog("通过id删除功效表" )
    @DeleteMapping("/{effectId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_effect_del')" )
    public R removeById(@PathVariable Long effectId) {
        return R.ok(effectService.removeById(effectId));
    }




}
