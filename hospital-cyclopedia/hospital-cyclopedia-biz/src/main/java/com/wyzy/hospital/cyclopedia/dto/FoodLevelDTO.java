package com.wyzy.hospital.cyclopedia.dto;


import com.wyzy.hospital.cyclopedia.entity.FoodLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/4/20  15:46
 */
@Data
public class FoodLevelDTO extends FoodLevel {
	/**
	 * 食物分类ID
	 */
	@ApiModelProperty(value="食物分类ID")
	private Long id;

	/**
	 * 食物分类名
	 */
	@ApiModelProperty(value="食物分类名")
	private String foodLevelName;

	/**
	 * 父类id
	 */
	@ApiModelProperty(value="父类id")
	private Long parentId;

	/**
	 *  --等级(0-一级类别   1-二级类别)
	 */
	@ApiModelProperty(value=" --等级(0-一级类别   1-二级类别)")
	private Integer levels;

}
