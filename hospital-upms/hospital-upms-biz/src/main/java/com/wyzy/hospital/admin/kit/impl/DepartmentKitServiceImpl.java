package com.wyzy.hospital.admin.kit.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.wyzy.hospital.admin.api.dto.DepartmentDetailDTO;
import com.wyzy.hospital.admin.api.dto.DepartmentsDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentSimpleDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentTreeDTO;
import com.wyzy.hospital.admin.api.entity.Departments;
import com.wyzy.hospital.admin.kit.DepartmentKitService;
import com.wyzy.hospital.admin.service.DepartmentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author aqie
 * Date on 2021/4/20  8:54
 * @Function:
 */
@Service
@AllArgsConstructor
public class DepartmentKitServiceImpl implements DepartmentKitService {

    private DepartmentsService departmentsService;


    @Override
    public List<DepartmentTreeDTO> getTreeDepartmentLambda() {
        // 1. 查询所有分类
        List<DepartmentTreeDTO> all = departmentsService.list().stream()
                .map(DepartmentTreeDTO::new).collect(Collectors.toList());
        return this.tree(all);
    }

    private List<DepartmentTreeDTO> tree(List<DepartmentTreeDTO> all){
        // 2. 把根分类区分出来
        List<DepartmentTreeDTO> roots = all.stream()
                .filter(dealDepartment -> (dealDepartment.getSuperiorId() == 0))
                .sorted((o1, o2) -> o2.getSort() - o1.getSort())
                .collect(Collectors.toList());

        // 3. 把非根分类区分出来
        List<DepartmentTreeDTO> subs = all.stream()
                .filter(category -> (category.getSuperiorId() != 0)).collect(Collectors.toList());

        // 4.递归构建结构化的分类信息
        roots.forEach(root -> buildSubs(root, subs));
        return roots;
    }

    /**
     * 递归构建
     * @param parent
     * @param subs
     */
    private void buildSubs(DepartmentTreeDTO parent, List<DepartmentTreeDTO> subs) {
        List<DepartmentTreeDTO> children = subs.stream()
                .filter(sub -> (sub.getSuperiorId().equals(parent.getId())))
                .collect(Collectors.toList());
        //有子分类的情况
        if (!CollectionUtils.isEmpty(children)) {
            parent.setChilds(children);
            //再次递归构建
            children.forEach(child -> buildSubs(child, subs));
        }
    }

    @Override
    public List<DepartmentSimpleDTO> getSubDepartment(Long departmentId) {
        List<Departments> list = departmentsService.list(new LambdaQueryWrapper<Departments>()
                .select(Departments::getId, Departments::getDepartmentName)
                .eq(Departments::getSuperiorId, departmentId)
        );
        List<DepartmentSimpleDTO> departmentSimpleDTOS = list.stream().map(DepartmentSimpleDTO::new).collect(Collectors.toList());
        return departmentSimpleDTOS;
    }


    @Override
    public List<DepartmentsDTO> getTreeList() {
        List<Departments> list = departmentsService.getDepartmentList();
        List<DepartmentsDTO> departmentsDTOList = treeDepartment(list);
        return departmentsDTOList;
    }

    @Override
    public List<DepartmentTreeDTO> getTreeListByHospitalId(Long hospitalId) {
        List<Departments> list = departmentsService.getDepartmentListByHospitalId(hospitalId);
        List<DepartmentTreeDTO> all = list.stream()
                .map(DepartmentTreeDTO::new).collect(Collectors.toList());
        return tree(all);
    }

    @Override
    public DepartmentDetailDTO detail(Long departmentId, Long hospitalId) {
        // todo 二级科室预约挂号详情
        DepartmentDetailDTO departmentDetailDTO = departmentsService.detail(departmentId, hospitalId);
        return departmentDetailDTO;
    }

    @Override
    public List<DepartmentsDTO> getHomeDepartments(int current, int size) {
        List<DepartmentsDTO> departmentsPage = departmentsService.getHomeDepartments(current, size);
        departmentsPage.forEach(item -> {
            item.setSubDepartment(departmentsService.getSubDepartmentName(item.getId()));
        });
        return departmentsPage;
    }

    private List<DepartmentsDTO> treeDepartment(List<Departments> list) {
        List<DepartmentsDTO> departmentsDTOList=new ArrayList<>();
        for(Departments departments: list){
            DepartmentsDTO departmentsDTO=new DepartmentsDTO();
            if(departments.getSuperiorId()==0 || departments.getSuperiorId()==-1){
                departmentsDTO.setId(departments.getId());
                departmentsDTO.setDepartmentName(departments.getDepartmentName());
                departmentsDTO.setSuperiorId(departments.getSuperiorId());
                departmentsDTO.setDepartmentNumber(departments.getDepartmentNumber());
                departmentsDTO.setDepartmentImage(departments.getDepartmentImage());
                departmentsDTOList.add(departmentsDTO);
            }
        }
        for(DepartmentsDTO departmentsDTO:departmentsDTOList){
            Long fId=departmentsDTO.getId();
            int number =0;
            List<Departments> lis = new ArrayList<>();
            for(Departments dep: list){
                if(dep.getSuperiorId().equals(fId)){
                    number++;
                    lis.add(dep);
                }
            }
            departmentsDTO.setDepartmentsList(lis);
            departmentsDTO.setDepartmentNumber(number);
        }
        return departmentsDTOList;
    }


    @Override
    public List<Departments> getOneDepartmentsList() {
        List<Departments> departmentsList =  departmentsService.getOneDepartmentsList();
        return departmentsList;
    }
}
