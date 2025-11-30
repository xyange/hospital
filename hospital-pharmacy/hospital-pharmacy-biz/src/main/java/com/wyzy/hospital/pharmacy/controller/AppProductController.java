package com.wyzy.hospital.pharmacy.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.pharmacy.dto.*;
import com.wyzy.hospital.pharmacy.kit.ProductKitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/22  17:37
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/product" )
@Api(value = "product", tags = "app药房商品表管理")
public class AppProductController {
	private final ProductKitService productKitService;

	/**
	 * 根据店铺id 和 分类id
	 * 查询店铺最底层分类下所有商品列表
	 * 支持一级分类/二级分类
	 */
	@ApiOperation(value = "查询店铺分类下所有商品列表", notes = "支持一级分类/二级分类")
	@GetMapping("getShopProductListByCate")
	@PreAuthorize("@pms.hasPermission('app_pharmacy_shop_view')")
	public R<IPage<ProductDTO>> getShopProductListByCate(Query query, Long cateId, Long shopId){
		IPage<ProductDTO> shopProductListByCate = productKitService.getShopProductListByCate(Condition.getPage(query), cateId, shopId);
		return R.ok(shopProductListByCate);
	}

	/**
	 * 根据店铺id 和 分类id
	 * 查询店铺最底层分类下所有商品
	 * 树状结构 传入一级分类id
	 * {
	 *       "id": "2",
	 *       "pid": "1",
	 *       "name": "口罩",
	 *       "products": [
	 *         {
	 *           "productId": "3",
	 *           "shopId": "1",
	 *           "productImage": "",
	 *           "productName": "医用外科口罩",
	 *           "cateId": "2"
	 *         },
	 *         {
	 *           "productId": "5",
	 *           "shopId": "1",
	 *           "productImage": "",
	 *           "productName": "N95口罩",
	 *           "cateId": "2"
	 *         }
	 *       ]
	 *     },
	 */
	@ApiOperation(value = "店铺分类下所有商品Tree", notes = "传入一级分类id查询二级分类及所有商品")
	@GetMapping("getShopProductTreeListByCate")
	@PreAuthorize("@pms.hasPermission('app_pharmacy_shop_view')")
	public R<List<CategoryProductDTO>> getShopProductTreeListByCate(Long cateId, Long shopId){
		List<CategoryProductDTO> list = productKitService.getShopProductTreeListByCate(cateId, shopId);
		return R.ok(list);
	}



	/**
	 * 查询分类下所有商品(根据商品名分组)
	 */
	@ApiOperation(value = "查询分类下所有商品列表", notes = "分页查询分类下所有商品(根据商品名分组),包含传入分类")
	@GetMapping("getProductListByCate")
	@PreAuthorize("@pms.hasPermission('app_pharmacy_shop_view')")
	public R<IPage<ProductDTO>> getProductListByCate(Query query, Long cateId){
		IPage<ProductDTO> pageList = productKitService.getProductListByCate(Condition.getPage(query), cateId);
		return R.ok(pageList);
	}


	/**
	 * 根据商品id查询说明书
	 */
	@ApiOperation(value = "根据商品id查询说明书", notes = "根据商品id查询说明书")
	@GetMapping("/getInstructionByProductId")
	@PreAuthorize("@pms.hasPermission('app_pharmacy_shop_view')")
	public R<PhInstructionsDTO> getInstructionByProductId(Long drugId){
		PhInstructionsDTO phInstructionsDTO = productKitService.getInstructionByProductId(drugId);
		if (phInstructionsDTO == null){
			return R.failed("查无此值");
		}
		return R.ok(phInstructionsDTO);
	}

	/**
	* @Description: 药房关键字搜索
	* @Param: [query, queryParam ]
	* @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.pharmacy.dto.ProductDTO>>
	* @Author: songM
	* @Date: 2021/6/9
	*/
	@ApiOperation(value = "药房关键字搜索", notes = "药房关键字搜索")
	@GetMapping("/keywordSearch" )
	@PreAuthorize("@pms.hasPermission('app_pharmacy_shop_view')" )
	public R<IPage<ShopProductDTO>> keywordSearch(Query query, ShopProductQueryParamDTO queryParam) {
		IPage<ShopProductDTO> shopProductListByCate = productKitService.keywordSearch(Condition.getPage(query),queryParam);
		return R.ok(shopProductListByCate);
	}
	
}
