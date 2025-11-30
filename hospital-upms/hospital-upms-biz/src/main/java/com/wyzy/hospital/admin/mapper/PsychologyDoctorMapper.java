package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface PsychologyDoctorMapper {
    /**
     * 查医生ids
     * @author wrk
     * @date 2021/06/03 17:16
     * @return java.lang.String
     */
    List<Doctor> getPsychologyDoctorIds(@Param("sex") Integer sex,@Param("area") String area);

    /**
     * 根据医生ID查询医生信息
     * @param doctorId
     * @return
     */
    Doctor getPsychologyByDoctorId(@Param("doctorId") Long doctorId);
}
