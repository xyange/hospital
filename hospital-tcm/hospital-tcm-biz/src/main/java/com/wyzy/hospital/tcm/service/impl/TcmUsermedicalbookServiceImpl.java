
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.tcm.entity.TcmUsermedicalbook;
import com.wyzy.hospital.tcm.mapper.TcmUsermedicalbookMapper;
import com.wyzy.hospital.tcm.service.TcmUsermedicalbookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 医书收藏表
 *
 * @author hospital code generator
 * @date 2021-04-30 10:38:12
 */
@Service
public class TcmUsermedicalbookServiceImpl extends ServiceImpl<TcmUsermedicalbookMapper, TcmUsermedicalbook> implements TcmUsermedicalbookService {

	@Override
	public int collectMedicalbook(Long userId, Long medicalbookId) {
	// 1. 查询
		TcmUsermedicalbook one = baseMapper.selectOne(new LambdaQueryWrapper<TcmUsermedicalbook>()
			.eq(TcmUsermedicalbook::getMedicalbookId, medicalbookId)
			.eq(TcmUsermedicalbook::getUserId, userId)
	);
	if(one == null) {
			one = new TcmUsermedicalbook();
			one.setIsCollect(CommonConstants.TRUE);
			one.setMedicalbookId(medicalbookId);
			one.setUserId(userId);
			return baseMapper.insert(one);
	}
	// 2. 点赞/取消点赞
		one.setIsCollect(one.getIsCollect() ^ 1);
	return baseMapper.updateById(one);
	}

	@Override
	public Integer isCollect(Long medicalbookId, Integer userId) {
		return baseMapper.isCollect(medicalbookId, userId).orElse(CommonConstants.FALSE);
	}

	/*根据用户ID查询收藏医书ID*/
	@Override
	public List<Long> getByUserId(Long id) {
		return baseMapper.getByUserId(id);
	}
}
