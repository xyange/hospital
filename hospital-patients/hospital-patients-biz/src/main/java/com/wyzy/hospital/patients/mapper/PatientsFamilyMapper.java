

package com.wyzy.hospital.patients.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.entity.Patients;
import com.wyzy.hospital.patients.entity.PatientsFamily;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 家人表
 *
 * @author hospital code generator
 * @date 2021-04-13 09:44:46
 */
@Mapper
public interface PatientsFamilyMapper extends HospitalBaseMapper<PatientsFamily> {
	//查询该用户所属家人

	List<PatientsFamily> SelectPatientsFamily(Integer patientsId);

	//通过病人的id查询病人家属的信息和病历

	List<PatientsFamily> SelectPatientsAndFamilyMedical(Integer pid);

	//根据病人家属id查询该家属病历

	List<MedicalRecord>SelectFamilyMedical(Integer fid);

}
