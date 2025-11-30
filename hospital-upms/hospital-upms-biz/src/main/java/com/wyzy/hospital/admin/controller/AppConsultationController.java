package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.ConsultSettingDTO;
import com.wyzy.hospital.admin.api.dto.consult.ConsultDTO;
import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.entity.ConsultOrder;
import com.wyzy.hospital.admin.api.entity.ConsultResult;
import com.wyzy.hospital.admin.kit.impl.ConsultDoctorKitServiceImpl;
import com.wyzy.hospital.admin.service.ConsultOrderService;
import com.wyzy.hospital.admin.service.ConsultSettingService;
import com.wyzy.hospital.admin.service.impl.ConsultDoctorServiceImpl;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 远程会诊表_APP端
 *
 * @date 2021-04-16 09:44:55
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/consultation" )
@Api(value = "appConsultation", tags = "app远程会诊管理")
public class AppConsultationController {


    private ConsultDoctorServiceImpl consultDoctorService;

    private ConsultDoctorKitServiceImpl consultDoctorKitService;

    private final ConsultSettingService consultSettingService;

    private final ConsultOrderService consultOrderService;

    /**
    * @Description: 根据疾病id,诊疗模式id查询平台合作专家列
    * @Param: [query, consultDTO]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>>
    * @Author: songM
    * @Date: 2021/6/19
    */
    @ApiOperation(value = "根据疾病id,诊疗模式id查询平台合作专家列表", notes = "根据疾病id,诊疗模式id查询平台合作专家列表")
    @GetMapping("/selectDoctorListById" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<IPage<AppDoctorDTO>> selectLocalClinicByKeyWord(Query query, ConsultDTO consultDTO) {
        return R.ok(consultDoctorKitService.selectDoctorListById(Condition.getPage(query),consultDTO));
    }

    /**
     * 根据医生ID和服务ID查询服务价格
     * @return
     */
    @ApiOperation(value = "根据医生ID和服务ID查询服务价格", notes = "根据医生ID和服务ID查询服务价格")
    @GetMapping("/selectPriceByDoctorId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<BigDecimal> selectPriceByDoctorId(Long doctorId) {
        return R.ok(consultDoctorService.selectPriceByDoctorId(doctorId));
    }

    /**
     * 根据doctorId查看预约时间
     * @param doctorId 医生id
     * @return R
     */
    @ApiOperation(value = "根据doctorId查看预约时间", notes = "根据doctorId查看预约时间")
    @GetMapping("/doctorId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<List<ConsultSettingDTO>> getTimeByDoctorId(Long doctorId) {
        List<ConsultSettingDTO> consultSettingDTOList = consultSettingService.getTimeByDoctorId(doctorId);
        return R.ok(consultSettingDTOList);
    }

    /**
     * 新增远程会诊预约表
     * @param consultOrder 远程会诊预约表
     * @return R
     */
    @ApiOperation(value = "新增远程会诊预约表", notes = "新增远程会诊预约表")
    @SysLog("新增远程会诊预约表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<Boolean> save(ConsultOrder consultOrder) {
        return R.ok(consultOrderService.saveConsultOrder(consultOrder));
    }

   /**
   * @Description: 查询会诊订单通过会员id
   * @Param: [query, consultOrder]
   * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO>>
   * @Author: songM
   * @Date: 2021/6/19
   */
    @ApiOperation(value = "查询会诊订单", notes = "查询会诊订单")
    @GetMapping("/selectConsultOrderListByMemberId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<IPage<ConsultOrderDTO>> selectConsultOrderListByMemberId(Query query, ConsultOrderDTO consultOrder) {
        return R.ok(consultDoctorKitService.selectConsultOrderListByMemberId(Condition.getPage(query),consultOrder));
    }

    /**
    * @Description: 根据就诊卡查询会诊结果
    * @Param:
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO>>
    * @Author: songM
    * @Date: 2021/6/18
    */
    @ApiOperation(value = "根据就诊卡id查询会诊结果", notes = "根据就诊卡查询会诊结果")
    @GetMapping("/selectConsultResultsByCardId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<List<ConsultResult>> selectConsultResultsByCardId(ConsultOrderDTO consultOrder) {
        return R.ok(consultDoctorKitService.selectConsultResultsByCardId(consultOrder));
    }

}
