

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.CyDepartmentDTO;
import com.wyzy.hospital.cyclopedia.dto.CyOneDepartmentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDepartment;

import java.util.List;

/**
 * 百科科室表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:05:20
 */
public interface CyDepartmentService extends IService<CyDepartment> {
	//查一级下二级科室

	List<CyOneDepartmentDTO> queryDepartmentMapList(Long departmentId);

	List<CyDepartmentDTO>queryOneDepartment();

	//根据一级查疾病

	List<CyOneDepartmentDTO>queryOneDiseases(Long aid);

	//查疾病姓名

	String getByName(String departmentName);
}
