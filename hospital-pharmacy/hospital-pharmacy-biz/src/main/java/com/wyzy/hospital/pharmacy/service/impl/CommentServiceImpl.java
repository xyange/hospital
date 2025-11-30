
package com.wyzy.hospital.pharmacy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pharmacy.dto.CommentDTO;
import com.wyzy.hospital.pharmacy.entity.Comment;
import com.wyzy.hospital.pharmacy.mapper.CommentMapper;
import com.wyzy.hospital.pharmacy.service.CommentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 药房评论
 *
 * @author aqie
 * @date 2021-04-22 09:47:09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

	@Override
	public Integer queryCommentNumbers(Long shopId) {
		Integer commentNumbers = baseMapper.selectCommentNumbers(shopId);
		return commentNumbers;
	}

	@Override
	public List<CommentDTO> queryComment(IPage<CommentDTO> page,Long shopId) {
		List<CommentDTO> patientCardDTOList = baseMapper.selectComment(page,shopId);
		return patientCardDTOList;
	}

	@Override
	public List<CommentDTO> queryGoodComment(IPage<CommentDTO> page,Long shopId) {
		List<CommentDTO> commentDTOList = baseMapper.selectGoodComment(page,shopId);
		return commentDTOList;
	}

	@Override
	public List<CommentDTO> queryNewDateComment(IPage<CommentDTO> page,Long shopId) {
		List<CommentDTO> commentDTOList = baseMapper.selectNewDateComment(page,shopId);
		return commentDTOList;
	}

	@Override
	public List<CommentDTO> querynewDateNeComment(IPage<CommentDTO> page,Long shopId) {
		List<CommentDTO> commentDTOList = baseMapper.newDateNeComment(page,shopId);
		return commentDTOList;
	}

	@Override
	public List<CommentDTO> queryHaveComment(IPage<CommentDTO> page,Long shopId) {
			List<CommentDTO> patientCardDTOList = baseMapper.selectHaveComment(page,shopId);
			return patientCardDTOList;
	}

	@Override
	public List<CommentDTO> queryHaveImageComment(IPage<CommentDTO> page,Long shopId) {
		List<CommentDTO> patientCardDTOList = baseMapper.selectHaveImageComment(page,shopId);
		return patientCardDTOList;
	}

	@Override
	public BigDecimal queryCommentAvg(Long shopId) {
		BigDecimal bigDecimal = baseMapper.selectCommentAvg(shopId);
		return bigDecimal;
	}
}
