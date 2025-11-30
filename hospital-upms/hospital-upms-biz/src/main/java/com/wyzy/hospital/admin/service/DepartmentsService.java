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

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.DepartmentDetailDTO;
import com.wyzy.hospital.admin.api.dto.DepartmentsDTO;
import com.wyzy.hospital.admin.api.entity.Departments;

import java.util.List;

/**
 * 科室表
 *
 * @author hospital code generator
 * @date 2021-04-12 13:56:39
 */
public interface DepartmentsService extends IService<Departments> {


	/**
	 * 查询医院下所有科室
	 * @param hospitalId
	 * @return
	 */
	List<Departments> getDepartmentListByHospitalId(Long hospitalId);

	/**
	 * 模糊查询科室
	 *
	 * @param name 科室名称
	 * @return R
	 */
	  List<Departments> listDepartmentByName(String name);

	/**
	 * 通过id删除科室列表
	 * @param id id
	 * @return R
	 */
	boolean removeListById(Long id);

	/**
	 * 添加
	 **/
	@Override
	boolean save(Departments departments);

	boolean removeById(Long id);

	/**
	 * 查询app 科室详情
	 * @param
	 * @return
	 */
	DepartmentDetailDTO detail(Long departmentId, Long hospitalId);

    Departments selectById(Integer departmentsId);

    List<Departments> getDepartmentList();

	/**
	 * 根据科室父级id 查询下一级科室名称 逗号分割
	 */
	String getSubDepartmentName(Long superiorId);

	List<DepartmentsDTO> getHomeDepartments(int current, int size);

    List<Departments> getOneDepartmentsList();

	/**
	 * 根据医院特色科室id 查询医院特色科室名
	 * @param ids
	 * @return
	 */
	String getSpecialDepartment(List ids);
}
