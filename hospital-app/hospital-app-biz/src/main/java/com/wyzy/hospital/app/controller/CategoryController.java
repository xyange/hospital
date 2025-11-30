

package com.wyzy.hospital.app.controller;

import com.wyzy.hospital.app.api.dto.CategoryTreeDTO;
import com.wyzy.hospital.app.api.entity.Category;
import com.wyzy.hospital.app.kit.CategoryKitService;
import com.wyzy.hospital.app.service.CategoryService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 电子书分类
 *
 * @author aqie
 * @date 2021-05-27 08:33:57
 */
@RestController
@AllArgsConstructor
@RequestMapping("/category" )
@Api(value = "category", tags = "电子书分类管理")
public class CategoryController {

    private final  CategoryService categoryService;

    private final CategoryKitService categoryKitService;

	/**
	 * 获取分类 Tree
	 * @param pid 顶级分类id
	 * @param type 分类类型
	 * @return
	 */
	@ApiOperation(value = "获取分类 Tree", notes = "获取分类 Tree")
	@ApiImplicitParams({@ApiImplicitParam(name = "pid", value = "顶级分类id", paramType = "query",example="0"),
			@ApiImplicitParam(name = "type", value = "分类类型", paramType = "query",example="0")})
	@GetMapping("tree")
	public R<List<CategoryTreeDTO>> getCategoryTree(Long pid, Integer type){
		List<CategoryTreeDTO> treeDTOS = categoryKitService.getInfiniteCategoryListLambda(pid, type);
		return R.ok(treeDTOS);
	}
    /**
     * 新增电子书分类
     * @param category 电子书分类
     * @return R
     */
    @ApiOperation(value = "新增电子书分类", notes = "新增电子书分类")
    @SysLog("新增电子书分类" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('app_category_add')" )
    public R save(@RequestBody Category category) {
        return R.ok(categoryService.save(category));
    }

    /**
     * 修改电子书分类
     * @param category 电子书分类
     * @return R
     */
    @ApiOperation(value = "修改电子书分类", notes = "修改电子书分类")
    @SysLog("修改电子书分类" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('app_category_edit')" )
    public R updateById(@RequestBody Category category) {
        return R.ok(categoryService.updateById(category));
    }

    /**
     * 通过id删除电子书分类
     * @param categoryId id
     * @return R
     */
    @ApiOperation(value = "通过id删除电子书分类", notes = "通过id删除电子书分类")
    @SysLog("通过id删除电子书分类" )
    @DeleteMapping("/{categoryId}" )
    @PreAuthorize("@pms.hasPermission('app_category_del')" )
    public R removeById(@PathVariable Long categoryId) {
        return R.ok(categoryService.removeById(categoryId));
    }

}
