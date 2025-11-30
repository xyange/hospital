

package com.wyzy.hospital.patients.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 病历表
 *
 * @author hospital code generator
 * @date 2021-04-14 15:01:00
 */
@Mapper
public interface MedicalRecordMapper extends HospitalBaseMapper<MedicalRecord> {
	//根据病人家属id查询该家属病历

    List<MedicalRecord>SelectFamilyMedical(Integer fid);

	//删除家属信息以及病历

	public void  deletePatientsFamily(Integer fid);
}
