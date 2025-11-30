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
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.department.entity.Departments;
import com.wyzy.hospital.department.entity.HosdepDetail;
import com.wyzy.hospital.department.mapper.DepartmentsMapper;
import com.wyzy.hospital.department.mapper.HosdepDetailMapper;
import com.wyzy.hospital.department.service.DepartmentsService;
import com.wyzy.hospital.department.service.HosdepDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-13 08:30:05
 */
@Service
public class HosdepDetailServiceImpl extends ServiceImpl<HosdepDetailMapper, HosdepDetail> implements HosdepDetailService {

	@Resource
	private DepartmentsMapper departmentsMapper;


	@Override
	public boolean saveHosdepDetail(HosdepDetail hosdepDetail) {
		Departments departments=departmentsMapper.selectById(hosdepDetail.getDepartmentsId());
		System.out.println(departments);
		List<HosdepDetail> byHosdepDetail = baseMapper.getByHosdepDetail(hosdepDetail);
		if (null == byHosdepDetail || byHosdepDetail.size() ==0){
			Integer number = baseMapper.saveHosdepDetail(hosdepDetail);
			/*insert返回值是插入条数，-1就是失败了*/
			if (number == -1){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<HosdepDetail> getByHosdepDetail(HosdepDetail hosdepDetail) {
		return baseMapper.getByHosdepDetail(hosdepDetail);
	}
}
