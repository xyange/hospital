package com.wyzy.hospital.cyclopedia.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/4/20  15:46
 */
@Data

public class DiseasesDrugDTO  {

	/**
	 * 疾病id
	 */
	@ApiModelProperty(value="eid")
	private Long eid;


	/**
	 * 疾病名称
	 */
	@ApiModelProperty(value="疾病名称")
	private String disName;


	private List<DrugDetailsDTO>drugDetailsDTOList;
}
