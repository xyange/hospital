

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.CounselType;
import com.wyzy.hospital.psychology.service.CounselTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 资讯类型表
 *
 * @author hospital code generator
 * @date 2021-06-11 14:40:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/counseltype" )
@Api(value = "counseltype", tags = "资讯类型表管理")
public class CounselTypeController {

    private final  CounselTypeService counselTypeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param counselType 资讯类型表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_counseltype_view')" )
    public R getCounselTypePage(Page page, CounselType counselType) {
        return R.ok(counselTypeService.page(page, Wrappers.query(counselType)));
    }


    /**
     * 通过id查询资讯类型表
     * @param counselId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{counselId}" )
    @PreAuthorize("@pms.hasPermission('psychology_counseltype_view')" )
    public R<CounselType> getById(@PathVariable("counselId" ) Integer counselId) {
        return R.ok(counselTypeService.getById(counselId));
    }

    /**
     * 新增资讯类型表
     * @param counselType 资讯类型表
     * @return R
     */
    @ApiOperation(value = "新增资讯类型表", notes = "新增资讯类型表")
    @SysLog("新增资讯类型表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_counseltype_add')" )
    public R<Boolean> save(@RequestBody CounselType counselType) {
        return R.ok(counselTypeService.save(counselType));
    }

    /**
     * 修改资讯类型表
     * @param counselType 资讯类型表
     * @return R
     */
    @ApiOperation(value = "修改资讯类型表", notes = "修改资讯类型表")
    @SysLog("修改资讯类型表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_counseltype_edit')" )
    public R<Boolean> updateById(@RequestBody CounselType counselType) {
        return R.ok(counselTypeService.updateById(counselType));
    }

    /**
     * 通过id删除资讯类型表
     * @param counselId id
     * @return R
     */
    @ApiOperation(value = "通过id删除资讯类型表", notes = "通过id删除资讯类型表")
    @SysLog("通过id删除资讯类型表" )
    @DeleteMapping("/{counselId}" )
    @PreAuthorize("@pms.hasPermission('psychology_counseltype_del')" )
    public R<Boolean> removeById(@PathVariable Integer counselId) {
        return R.ok(counselTypeService.removeCounselTypeById(counselId));
    }

}
