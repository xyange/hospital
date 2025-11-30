
package com.wyzy.hospital.integration.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
@Data
public class BpIntegralVO {
	/**
	 * 积分序号
	 */
	@TableId
	@ApiModelProperty(value="积分序号")
	private Long id;

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
	 * 积分总量
	 */
	@ApiModelProperty(value="积分总量")
	private Integer totalIntegral;

	/**
	 * 使用积分
	 */
	@ApiModelProperty(value="使用积分")
	private Integer usingIntegral;

	/**
	 * 剩余积分
	 */
	@ApiModelProperty(value="剩余积分")
	private Integer residualintegral;

	/**
	 * 冻结积分
	 */
	@ApiModelProperty(value="冻结积分")
	private Integer frozenintegral;

	/**
	 * 过期积分
	 */
	@ApiModelProperty(value="过期积分")
	private Integer overdue;
}
