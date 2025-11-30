package com.wyzy.hospital.admin.controller;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.entity.ConsultSetting;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.service.ConsultSettingService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 远程会诊预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:52
 */
@RestController
@AllArgsConstructor
@RequestMapping("/consultsetting" )
@Api(value = "consultsetting", tags = "远程会诊预约配置表管理")
public class ConsultSettingController {

    private final  ConsultSettingService consultSettingService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param consultSetting 远程会诊预约配置表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('admin_consultsetting_view')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R getConsultSettingPage(Page page, ConsultSetting consultSetting) {
        return R.ok(consultSettingService.page(page, Wrappers.query(consultSetting)));
    }

    /**
     * 新增远程会诊预约配置表
     * @param consultSetting 远程会诊预约配置表
     * @return R
     */
    @ApiOperation(value = "新增远程会诊预约配置表", notes = "新增远程会诊预约配置表")
    @SysLog("新增远程会诊预约配置表" )
    @PostMapping("/consultsettingAdd")
    //@PreAuthorize("@pms.hasPermission('admin_consultsetting_add')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<Boolean> save(ConsultSetting consultSetting) {
        return R.ok(consultSettingService.saveConsultSetting(consultSetting));
    }

    /**
     * 修改远程会诊预约配置表
     * @param consultSetting 远程会诊预约配置表
     * @return R
     */
    @ApiOperation(value = "修改远程会诊预约配置表", notes = "修改远程会诊预约配置表")
    @SysLog("修改远程会诊预约配置表" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('admin_consultsetting_edit')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R updateById(@RequestBody ConsultSetting consultSetting) {
        return R.ok(consultSettingService.updateById(consultSetting));
    }

    /**
     * 通过id删除远程会诊预约配置表
     * @param orderId id
     * @return R
     */
    @ApiOperation(value = "通过id删除远程会诊预约配置表", notes = "通过id删除远程会诊预约配置表")
    @SysLog("通过id删除远程会诊预约配置表" )
    @DeleteMapping("/{orderId}" )
    //@PreAuthorize("@pms.hasPermission('admin_consultsetting_del')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R removeById(@PathVariable Long orderId) {
        return R.ok(consultSettingService.removeById(orderId));
    }

    /**
     * 通过id查询远程会诊预约配置表
     * @param orderId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{orderId}" )
    //@PreAuthorize("@pms.hasPermission('admin_consultsetting_view')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R getById(@PathVariable("orderId" ) Long orderId) {
        return R.ok(consultSettingService.getById(orderId));
    }
}
