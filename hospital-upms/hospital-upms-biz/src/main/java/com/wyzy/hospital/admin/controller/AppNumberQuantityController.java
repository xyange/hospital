package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDTO;
import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDetailsDTO;
import com.wyzy.hospital.admin.service.NumberQuantityService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * 号源情况
 *
 * @author wrk
 * @date 2021/05/12 15:11
 **/

@RestController
@AllArgsConstructor
@RequestMapping("/app/numberQuantity")
@Api(value = "numberQuantity", tags = "app患者端号源情况")
public class AppNumberQuantityController {
    private final NumberQuantityService numberQuantityService;
    /**
     * 根据医院id（或者医院名称）科室id（或者科室名称）查近几天号源情况
     *
     * @return
     */
    @ApiOperation(value = "科室选医 查近几天号源情况", notes = "科室选医 查近几天号源情况")
    @ApiImplicitParams({@ApiImplicitParam(name = "hospitalId", value = "医院id", paramType = "query"),
            @ApiImplicitParam(name = "hospitalName", value = "医院名称", paramType = "query"),
            @ApiImplicitParam(name = "deportmentId", value = "科室id", paramType = "query"),
            @ApiImplicitParam(name = "deportmentName", value = "科室名称", paramType = "query"),
            @ApiImplicitParam(name = "nearDays", value = "近？天", paramType = "query")})
    @GetMapping("/getNumberQuantity")
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<NumberQuantityDTO>> getNumberQuantity(Long hospitalId,String hospitalName, Long deportmentId,String deportmentName, Integer nearDays) {
        List<NumberQuantityDTO> list=numberQuantityService.getNumberQuantity(hospitalId,hospitalName, deportmentId,deportmentName, nearDays);
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

    /**
     * 根据医院id科室id日期查号源情况
     *
     * @return
     */
    @ApiOperation(value = "科室选医 根据医院id科室id日期查号源情况", notes = "科室选医 根据医院id科室id日期查号源情况")
    @ApiImplicitParams({@ApiImplicitParam(name = "hospitalId", value = "医院id", paramType = "query",example="1"),
            @ApiImplicitParam(name = "hospitalName", value = "医院名称", paramType = "query",example="衡水市人民医院"),
            @ApiImplicitParam(name = "deportmentId", value = "科室id", paramType = "query",example="7"),
            @ApiImplicitParam(name = "deportmentName", value = "科室名称", paramType = "query",example="胸外科"),
            @ApiImplicitParam(name = "registrationDate", value = "哪天", paramType = "query",example="2021-05-23")})
    @GetMapping("/getDetailNumberQuantity")
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<NumberQuantityDetailsDTO>> getNumberDetailQuantity(Long hospitalId,String hospitalName, Long deportmentId,String deportmentName, LocalDate registrationDate) {
        List<NumberQuantityDetailsDTO> list=numberQuantityService.getNumberQuantityDetail(hospitalId,hospitalName, deportmentId,deportmentName, registrationDate);
        if(list==null || list.size()==0){
            return R.error(CodeMsg.NO_DATA);
        }
        return R.ok(list);
    }

}
