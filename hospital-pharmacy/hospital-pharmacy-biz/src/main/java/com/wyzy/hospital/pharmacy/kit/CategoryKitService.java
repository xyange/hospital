package com.wyzy.hospital.pharmacy.kit;

import com.wyzy.hospital.pharmacy.dto.CategoryDTO;
import com.wyzy.hospital.pharmacy.dto.CategoryTreeDTO;
import com.wyzy.hospital.pharmacy.entity.Category;

import java.util.List;
import java.util.Set;

/**
 * @Author aqie
 * Date on 2021/4/22  10:24
 * @Function:
 */
public interface CategoryKitService {

	// 查询所有父级分类下一级子分类
	List<Category> list(CategoryDTO categoryDTO);

	/**
	 * 查询父级分类无限极树状分类
	 * @param pid
	 * @return
	 */
	List<CategoryTreeDTO> getInfiniteCategoryList(Long pid);

	/**
	 * 流实现无限极分类
	 * @param pid
	 * @return
	 */
	List<CategoryTreeDTO> getInfiniteCategoryListLambda(Long pid);

	/**
	 * 查询父级分类下所有子分类
	 * @param parentId
	 * @return
	 */
	Set<Category> getAllSubCategoriesByParentId(Long parentId);

	/**
	 * 查询父级分类下所有子分类id
	 * @param parentId
	 * @return
	 */
	Set<Long> getAllSubCategoryIdsByParentId(Long parentId);

	/**
	 * todo 查询店铺分类下所有商品
	 * SELECT * FROM ph_product where shop_id = 1 and cate_id=5;
	 */

	/**
	 * todo 查询分类下所有商品(规则只查价格最低的)
	 * SELECT * FROM ph_product group by product_name having cate_id in (5)  order by price ;
	 */
}
