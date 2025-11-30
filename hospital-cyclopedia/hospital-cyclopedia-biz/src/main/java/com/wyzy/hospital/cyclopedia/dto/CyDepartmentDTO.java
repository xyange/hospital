package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/21  9:14
 */
@Data
public class CyDepartmentDTO {
	/**
	 * 科室id
	 */
	@TableId
	@ApiModelProperty(value="科室id")
	private Long departmentId;

	/**
	 * 科室姓名
	 */
	@ApiModelProperty(value="科室姓名")
	private String departmentName;

	/**
	 * 二级科室父类
	 */
	@ApiModelProperty(value="二级科室父类")
	private Long parentId;

	/**
	 * 科室等级
	 */
	@ApiModelProperty(value="科室等级")
	private Integer departmentLevel;
}
