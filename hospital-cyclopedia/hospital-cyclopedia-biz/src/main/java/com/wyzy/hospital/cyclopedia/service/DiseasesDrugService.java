

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.DiseasesDrugDTO;
import com.wyzy.hospital.cyclopedia.entity.DiseasesDrug;

import java.util.List;

/**
 * 药品_疾病表
 *
 * @author hospital code generator
 * @date 2021-05-06 09:31:00
 */
public interface DiseasesDrugService extends IService<DiseasesDrug> {
// 根据疾病ID找药

	List<DiseasesDrugDTO> queryByDiseasesDrug(Long eid);
}
