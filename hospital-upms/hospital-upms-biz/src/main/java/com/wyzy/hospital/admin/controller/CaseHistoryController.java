

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.CaseHistory;
import com.wyzy.hospital.admin.service.CaseHistoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 病历表
 *
 * @author aqie
 * @date 2021-04-26 15:27:03
 */
@RestController
@AllArgsConstructor
@RequestMapping("/casehistory" )
@Api(value = "casehistory", tags = "病历表管理")
public class CaseHistoryController {

    private final  CaseHistoryService caseHistoryService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param caseHistory 病历表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_casehistory_view')" )
    public R getCaseHistoryPage(Page page, CaseHistory caseHistory) {
        return R.ok(caseHistoryService.page(page, Wrappers.query(caseHistory)));
    }


    /**
     * 通过id查询病历表
     * @param caseHistoryId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{caseHistoryId}" )
    @PreAuthorize("@pms.hasPermission('admin_casehistory_view')" )
    public R getById(@PathVariable("caseHistoryId" ) Long caseHistoryId) {
        return R.ok(caseHistoryService.getById(caseHistoryId));
    }

    /**
     * 新增病历表
     * @param caseHistory 病历表
     * @return R
     */
    @ApiOperation(value = "新增病历表", notes = "新增病历表")
    @SysLog("新增病历表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_casehistory_add')" )
    public R save(@RequestBody CaseHistory caseHistory) {
        return R.ok(caseHistoryService.save(caseHistory));
    }

    /**
     * 修改病历表
     * @param caseHistory 病历表
     * @return R
     */
    @ApiOperation(value = "修改病历表", notes = "修改病历表")
    @SysLog("修改病历表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_casehistory_edit')" )
    public R updateById(@RequestBody CaseHistory caseHistory) {
        return R.ok(caseHistoryService.updateById(caseHistory));
    }

    /**
     * 通过id删除病历表
     * @param caseHistoryId id
     * @return R
     */
    @ApiOperation(value = "通过id删除病历表", notes = "通过id删除病历表")
    @SysLog("通过id删除病历表" )
    @DeleteMapping("/{caseHistoryId}" )
    @PreAuthorize("@pms.hasPermission('admin_casehistory_del')" )
    public R removeById(@PathVariable Long caseHistoryId) {
        return R.ok(caseHistoryService.removeById(caseHistoryId));
    }

}
