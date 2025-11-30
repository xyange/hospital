

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.DoctorServe;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
@Mapper
public interface DoctorServiceMapper extends HospitalBaseMapper<DoctorServe> {

    /**
     * 保存
     *
     * @param doctorServe
     * @return java.lang.Integer
     * @author wrk
     * @date 2021/06/01 15:27
     */
    Integer save(@Param("doctorServe") DoctorServe doctorServe);

}
