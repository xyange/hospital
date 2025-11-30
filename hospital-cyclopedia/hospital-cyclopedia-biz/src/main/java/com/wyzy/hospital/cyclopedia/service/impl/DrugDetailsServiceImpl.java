
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.DrugDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugDetails;
import com.wyzy.hospital.cyclopedia.mapper.DrugDetailsMapper;
import com.wyzy.hospital.cyclopedia.service.DrugDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:56
 */
@Service
public class DrugDetailsServiceImpl extends ServiceImpl<DrugDetailsMapper, DrugDetails> implements DrugDetailsService {

	@Resource
	DrugDetailsMapper drugDetailsMapper;


	@Override
	public List<DrugDetailsDTO> queryDrugType(Long drugId) {
		List<DrugDetailsDTO> drugDetailsDTOList = baseMapper.selectDrugType(drugId);
		return drugDetailsDTOList;
	}


	@Override
	public String movenDrug(Long id) {

			Integer count=drugDetailsMapper.selectDrugTypeNumber(id);
		if (count==0){
			drugDetailsMapper.deleteById(id);
		}else{
			return "该药品下有试剂不能删除";
		}
		return "删除成功";
	}
}
