package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO;

import java.util.List;

/**
 * @author wrk
 */
public interface DepartmentDiseaseService {
    /**
     *查全部一级科室及以内疾病
     * @author wrk
     * @date 2021/05/10 11:15
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO>
     */
    List<DepartmentsDiseaseDTO> listDepartmentDisease();
    /**
     *app查全部一级科室及以内疾病
     * @author wrk
     * @date 2021/05/10 11:15
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO>
     */
    List<DepartmentsDiseaseDTO> appListDepartmentDisease();

}
