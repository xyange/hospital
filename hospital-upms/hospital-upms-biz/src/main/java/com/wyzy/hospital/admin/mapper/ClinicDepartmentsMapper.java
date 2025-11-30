

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO;
import com.wyzy.hospital.admin.api.dto.department.DiseaseDTO;
import com.wyzy.hospital.admin.api.entity.ClinicDepartments;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门诊科室表
 *
 * @author SongM
 * @date 2021-04-20 11:09:15
 */
@Mapper
public interface ClinicDepartmentsMapper extends HospitalBaseMapper<ClinicDepartments> {
    /**
     * 查询诊所列表通过门诊id
     * @param clinicId
     * @return
     */
    List<ClinicDepartments> selectListByClinicId(@Param("clinicId") Long clinicId);

    /**
     * 查询科室名通过门诊id
     * @param clinicId
     * @return
     */
    String selectDepartmentNameByClinicId(@Param("clinicId") Long clinicId);

    /**
    * @Description: 根据科室查询疾病
    * @Param: []
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO>
    * @Author: songM
    * @Date: 2021/5/24
    */
    List<DepartmentDiseaseRewriteDTO> getDiseaseByDeptNum();
    /**
    * @Description: 根据二级科室id查询疾病
    * @Param: [departmentsId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.Disease>
    * @Author: songM
    * @Date: 2021/5/25
    */
    List<DiseaseDTO> getDiseaseByTwoDeptNum(@Param("departmentsId") Long departmentsId);
}
