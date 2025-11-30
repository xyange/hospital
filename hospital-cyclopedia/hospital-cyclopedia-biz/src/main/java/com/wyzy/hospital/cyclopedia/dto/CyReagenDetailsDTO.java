package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/17  11:29
 */
@Data
public class CyReagenDetailsDTO {
	/**
	 * 公司制药详情表id
	 */

	@ApiModelProperty(value="公司制药详情表id")
	private Long cyReagentDetailsId;


	/**
	 * 别名
	 */
	@ApiModelProperty(value="别名")
	private String drugAlias;

	/**
	 * 适应症状
	 */
	@ApiModelProperty(value="适应症状")
	private String indications;

	/**
	 * 用法用量
	 */
	@ApiModelProperty(value="用法用量")
	private String takeMethod;

	/**
	 * 注意事项
	 */
	@ApiModelProperty(value="注意事项")
	private String medicineHint;

	/**
	 * 禁忌
	 */
	@ApiModelProperty(value="禁忌")
	private String contraindication;

	/**
	 * 药品单位
	 */
	@ApiModelProperty(value="药品单位")
	private String drugUnit;

	/**
	 * 不良反应
	 */
	@ApiModelProperty(value="不良反应")
	private String adverseReactions;

	/**
	 * 药品剂量
	 */
	@ApiModelProperty(value="药品剂量")
	private BigDecimal drugDose;

	/**
	 * 相互作用
	 */
	@ApiModelProperty(value="相互作用")
	private String drugInteractions;


	/**
	 * 人群用药
	 */
	@ApiModelProperty(value="人群用药")
	private String crowdMedication;

	/**
	 * 其他
	 */
	@ApiModelProperty(value="其他")
	private String drugOther;

}
