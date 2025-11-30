

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.RegisterRecord;
import com.wyzy.hospital.admin.service.RegisterRecordService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 挂号记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/registerrecord" )
@Api(value = "registerrecord", tags = "挂号记录管理")
public class RegisterRecordController {

    private final  RegisterRecordService registerRecordService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param registerRecord 挂号记录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_registerrecord_view')" )
    public R getRegisterRecordPage(Page page, RegisterRecord registerRecord) {
        return R.ok(registerRecordService.page(page, Wrappers.query(registerRecord)));
    }


    /**
     * 通过id查询挂号记录
     * @param registerId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{registerId}" )
    @PreAuthorize("@pms.hasPermission('admin_registerrecord_view')" )
    public R getById(@PathVariable("registerId" ) Long registerId) {
        return R.ok(registerRecordService.getById(registerId));
    }

    /**
     * 新增挂号记录
     * @param registerRecord 挂号记录
     * @return R
     */
    @ApiOperation(value = "新增挂号记录", notes = "新增挂号记录")
    @SysLog("新增挂号记录" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_registerrecord_add')" )
    public R save(@RequestBody RegisterRecord registerRecord) {
        return R.ok(registerRecordService.save(registerRecord));
    }

    /**
     * 修改挂号记录
     * @param registerRecord 挂号记录
     * @return R
     */
    @ApiOperation(value = "修改挂号记录", notes = "修改挂号记录")
    @SysLog("修改挂号记录" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_registerrecord_edit')" )
    public R updateById(@RequestBody RegisterRecord registerRecord) {
        return R.ok(registerRecordService.updateById(registerRecord));
    }

    /**
     * 通过id删除挂号记录
     * @param registerId id
     * @return R
     */
    @ApiOperation(value = "通过id删除挂号记录", notes = "通过id删除挂号记录")
    @SysLog("通过id删除挂号记录" )
    @DeleteMapping("/{registerId}" )
    @PreAuthorize("@pms.hasPermission('admin_registerrecord_del')" )
    public R removeById(@PathVariable Long registerId) {
        return R.ok(registerRecordService.removeById(registerId));
    }

}
