package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/22  16:47
 */
@Data
public class FoodTwoLevelDTO {
	/**
	 * 食物分类ID
	 */
	@TableId
	@ApiModelProperty(value="食物分类ID")
	private Long cid;

	/**
	 * 食物分类名
	 */
	@ApiModelProperty(value="食物分类名")
	private String cname;


	/**
	 *  --等级(0-一级类别   1-二级类别)
	 */
	@ApiModelProperty(value=" --等级(0-一级类别   1-二级类别)")
	private Integer clevels;

	private List<FoodBackstageDTO> foodBackstageDTOList;
}
