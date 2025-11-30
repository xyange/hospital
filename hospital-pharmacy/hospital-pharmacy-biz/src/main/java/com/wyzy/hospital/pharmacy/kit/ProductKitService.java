package com.wyzy.hospital.pharmacy.kit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.pharmacy.dto.*;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/22  17:50
 * @Function:
 */
public interface ProductKitService {
	/**
	 * 查询店铺分类下所有商品
	 * @param cateId
	 * @param shopId
	 */
	IPage<ProductDTO> getShopProductListByCate(IPage<ProductDTO> page, Long cateId, Long shopId);

	/**
	 * 查询店铺分类下所有商品 树状结构
	 * @param page
	 * @param cateId
	 * @param shopId
	 * @return
	 */
	List<CategoryProductDTO> getShopProductTreeListByCate(Long cateId, Long shopId);
	/**
	 * 查询分类下所有商品(根据商品名分组)
	 * @param page
	 * @param cateId
	 * @return
	 */
	IPage<ProductDTO> getProductListByCate(IPage<ProductDTO> page, Long cateId);

	/**
	 * 根据药品id查询说明书
	 * @param drugId
	 * @return
	 */
	PhInstructionsDTO getInstructionByProductId(Long drugId);

	/**
	 * 关键字搜索
	 * @param page
	 * @param queryParam
	 * @return
	 */
    IPage<ShopProductDTO> keywordSearch(IPage<ShopProductDTO> page, ShopProductQueryParamDTO queryParam);
}
