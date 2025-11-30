package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.DoctorDisease;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生疾病关系表
 *
 * @author songM
 * @date 2021-05-27 16:43:37
 */
@Mapper
public interface DoctorDiseaseMapper extends HospitalBaseMapper<DoctorDisease> {


}
