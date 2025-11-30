
package com.wyzy.hospital.admin.kit.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.consult.ConsultDTO;
import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.entity.ConsultResult;
import com.wyzy.hospital.admin.kit.ConsultDoctorKitService;
import com.wyzy.hospital.admin.service.ConsultResultService;
import com.wyzy.hospital.admin.service.impl.ConsultDoctorServiceImpl;
import com.wyzy.hospital.admin.service.impl.ConsultOrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 远程会诊-诊疗模式医生关系表
 *
 * @author songM
 * @date 2021-06-15 15:01:43
 */
@Service
@AllArgsConstructor
public class ConsultDoctorKitServiceImpl implements ConsultDoctorKitService {

    private final ConsultDoctorServiceImpl consultDoctorService;

    private final ConsultOrderServiceImpl consultOrderService;

    private final ConsultResultService consultResultService;

    /**
    * @Description: 根据疾病id,诊疗模式id查询平台合作专家列表
    * @Param: [page, consultDTO]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>
    * @Author: songM
    * @Date: 2021/6/15
    */
    @Override
    public IPage<AppDoctorDTO> selectDoctorListById(IPage<AppDoctorDTO> page, ConsultDTO consultDTO) {
        List<AppDoctorDTO> doctorDTOList = consultDoctorService.selectDoctorListById(page,consultDTO);
        return page.setRecords(doctorDTOList);
    }


    @Override
    public IPage<ConsultOrderDTO> selectConsultOrderListByMemberId(IPage<ConsultOrderDTO> page, ConsultOrderDTO consultOrder) {
        List<ConsultOrderDTO> consultOrderDTOList = new ArrayList<>();
        List<ConsultOrderDTO> consultOrderList = consultOrderService.selectConsultOrderListByMemberId(page,consultOrder);
        if("0".equals(consultOrder.getOrderState())){
            for (ConsultOrderDTO c:consultOrderList
            ) {
                    if (LocalDateTime.now().isBefore(c.getOrderTime() ) ){
                            c.setOrderState("未进行");
                        consultOrderDTOList.add(c);
                    }
            }
            return page.setRecords(consultOrderDTOList);
        }

        if("2".equals(consultOrder.getOrderState())){
            for (ConsultOrderDTO c:consultOrderList
            ) {
                if (LocalDateTime.now().isAfter(c.getOrderTime().plusMinutes(40) )){
                    c.setOrderState("已结束");
                    consultOrderDTOList.add(c);
                }
            }
            return page.setRecords(consultOrderDTOList);
        }


        if("1".equals(consultOrder.getOrderState())){
            for (ConsultOrderDTO c:consultOrderList
            ) {
                if(LocalDateTime.now().isAfter(c.getOrderTime()) && LocalDateTime.now().isBefore(c.getOrderTime().plusMinutes(40) )){
                    c.setOrderState("进行中");
                    consultOrderDTOList.add(c);
                }
            }
            return page.setRecords(consultOrderDTOList);
        }
        return page.setRecords(consultOrderList);
    }
    /**
    * @Description: 查询会诊结果通过就诊卡id
    * @Param: [consultOrder]
    * @return: com.wyzy.hospital.admin.api.entity.ConsultResult
    * @Author: songM
    * @Date: 2021/6/18
    */
    @Override
    public List<ConsultResult> selectConsultResultsByCardId(ConsultOrderDTO consultOrder) {
        return consultResultService.selectConsultResultsByCardId(consultOrder);
    }
}
