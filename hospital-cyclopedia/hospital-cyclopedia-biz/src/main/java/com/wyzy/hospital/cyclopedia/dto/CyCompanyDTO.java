package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/17  9:48
 */
@Data
public class CyCompanyDTO {

	/**
	 * compayId
	 */
	@ApiModelProperty(value="compayId")
	private Long compayId;

	/**
	 * compayName
	 */
	@ApiModelProperty(value="compayName")
	private String compayName;


}
