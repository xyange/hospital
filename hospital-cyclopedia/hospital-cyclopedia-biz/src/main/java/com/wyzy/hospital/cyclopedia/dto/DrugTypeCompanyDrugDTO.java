package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/17  11:34
 */
@Data
public class DrugTypeCompanyDrugDTO {
	/**
	 * ID
	 */
	@ApiModelProperty(value="ID")
	private Long id;

	/**
	 * 药剂名称
	 */
	@ApiModelProperty(value="药剂名称")
	private String drugTypeName;

	/**
	 * 公司制药id
	 */
	@ApiModelProperty(value="公司制药id")
	private Long cyReagentId;

	/**
	 * 产药名称
	 */
	@ApiModelProperty(value="产药名称")
	private String cyReagentName;

	/**
	 * compayName
	 */
	@ApiModelProperty(value="compayName")
	private String compayName;

}
