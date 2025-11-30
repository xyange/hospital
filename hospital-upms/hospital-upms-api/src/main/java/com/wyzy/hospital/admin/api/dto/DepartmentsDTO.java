package com.wyzy.hospital.admin.api.dto;

import com.wyzy.hospital.admin.api.entity.Departments;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author aqie
 */
@Data
public class DepartmentsDTO {

	/**
	 * 科室ID
	 */
	@ApiModelProperty(value="科室ID")
	private Long id;

	/**
	 * 科室名称
	 */
	@ApiModelProperty(value="科室名称")
	private String departmentName;

	/**
	 * 上一级科室ID
	 */
	@ApiModelProperty(value="上一级科室ID")
	private Long superiorId;

	/**
	 * 子科室数量
	 */
	@ApiModelProperty(value="子科室数量")
	private Integer departmentNumber;

	private List<Departments> departmentsList;

	@ApiModelProperty(value="一级子科室名称,逗号分割")
	private String subDepartment;

	@ApiModelProperty(value="科室图片")
	private String departmentImage;
}
