
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.DiseasesDrugDTO;
import com.wyzy.hospital.cyclopedia.entity.DiseasesDrug;
import com.wyzy.hospital.cyclopedia.mapper.DiseasesDrugMapper;
import com.wyzy.hospital.cyclopedia.service.DiseasesDrugService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品_疾病表
 *
 * @author hospital code generator
 * @date 2021-05-06 09:31:00
 */
@Service
public class DiseasesDrugServiceImpl extends ServiceImpl<DiseasesDrugMapper, DiseasesDrug> implements DiseasesDrugService {

	@Override
	public List<DiseasesDrugDTO> queryByDiseasesDrug(Long eid) {
		List<DiseasesDrugDTO> diseasesDrugs = baseMapper.selectByDiseasesDrug(eid);
		return diseasesDrugs;
	}
}
