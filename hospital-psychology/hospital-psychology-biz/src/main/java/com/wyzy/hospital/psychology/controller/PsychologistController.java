package com.wyzy.hospital.psychology.controller;

import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.api.feign.RemoteHospitalService;
import com.wyzy.hospital.admin.api.feign.RemotePsychologyDoctorService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.Kit.OrderRecordKitService;
import com.wyzy.hospital.psychology.Kit.PsychologistRecommendDetailKitService;
import com.wyzy.hospital.psychology.Kit.PsychologistRecommendKitService;
import com.wyzy.hospital.psychology.api.dto.OrderRecordDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.service.PsychologyImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * app心理
 *
 * @author wrk
 * @date 2021/05/08 08:53
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/psychologist")
@Api(value = "psychologist", tags = "心理")
public class PsychologistController {

}
