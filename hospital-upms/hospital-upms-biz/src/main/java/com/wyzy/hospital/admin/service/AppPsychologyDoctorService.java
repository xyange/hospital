package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.entity.Doctor;

import java.util.List;

/**
 * @author Administrator
 */
public interface AppPsychologyDoctorService {
    /**
     * 查心理医生ids
     * @author wrk
     * @date 2021/06/03 17:14
     * @return java.lang.String
     */
    List<Doctor> getPsychologyDoctorIds(Integer sex,String area);

    /**
     * 根据医生ID查询医生信息
     * @param doctorId
     * @return
     */
    Doctor getPsychologyByDoctorId(Long doctorId);
}
