
package com.wyzy.hospital.integration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
@Data
@TableName("bp_integral")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "积分表")
public class BpIntegral extends Model<BpIntegral> {

    private static final long serialVersionUID = 1L;

    /**
     * 积分序号
     */
	@TableId(value = "id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="积分序号")
    private Long id;

    /**
     * 获取类型Id
     */
    @ApiModelProperty(value="获取类型Id")
    private Long typeId;

	/**
	 * 获取类型Name
	 */
	@ApiModelProperty(value="获取类型Name")
	private String typeName;

	/**
	 * 会员ID
	 */
	@ApiModelProperty(value="会员ID")
	private Long memberId;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 状态(0增加，1使用，2冻结)
     */
    @ApiModelProperty(value="状态(0增加，1使用，2冻结)")
    private Integer fluctuate;

    /**
     * 获取积分
     */
    @ApiModelProperty(value="获取积分")
    private Integer obtainIntegral;

    /**
     * 消费金额
     */
    @ApiModelProperty(value="消费金额")
    private BigDecimal monetary;

    /**
     * 订单编号
     */
    @ApiModelProperty(value="订单编号")
    private Long orderId;

	/**
	 * 到期时间
	 */
	@ApiModelProperty(value="到期时间")
	private LocalDateTime expiration;

	/**
	 * 连续签到天数  检查最后一次签到是不是昨天，是的话就+1，不是的话就变成1，
	 */
	@ApiModelProperty(value="连续签到天数")
	private Integer continueNumber;
}
