

package com.wyzy.hospital.pharmacy.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.pharmacy.dto.CommentDTO;
import com.wyzy.hospital.pharmacy.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 药房评论
 *
 * @author aqie
 * @date 2021-04-22 09:47:09
 */
@Mapper
public interface CommentMapper extends HospitalBaseMapper<Comment> {

Integer selectCommentNumbers(Long shopId);

List<CommentDTO> selectComment(IPage<CommentDTO> page,@Param("shopId") Long shopId);

List<CommentDTO> selectGoodComment(IPage<CommentDTO> page,@Param("shopId") Long shopId);

//最新评论

List<CommentDTO>selectNewDateComment(IPage<CommentDTO> page,@Param("shopId") Long shopId);

//近期差评

List<CommentDTO>newDateNeComment(IPage<CommentDTO> page,@Param("shopId") Long shopId);

//只查看有内容评论

	List<CommentDTO>selectHaveComment(IPage<CommentDTO> page,@Param("shopId") Long shopId);

//只看有图片的评论

	List<CommentDTO>selectHaveImageComment(IPage<CommentDTO> page,@Param("shopId") Long shopId);

//查药店综合评分

	BigDecimal selectCommentAvg(Long shopId);

}
