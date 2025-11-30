

package com.wyzy.hospital.pharmacy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.pharmacy.dto.PhInstructionsDTO;
import com.wyzy.hospital.pharmacy.dto.ShopProductDTO;
import com.wyzy.hospital.pharmacy.dto.ShopProductQueryParamDTO;
import com.wyzy.hospital.pharmacy.entity.PhInstructions;

import java.util.List;

/**
 * 药品说明书
 *
 * @author songM
 * @date 2021-06-04 14:29:57
 */
public interface PhInstructionsService extends IService<PhInstructions> {
	/**
	* @Description: 根据药品id查询说明书
	* @Param: [drugId]
	* @return: com.wyzy.hospital.pharmacy.entity.PhInstructions
	* @Author: songM
	* @Date: 2021/6/4
	*/
	PhInstructionsDTO getInstructionByProductId(Long drugId);
	/**
	* @Description: 关键字搜索
	* @Param: [page, queryParam]
	* @return: java.util.List<com.wyzy.hospital.pharmacy.dto.ShopProductDTO>
	* @Author: songM
	* @Date: 2021/6/9
	*/
    List<ShopProductDTO> keywordSearch(IPage<ShopProductDTO> page, ShopProductQueryParamDTO queryParam);
}
