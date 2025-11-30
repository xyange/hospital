package com.wyzy.hospital.pharmacy.kit.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.pharmacy.dto.*;
import com.wyzy.hospital.pharmacy.kit.CategoryKitService;
import com.wyzy.hospital.pharmacy.kit.ProductKitService;
import com.wyzy.hospital.pharmacy.service.CategoryService;
import com.wyzy.hospital.pharmacy.service.PhInstructionsService;
import com.wyzy.hospital.pharmacy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author aqie
 * Date on 2021/4/22  17:50
 * @Function:
 */
@Service
public class ProductKitServiceImpl implements ProductKitService {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryKitService categoryKitService;

	@Autowired
	private PhInstructionsService phInstructionsService;

	@Override
	public IPage<ProductDTO> getShopProductListByCate(IPage<ProductDTO> page, Long cateId, Long shopId) {
		// 获取所有子分类id 去重
		Set<Long> cateSet = categoryKitService.getAllSubCategoryIdsByParentId(cateId);
		// 查询所有商品列表
		List<ProductDTO> dtoList = productService.getShopProductListByCate(page, cateSet, shopId);
		// 分页
		IPage<ProductDTO> pageList = page.setRecords(dtoList);
		return pageList;
	}

	@Override
	public List<CategoryProductDTO> getShopProductTreeListByCate(Long cateId, Long shopId) {
		List<CategoryProductDTO> list = categoryService.getShopProductTreeListByCate(cateId, shopId);
		return list;
	}

	@Override
	public IPage<ProductDTO> getProductListByCate(IPage<ProductDTO> page,Long cateId) {
		Set<Long> cateSet = categoryKitService.getAllSubCategoryIdsByParentId(cateId);
		cateSet.add(cateId);
		List<ProductDTO> dtoList = productService.getProductListByCate(page, cateSet);
		IPage<ProductDTO> pageList = page.setRecords(dtoList);
		return pageList;
	}

	@Override
	public PhInstructionsDTO getInstructionByProductId(Long drugId) {
		PhInstructionsDTO phInstructionsIPage  = phInstructionsService.getInstructionByProductId(drugId);
		return phInstructionsIPage;
	}

	/**
	 * 关键字搜索
	 * @param page
	 * @param queryParam
	 * @return
	 */
	@Override
	public IPage<ShopProductDTO> keywordSearch(IPage<ShopProductDTO> page, ShopProductQueryParamDTO queryParam) {
		List<ShopProductDTO> shopProducList = phInstructionsService.keywordSearch(page,queryParam);
		Integer sas = 0;
		for (ShopProductDTO s:shopProducList
			 ) {
			for (ProductShopDTO p:s.getProductShopDTO()
				 ) {
				sas	+= p.getSales();
			}
			s.setSales(sas);
		}
		return page.setRecords(shopProducList);
	}
}
