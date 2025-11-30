

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.dto.TagDTO;
import com.wyzy.hospital.cyclopedia.entity.Tag;
import com.wyzy.hospital.cyclopedia.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 食物标签
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:59
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tag" )
@Api(value = "tag", tags = "App食物标签管理")
public class AppTagController {

    private final  TagService tagService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param tag 食物标签
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R getTagPage(Page page, Tag tag) {
        return R.ok(tagService.page(page, Wrappers.query(tag)));
    }


    /**
     * 通过id查询食物标签
     * @param tagId id
     * @return R
     */
    @ApiOperation(value = "食物标签表查一个", notes = "通过id查询")
    @GetMapping("/app/{tagId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R getById(@PathVariable("tagId" ) Long tagId) {
        return R.ok(tagService.getById(tagId));
    }

	/**
	 * 通过tid查询食物标签下的食物
	 * @param tid tid
	 * @return R
	 */
	@ApiOperation(value = "查询食物标签下的食物", notes = "通过tid查询")
	@GetMapping("/TagFood/{tid}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TagDTO>> getTagFood(@PathVariable("tid" ) Long tid) {

		return R.ok(tagService.queryTagFoodById(tid));
	}




}
