

package com.wyzy.hospital.patients.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.patients.entity.Patients;
import com.wyzy.hospital.patients.entity.PatientsFamily;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 病人表
 *
 * @author hospital code generator
 * @date 2021-04-12 11:16:16
 */
@Mapper
public interface PatientsMapper extends HospitalBaseMapper<Patients> {
	//通过病人的姓名查病历

	List<Patients> SelectMedicalRecord(@Param("name")String patientName, @Param("iphone")String iphone);

}
