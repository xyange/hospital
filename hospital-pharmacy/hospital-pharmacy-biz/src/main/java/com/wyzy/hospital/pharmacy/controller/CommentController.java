

package com.wyzy.hospital.pharmacy.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.pharmacy.entity.Comment;
import com.wyzy.hospital.pharmacy.service.CommentService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 药房评论
 *
 * @author aqie
 * @date 2021-04-22 09:47:09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/comment" )
@Api(value = "comment", tags = "药房评论管理")
public class CommentController {

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
     * 新增药房评论
     * @param comment 药房评论
     * @return R
     */
    @ApiOperation(value = "新增药房评论", notes = "新增药房评论")
    @SysLog("新增药房评论" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_comment_add')" )
    public R save(@RequestBody Comment comment) {
        return R.ok(commentService.save(comment));
    }

    /**
     * 修改药房评论
     * @param comment 药房评论
     * @return R
     */
    @ApiOperation(value = "修改药房评论", notes = "修改药房评论")
    @SysLog("修改药房评论" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_comment_edit')" )
    public R updateById(@RequestBody Comment comment) {
        return R.ok(commentService.updateById(comment));
    }

    /**
     * 通过id删除药房评论
     * @param commentId id
     * @return R
     */
    @ApiOperation(value = "通过id删除药房评论", notes = "通过id删除药房评论")
    @SysLog("通过id删除药房评论" )
    @DeleteMapping("/{commentId}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_comment_del')" )
    public R removeById(@PathVariable Long commentId) {
        return R.ok(commentService.removeById(commentId));
    }

}
