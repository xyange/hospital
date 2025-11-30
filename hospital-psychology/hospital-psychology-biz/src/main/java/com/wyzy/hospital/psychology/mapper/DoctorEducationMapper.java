

package com.wyzy.hospital.psychology.mapper;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.DoctorEducation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 心理医生教育学历表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:40
 */
@Mapper
public interface DoctorEducationMapper extends HospitalBaseMapper<DoctorEducation> {

    /**
     * 通过id查询心理医生教育学历表
     * @param doctorId id
     * @return R
     */
    List<DoctorEducation> selectDoctorEducationByDoctorId(@Param("doctorId") Long doctorId);

    /**
     * 新增心理医生教育学历表
     * @param doctorEducation 心理医生教育学历表
     */
    Integer selectDoctorEducationByDoctorEducation(@Param("doctorEducation") DoctorEducation doctorEducation);
}
