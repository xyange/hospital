package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.dto.member.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.PatientCard;
import com.wyzy.hospital.admin.kit.PatientCardKitService;
import com.wyzy.hospital.admin.service.PatientCardService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/27  11:17
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/patientCard" )
@Api(value = "appPatientCard", tags = "app就诊人")
public class AppPatientCardController {
    private final PatientCardKitService patientCardKitService;

    @ApiOperation(value = "就诊人列表", notes = "会员下所有就诊人")
    @GetMapping("/getPatientCard" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<PatientCardDTO>> getPatientCard(Long memberId) {
        List<PatientCardDTO> patientCards = patientCardKitService.getPatientCard(memberId);
        return R.ok(patientCards);
    }

    /**
     * 新增就诊人
     * @param patientCardDTO
     * @return
     */
    @ApiOperation(value = "新增就诊人", notes = "新增就诊人")
    @PostMapping("/addPatientCard" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<Boolean> addPatientCard(@RequestBody PatientCardDTO patientCardDTO) {
        return R.ok(patientCardKitService.addPatientCard(patientCardDTO));
    }

    /**
     * 通过id查询就诊卡
     * @param cardId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{cardId}" )
    @PreAuthorize("@pms.hasPermission('admin_patientcard_view')" )
    public R<PatientCardDTO> getById(@PathVariable("cardId" ) Long cardId) {
        return R.ok(patientCardKitService.getById(cardId));
    }

    /**
     * 修改就诊卡
     * @param patientCardDTO 就诊卡
     * @return R
     */
    @ApiOperation(value = "修改就诊卡", notes = "修改就诊卡")
    @SysLog("修改就诊卡" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_patientcard_edit')" )
    public R<Boolean> updateById(@RequestBody PatientCardDTO patientCardDTO) {
        return R.ok(patientCardKitService.updateById(patientCardDTO));
    }
}
