

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.ConsultSettingDTO;
import com.wyzy.hospital.admin.api.entity.ConsultSetting;

import java.util.List;

/**
 * 远程会诊预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:52
 */
public interface ConsultSettingService extends IService<ConsultSetting> {

    /**
     * 根据doctorId查看预约时间
     * @param doctorId 医生id
     * @return R
     */
    List<ConsultSettingDTO> getTimeByDoctorId(Long doctorId);

    /**
     * 新增远程会诊预约配置表
     * @param consultSetting 远程会诊预约配置表
     * @return R
     */
    boolean saveConsultSetting(ConsultSetting consultSetting);
}
