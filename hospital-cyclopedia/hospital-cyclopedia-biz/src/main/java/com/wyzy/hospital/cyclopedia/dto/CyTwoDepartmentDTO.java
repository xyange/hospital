package com.wyzy.hospital.cyclopedia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/21  9:04
 */
@Data
public class CyTwoDepartmentDTO {
	/**
	 * 科室id
	 */
	@ApiModelProperty(value="科室id")
	private Long bid;

	/**
	 * 科室姓名
	 */
	@ApiModelProperty(value="科室姓名")
	private String bname;

	/**
	 * 科室等级
	 */
	@ApiModelProperty(value="科室等级")
	private Integer blevel;

	/**
	 * 疾病集合
	 */
	private List<CyDiseasesDTO> cyDiseasesDTOList;
}
