

package com.wyzy.hospital.admin.kit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.consult.ConsultDTO;
import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.entity.ConsultResult;

import java.util.List;


/**
 * 远程会诊-诊疗模式医生关系表
 *
 * @author songM
 * @date 2021-06-15 15:01:43
 */
public interface ConsultDoctorKitService {

     IPage<AppDoctorDTO> selectDoctorListById(IPage<AppDoctorDTO> page, ConsultDTO consultDTO);

    IPage<ConsultOrderDTO> selectConsultOrderListByMemberId(IPage<ConsultOrderDTO> page, ConsultOrderDTO consultOrder);

    List<ConsultResult> selectConsultResultsByCardId(ConsultOrderDTO consultOrder);
}
