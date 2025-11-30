

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.TagDTO;
import com.wyzy.hospital.cyclopedia.entity.Tag;

import java.util.List;

/**
 * 食物标签
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:59
 */
public interface TagService extends IService<Tag> {
	List<TagDTO> queryTagFoodById(Long tid);
}
