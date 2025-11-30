

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.DrugDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugDetails;

import java.util.List;

/**
 * 药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:56
 */
public interface DrugDetailsService extends IService<DrugDetails> {
	List<DrugDetailsDTO> queryDrugType(Long drugId);

	String movenDrug(Long id);
}
