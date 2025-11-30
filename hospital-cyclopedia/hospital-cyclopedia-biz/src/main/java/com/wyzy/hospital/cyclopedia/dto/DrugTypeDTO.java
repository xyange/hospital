package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/17  9:14
 */
@Data
public class DrugTypeDTO {
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
	 * 药品等级表cid
	 */
	@ApiModelProperty(value="药品等级表cid")
	private Long drugDetailsId;

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

	//公司药品dto集合

   private List<CyReagentDTO>cyReagentDTOList;

}
