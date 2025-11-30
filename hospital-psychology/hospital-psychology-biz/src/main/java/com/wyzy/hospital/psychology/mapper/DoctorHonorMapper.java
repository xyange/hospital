

package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.DoctorHonor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 心理医生荣誉名称表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:32
 */
@Mapper
public interface DoctorHonorMapper extends HospitalBaseMapper<DoctorHonor> {


    DoctorHonor selectDoctorHonorByHonorName(@Param("doctorHonor") DoctorHonor doctorHonor);
}
