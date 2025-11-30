package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/22  16:48
 */
@Data
public class FoodOneLevelDTO {
	/**
	 * 食物分类ID
	 */
	@TableId
	@ApiModelProperty(value="食物分类ID")
	private Long fid;

	/**
	 * 食物分类名
	 */
	@ApiModelProperty(value="食物分类名")
	private String fname;


	/**
	 *  --等级(0-一级类别   1-二级类别)
	 */
	@ApiModelProperty(value=" --等级(0-一级类别   1-二级类别)")
	private Integer flevels;

	/**
	 * 二级食物数量
	 */
	private  int foodNumber;

	private List<FoodTwoLevelDTO> foodTwoLevelDTOList;
}
