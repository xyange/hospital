package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.RegisterRecordDTO;
import com.wyzy.hospital.admin.api.entity.RegisterRecord;
import com.wyzy.hospital.admin.kit.RegisterRecordKitService;
import com.wyzy.hospital.admin.service.RegisterRecordService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/27  14:23
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/registerrecord" )
@Api(value = "appRegisterrecord", tags = "app挂号记录管理")
public class AppRegisterRecordController {
    private final RegisterRecordService registerRecordService;
    private final RegisterRecordKitService registerRecordKitService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param registerRecord 挂号记录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
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
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R getById(@PathVariable("registerId" ) Long registerId) {
        return R.ok(registerRecordService.getById(registerId));
    }

    /**
     * 插入挂号记录
     * @param registerRecord 挂号记录
     * @return R
     */
    @ApiOperation(value = "插入挂号记录", notes = "插入挂号记录")
    @PostMapping("/addRegisterRecord" )
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R addRegisterRecord(RegisterRecord registerRecord) {
        return registerRecordKitService.addRegisterRecord(registerRecord);
    }

    /**
     * 通过就诊卡ID查询挂号记录
     * @param cardId 就诊卡ID
     * @return R
     */
    @ApiOperation(value = "通过就诊卡ID查询挂号记录", notes = "通过就诊卡ID查询挂号记录")
    @GetMapping("/cardId" )
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<RegisterRecordDTO>> getByCardId(Long cardId) {
        return R.ok(registerRecordService.getPojoByCardId(cardId));
    }
}
