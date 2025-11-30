

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.EnArticles;
import com.wyzy.hospital.cyclopedia.service.EnArticlesService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 文章表
 *
 * @author hospital code generator
 * @date 2021-04-22 08:48:06
 */
@RestController
@AllArgsConstructor
@RequestMapping("/enarticles" )
@Api(value = "enarticles", tags = "文章表管理")
public class EnArticlesController {

    private final  EnArticlesService enArticlesService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param enArticles 文章表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_enarticles_view')" )
    public R getEnArticlesPage(Page page, EnArticles enArticles) {
        return R.ok(enArticlesService.page(page, Wrappers.query(enArticles)));
    }


    /**
     * 通过id查询文章表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_enarticles_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(enArticlesService.getById(id));
    }

    /**
     * 新增文章表
     * @param enArticles 文章表
     * @return R
     */
    @ApiOperation(value = "新增文章表", notes = "新增文章表")
    @SysLog("新增文章表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_enarticles_add')" )
    public R save(@RequestBody EnArticles enArticles) {
        return R.ok(enArticlesService.save(enArticles));
    }

    /**
     * 修改文章表
     * @param enArticles 文章表
     * @return R
     */
    @ApiOperation(value = "修改文章表", notes = "修改文章表")
    @SysLog("修改文章表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_enarticles_edit')" )
    public R updateById(@RequestBody EnArticles enArticles) {
        return R.ok(enArticlesService.updateById(enArticles));
    }

    /**
     * 通过id删除文章表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除文章表", notes = "通过id删除文章表")
    @SysLog("通过id删除文章表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_enarticles_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(enArticlesService.removeById(id));
    }

/*	*//**
	 * 通过articleName模糊查询并随机查询3条文章表信息
	 * @param articleName
	 * @return R
	 *//*
	@ApiOperation(value = "通过name查询", notes = "通过id查询")
	@GetMapping("/articleName/{articleName}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_enarticles_view')" )
	public R getById(@PathVariable("articleName" ) String articleName) {
		return R.ok(enArticlesService.queryLikeName(articleName));*/


}
