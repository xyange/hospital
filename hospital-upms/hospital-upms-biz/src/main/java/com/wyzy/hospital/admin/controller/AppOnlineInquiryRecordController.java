package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.dto.online.OnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.kit.OnlineInquiryRecordKitService;
import com.wyzy.hospital.admin.service.OnlineInquiryRecordService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/27  14:15
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/onlineinquiryrecord" )
@Api(value = "appOnlineinquiryrecord", tags = "app在线问诊记录管理")
public class AppOnlineInquiryRecordController {

    private final OnlineInquiryRecordService onlineInquiryRecordService;
    private final OnlineInquiryRecordKitService onlineInquiryRecordKitService;

    /**
     * 新增在线问诊记录
     * @param record 在线问诊记录
     * @return R
     */
    @ApiOperation(value = "新增在线问诊记录", notes = "新增在线问诊记录")
    @SysLog("新增在线问诊记录")
    @PostMapping("/addRecord")
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R save(OnlineInquiryRecordDTO record,@RequestPart("files")MultipartFile[] files) {
        return onlineInquiryRecordKitService.addRecord(record,files);
    }

    /**
     * 根据问诊状态查询在线问诊记录
     * @param memberId 会员ID
     * @param status 问诊状态
     * null-全部 0-进行中 1-已结束 2-已退款
     * @return
     */
    @ApiOperation(value = "根据问诊状态查询问诊记录", notes = "status: null-全部 0-进行中 1-已结束 2-已退款")
    @GetMapping("/status" )
    @ApiImplicitParams({@ApiImplicitParam(name = "memberId", value = "会员id", paramType = "query")})
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<OnlineInquiryRecordDTO>> getPojoByStatus(Long memberId,Integer status) {
        return R.ok(onlineInquiryRecordService.getPojoByStatus(memberId,status));
    }



}
