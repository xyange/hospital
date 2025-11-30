

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.EnMedicine;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 药品表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:35
 */
@Mapper
public interface EnMedicineMapper extends HospitalBaseMapper<EnMedicine> {
//根据疾病找药

List<EnMedicine> selectEnMedicineByDiseaseName(String diseaseName);
}
