

package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.DoctorCounsel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 心理医生 咨询类型关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:11
 */
@Mapper
public interface DoctorCounselMapper extends HospitalBaseMapper<DoctorCounsel> {

    /**
     * 新增心理医生 咨询类型关系表
     * @param doctorCounsel 心理医生 咨询类型关系表
     * @return R
     */
    DoctorCounsel selectDoctorCounselBydoctorCounsel(@Param("doctorCounsel") DoctorCounsel doctorCounsel);

    DoctorCounsel selectDoctorCounselCounselTypeId(@Param("counselId") Integer counselId);

}
