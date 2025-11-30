

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.EffectDTO;
import com.wyzy.hospital.cyclopedia.entity.Effect;

import java.util.List;

/**
 * 功效表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:13
 */
public interface EffectService extends IService<Effect> {
//根据功效id查推荐表下食物

	List<EffectDTO> queryMyEffecTag(Long eid);

	//查标签

	List<EffectDTO>selectEffect();
}
