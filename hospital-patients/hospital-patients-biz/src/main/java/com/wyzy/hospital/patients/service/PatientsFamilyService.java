

package com.wyzy.hospital.patients.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.entity.Patients;
import com.wyzy.hospital.patients.entity.PatientsFamily;

import java.util.List;

/**
 * 家人表
 *
 * @author hospital code generator
 * @date 2021-04-13 09:44:46
 */
public interface PatientsFamilyService extends IService<PatientsFamily> {
	//查询该用户所属家人

	List<PatientsFamily> QueryPatientsFamily(Integer patientsId);

    //查家属病历

	List<PatientsFamily> QueryPatientsAndFamilyMedical(Integer pid);

	//根据病人家属id查询该家属病历

	List<MedicalRecord> queryFamilyMedical(Integer fid);
}
