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

package com.wyzy.hospital.department.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.department.entity.Departments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

	List<Departments> selectBySuperiorId(Integer id);

	List<Departments> listAllDepartment();

}
