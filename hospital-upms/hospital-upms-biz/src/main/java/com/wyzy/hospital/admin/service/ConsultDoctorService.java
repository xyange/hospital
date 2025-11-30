

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.consult.ConsultDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.entity.ConsultDoctor;
import com.wyzy.hospital.admin.api.entity.ConsultOrder;

import java.math.BigDecimal;
import java.util.List;


/**
 * 远程会诊-诊疗模式医生关系表
 *
 * @author songM
 * @date 2021-06-15 15:01:43
 */
public interface ConsultDoctorService extends IService<ConsultDoctor> {

    List<AppDoctorDTO> selectDoctorListById(IPage<AppDoctorDTO> page, ConsultDTO consultDTO);


    BigDecimal selectPriceByDoctorId(Long doctorId);
}
