package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.mapper.PsychologyDoctorMapper;
import com.wyzy.hospital.admin.service.AppPsychologyDoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class AppPsychologyDoctorServiceImpl implements AppPsychologyDoctorService {
    @Resource
    private PsychologyDoctorMapper psychologyDoctorMapper;

    /**
     * 查心理医生ids
     * @author wrk
     * @date 2021/06/03 17:14
     * @return java.lang.String
     */
    @Override
    public List<Doctor> getPsychologyDoctorIds(Integer sex,String area) {
        return psychologyDoctorMapper.getPsychologyDoctorIds(sex,area);
    }

    /**
     * 根据医生ID查询医生信息
     * @param doctorId
     * @return
     */
    @Override
    public Doctor getPsychologyByDoctorId(Long doctorId) {
        return psychologyDoctorMapper.getPsychologyByDoctorId(doctorId);
    }
}
