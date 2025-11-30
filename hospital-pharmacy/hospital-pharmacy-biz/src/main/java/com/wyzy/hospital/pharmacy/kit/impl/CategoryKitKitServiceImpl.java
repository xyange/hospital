package com.wyzy.hospital.pharmacy.kit.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.wyzy.hospital.pharmacy.dto.CategoryDTO;
import com.wyzy.hospital.pharmacy.dto.CategoryTreeDTO;
import com.wyzy.hospital.pharmacy.entity.Category;
import com.wyzy.hospital.pharmacy.kit.CategoryKitService;
import com.wyzy.hospital.pharmacy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author aqie
 * Date on 2021/4/22  10:24
 * @Function:
 */
@Service
public class CategoryKitKitServiceImpl implements CategoryKitService {
	@Autowired
	private CategoryService categoryService;

	// 查询指定id下所有分类
	private static Set<Category> allSubCategories = new HashSet<>();

	@Override
	public List<Category> list(CategoryDTO categoryDTO) {
		List<Category> list = categoryService.list(new LambdaQueryWrapper<Category>()
				.eq(Category::getPid, categoryDTO.getId()));
		return list;
	}

	@Override
	public List<CategoryTreeDTO> getInfiniteCategoryList(Long pid) {
		// 1. 查询所有分类
		List<Category> all = categoryService.list();
		// 2. 查询指定分类id下所有分类
		initAllSubcategories();
		Set<Category> allSubCategoriesByParentId = getAllSubCategoriesByParentId(pid, all);
		List<CategoryTreeDTO> categoryTreeDTOList = allSubCategoriesByParentId.stream().map(CategoryTreeDTO::new).collect(Collectors.toList());
		List<CategoryTreeDTO> treeCategories = getTreeCategories(pid, categoryTreeDTOList, 0);
		return treeCategories;
	}

	@Override
	public List<CategoryTreeDTO> getInfiniteCategoryListLambda(Long pid) {
		// 1. 查询所有分类
		List<CategoryTreeDTO> all = categoryService.list().stream().map(CategoryTreeDTO::new).collect(Collectors.toList());
		// 2. 把根分类区分出来
		List<CategoryTreeDTO> roots = all.stream().filter(dealCategory -> (dealCategory.getPid() == 0)).collect(Collectors.toList());
		// 3. 对根分类进行排序 小的在前
		roots.sort(new Comparator<CategoryTreeDTO>() {
			@Override
			public int compare(CategoryTreeDTO o1, CategoryTreeDTO o2) {
				return o2.getSort() - o1.getSort();
			}
		});

		// 4. 把非根分类区分出来
		List<CategoryTreeDTO> subs = all.stream().filter(category -> (category.getPid() != 0)).collect(Collectors.toList());

		// 5.递归构建结构化的分类信息
		roots.forEach(root -> buildSubs(root, subs));
		return roots;
	}

	/**
	 * 递归构建
	 * @param parent
	 * @param subs
	 */
	private void buildSubs(CategoryTreeDTO parent, List<CategoryTreeDTO> subs) {
		List<CategoryTreeDTO> children = subs.stream().filter(sub -> (sub.getPid().equals(parent.getId()))).collect(Collectors.toList());
		//有子分类的情况
		if (!CollectionUtils.isEmpty(children)) {
			parent.setChilds(children);
			//再次递归构建
			children.forEach(child -> buildSubs(child, subs));
		}
	}

	@Override
	public Set<Category> getAllSubCategoriesByParentId(Long parentId) {
		List<Category> all = categoryService.list();
		initAllSubcategories();
		// log.info("{}", allSubCategories.size());
		return getAllSubCategoriesByParentId(parentId, all);
	}

	@Override
	public Set<Long> getAllSubCategoryIdsByParentId(Long parentId) {
		List<Category> all = categoryService.list();
		initAllSubcategories();
		Set<Category> allSubCategoriesByParentId = getAllSubCategoriesByParentId(parentId, all);
		return allSubCategoriesByParentId.stream().map(Category::getId).collect(Collectors.toSet());
	}

	/**
	 * 这里必须要用静态变量 不然只会查出一级数据
	 * @param pid
	 * @param all
	 * @return
	 */
	private Set<Category> getAllSubCategoriesByParentId(Long pid, List<Category> all) {
		for(Category category : all){
			if (pid.equals(category.getPid())){
				allSubCategories.add(category);
				getAllSubCategoriesByParentId(category.getId(),all);
			}
		}
		return allSubCategories;
	}

	// 静态变量 在每次调用前初始到原来状态
	private void initAllSubcategories() {
		if (allSubCategories.size() > 0){
			allSubCategories = new HashSet<>();
		}
	}

	private List<CategoryTreeDTO> getTreeCategories(Long parentId, List<CategoryTreeDTO> allSubCategoriesResponse, Integer level) {
		List<CategoryTreeDTO> treeCategories = new ArrayList<>();
		for (CategoryTreeDTO category : allSubCategoriesResponse){
			if (parentId.equals(category.getPid())){
				category.setLevel(level);
				// 如果遍历的分类parentId等于 传入的父级分类id，则将其加入返回list
				// 然后将该分类作为父级分类继续递归调用
				List<CategoryTreeDTO> childs = getTreeCategories(category.getId(), allSubCategoriesResponse, (level + 1));
				if (childs.size() > 0){
					category.setChilds(childs);
				}
				treeCategories.add(category);
			}
		}
		return treeCategories;
	}
}
