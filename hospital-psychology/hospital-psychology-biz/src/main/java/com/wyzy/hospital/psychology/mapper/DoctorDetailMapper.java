

package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.DoctorDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 心理医生详情表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:21
 */
@Mapper
public interface DoctorDetailMapper extends HospitalBaseMapper<DoctorDetail> {

    /**
     * 新增心理医生详情表
     * @param doctorDetail 心理医生详情表
     * @return R
     */
    DoctorDetail selectByPojo(@Param("doctorDetail") DoctorDetail doctorDetail);
}
