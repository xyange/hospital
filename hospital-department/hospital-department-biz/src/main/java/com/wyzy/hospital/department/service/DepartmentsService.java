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

package com.wyzy.hospital.department.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.department.entity.Departments;

import java.util.List;

/**
 * 科室表
 *
 * @author hospital code generator
 * @date 2021-04-12 13:56:39
 */
public interface DepartmentsService extends IService<Departments> {

	/**
	 * 通过id查询科室列表
	 * @param id id
	 * @return R
	 */
	List getListById(Integer id);

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
	boolean removeListById(Integer id);
}
