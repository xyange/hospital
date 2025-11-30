package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/17  15:14
 */
@Data
public class DrugLevelDTO {
	/**
	 * 药品分类ID
	 */
	@ApiModelProperty(value="药品分类ID")
	private Long id;

	/**
	 * 药品分类名
	 */
	@ApiModelProperty(value="药品分类名")
	private String drugLevelName;


	/**
	 * 一级类下二级药品数量
	 */
	private Integer levelDrugNumber;



	/**
	 * 二级表详情
	 */
private List<DrugDetailsDTO>drugDetailsDTOList;
}
