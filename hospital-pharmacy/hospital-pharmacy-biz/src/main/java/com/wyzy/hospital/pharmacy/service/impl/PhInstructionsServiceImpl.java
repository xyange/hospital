
package com.wyzy.hospital.pharmacy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pharmacy.dto.PhInstructionsDTO;
import com.wyzy.hospital.pharmacy.dto.ShopProductDTO;
import com.wyzy.hospital.pharmacy.dto.ShopProductQueryParamDTO;
import com.wyzy.hospital.pharmacy.entity.PhInstructions;
import com.wyzy.hospital.pharmacy.mapper.PhInstructionsMapper;
import com.wyzy.hospital.pharmacy.service.PhInstructionsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品说明书
 *
 * @author songM
 * @date 2021-06-04 14:29:57
 */
@Service
public class PhInstructionsServiceImpl extends ServiceImpl<PhInstructionsMapper, PhInstructions> implements PhInstructionsService {

	/**
	* @Description: 根据药品id查询说明书
	* @Param: [drugId] 药品id
	* @return: com.wyzy.hospital.pharmacy.entity.PhInstructions
	* @Author: songM
	* @Date: 2021/6/4
	*/
	@Override
	public PhInstructionsDTO getInstructionByProductId(Long drugId) {
		return baseMapper.getInstructionByProductId(drugId);
	}
	/**
	* @Description: 关键字搜索
	* @Param: [page, queryParam]
	* @return: java.util.List<com.wyzy.hospital.pharmacy.dto.ShopProductDTO>
	* @Author: songM
	* @Date: 2021/6/9
	*/
	@Override
	public List<ShopProductDTO> keywordSearch(IPage<ShopProductDTO> page, ShopProductQueryParamDTO queryParam) {
		return baseMapper.keywordSearch(page,queryParam);
	}
}
