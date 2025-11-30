
package com.wyzy.hospital.cyclopedia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.cyclopedia.dto.TagDTO;
import com.wyzy.hospital.cyclopedia.entity.Tag;
import com.wyzy.hospital.cyclopedia.mapper.TagMapper;
import com.wyzy.hospital.cyclopedia.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 食物标签
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:59
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

	@Override
	public List<TagDTO> queryTagFoodById(Long tid) {
		return baseMapper.selectTagFood(tid);
	}
}
