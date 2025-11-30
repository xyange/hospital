package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.vo.hospital.HospitalsCollectVO;
import com.wyzy.hospital.admin.service.AppDoctorService;
import com.wyzy.hospital.admin.service.ClinicService;
import com.wyzy.hospital.admin.service.UserHospitalService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * App个人中心 我的收藏
 *
 * @author wrk
 * @date 2021/05/25 10:25
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/app/myCollect")
@Api(value = "appPersonalCenter", tags = "App个人中心 我的收藏")
public class AppMyCollect {
    private final ClinicService clinicService;
    private final UserHospitalService userHospitalService;
    private final AppDoctorService appDoctorService;

    /**
     * 个人中心 我收藏的医院
     *
     * @return com.wyzy.hospital.common.core.util.R
     * @author wrk
     * @date 2021/05/25 10:29
     */
    @ApiOperation(value = "个人中心 我收藏的医院", notes = "个人中心 我收藏的医院")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "longitude", value = "经度", paramType = "query",example="115.682979",required = true),
            @ApiImplicitParam(name = "latitude", value = "纬度", paramType = "query",example="37.740753",required = true)})
    @GetMapping("/getCollectedHospital")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<IPage<HospitalsCollectVO>> getCollectedHospital(Query query,String longitude, String latitude) {
        IPage<HospitalsCollectVO> pa=userHospitalService.getCollectedHospital(Condition.getPage(query),longitude,latitude);
        if(pa.getRecords()==null || pa.getRecords().size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(pa);
    }

    /**
     * 个人中心 我收藏的诊所
     * @param longitude 经度
     * @param latitude 纬度
     * @return com.wyzy.hospital.common.core.util.R
     * @author wrk
     * @date 2021/05/25 11:23
     */
    @ApiOperation(value = "个人中心 我收藏的诊所", notes = "个人中心 我收藏的诊所")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "longitude", value = "经度", paramType = "query",example="115.682979",required = true),
            @ApiImplicitParam(name = "latitude", value = "纬度", paramType = "query",example="37.740753",required = true)})
    @GetMapping("/getCollectedClinic")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<IPage<ClinicDiagnosisServiceDto>> getCollectedClinic(Query query, String longitude, String latitude) {
        IPage<ClinicDiagnosisServiceDto> pa=clinicService.getCollectedClinic(Condition.getPage(query),longitude, latitude);
        if(pa.getRecords()==null || pa.getRecords().size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(pa);
    }

    /**
     * 个人中心 我收藏的医生
     *
     * @return com.wyzy.hospital.common.core.util.R
     * @author wrk
     * @date 2021/05/25 10:29
     */
    @ApiOperation(value = "个人中心 我收藏的医生", notes = "个人中心 我收藏的医生")
    @GetMapping("/getCollectedDoctor")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<AppDoctorDTO>> getCollectedDoctor() {
        List<AppDoctorDTO> list =appDoctorService.getCollectedDoctors();
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * 个人中心 我收藏的药房
     *
     * @return com.wyzy.hospital.common.core.util.R
     * @author wrk
     * @date 2021/05/25 10:29
     */
    @ApiOperation(value = "个人中心 我收藏的药房(未做)", notes = "个人中心 我收藏的药房")
    @GetMapping("/getCollectedPharmacy")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R getCollectedPharmacy() {
        return null;
    }
}
