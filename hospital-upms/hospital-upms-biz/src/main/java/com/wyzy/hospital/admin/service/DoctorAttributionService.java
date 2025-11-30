package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.entity.DoctorAttribution;

import java.util.List;

/**
 * @author Wrk
 */
public interface DoctorAttributionService {
    /**
     * 添加医生归属关系
     * @author
     * @date 2021/04/28 17:09
     * @param list 医生归属
     * @return java.lang.Boolean
     */
    Boolean batchAddDoctorAttribution(List<DoctorAttribution> list);
    /**
     * 删除医生归属关系
     * @author
     * @date 2021/04/28 17:09
     * @param id 医生id
     * @return java.lang.Boolean
     */
    Boolean batchDeleteDoctorAttribution(Long id);

    /**
     * 添加医生归属关系
     * @param doctorAttribution
     * @return
     */
    int add(DoctorAttribution doctorAttribution);
}
