

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.CyReagentDetails;
import com.wyzy.hospital.cyclopedia.service.CyReagentDetailsService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 公司药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cyreagentdetails" )
@Api(value = "cyreagentdetails", tags = "公司药品详情表管理")
public class CyReagentDetailsController {

    private final  CyReagentDetailsService cyReagentDetailsService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param cyReagentDetails 公司药品详情表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyreagentdetails_view')" )
    public R getCyReagentDetailsPage(Page page, CyReagentDetails cyReagentDetails) {
        return R.ok(cyReagentDetailsService.page(page, Wrappers.query(cyReagentDetails)));
    }


    /**
     * 通过id查询公司药品详情表
     * @param cyReagentDetailsId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{cyReagentDetailsId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyreagentdetails_view')" )
    public R getById(@PathVariable("cyReagentDetailsId" ) Long cyReagentDetailsId) {
        return R.ok(cyReagentDetailsService.getById(cyReagentDetailsId));
    }

    /**
     * 新增公司药品详情表
     * @param cyReagentDetails 公司药品详情表
     * @return R
     */
    @ApiOperation(value = "新增公司药品详情表", notes = "新增公司药品详情表")
    @SysLog("新增公司药品详情表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyreagentdetails_add')" )
    public R save(@RequestBody CyReagentDetails cyReagentDetails) {
        return R.ok(cyReagentDetailsService.save(cyReagentDetails));
    }

    /**
     * 修改公司药品详情表
     * @param cyReagentDetails 公司药品详情表
     * @return R
     */
    @ApiOperation(value = "修改公司药品详情表", notes = "修改公司药品详情表")
    @SysLog("修改公司药品详情表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyreagentdetails_edit')" )
    public R updateById(@RequestBody CyReagentDetails cyReagentDetails) {
        return R.ok(cyReagentDetailsService.updateById(cyReagentDetails));
    }

    /**
     * 通过id删除公司药品详情表
     * @param cyReagentDetailsId id
     * @return R
     */
    @ApiOperation(value = "通过id删除公司药品详情表", notes = "通过id删除公司药品详情表")
    @SysLog("通过id删除公司药品详情表" )
    @DeleteMapping("/{cyReagentDetailsId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cyreagentdetails_del')" )
    public R removeById(@PathVariable Long cyReagentDetailsId) {
        return R.ok(cyReagentDetailsService.removeById(cyReagentDetailsId));
    }

}
