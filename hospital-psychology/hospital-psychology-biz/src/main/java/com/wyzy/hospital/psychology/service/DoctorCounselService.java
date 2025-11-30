

package com.wyzy.hospital.psychology.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.DoctorCounsel;

/**
 * 心理医生 咨询类型关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:11
 */
public interface DoctorCounselService extends IService<DoctorCounsel> {

    /**
     * 新增心理医生 咨询类型关系表
     * @param doctorCounsel 心理医生 咨询类型关系表
     * @return R
     */
    boolean saveDoctorCounsel(DoctorCounsel doctorCounsel);

    DoctorCounsel selectDoctorCounselCounselTypeId(Integer counselId);
}
