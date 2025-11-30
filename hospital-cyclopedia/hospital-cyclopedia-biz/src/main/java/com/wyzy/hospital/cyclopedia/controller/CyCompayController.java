

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.CyCompay;
import com.wyzy.hospital.cyclopedia.service.CyCompayService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 制药公司表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cycompay")
@Api(value = "cycompay", tags = "制药公司表管理")
public class CyCompayController {

    private final  CyCompayService cyCompayService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param cyCompay 制药公司表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cycompay_view')" )
    public R getCyCompayPage(Page page, CyCompay cyCompay) {
        return R.ok(cyCompayService.page(page, Wrappers.query(cyCompay)));
    }


    /**
     * 通过id查询制药公司表
     * @param compayId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{compayId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cycompay_view')" )
    public R getById(@PathVariable("compayId" ) Long compayId) {
        return R.ok(cyCompayService.getById(compayId));
    }

    /**
     * 新增制药公司表
     * @param cyCompay 制药公司表
     * @return R
     */
    @ApiOperation(value = "新增制药公司表", notes = "新增制药公司表")
    @SysLog("新增制药公司表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cycompay_add')" )
    public R save(@RequestBody CyCompay cyCompay) {
        return R.ok(cyCompayService.save(cyCompay));
    }

    /**
     * 修改制药公司表
     * @param cyCompay 制药公司表
     * @return R
     */
    @ApiOperation(value = "修改制药公司表", notes = "修改制药公司表")
    @SysLog("修改制药公司表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cycompay_edit')" )
    public R updateById(@RequestBody CyCompay cyCompay) {
        return R.ok(cyCompayService.updateById(cyCompay));
    }

    /**
     * 通过id删除制药公司表
     * @param compayId id
     * @return R
     */
    @ApiOperation(value = "通过id删除制药公司表", notes = "通过id删除制药公司表")
    @SysLog("通过id删除制药公司表" )
    @DeleteMapping("/{compayId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cycompay_del')" )
    public R removeById(@PathVariable Long compayId) {
        return R.ok(cyCompayService.removeById(compayId));
    }

}
