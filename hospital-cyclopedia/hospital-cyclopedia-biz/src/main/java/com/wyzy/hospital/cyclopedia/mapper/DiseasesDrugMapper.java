

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.DiseasesDrugDTO;
import com.wyzy.hospital.cyclopedia.entity.DiseasesDrug;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 药品_疾病表
 *
 * @author hospital code generator
 * @date 2021-05-06 09:31:00
 */
@Mapper
public interface DiseasesDrugMapper extends HospitalBaseMapper<DiseasesDrug> {
// 根据疾病ID找药(前台)





	List<DiseasesDrugDTO>selectByDiseasesDrug(Long eid);


}
