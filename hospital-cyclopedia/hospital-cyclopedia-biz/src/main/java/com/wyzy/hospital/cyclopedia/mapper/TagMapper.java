

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.TagDTO;
import com.wyzy.hospital.cyclopedia.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 食物标签
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:59
 */
@Mapper
public interface TagMapper extends HospitalBaseMapper<Tag> {
	//根据功效表查合适条件的食物

List<TagDTO> selectTagFood(Long tid);
}
