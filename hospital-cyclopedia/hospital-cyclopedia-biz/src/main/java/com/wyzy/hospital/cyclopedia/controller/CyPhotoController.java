

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.CyPhoto;
import com.wyzy.hospital.cyclopedia.service.CyPhotoService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 轮播图表
 *
 * @author hospital code generator
 * @date 2021-06-07 11:09:07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cyphoto" )
@Api(value = "cyphoto", tags = "轮播图表管理")
public class CyPhotoController {

    private final  CyPhotoService cyPhotoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param cyPhoto 轮播图表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyphoto_view')" )
    public R getCyPhotoPage(Page page, CyPhoto cyPhoto) {
        return R.ok(cyPhotoService.page(page, Wrappers.query(cyPhoto)));
    }


    /**
     * 通过id查询轮播图表
     * @param photoId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{photoId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyphoto_view')" )
    public R getById(@PathVariable("photoId" ) Long photoId) {
        return R.ok(cyPhotoService.getById(photoId));
    }

    /**
     * 新增轮播图表
     * @param cyPhoto 轮播图表
     * @return R
     */
    @ApiOperation(value = "新增轮播图表", notes = "新增轮播图表")
    @SysLog("新增轮播图表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyphoto_add')" )
    public R save(@RequestBody CyPhoto cyPhoto) {
        return R.ok(cyPhotoService.save(cyPhoto));
    }

    /**
     * 修改轮播图表
     * @param cyPhoto 轮播图表
     * @return R
     */
    @ApiOperation(value = "修改轮播图表", notes = "修改轮播图表")
    @SysLog("修改轮播图表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyphoto_edit')" )
    public R updateById(@RequestBody CyPhoto cyPhoto) {
        return R.ok(cyPhotoService.updateById(cyPhoto));
    }

    /**
     * 通过id删除轮播图表
     * @param photoId id
     * @return R
     */
    @ApiOperation(value = "通过id删除轮播图表", notes = "通过id删除轮播图表")
    @SysLog("通过id删除轮播图表" )
    @DeleteMapping("/{photoId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyphoto_del')" )
    public R removeById(@PathVariable Long photoId) {
        return R.ok(cyPhotoService.removeById(photoId));
    }

}
