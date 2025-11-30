

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.CyDepartmentDTO;
import com.wyzy.hospital.cyclopedia.dto.CyOneDepartmentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDepartment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 百科科室表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:05:20
 */
@Mapper
public interface CyDepartmentMapper extends HospitalBaseMapper<CyDepartment> {

	List<CyOneDepartmentDTO>selectDepartmentMapList(Long departmentId);

	//查一级科室

	List<CyDepartmentDTO>selectDepartment();

	//根据一级查疾病

	List<CyOneDepartmentDTO>selectOneDiseases(Long aid);

	//查疾病姓名

	String selectName(String departmentName);

}
