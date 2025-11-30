
package com.wyzy.hospital.pharmacy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pharmacy.dto.CategoryProductDTO;
import com.wyzy.hospital.pharmacy.dto.ProductDTO;
import com.wyzy.hospital.pharmacy.entity.Product;
import com.wyzy.hospital.pharmacy.mapper.ProductMapper;
import com.wyzy.hospital.pharmacy.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 药房商品表
 *
 * @author aqie
 * @date 2021-04-22 09:17:03
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

	@Override
	public List<ProductDTO> getProductListByCate(IPage<ProductDTO> page, Set<Long> cates) {
		List<ProductDTO> productListByCate = baseMapper.getProductListByCate(page, cates);
		return productListByCate;
	}

	@Override
	public List<ProductDTO> getShopProductListByCate(IPage<ProductDTO> page, Set<Long> cates, Long shopId) {
		return baseMapper.getShopProductListByCate(page, cates, shopId);
	}


}
