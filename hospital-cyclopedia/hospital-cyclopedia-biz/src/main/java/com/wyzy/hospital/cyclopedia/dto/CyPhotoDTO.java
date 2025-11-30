package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/6/7  11:20
 */
@Data
public class CyPhotoDTO {
	/**
	 * ID
	 */
	private Long photoId;

	/**
	 * 图片姓名
	 */
	@ApiModelProperty(value="imageName")
	private String imageName;

	/**
	 * 图片地址
	 */
	@ApiModelProperty(value="imageSrc")
	private String imageSrc;

	/**
	 * 图片分类
	 */
	@ApiModelProperty(value="imageCode")
	private Long imageCode;
}
