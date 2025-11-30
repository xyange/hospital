

package com.wyzy.hospital.pharmacy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.pharmacy.dto.CommentDTO;
import com.wyzy.hospital.pharmacy.entity.Comment;

import java.math.BigDecimal;
import java.util.List;

/**
 * 药房评论
 *
 * @author aqie
 * @date 2021-04-22 09:47:09
 */
public interface CommentService extends IService<Comment> {
	Integer queryCommentNumbers(Long shopId);

	List<CommentDTO> queryComment(IPage<CommentDTO> page,Long shopId);

	List<CommentDTO> queryGoodComment(IPage<CommentDTO> page,Long shopId);

	//最新评论

	List<CommentDTO>queryNewDateComment(IPage<CommentDTO> page,Long shopId);

    //近期差评

	List<CommentDTO>querynewDateNeComment(IPage<CommentDTO> page,Long shopId);

	//筛选无内容的评论

	List<CommentDTO>queryHaveComment(IPage<CommentDTO> page,Long shopId);

	//只看有图片的评论

	List<CommentDTO>queryHaveImageComment(IPage<CommentDTO> page,Long shopId);

	//查药店综合评分

	BigDecimal queryCommentAvg(Long shopId);


}
