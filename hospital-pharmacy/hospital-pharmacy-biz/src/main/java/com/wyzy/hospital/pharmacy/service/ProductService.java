

package com.wyzy.hospital.pharmacy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.pharmacy.dto.ProductDTO;
import com.wyzy.hospital.pharmacy.entity.Product;

import java.util.List;
import java.util.Set;

/**
 * 药房商品表
 *
 * @author aqie
 * @date 2021-04-22 09:17:03
 */
public interface ProductService extends IService<Product> {

	List<ProductDTO> getProductListByCate(IPage<ProductDTO> page, Set<Long> cates);

	List<ProductDTO> getShopProductListByCate(IPage<ProductDTO> page, Set<Long> cates, Long shopId);


}
