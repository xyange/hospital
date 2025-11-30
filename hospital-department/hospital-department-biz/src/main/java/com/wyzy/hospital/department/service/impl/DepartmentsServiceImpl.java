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
package com.wyzy.hospital.department.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.department.dto.DepartmentsDTO;
import com.wyzy.hospital.department.entity.Departments;
import com.wyzy.hospital.department.mapper.DepartmentsMapper;
import com.wyzy.hospital.department.mapper.HosdepDetailMapper;
import com.wyzy.hospital.department.service.DepartmentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
	HosdepDetailMapper hosdepDetailMapper;

	@Override
	public List getListById(Integer id) {
		/*查询出科室表所有信息*/
		List<Departments> list=baseMapper.listAllDepartment();
		/*创建返回的集合*/
		List<DepartmentsDTO> departmentsDTOList=new ArrayList<>();
		/*将一级科室赋值赋值*/
		for(Departments departments:list){
			DepartmentsDTO departmentsDTO=new DepartmentsDTO();
			if(departments.getSuperiorId()==0){
				departmentsDTO.setId(departments.getId());
				departmentsDTO.setDepartmentName(departments.getDepartmentName());
				departmentsDTO.setSuperiorId(departments.getSuperiorId());
				departmentsDTOList.add(departmentsDTO);
			}
		}
		/*循环存放一级科室的DepartmentsDTO*/
		for(DepartmentsDTO departmentsDTO:departmentsDTOList){
			/*查询一级科室的ID*/
			Integer fId=departmentsDTO.getId();
			int number =0;
			List lis = new ArrayList();
			for(Departments dep:list){
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
	public boolean removeListById(Integer id) {
		/*根据id获取相关科室信息，且查询下一级信息*/
		Departments departments = baseMapper.selectById(id);
		Integer superiorId = departments.getSuperiorId();//id 数据的 上一层ID
		List<Departments> departmentsList = baseMapper.selectBySuperiorId(id);//二级分类
		/*上层ID为0时，即为一级科室，若二级科室列表为空时，或无下级分类*/
		if ((superiorId == 0 &&(null == departmentsList || departmentsList.size() ==0))||null == departmentsList || departmentsList.size() ==0){
			/*删除id科室下的科室详情信息*/
			Integer deletehosdepDetail = hosdepDetailMapper.deleteById(id);
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
				deletehosdepDetail1 = hosdepDetailMapper.deleteById(department.getId());
				/*删除一级分类下的详情*/
				deletehosdepDetail2 = hosdepDetailMapper.deleteById(id);
				deletedepartments = baseMapper.deleteById(department.getId());
				deletedepartment = baseMapper.deleteById(id);
			}
				return true;
		}
	}

	@Resource
	private DepartmentsMapper departmentsMapper;
	@Override
	public List<Departments> listDepartmentByName(String name) {
		return departmentsMapper.listDepartmentByName(name);
	}

}
