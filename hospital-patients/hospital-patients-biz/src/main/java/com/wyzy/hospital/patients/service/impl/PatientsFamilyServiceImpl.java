
package com.wyzy.hospital.patients.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.entity.Patients;
import com.wyzy.hospital.patients.entity.PatientsFamily;
import com.wyzy.hospital.patients.mapper.PatientsFamilyMapper;
import com.wyzy.hospital.patients.service.PatientsFamilyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 家人表
 *
 * @author hospital code generator
 * @date 2021-04-13 09:44:46
 */
@Service
public class PatientsFamilyServiceImpl extends ServiceImpl<PatientsFamilyMapper, PatientsFamily> implements PatientsFamilyService {

	@Override
	public List<PatientsFamily> QueryPatientsFamily(Integer patientsId) {

		return baseMapper.SelectPatientsFamily(patientsId);
	}

	@Override
	public List<PatientsFamily> QueryPatientsAndFamilyMedical(Integer pid) {
		return baseMapper.SelectPatientsAndFamilyMedical(pid);
	}

	@Override
	public List<MedicalRecord> queryFamilyMedical(Integer fid) {
		return baseMapper.SelectFamilyMedical(fid);
	}


}
