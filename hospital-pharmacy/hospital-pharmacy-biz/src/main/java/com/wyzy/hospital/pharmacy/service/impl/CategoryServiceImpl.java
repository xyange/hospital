
package com.wyzy.hospital.pharmacy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pharmacy.dto.CategoryProductDTO;
import com.wyzy.hospital.pharmacy.entity.Category;
import com.wyzy.hospital.pharmacy.mapper.CategoryMapper;
import com.wyzy.hospital.pharmacy.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药房分类表
 *
 * @author aqie
 * @date 2021-04-22 09:19:47
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
	@Override
	public List<CategoryProductDTO> getShopProductTreeListByCate(Long cateId, Long shopId) {
		return baseMapper.getShopProductTreeListByCate(cateId, shopId);
	}
}
