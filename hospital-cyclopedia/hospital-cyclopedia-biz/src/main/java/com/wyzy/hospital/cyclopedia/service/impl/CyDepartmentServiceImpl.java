
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.CyDepartmentDTO;
import com.wyzy.hospital.cyclopedia.dto.CyOneDepartmentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDepartment;
import com.wyzy.hospital.cyclopedia.mapper.CyDepartmentMapper;
import com.wyzy.hospital.cyclopedia.service.CyDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 百科科室表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:05:20
 */
@Service
public class CyDepartmentServiceImpl extends ServiceImpl<CyDepartmentMapper, CyDepartment> implements CyDepartmentService {

	@Override
	public List<CyOneDepartmentDTO> queryDepartmentMapList(Long departmentId) {
		List<CyOneDepartmentDTO> cyDepartmentDTOList = baseMapper.selectDepartmentMapList(departmentId);
		return cyDepartmentDTOList;
	}

	@Override
	public List<CyDepartmentDTO> queryOneDepartment() {
		List<CyDepartmentDTO> departmentList = baseMapper.selectDepartment();
		return departmentList;
	}

	@Override
	public List<CyOneDepartmentDTO> queryOneDiseases(Long aid) {
		List<CyOneDepartmentDTO> cyOneDepartmentDTOList = baseMapper.selectOneDiseases(aid);
		return cyOneDepartmentDTOList;
	}

	@Override
	public String getByName(String departmentName) {
		String selectName = baseMapper.selectName(departmentName);
		return selectName;
	}

/*	@Override
	public List<CyDepartmentDTO> queryOneDepartment() {
		//创建实体类对象
		List<CyDepartment> cyDepartmentList =baseMapper.selectDepartment();
		//创建DTO对象
		List<CyDepartmentDTO> cyDepartmentDTOList = new ArrayList<>();
		//for循环遍历实体类
		for (CyDepartment cyDepartment : cyDepartmentList) {
			//如果实体类中等级为1及科室
			if (cyDepartment.getDepartmentLevel()== 1) {
				//创建DTO对象
				CyDepartmentDTO cyDepartmentDTO = new CyDepartmentDTO();
				//将数据copy添加到dto
				cyDepartmentDTO.setAid(cyDepartment.getDepartmentId());
				cyDepartmentDTO.setAname(cyDepartment.getDepartmentName());
				cyDepartmentDTOList.add(cyDepartmentDTO);
			}
		}
		*//*for循环将数据存入dto*//*
		for (CyDepartmentDTO cyDepartmentDTO : cyDepartmentDTOList) {
			Long id = cyDepartmentDTO.getAid();
			List<CyDepartment> cyDepartmentList1 = new ArrayList<>();
			for (CyDepartment cyDepartment : cyDepartmentList) {
				if (cyDepartment.getParentId().equals(id)) {
					cyDepartmentList1.add(cyDepartment);
				}
			}
			cyDepartmentDTO.setCyDepartmentList(cyDepartmentList1);
		}
		return cyDepartmentDTOList;
	}*/
}
