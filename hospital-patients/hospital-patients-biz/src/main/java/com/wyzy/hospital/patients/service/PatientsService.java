

package com.wyzy.hospital.patients.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.patients.entity.Patients;

import java.util.List;

/**
 * 病人表
 *
 * @author hospital code generator
 * @date 2021-04-12 11:16:16
 */
public interface PatientsService extends IService<Patients> {
	//根据姓名和手机查询病历

	public List<Patients> QuerysMedicalRecords(String name,String iphone);

}
