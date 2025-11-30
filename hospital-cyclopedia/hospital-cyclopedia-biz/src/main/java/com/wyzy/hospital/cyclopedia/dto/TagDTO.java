package com.wyzy.hospital.cyclopedia.dto;


import com.wyzy.hospital.cyclopedia.entity.Effect;
import com.wyzy.hospital.cyclopedia.entity.Tag;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/4/20  15:46
 */
@Data
public class TagDTO extends Tag {
private List<FoodDetailsDTO>foodDetailsDTOList;
private List<Effect>effectList;

	/**
	 * tagId
	 */
	private Long tagId;

	/**
	 * 标签名称
	 */
	private String tagName;

	/**
	 * 图片
	 */
	private String tagImage;
}
