

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO;
import com.wyzy.hospital.admin.api.dto.department.DiseaseDTO;
import com.wyzy.hospital.admin.api.entity.ClinicDepartments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门诊科室表
 *
 * @author SongM
 * @date 2021-04-20 11:09:15
 */
public interface ClinicDepartmentsService extends IService<ClinicDepartments> {



    List<ClinicDepartments> selectListByClinicId(@Param("clinicId") Long clinicId);

    String selectDepartmentNameByClinicId(Long clinicId);

    List<DepartmentDiseaseRewriteDTO> getDiseaseByDeptNum();

    List<DiseaseDTO> getDiseaseByTwoDeptNum(Long departmentsId);
}
