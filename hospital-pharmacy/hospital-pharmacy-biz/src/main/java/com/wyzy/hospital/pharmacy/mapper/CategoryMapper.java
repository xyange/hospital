

package com.wyzy.hospital.pharmacy.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.pharmacy.dto.CategoryProductDTO;
import com.wyzy.hospital.pharmacy.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 药房分类表
 *
 * @author aqie
 * @date 2021-04-22 09:19:47
 */
@Mapper
public interface CategoryMapper extends HospitalBaseMapper<Category> {
	List<CategoryProductDTO> getShopProductTreeListByCate(@Param("cateId") Long cateId, @Param("shopId") Long shopId);
}
