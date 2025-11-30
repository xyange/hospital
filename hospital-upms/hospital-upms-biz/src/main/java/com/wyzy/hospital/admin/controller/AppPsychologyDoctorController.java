package com.wyzy.hospital.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.service.*;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 心理医生控制器
 *
 * @author wrk
 * @date 2021/06/03 09:36
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/app/psychologyDoctor")
@Api(value = "psychologyDoctor", tags = "心理医生")

public class AppPsychologyDoctorController {

    private final AppPsychologyDoctorService appPsychologyDoctorService;
    @ApiOperation(value = "查心理医生List", notes = "查心理医生List")
    @GetMapping("getPsychologyDoctorIds")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<Doctor>> getPsychologyDoctorIds(Integer sex,String area) {
        List<Doctor> doctorList= appPsychologyDoctorService.getPsychologyDoctorIds(sex,area);
        if(doctorList == null || doctorList.size() == 0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(doctorList);
    }

    @ApiOperation(value = "根据医生ID查询医生信息", notes = "根据医生ID查询医生信息")
    @GetMapping("getPsychologyByDoctorId")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<Doctor> getPsychologyByDoctorId(Long doctorId) {
        Doctor doctor= appPsychologyDoctorService.getPsychologyByDoctorId(doctorId);
        if(doctor == null){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(doctor);
    }
}
