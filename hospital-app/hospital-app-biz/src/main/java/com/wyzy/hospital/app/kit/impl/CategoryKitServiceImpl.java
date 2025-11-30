package com.wyzy.hospital.app.kit.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.wyzy.hospital.app.api.dto.CategoryTreeDTO;
import com.wyzy.hospital.app.api.entity.Category;
import com.wyzy.hospital.app.kit.CategoryKitService;
import com.wyzy.hospital.app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author aqie
 * Date on 2021/5/27  8:43
 * @Function:
 */
@Service
@RequiredArgsConstructor
public class CategoryKitServiceImpl implements CategoryKitService {
	private final CategoryService categoryService;

	@Override
	public List<CategoryTreeDTO> getInfiniteCategoryListLambda(Long pid, Integer type) {
		// 1. 查询所有分类
		List<CategoryTreeDTO> all = getList(type)
				.stream().map(CategoryTreeDTO::new)
				.collect(Collectors.toList());
		// 2. 把根分类区分出来
		List<CategoryTreeDTO> roots = all.stream()
				.filter(dealCategory -> (dealCategory.getPid() == 0))
				.collect(Collectors.toList());
		// 3. 对根分类进行排序 小的在前
		roots.sort(new Comparator<CategoryTreeDTO>() {
			@Override
			public int compare(CategoryTreeDTO o1, CategoryTreeDTO o2) {
				return o2.getSort() - o1.getSort();
			}
		});

		// 4. 把非根分类区分出来
		List<CategoryTreeDTO> subs = all.stream()
				.filter(category -> (category.getPid() != 0))
				.collect(Collectors.toList());

		// 5.递归构建结构化的分类信息
		roots.forEach(root -> buildSubs(root, subs));
		return roots;
	}

	/**
	 * 获取指定类型的分类列表
	 * @return
	 */
	private List<Category> getList(Integer type) {
		List<Category> list = categoryService.list(new LambdaQueryWrapper<Category>().eq(Category::getType, type));
		return list;
	}

	/**
	 * 递归构建
	 * @param parent
	 * @param subs
	 */
	private void buildSubs(CategoryTreeDTO parent, List<CategoryTreeDTO> subs) {
		List<CategoryTreeDTO> children = subs.stream()
				.filter(sub -> (sub.getPid().equals(parent.getCategoryId())))
				.collect(Collectors.toList());
		//有子分类的情况
		if (!CollectionUtils.isEmpty(children)) {
			parent.setChilds(children);
			//再次递归构建
			children.forEach(child -> buildSubs(child, subs));
		}
	}
}
