package com.wyzy.hospital.app.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.app.api.dto.AppEbookDTO;
import com.wyzy.hospital.app.api.dto.CategoryTreeDTO;
import com.wyzy.hospital.app.kit.CategoryKitService;
import com.wyzy.hospital.app.service.BookService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/6/10  9:52
 * @Function:
 */
@Slf4j
@RestController
@RequestMapping("app/ebook")
@RequiredArgsConstructor
@Api(value = "appEbook", tags = "app电子书管理")
public class AppEbookController {

	private final BookService bookService;

	private final CategoryKitService categoryKitService;

	/**
	 * 分页查询
	 * @param query 分页对象
	 * @param book 电子书
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	public R<IPage<AppEbookDTO>> getBookPage(Query query, AppEbookDTO book) {
		return R.ok(bookService.bookPage(Condition.getPage(query), book));
	}

	/**
	 * 获取分类 Tree
	 * @param pid 顶级分类id
	 * @param type 分类类型
	 * @return
	 */
	@ApiOperation(value = "获取分类 Tree", notes = "获取分类 Tree")
	@GetMapping("tree")
	public R<List<CategoryTreeDTO>> getCategoryTree(@RequestParam Long pid, @RequestParam Integer type){
		List<CategoryTreeDTO> treeDTOS = categoryKitService.getInfiniteCategoryListLambda(pid, type);
		return R.ok(treeDTOS);
	}

	/**
	 * 增加电子书浏览量
	 */
	@PutMapping("increaseView/{id}")
	public R<Boolean> increaseView(@PathVariable Long id){
		return R.ok(bookService.increaseView(id));
	}
}
