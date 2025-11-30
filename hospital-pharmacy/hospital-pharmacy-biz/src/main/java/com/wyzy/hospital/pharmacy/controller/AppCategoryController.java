package com.wyzy.hospital.pharmacy.controller;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.pharmacy.dto.CategoryDTO;
import com.wyzy.hospital.pharmacy.dto.CategoryTreeDTO;
import com.wyzy.hospital.pharmacy.entity.Category;
import com.wyzy.hospital.pharmacy.kit.CategoryKitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author aqie
 * Date on 2021/4/22  10:22
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/category" )
@Api(value = "category", tags = "app药房分类表管理")
public class AppCategoryController {
	private final CategoryKitService categoryKitService;

	/**
	 * 查询顶级分类 在首页展示
	 * @param
	 * @return
	 */
	@ApiOperation(value = "查询下一级分类", notes = "id查询")
	@GetMapping
	@PreAuthorize("@pms.hasPermission('app_pharmacy_category_view')")
	public R<List<CategoryDTO>> list(CategoryDTO categoryDTO){
		List<Category> categoryList = categoryKitService.list(categoryDTO);
		List<CategoryDTO> responseList = categoryList.stream().map(CategoryDTO::new).collect(Collectors.toList());
		return R.ok(responseList);
	}

	/**
	 * 无限极树状分类
	 * @param pid
	 * @return
	 */
	@ApiOperation(value = "无限极分类", notes = "通过pid查询")
	@GetMapping("treeCats")
	@PreAuthorize("@pms.hasPermission('app_pharmacy_category_view')")
	public R<List<CategoryTreeDTO>> Infinite(@RequestParam("pid") Long pid){
		List<CategoryTreeDTO> infiniteCategoryList = categoryKitService.getInfiniteCategoryList(pid);
		return R.ok(infiniteCategoryList);
	}

	/**
	 * lambda无限极树状分类
	 * @param pid
	 * @return
	 */
	@ApiOperation(value = "lambda无限极分类", notes = "lambda通过pid查询")
	@GetMapping("treeCatsLambda")
	@PreAuthorize("@pms.hasPermission('app_pharmacy_category_view')")
	public R<List<CategoryTreeDTO>> InfiniteLambda(@RequestParam("pid") Long pid){
		List<CategoryTreeDTO> infiniteCategoryList = categoryKitService.getInfiniteCategoryList(pid);
		return R.ok(infiniteCategoryList);
	}


	/**
	 * 获取传入分类下所有子分类(模型)
	 * @return
	 */
	@ApiOperation(value = "获取传入分类下所有子分类", notes = "通过pid查询获取传入分类下所有子分类")
	@GetMapping("allSubCats")
	@PreAuthorize("@pms.hasPermission('app_pharmacy_category_view')")
	public R<List<CategoryTreeDTO>> subCategories(@RequestParam("pid") Long pid){
		Set<Category> allSubCategories = categoryKitService.getAllSubCategoriesByParentId(pid);
		List<CategoryTreeDTO> allSubCategoriesResponse = allSubCategories.stream().map(CategoryTreeDTO::new).collect(Collectors.toList());
		return R.ok(allSubCategoriesResponse);
	}
}
