

package com.wyzy.hospital.app.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.app.api.entity.UserTask;
import com.wyzy.hospital.app.service.UserTaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 用户用药计划表
 *
 * @author aqie
 * @date 2021-05-28 14:59:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/usertask" )
@Api(value = "usertask", tags = "用户用药计划表管理")
public class UserTaskController {

    private final  UserTaskService userTaskService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param userTask 用户用药计划表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('app_usertask_view')" )
    public R getUserTaskPage(Page page, UserTask userTask) {
        return R.ok(userTaskService.page(page, Wrappers.query(userTask)));
    }


    /**
     * 通过id查询用户用药计划表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('app_usertask_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(userTaskService.getById(id));
    }

    /**
     * 新增用户用药计划表
     * @param userTask 用户用药计划表
     * @return R
     */
    @ApiOperation(value = "新增用户用药计划表", notes = "新增用户用药计划表")
    @SysLog("新增用户用药计划表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('app_usertask_add')" )
    public R save(@RequestBody UserTask userTask) {
        return R.ok(userTaskService.save(userTask));
    }

    /**
     * 修改用户用药计划表
     * @param userTask 用户用药计划表
     * @return R
     */
    @ApiOperation(value = "修改用户用药计划表", notes = "修改用户用药计划表")
    @SysLog("修改用户用药计划表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('app_usertask_edit')" )
    public R updateById(@RequestBody UserTask userTask) {
        return R.ok(userTaskService.updateById(userTask));
    }

    /**
     * 通过id删除用户用药计划表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除用户用药计划表", notes = "通过id删除用户用药计划表")
    @SysLog("通过id删除用户用药计划表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('app_usertask_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(userTaskService.removeById(id));
    }

}
