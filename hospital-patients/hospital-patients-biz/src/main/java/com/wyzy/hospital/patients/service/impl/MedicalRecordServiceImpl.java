
package com.wyzy.hospital.patients.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.mapper.MedicalRecordMapper;
import com.wyzy.hospital.patients.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 病历表
 *
 * @author hospital code generator
 * @date 2021-04-14 15:01:00
 */
@Service
public class MedicalRecordServiceImpl extends ServiceImpl<MedicalRecordMapper, MedicalRecord> implements MedicalRecordService {

	@Override
	public List<MedicalRecord> QueryFamilyMedical(Integer fid) {
		return baseMapper.SelectFamilyMedical(fid);
	}

	@Override
	public void removerPatientsFamily(Integer fid) {
		baseMapper.deletePatientsFamily(fid);
	}


}
