

package com.wyzy.hospital.patients.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.patients.entity.MedicalRecord;

import java.util.List;

/**
 * 病历表
 *
 * @author hospital code generator
 * @date 2021-04-14 15:01:00
 */
public interface MedicalRecordService extends IService<MedicalRecord> {
	//根据病人家属id查病历

	public List<MedicalRecord> QueryFamilyMedical(Integer fid);

	//删除家属信息以及病历

	public void  removerPatientsFamily(Integer fid);
}
