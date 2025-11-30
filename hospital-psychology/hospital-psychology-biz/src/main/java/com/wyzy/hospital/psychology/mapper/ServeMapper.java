

package com.wyzy.hospital.psychology.mapper;


import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.Serve;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 心理医生服务表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:07
 */
@Mapper
public interface ServeMapper extends HospitalBaseMapper<Serve> {

    /**
     * 根据名称查
     */
    Serve selectDoctorServeByServeName(@Param("serveName") String serveName);
}
