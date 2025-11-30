

package com.wyzy.hospital.integration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 积分规则表
 *
 * @author hospital code generator
 * @date 2021-05-10 11:18:22
 */
@Data
@TableName("bp_integralrule")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "积分规则表")
public class BpIntegralrule extends Model<BpIntegralrule> {

    private static final long serialVersionUID = 1L;

    /**
     * 积分方式ID
     */
	@TableId(value = "id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="积分方式ID")
    private Long id;

    /**
     * 积分方式名称
     */
    @ApiModelProperty(value="积分方式名称")
    private String integralMethod;

    /**
     * 签到状态:(0按日签到，1：按连续签到)
     */
    @ApiModelProperty(value="签到状态:(0按日签到，1：按连续签到)")
    private Integer checkstatus;

    /**
     * 通用积分
     */
    @ApiModelProperty(value="通用积分")
    private Integer number;

    /**
     * 按连续签到
     */
    @ApiModelProperty(value="按连续签到")
    private String continuously;

    /**
     * 支付金额
     */
    @ApiModelProperty(value="支付金额")
    private Float paymentAmount;

    /**
     * 支付订单最高积分
     */
    @ApiModelProperty(value="支付订单最高积分")
    private Integer highestScore;

    /**
     * 到期规则：(0永久有效，1固定时间，2固定天数)
     */
    @ApiModelProperty(value="到期规则：(0永久有效，1固定时间，2固定天数)")
    private Integer expirationRules;

    /**
     * 固定时间
     */
    @ApiModelProperty(value="固定时间")
    private LocalDateTime time;

    /**
     * 固定天数
     */
    @ApiModelProperty(value="固定天数")
    private Integer days;

    /**
     * 到期提醒设置：(0不提醒，1提醒)
     */
    @ApiModelProperty(value="到期提醒设置：(0不提醒，1提醒)")
    private Integer reminder;

    /**
     * 积分抵扣状态：(0不可抵扣，1可抵扣)
     */
    @ApiModelProperty(value="积分抵扣状态：(0不可抵扣，1可抵扣)")
    private Integer deduction;

    /**
     * 抵扣积分
     */
    @ApiModelProperty(value="抵扣积分")
    private Integer integral;

    /**
     * 抵扣金额
     */
    @ApiModelProperty(value="抵扣金额")
    private Integer money;

	/**
	 * 状态:1 正常, 0 失效
	 */
	@TableLogic(value="0",delval="1")
	@ApiModelProperty(value="状态:1 失效, 0 正常")
	private Integer delFlag;

	/**
	 * 每日任务(0.否1是)
	 */
	@ApiModelProperty(value="每日任务(0.否1是)")
	private Integer isEveryday;

	/**
	 * 数量限制
	 */
	@ApiModelProperty(value="数量限制")
	private Integer quantityLimit;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value="更新时间")
	private LocalDateTime updateTime;
}
