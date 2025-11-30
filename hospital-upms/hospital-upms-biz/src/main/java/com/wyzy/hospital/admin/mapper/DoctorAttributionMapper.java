package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.DoctorAttribution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wrk
 */
@Mapper
public interface DoctorAttributionMapper {

    /**
     * 添加医生归属
     *
     * @param list 批量插入医生归属
     * @return java.lang.Integer
     * @author
     * @date 2021/04/28 17:12
     */
    Integer batchAddDoctorAttribution(@Param("list") List<DoctorAttribution> list);

    /**
     * 删除医生归属关系
     *
     * @param id 医生id
     * @return java.lang.Integer
     * @author wrk
     * @date 2021/04/29 16:47
     */
    Integer batchDeleteDoctorAttribution(@Param("id") Long id);

    /**
     * 添加单个医生归属关系
     * @param doctorAttribution
     * @return
     */
    int add(@Param("doctorAttribution")DoctorAttribution doctorAttribution);
}
