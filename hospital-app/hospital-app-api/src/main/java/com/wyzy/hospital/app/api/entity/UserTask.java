

package com.wyzy.hospital.app.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * 用户用药计划表
 *
 * @author aqie
 * @date 2021-05-28 14:59:31
 */
@Data
@TableName("wyzy_user_task")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户用药计划表")
public class UserTask extends Model<UserTask> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="id")
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

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;

    /**
     * 是否删除 0-否 1-是
     */
    @ApiModelProperty(value="是否删除 0-否 1-是")
    private Integer delFlag;

	@ApiModelProperty(value="提醒天数")
    private Integer remindDay;

}
