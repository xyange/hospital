

package com.wyzy.hospital.hospital.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.hospital.dto.HospitalDTO;
import com.wyzy.hospital.hospital.entity.Hospitals;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-10 08:33:26
 */
@Mapper
public interface HospitalsMapper extends HospitalBaseMapper<Hospitals> {
	/**
	 * 模糊查询医院
	 * @param name 医院名称
	 * @return R
	 */
	List<Hospitals> listHospitalsByName(@Param("name") String name);

	@Select("SELECT d.department_name, h.name FROM wyzy_department.hosdep_detail as hd " +
			"left join wyzy_department.departments as d on d.id = hd.departments_id " +
			"left join wyzy_hospital.hospitals as h on hd.hospital_id= h.id where d.id=11")
	List<HospitalDTO> listHospital();

}
