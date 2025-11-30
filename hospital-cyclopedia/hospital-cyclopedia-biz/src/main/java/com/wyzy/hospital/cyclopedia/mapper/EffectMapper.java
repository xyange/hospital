

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.EffectDTO;
import com.wyzy.hospital.cyclopedia.entity.Effect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功效表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:13
 */
@Mapper
public interface EffectMapper extends HospitalBaseMapper<Effect> {
	//根据功效id查推荐表下食物

      List<EffectDTO>lookMyEffecTag(Long eid);

      //查标签

	List<EffectDTO>selectEffect();
}
