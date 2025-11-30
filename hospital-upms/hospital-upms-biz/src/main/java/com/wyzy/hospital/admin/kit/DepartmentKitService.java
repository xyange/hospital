package com.wyzy.hospital.admin.kit;

import com.wyzy.hospital.admin.api.dto.DepartmentDetailDTO;
import com.wyzy.hospital.admin.api.dto.DepartmentsDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentSimpleDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentTreeDTO;
import com.wyzy.hospital.admin.api.entity.Departments;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/20  8:53
 * @Function:
 */
public interface DepartmentKitService {

    /**
     * 无限极分类
     * @return
     */
    public List<DepartmentTreeDTO> getTreeDepartmentLambda();

    /**
     * 根据父级id 获取子级的科室列表
     * @param departmentId
     * @return
     */
    List<DepartmentSimpleDTO> getSubDepartment(Long departmentId);


    /**
     * 查询科室树状结构 列表
     * @return
     */
    public List<DepartmentsDTO> getTreeList();

    /**
     * 查询指定医院科室树状结构
     * @return
     */
    List<DepartmentTreeDTO> getTreeListByHospitalId(Long hospitalId);

    /**
     * app 查询医院科室详情
     * @param
     * @return
     */
    DepartmentDetailDTO detail(Long departmentId, Long hospitalId);

    /**
     * app 查询首页科室
     * @param current
     * @param size
     * @return
     */
    List<DepartmentsDTO> getHomeDepartments(int current, int size);

    List<Departments> getOneDepartmentsList();
}
