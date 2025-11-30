

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO;
import com.wyzy.hospital.admin.api.entity.DepartmentDisease;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 科室疾病表
 *
 * @author hospital code generator
 * @date 2021-04-19 11:43:06
 */
@Mapper
public interface DepartmentDiseaseMapper extends HospitalBaseMapper<DepartmentDisease> {
    /**
     *查科室以及科室内的疾病
     * @author wrk
     * @date 2021/05/08 17:51
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO>
     */
    List<DepartmentsDiseaseDTO> listDepartmentDisease();


    /**
     *app查全部一级科室及以内疾病
     * @author wrk
     * @date 2021/05/08 17:51
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO>
     */
    List<DepartmentsDiseaseDTO> appListDepartmentDisease();

}
