package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.entity.Disease;
import com.wyzy.hospital.admin.api.vo.AppDoctorDetailVO;
import com.wyzy.hospital.admin.service.AppDoctorKitService;
import com.wyzy.hospital.admin.service.AppDoctorService;
import com.wyzy.hospital.admin.service.DepartmentDiseaseService;
import com.wyzy.hospital.admin.service.DiseaseService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 患者端app 医生
 *
 * @author Wrk
 */

@RestController
@AllArgsConstructor
@RequestMapping("/app/doctor")
@Api(value = "appDoctor", tags = "App端医生")
public class AppDoctorController {
    private final AppDoctorService appDoctorService;
    private final AppDoctorKitService appDoctorKitService;
    private final DepartmentDiseaseService departmentDiseaseService;
    private final DiseaseService diseaseService;

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param keyWord 关键词 医生姓名/症状/科室/医院
     * @return
     */
    @ApiOperation(value = "条件分页查询", notes = "条件分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyWord", value = "医生姓名/症状/科室/医院", paramType = "query", example = ""),
            @ApiImplicitParam(name = "area", value = "区域", paramType = "query", example = "河北省，衡水市，桃城区"),
            @ApiImplicitParam(name = "departmentId", value = "科室id", paramType = "query", example = ""),
            @ApiImplicitParam(name = "sortCode", value = "是否根据peopleNumber 排序 ，不排序的话不用传", paramType = "query", example = "true"),
            @ApiImplicitParam(name = "serviceId", value = "服务", paramType = "query", example = ""),
            @ApiImplicitParam(name = "priceBegin", value = "最低价格", paramType = "query", example = ""),
            @ApiImplicitParam(name = "priceEnd", value = "最高价格", paramType = "query", example = ""),
            @ApiImplicitParam(name = "professionalTitleId", value = "职称", paramType = "query", example = "")
    })
    @GetMapping("/page")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R getDoctorPage(Page page, String keyWord, String area, Long departmentId,
                           String sortCode, Long serviceId, Integer priceBegin,
                           Integer priceEnd, Long professionalTitleId) {
        List<AppDoctorDTO> list = appDoctorService.listAllDoctorBy(keyWord, area, departmentId, sortCode, serviceId, priceBegin, priceEnd, professionalTitleId, page);
        if (list == null) {
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * 查医生收藏
     *
     * @return
     */
    @ApiOperation(value = "查询收藏的医生", notes = "查询收藏的医生")
    @GetMapping("/getCollectDoctors")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<AppDoctorDTO>> getCollectDoctors() {
        List<AppDoctorDTO> list=appDoctorService.getCollectedDoctors();
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * 医生收藏/取消收藏
     *
     * @param doctorId 医生id
     * @return
     */
    @ApiOperation(value = "医生收藏/取消收藏", notes = "医生收藏/取消收藏")
    @PostMapping("/collectDoctors")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R collectDoctors(Long doctorId) {
        HospitalUser user = SecurityUtils.getUser();
        return appDoctorService.collectedDoctor(user.getId().longValue(), doctorId);
    }

    /**
     * app 医生页 查科室以及内的疾病（一级科室）
     *
     * @return R
     */
    @ApiOperation(value = "app 医生页 查科室疾病", notes = "app 医生页查询科室疾病")
    @GetMapping("/appListDepartmentDisease")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<DepartmentsDiseaseDTO>> listDepartmentDisease() {
        List<DepartmentsDiseaseDTO> list=departmentDiseaseService.appListDepartmentDisease();
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * app 医生页 查常见疾病
     *
     * @return R
     */
    @ApiOperation(value = "app 医生页 查常见疾病", notes = "app 医生页 查常见疾病")
    @GetMapping("/appListCommonDisease")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<Disease>> appListCommonDisease() {
        List<Disease> list=diseaseService.appListCommonDiseaseOnDoctor();
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * 医生详情页
     *
     * @return R
     */
    @ApiOperation(value = "app 医生页 医生详情", notes = "app 医生页 医生详情")
    @GetMapping("/appDoctorDetail")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<AppDoctorDetailVO> appDoctorDetail(Long id) {
        HospitalUser user = SecurityUtils.getUser();
        AppDoctorDetailVO vo=appDoctorKitService.appDoctorDetailVo(id, user.getId());
        if(vo==null){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(vo);
    }


    /**
     * 医生页-- 推荐其他同科室医生 按照服务人次排序
     *
     * @param deportmentId
     * @param doctorId
     * @param deportmentName
     * @param doctorName
     * @return com.wyzy.hospital.common.core.util.R<java.util.List < com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>>
     * @author wrk
     * @date 2021/05/24 14:08
     */
    @ApiOperation(value = "app 医生页 推荐其他同科室医生", notes = "app 医生页 推荐其他同科室医生")
    @ApiImplicitParams({@ApiImplicitParam(name = "deportmentId", value = "科室id", paramType = "query", example = "7"),
            @ApiImplicitParam(name = "doctorId", value = "医生id", paramType = "query", example = "28"),
            @ApiImplicitParam(name = "deportmentName", value = "科室名称", paramType = "query", example = "胸外科"),
            @ApiImplicitParam(name = "doctorName", value = "医生名称", paramType = "query", example = "江永天")})
    @GetMapping("/appDoctorRecommend")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<AppDoctorDTO>> appDoctorRecommend(Long deportmentId, Long doctorId, String deportmentName, String doctorName) {
        List<AppDoctorDTO> list=appDoctorService.appDoctorRecommend(deportmentId, doctorId, deportmentName, doctorName);
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * 医生筛选
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
    @ApiOperation(value = "医生筛选", notes = "医生筛选")
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
            @ApiImplicitParam(name = "distance", value = "距离(km)(填写此项以后未进行分页)", paramType = "query",example="2"),
            @ApiImplicitParam(name = "wellKnown", value = "0 非名医， 1 名医， null或不传 查全部", paramType = "query",example="")


    })
    @GetMapping("/getDoctorByFilter")
    @PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
    public R<List<AppDoctorDTO>> getDoctorByFilter(String longitude,String latitude,Double distance,
                                                   Query query, String area, Long diseaseId,
                                                   String diseaseName, Long deportmentId, String doctorName,
                                                   String sortCode, Long serveId, Integer priceBegin,
                                                   Integer priceEnd,Long professionalTitleId,Integer wellKnown) {
        List<AppDoctorDTO> list= appDoctorService.getDoctorByFilter(longitude,latitude,distance,query,area,diseaseId,diseaseName,deportmentId,doctorName,sortCode,serveId,priceBegin,priceEnd,professionalTitleId,wellKnown);
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }


}
