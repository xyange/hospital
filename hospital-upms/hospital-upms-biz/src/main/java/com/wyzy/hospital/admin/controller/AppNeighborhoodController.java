package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.dto.ClinicNeighborhoodDTO;
import com.wyzy.hospital.admin.api.dto.HospitalNeighborhoodDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.vo.AppDiseaseVO;
import com.wyzy.hospital.admin.service.AppDoctorService;
import com.wyzy.hospital.admin.service.ClinicService;
import com.wyzy.hospital.admin.service.DiseaseService;
import com.wyzy.hospital.admin.service.HospitalsService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
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
 * 本地附近
 *
 * @author wrk
 * @date 2021/05/17 11:35
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/app/neighborhood")
@Api(value = "neighborhood", tags = "App患者端本地附近")
public class AppNeighborhoodController {
    private final DiseaseService diseaseService;
    private final ClinicService clinicService;
    private final HospitalsService hospitalsService;
    private final AppDoctorService appDoctorService;
    /**
     * app患者端 本地附近页 查常见疾病
     *
     * @return R
     */
    @ApiOperation(value = "app患者端 本地附近页 查常见疾病", notes = "app患者端 本地附近页 查常见疾病")
    @GetMapping("/listDisease")
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")")
    public R<List<AppDiseaseVO>> appListCommonDisease() {
        List<AppDiseaseVO> list=diseaseService.appListCommonDiseaseOnNeighborhood();
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }
    /**
     * app患者端 本地附近页 查诊所
     *
     * @return R
     */
    @ApiOperation(value = "app患者端 本地附近页 查诊所", notes = "app患者端 本地附近页 查诊所")
    @ApiImplicitParams({@ApiImplicitParam(name = "distance", value = "距离", paramType = "query",example="2"),
            @ApiImplicitParam(name = "longitude", value = "经度", paramType = "query",example="115.682979"),
            @ApiImplicitParam(name = "latitude", value = "纬度", paramType = "query",example="37.740753"),
            @ApiImplicitParam(name = "deportmentId", value = "科室id", paramType = "query",example=""),
            @ApiImplicitParam(name = "diseaseId", value = "疾病id", paramType = "query",example=""),
            @ApiImplicitParam(name = "area", value = "区域", paramType = "query",example="河北省，衡水市，桃城区"),
            @ApiImplicitParam(name = "keyWord", value = "关键词", paramType = "query",example="")})
    @GetMapping("/listClinics")
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")")
    public R getNeighborhoodClinics(Double distance,String longitude, String latitude, Long deportmentId, Long diseaseId, String area, String keyWord) {
        List<ClinicNeighborhoodDTO> list=clinicService.getNeighborhoodClinics(distance,longitude,latitude,deportmentId,diseaseId,area,keyWord);
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * app患者端 本地附近页 查医生
     * @param area
     * @param diseaseId
     * @param deportmentId
     * @param doctorName
     * @param sortCode
     * @param serveId
     * @param priceBegin
     * @param priceEnd
     * @param professionalTitleId
     * @return com.wyzy.hospital.common.core.util.R<java.util.List < com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>>
     * @author
     * @date 2021/05/31 17:33
     */
    @ApiOperation(value = "app患者端 本地附近页 查医生", notes = "app患者端 本地附近页 查医生")
    @ApiImplicitParams({@ApiImplicitParam(name = "area", value = "区域", paramType = "query", example = "河北省，衡水市，桃城区"),
            @ApiImplicitParam(name = "diseaseId", value = "疾病id", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "diseaseName", value = "疾病名称", paramType = "query", example = "流行性感冒"),
            @ApiImplicitParam(name = "deportmentId", value = "科室Id", paramType = "query", example = "7"),
            @ApiImplicitParam(name = "doctorName", value = "医生名称", paramType = "query", example = "天"),
            @ApiImplicitParam(name = "sortCode", value = "是否根据咨询人数排序", paramType = "query", example = "true"),
            @ApiImplicitParam(name = "serveId", value = "服务id", paramType = "query", example = ""),
            @ApiImplicitParam(name = "priceBegin", value = "最低价格", paramType = "query", example = ""),
            @ApiImplicitParam(name = "priceEnd", value = "最高价格", paramType = "query", example = ""),
            @ApiImplicitParam(name = "professionalTitleId", value = "医生等级（职称）", paramType = "query", example = ""),
            @ApiImplicitParam(name = "longitude", value = "经度(填写此项以后未进行分页)", paramType = "query", example = "115.682979"),
            @ApiImplicitParam(name = "latitude", value = "纬度(填写此项以后未进行分页)", paramType = "query", example = "37.740753"),
            @ApiImplicitParam(name = "distance", value = "距离(km)(填写此项以后未进行分页)", paramType = "query",example="2")


    })
    @GetMapping("/listDoctors")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<AppDoctorDTO>> listDoctors(String longitude, String latitude, Double distance,
                                                   Query query, String area, Long diseaseId,
                                                   String diseaseName, Long deportmentId, String doctorName,
                                                   String sortCode, Long serveId, Integer priceBegin,
                                                   Integer priceEnd, Long professionalTitleId) {
        List<AppDoctorDTO> list= appDoctorService.getDoctorByFilter(longitude,latitude,distance,query,area,diseaseId,diseaseName,deportmentId,doctorName,sortCode,serveId,priceBegin,priceEnd,professionalTitleId,null);
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }


    /**
    * @Description: app患者端 本地附近页 查医院
    * @Param: [distance, longitude, latitude, deportmentId, diseaseId, area, keyWord]
    * @return: com.wyzy.hospital.common.core.util.R
    * @Author: songM
    * @Date: 2021/6/3
    */
    @ApiOperation(value = "app患者端 本地附近页 查医院", notes = "app患者端 本地附近页 查医院")
    @ApiImplicitParams({@ApiImplicitParam(name = "distance", value = "距离", paramType = "query",example="2"),
            @ApiImplicitParam(name = "longitude", value = "经度", paramType = "query",example="115.682979"),
            @ApiImplicitParam(name = "latitude", value = "纬度", paramType = "query",example="37.740753"),
            @ApiImplicitParam(name = "deportmentId", value = "科室id", paramType = "query",example=""),
            @ApiImplicitParam(name = "diseaseId", value = "疾病id", paramType = "query",example=""),
            @ApiImplicitParam(name = "area", value = "区域", paramType = "query",example="河北省，衡水市，桃城区"),
            @ApiImplicitParam(name = "keyWord", value = "关键词", paramType = "query",example="")})
    @GetMapping("/listHospitals")
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")")
    public R listHospitals(Double distance,String longitude, String latitude, Long deportmentId, Long diseaseId, String area, String keyWord) {
        List<HospitalNeighborhoodDTO> list= hospitalsService.getNeighborhoodHospitals(distance,longitude,latitude,deportmentId,diseaseId,area,keyWord);
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }
}
