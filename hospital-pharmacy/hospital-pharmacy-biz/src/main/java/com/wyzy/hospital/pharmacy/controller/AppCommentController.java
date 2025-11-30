

package com.wyzy.hospital.pharmacy.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.pharmacy.dto.CommentDTO;
import com.wyzy.hospital.pharmacy.entity.Comment;
import com.wyzy.hospital.pharmacy.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


/**
 * 药房评论
 *
 * @author aqie
 * @date 2021-04-22 09:47:09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/comment" )
@Api(value = "comment", tags = "App药房评论管理")
public class AppCommentController {

    private final  CommentService commentService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param comment 药房评论
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
    public R getCommentPage(Page page, Comment comment) {
        return R.ok(commentService.page(page, Wrappers.query(comment)));
    }


    /**
     * 通过id查询药房评论
     * @param commentId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{commentId}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
    public R getById(@PathVariable("commentId" ) Long commentId) {
        return R.ok(commentService.getById(commentId));
    }

	/**
	 * 查询药房评价总数
	 * @param shopId
	 * @return
	 */
	@ApiOperation(value = "查询药房评价总数", notes = "查询药房评价总数")
	@GetMapping("/queryCommentNumbers/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R queryCommentNumbers( @PathVariable Long shopId) {

		return R.ok(commentService.queryCommentNumbers(shopId));
	}

	/**
	 * 查询药房评价(分页)
	 * @return
	 */
	@ApiOperation(value = "查询药房评价(分页)", notes = "查询药房评价(分页)")
	@GetMapping("/selectComment/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R <List<CommentDTO>> selectComment(Query query,@PathVariable Long shopId) {
		return R.ok(commentService.queryComment(Condition.getPage(query),shopId));
	}

	/**
	 * 查询药房评价(分页)
	 * @return
	 */
	@ApiOperation(value = "查询药房好评(分页)", notes = "查询药房好评((分页)")
	@GetMapping("/queryGoodComment/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R <List<CommentDTO>> queryGoodComment(Query query,@PathVariable Long shopId) {
		return R.ok(commentService.queryGoodComment(Condition.getPage(query),shopId));
	}

	/**
	 * 查询药房评价最新(最近两天)
	 * @return
	 */
	@ApiOperation(value = "查询药房评价最新(分页)", notes = "查询药房评价最新((分页)")
	@GetMapping("/queryNewDateComment/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R <List<CommentDTO>> queryNewDateComment(Query query,@PathVariable Long shopId) {
		return R.ok(commentService.queryNewDateComment(Condition.getPage(query),shopId));
	}

	/**
	 * 查询药房评价近期差评(最近7天)
	 * @return
	 */
	@ApiOperation(value = "查询药房评价近期差评(分页)", notes = "查询药房评价近期差评((分页)")
	@GetMapping("/querynewDateNeComment/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R <List<CommentDTO>> querynewDateNeComment(Query query,@PathVariable Long shopId) {
		return R.ok(commentService.querynewDateNeComment(Condition.getPage(query),shopId));
	}

	/**
	 * 筛选有内容的评论
	 * @return
	 */
	@ApiOperation(value = "筛选有内容的评论(分页)", notes = "筛选有内容的评论")
	@GetMapping("/queryHaveComment/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R <List<CommentDTO>> queryHaveComment(Query query,@PathVariable Long shopId) {
		return R.ok(commentService.queryHaveComment(Condition.getPage(query),shopId));
	}

	/**
	 * 筛选有图片的评论
	 * shopId
	 * @return
	 */
	@ApiOperation(value = "筛选有图片的评论(分页)", notes = "筛选有图片的评论")
	@GetMapping("/queryHaveImageComment/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R <List<CommentDTO>>queryHaveImageComment(Query query,@PathVariable Long shopId) {
		return R.ok(commentService.queryHaveImageComment(Condition.getPage(query),shopId));
	}

	/**
	 * 药店评分
	 * commentId
	 * @return
	 */
	@ApiOperation(value = "药店评分(分页)", notes = "药店评分")
	@GetMapping("/queryCommentAvg/{shopId}" )
	@PreAuthorize("@pms.hasPermission('pharmacy_comment_view')" )
	public R queryCommentAvg(@PathVariable Long shopId) {
		BigDecimal score=commentService.queryCommentAvg(shopId);
		return R.ok(score);
	}
}
