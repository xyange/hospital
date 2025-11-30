

package com.wyzy.hospital.psychology.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.DoctorHonor;

/**
 * 心理医生荣誉名称表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:32
 */
public interface DoctorHonorService extends IService<DoctorHonor> {

    /**
     * 新增心理医生荣誉名称表
     * @param doctorHonor 心理医生荣誉名称表
     * @return R
     */
    boolean saveDoctorHonor(DoctorHonor doctorHonor);
}
