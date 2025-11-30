/*
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author:  wyzy
 */
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.DepartmentDetailDTO;
import com.wyzy.hospital.admin.api.dto.DepartmentsDTO;
import com.wyzy.hospital.admin.api.entity.Departments;
import com.wyzy.hospital.admin.mapper.DepartmentsMapper;
import com.wyzy.hospital.admin.mapper.HospitalDepartmentMapper;
import com.wyzy.hospital.admin.service.DepartmentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科室表
 *
 * @author hospital code generator
 * @date 2021-04-12 13:56:39
 */
@Service
public class DepartmentsServiceImpl extends ServiceImpl<DepartmentsMapper, Departments> implements DepartmentsService {

	@Resource
    HospitalDepartmentMapper hospitalDepartmentMapper;

	@Resource
	private DepartmentsMapper departmentsMapper;


	@Override
	public List<Departments> getDepartmentListByHospitalId(Long hospitalId) {
		return baseMapper.listAllHospitalDepartment(hospitalId);
	}

	@Override
	public boolean removeListById(Long id) {
		/*根据id获取科室信息*/
		Departments departments = baseMapper.selectById(id);
		Long superiorId = departments.getSuperiorId();
		//查询出二级分类
		List<Departments> departmentsList = baseMapper.selectBySuperiorId(id);

		if ((superiorId == 0 &&(departmentsList == null || departmentsList.size() ==0))||(null == departmentsList || departmentsList.size() ==0)){
			/*删除id科室下的科室详情信息*/
			Integer deletehosdepDetail = hospitalDepartmentMapper.removeBydepartmentsId(id);
			/*删除科室表下的id科室*/
			Integer deletedepartments = baseMapper.deleteById(id);
					return true;
		}else {
			Integer deletehosdepDetail1;
			Integer deletehosdepDetail2;
			Integer deletedepartments;
			Integer deletedepartment;
			for (Departments department:departmentsList){
				/*删除二级分类下的详情*/
				deletehosdepDetail1 = hospitalDepartmentMapper.removeBydepartmentsId(department.getId());
				/*删除一级分类下的详情*/
				deletehosdepDetail2 = hospitalDepartmentMapper.removeBydepartmentsId(id);
				deletedepartments = baseMapper.deleteById(department.getId());
				deletedepartment = baseMapper.deleteById(id);
			}
				return true;
		}
	}

	@Override
	public boolean save(Departments departments) {
		int insert = baseMapper.insert(departments);
		if (insert > 0){
            if(departments.getSuperiorId() != 0){
                /**
                 * 二级科室的数量
                 */
                List<Departments> departmentsList = baseMapper.selectBySuperiorId(departments.getSuperiorId());
                int size = departmentsList.size();
                /**
                 * 修改一级科室的子科室数
                 */
                Departments department = new Departments();
                department.setId(departments.getSuperiorId());
                department.setDepartmentNumber(size);
                int i = baseMapper.updateById(department);
                if (i > 0){
                    return true;
                }
            }else{
                return true;
            }
        }
		return false;
	}

	@Override
	public boolean removeById(Long id) {
		List<Departments> departmentsList = baseMapper.selectBySuperiorId(id);
		/*删除的是二级科室，或者是无二级科室的一级科室*/
		if (null == departmentsList || departmentsList.size() ==0){
			/**
			 * 如果是二级科室需要查询一级科室ID
			 */
			Departments departments = baseMapper.selectById(id);
			Long superiorId = departments.getSuperiorId();
			/*删除医院详情详情*/
			Integer integer = hospitalDepartmentMapper.removeBydepartmentsId(id);
			int i = baseMapper.deleteById(id);
			/**
			 *如果上一级ID不为0则，需要修改一级科室的子科室数
			 */
			if (superiorId !=0){
				/**
				 * 二级科室的数量
				 */
				List<Departments> departmentList = baseMapper.selectBySuperiorId(superiorId);
				int size = departmentList.size();
				/**
				 * 修改一级科室的子科室数
				 */
				Departments department = new Departments();
				department.setId(departments.getSuperiorId());
				department.setDepartmentNumber(size);
				int i1 = baseMapper.updateById(department);
				return true;
			}
			return true;
		}
		return false;
	}

	@Override
	public DepartmentDetailDTO detail(Long departmentId, Long hospitalId) {
		return baseMapper.detail(departmentId, hospitalId);
	}

	@Override
	public Departments selectById(Integer departmentsId) {
		return baseMapper.selectById(departmentsId);
	}

	@Override
	public List<Departments> getDepartmentList() {
		/*查询出科室表所有信息*/
		List<Departments> list = baseMapper.listAllDepartment();
		return list;
	}

	@Override
	public String getSubDepartmentName(Long superiorId) {
		return baseMapper.getSubDepartmentName(superiorId);
	}

	@Override
	public List<DepartmentsDTO> getHomeDepartments(int current, int size) {
		return baseMapper.getHomeDepartments((current-1)*size, size);
	}




	@Override
	public List<Departments> listDepartmentByName(String name) {
		return departmentsMapper.listDepartmentByName(name);
	}


	@Override
	public List<Departments> getOneDepartmentsList() {
		return baseMapper.getOneDepartmentsList();
	}

	@Override
	public String getSpecialDepartment(List ids) {
		return baseMapper.getSpecialDepartment(ids);
	}
}
