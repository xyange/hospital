package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.entity.ConsultOrder;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.service.ConsultOrderService;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 远程会诊预约表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:57
 */
@RestController
@AllArgsConstructor
@RequestMapping("/consultorder" )
@Api(value = "consultorder", tags = "远程会诊预约表管理")
public class ConsultOrderController {

    private final ConsultOrderService consultOrderService;

    /**
     * 新增远程会诊预约表
     * @param consultOrder 远程会诊预约表
     * @return R
     */
    @ApiOperation(value = "新增远程会诊预约表", notes = "新增远程会诊预约表")
    @SysLog("新增远程会诊预约表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<Boolean> save(ConsultOrder consultOrder) {
        return R.ok(consultOrderService.saveConsultOrder(consultOrder));
    }

    /**
     * 分页查询
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('admin_consultorder_view')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<IPage<ConsultOrder>> getConsultOrderPage(Query query, Long memberId) {
        return R.ok(consultOrderService.pageConsultOrder(Condition.getPage(query),memberId));
    }


    /**
     * 通过id查询远程会诊预约表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('admin_consultorder_view')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<ConsultOrder> getById(@PathVariable("id" ) Long id) {
        return R.ok(consultOrderService.getById(id));
    }


    /**
     * 修改远程会诊预约表
     * @param consultOrder 远程会诊预约表
     * @return R
     */
    @ApiOperation(value = "修改远程会诊预约表", notes = "修改远程会诊预约表")
    @SysLog("修改远程会诊预约表" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('admin_consultorder_edit')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<Boolean> updateById(@RequestBody ConsultOrder consultOrder) {
        return R.ok(consultOrderService.updateById(consultOrder));
    }

    /**
     * 通过id删除远程会诊预约表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除远程会诊预约表", notes = "通过id删除远程会诊预约表")
    @SysLog("通过id删除远程会诊预约表" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('admin_consultorder_del')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(consultOrderService.removeById(id));
    }

}
