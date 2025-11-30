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

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.DepartmentDetailDTO;
import com.wyzy.hospital.admin.api.dto.DepartmentsDTO;
import com.wyzy.hospital.admin.api.entity.Departments;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 科室表
 *
 * @author hospital code generator
 * @date 2021-04-12 13:56:39
 */
@Mapper
public interface DepartmentsMapper extends HospitalBaseMapper<Departments> {

	/**
	 * 模糊查询科室
	 *
	 * @param name 科室名称
	 * @return R
	 */
	List<Departments> listDepartmentByName(@Param("name") String name);

	/**
	 * 通过上一级ID：SuperiorId查询科室列表
	 * @param id id
	 * @return R
	 */
	List<Departments> selectBySuperiorId(Long id);

	/**
	 * 查询全部科室列表
	 * @param
	 * @return R
	 */
	List<Departments> listAllDepartment();

	List<Departments> selectDepartmentByName(String departmentName);

	@Select("select d.id,d.department_name,d.superior_id,d.department_number,d.create_time,d.update_time,d.sort from departments as d " +
			"left join hospital_department as hd on d.id=hd.departments_id " +
			"where hd.hospital_id=#{hospitalId}")
    List<Departments> listAllHospitalDepartment(Long hospitalId);

	@Select("SELECT d.id, d.department_name,d.sort, h.hospital_name, d2.department_name superior_name FROM wyzy.departments d " +
			"left join departments d2 on d.superior_id=d2.id " +
			"left join hospital_department hd on d.id = hd.departments_id " +
			"left join hospitals h on h.id = hd.hospital_id " +
			"where hd.hospital_id=#{hospitalId} and d.id = #{departmentId}")
	DepartmentDetailDTO detail(@Param("departmentId")Long departmentId, @Param("hospitalId")Long hospitalId);

	@Select("SELECT GROUP_CONCAT(department_name) FROM departments where superior_id = #{superiorId}")
	String getSubDepartmentName(@Param("superiorId") Long superiorId);

	@Select("select id,department_name,department_image from departments where superior_id=0 limit #{current}, #{size}")
	List<DepartmentsDTO> getHomeDepartments(@Param("current") int current, @Param("size") int size);

    List<Departments> getOneDepartmentsList();

	/**
	 * 根据医院特色科室id 查询医院特色科室名
	 * @param ids
	 * @return
	 */
    String getSpecialDepartment(@Param("ids")List ids);
}
