package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.exception.GlobalException;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.PatientCard;
import com.wyzy.hospital.admin.service.PatientCardService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 就诊卡
 *
 * @author aqie
 * @date 2021-04-26 15:23:39
 */
@RestController
@AllArgsConstructor
@RequestMapping("/patientcard" )
@Api(value = "patientcard", tags = "就诊卡管理")
public class PatientCardController {

    private final  PatientCardService patientCardService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param patientCard 就诊卡
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_patientcard_view')" )
    public R getPatientCardPage(Page page, PatientCard patientCard) {
        return R.ok(patientCardService.page(page, Wrappers.query(patientCard)));
    }

    /**
     * 通过id查询就诊卡
     * @param cardId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{cardId}" )
    @PreAuthorize("@pms.hasPermission('admin_patientcard_view')" )
    public R getById(@PathVariable("cardId" ) Long cardId) {
        return R.ok(patientCardService.getById(cardId));
    }

    /**
     * 修改就诊卡
     * @param patientCard 就诊卡
     * @return R
     */
    @ApiOperation(value = "修改就诊卡", notes = "修改就诊卡")
    @SysLog("修改就诊卡" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_patientcard_edit')" )
    public R updateById(@RequestBody PatientCard patientCard) {
        return R.ok(patientCardService.updateById(patientCard));
    }

    /**
     * 通过id删除就诊卡
     * @param cardId id
     * @return R
     */
    @ApiOperation(value = "通过id删除就诊卡", notes = "通过id删除就诊卡")
    @SysLog("通过id删除就诊卡" )
    @DeleteMapping("/{cardId}" )
    @PreAuthorize("@pms.hasPermission('admin_patientcard_del')" )
    public R removeById(@PathVariable Long cardId) {
        return R.ok(patientCardService.removeById(cardId));
    }
}
