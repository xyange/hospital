

package com.wyzy.hospital.pharmacy.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.pharmacy.dto.ProductDTO;
import com.wyzy.hospital.pharmacy.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 药房商品表
 *
 * @author aqie
 * @date 2021-04-22 09:17:03
 */
@Mapper
public interface ProductMapper extends HospitalBaseMapper<Product> {

	/**
	 * 根据分类获取产品列表
	 * @param cates
	 * @return
	 */
    List<ProductDTO> getProductListByCate(IPage<ProductDTO> page, @Param("cates") Set<Long> cates);

	/**
	 *
	 * @param cates
	 * @return
	 */
	List<ProductDTO> getShopProductListByCate(IPage<ProductDTO> page, @Param("cates") Set<Long> cates, @Param("shopId")Long shopId);



}
