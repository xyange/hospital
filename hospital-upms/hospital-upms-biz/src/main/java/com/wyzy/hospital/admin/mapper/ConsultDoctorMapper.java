

package com.wyzy.hospital.admin.mapper;


import com.wyzy.hospital.admin.api.entity.ConsultDoctor;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 远程会诊-诊疗模式医生关系表
 *
 * @author songM
 * @date 2021-06-15 15:01:43
 */
@Mapper
public interface ConsultDoctorMapper extends HospitalBaseMapper<ConsultDoctor> {
    

}
