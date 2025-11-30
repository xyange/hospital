

package com.wyzy.hospital.pharmacy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.pharmacy.dto.CategoryProductDTO;
import com.wyzy.hospital.pharmacy.entity.Category;

import java.util.List;

/**
 * 药房分类表
 *
 * @author aqie
 * @date 2021-04-22 09:19:47
 */
public interface CategoryService extends IService<Category> {
	List<CategoryProductDTO> getShopProductTreeListByCate(Long cateId, Long shopId);
}
