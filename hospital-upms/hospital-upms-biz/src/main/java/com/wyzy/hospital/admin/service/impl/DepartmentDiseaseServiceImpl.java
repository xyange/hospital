package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.api.dto.department.DepartmentsDiseaseDTO;
import com.wyzy.hospital.admin.mapper.DepartmentDiseaseMapper;
import com.wyzy.hospital.admin.service.DepartmentDiseaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科室疾病
 *
 * @author wrk
 * @date 2021/05/10 09:08
 **/
@Service
public class DepartmentDiseaseServiceImpl implements DepartmentDiseaseService {
    @Resource
    private DepartmentDiseaseMapper departmentDiseaseMapper;
    @Override
    public List<DepartmentsDiseaseDTO> listDepartmentDisease() {
        return departmentDiseaseMapper.listDepartmentDisease();
    }

    @Override
    public List<DepartmentsDiseaseDTO> appListDepartmentDisease() {
        return departmentDiseaseMapper.appListDepartmentDisease();
    }
}
