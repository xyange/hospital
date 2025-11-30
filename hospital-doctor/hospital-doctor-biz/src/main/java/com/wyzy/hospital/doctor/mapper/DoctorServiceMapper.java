

package com.wyzy.hospital.doctor.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.doctor.entity.DoctorService;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
@Mapper
public interface DoctorServiceMapper extends HospitalBaseMapper<DoctorService> {

}
