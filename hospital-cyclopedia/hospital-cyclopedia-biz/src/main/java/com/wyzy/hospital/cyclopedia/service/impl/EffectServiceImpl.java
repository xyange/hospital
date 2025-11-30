
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.EffectDTO;
import com.wyzy.hospital.cyclopedia.entity.Effect;
import com.wyzy.hospital.cyclopedia.mapper.EffectMapper;
import com.wyzy.hospital.cyclopedia.service.EffectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功效表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:13
 */
@Service
public class EffectServiceImpl extends ServiceImpl<EffectMapper, Effect> implements EffectService {

	@Override
	public List<EffectDTO> queryMyEffecTag(Long eid) {
		return baseMapper.lookMyEffecTag(eid);
	}

	@Override
	public List<EffectDTO> selectEffect() {
		List<EffectDTO> effectDTOList = baseMapper.selectEffect();
		return effectDTOList;
	}
}
