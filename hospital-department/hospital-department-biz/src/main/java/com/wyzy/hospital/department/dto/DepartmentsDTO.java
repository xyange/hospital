package com.wyzy.hospital.department.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wyzy.hospital.department.entity.Departments;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DepartmentsDTO {

	/**
	 * 科室ID
	 */
	@TableId
	@ApiModelProperty(value="科室ID")
	private Integer id;

	/**
	 * 科室名称
	 */
	@ApiModelProperty(value="科室名称")
	private String departmentName;

	/**
	 * 上一级科室ID
	 */
	@ApiModelProperty(value="上一级科室ID")
	private Integer superiorId;

	/**
	 * 子科室数量
	 */
	@ApiModelProperty(value="子科室数量")
	private Integer departmentNumber;

	private List<Departments> departmentsList;
}
