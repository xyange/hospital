
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO;
import com.wyzy.hospital.admin.api.dto.department.DiseaseDTO;
import com.wyzy.hospital.admin.api.entity.ClinicDepartments;
import com.wyzy.hospital.admin.mapper.ClinicDepartmentsMapper;
import com.wyzy.hospital.admin.service.ClinicDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 门诊科室表
 *
 * @author SongM
 * @date 2021-04-20 11:09:15
 */
@Service
public class ClinicDepartmentsServiceImpl extends ServiceImpl<ClinicDepartmentsMapper, ClinicDepartments> implements ClinicDepartmentsService {

    @Autowired
    private ClinicDepartmentsMapper clinicDepartmentsMapper;

    @Override
    public List<ClinicDepartments> selectListByClinicId(Long clinicId) {

        return clinicDepartmentsMapper.selectListByClinicId(clinicId);
    }

    /**
     * 查询每个诊所的科室名字
     * @param clinicId
     * @return
     */
    @Override
    public String selectDepartmentNameByClinicId(Long clinicId) {
        return clinicDepartmentsMapper.selectDepartmentNameByClinicId(clinicId);
    }
    /**
    * @Description: 根据科室查询疾病
    * @Param: []
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO>
    * @Author: songM
    * @Date: 2021/5/24
    */
    @Override
    public List<DepartmentDiseaseRewriteDTO> getDiseaseByDeptNum() {
        return clinicDepartmentsMapper.getDiseaseByDeptNum();
    }

    @Override
    public List<DiseaseDTO> getDiseaseByTwoDeptNum(Long departmentsId) {
        return baseMapper.getDiseaseByTwoDeptNum(departmentsId);
    }
}
