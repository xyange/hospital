
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.DrugTypeCompanyDrugDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugType;
import com.wyzy.hospital.cyclopedia.mapper.DrugTypeMapper;
import com.wyzy.hospital.cyclopedia.service.DrugTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药剂表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:18
 */
@Service
public class DrugTypeServiceImpl extends ServiceImpl<DrugTypeMapper, DrugType> implements DrugTypeService {

	@Override
	public List<DrugTypeCompanyDrugDTO> queryDrugTypeCompanyDrug(Long tid) {
		List<DrugTypeCompanyDrugDTO> drugTypeCompanyDrugDTOList = baseMapper.selectDrugTypeCompanyDrug(tid);
		return drugTypeCompanyDrugDTOList;
	}
}
