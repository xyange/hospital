package com.wyzy.hospital.app.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;

/**
 * @Author aqie
 * Date on 2021/5/28  15:04
 * @Function: 用户用药计划DTO
 */
@Data
public class UserTaskDTO implements Serializable {

	@ApiModelProperty(value="任务id")
	private Long id;

	@ApiModelProperty(value="用户id")
	private Long userId;

	@ApiModelProperty(value="手机")
	private String phone;

	/**
	 * 任务名称
	 */
	@ApiModelProperty(value="任务名称")
	private String jobName;

	/**
	 * 任务时间
	 */
	@JsonFormat(pattern = "HH:mm")
	@ApiModelProperty(value="任务时间")
	private Time taskTime;

	/**
	 * 药品单位
	 */
	@ApiModelProperty(value="药品单位")
	private String unit;

	/**
	 * 剂量
	 */
	@ApiModelProperty(value="剂量")
	private String quantity;

	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
	private String remark;

	@ApiModelProperty(value="提醒天数")
	private Integer remindDay;
}
