

package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.DoctorServe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 心理医生服务关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:02
 */
@Mapper
public interface DoctorServeMapper extends HospitalBaseMapper<DoctorServe> {

    List<DoctorServe> selectDoctorServeByServeId(@Param("serveId") Long serveId);
}
