

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.admin.api.entity.ClinicDiagnosis;
import org.apache.ibatis.annotations.Mapper;

/**
 * 诊疗项目表
 *
 * @author songM
 * @date 2021-04-17 10:49:36
 */
@Mapper
public interface ClinicDiagnosisMapper extends HospitalBaseMapper<ClinicDiagnosis> {

}
