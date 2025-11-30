
package com.wyzy.hospital.patients.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.patients.entity.Patients;
import com.wyzy.hospital.patients.mapper.PatientsMapper;
import com.wyzy.hospital.patients.service.PatientsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 病人表
 *
 * @author hospital code generator
 * @date 2021-04-12 11:16:16
 */
@Service
public class PatientsServiceImpl extends ServiceImpl<PatientsMapper, Patients> implements PatientsService {

	@Override
	public List<Patients> QuerysMedicalRecords(String name,String iphone) {

		return baseMapper.SelectMedicalRecord(name,iphone);
	}
}
