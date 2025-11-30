

package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.DoctorTraining;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 心理医生培训表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:49
 */
@Mapper
public interface DoctorTrainingMapper extends HospitalBaseMapper<DoctorTraining> {

    /**
     * 通过doctorId查询心理医生培训表
     * @param doctorId id
     * @return R
     */
    List<DoctorTraining> selectByDoctorId(@Param("doctorId") Long doctorId);


    Integer selectByDoctorTraining(@Param("doctorTraining") DoctorTraining doctorTraining);
}
