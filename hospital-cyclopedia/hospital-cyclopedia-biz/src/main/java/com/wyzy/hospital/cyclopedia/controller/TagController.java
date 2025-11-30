

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.dto.TagDTO;
import com.wyzy.hospital.cyclopedia.entity.Tag;
import com.wyzy.hospital.cyclopedia.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 食物标签
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:59
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tag" )
@Api(value = "tag", tags = "食物标签管理")
public class TagController {

    private final  TagService tagService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param tag 食物标签
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_tag_view')" )
    public R getTagPage(Page page, Tag tag) {
        return R.ok(tagService.page(page, Wrappers.query(tag)));
    }


    /**
     * 通过id查询食物标签
     * @param tagId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{tagId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_tag_view')" )
    public R getById(@PathVariable("tagId" ) Long tagId) {
        return R.ok(tagService.getById(tagId));
    }

    /**
     * 新增食物标签
     * @param tag 食物标签
     * @return R
     */
    @ApiOperation(value = "新增食物标签", notes = "新增食物标签")
    @SysLog("新增食物标签" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_tag_add')" )
    public R save(@RequestBody Tag tag) {
        return R.ok(tagService.save(tag));
    }

    /**
     * 修改食物标签
     * @param tag 食物标签
     * @return R
     */
    @ApiOperation(value = "修改食物标签", notes = "修改食物标签")
    @SysLog("修改食物标签" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_tag_edit')" )
    public R updateById(@RequestBody Tag tag) {
        return R.ok(tagService.updateById(tag));
    }

    /**
     * 通过id删除食物标签
     * @param tagId id
     * @return R
     */
    @ApiOperation(value = "通过id删除食物标签", notes = "通过id删除食物标签")
    @SysLog("通过id删除食物标签" )
    @DeleteMapping("/{tagId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_tag_del')" )
    public R removeById(@PathVariable Long tagId) {
        return R.ok(tagService.removeById(tagId));
    }

	/**
	 * 通过tid查询食物标签下的食物
	 * @param tid tid
	 * @return R
	 */
	@ApiOperation(value = "通过tid查询食物标签下的食物", notes = "通过tid查询")
	@GetMapping("/TagFood/{tid}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_tag_view')" )
	public R<List<TagDTO>> getTagFood(@PathVariable("tid" ) Long tid) {

		return R.ok(tagService.queryTagFoodById(tid));
	}




}
