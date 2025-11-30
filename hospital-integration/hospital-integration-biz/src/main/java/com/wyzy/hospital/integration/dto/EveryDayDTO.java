package com.wyzy.hospital.integration.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

/**
 * ClassName: EveryDayDTO<br/>
 * Description: <br/>
 * date: 2021/5/31 15:39<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
@Data
public class EveryDayDTO {

	/**
	 * 积分方式ID
	 */
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
	 * 数量限制
	 */
	@ApiModelProperty(value="数量限制")
	private Integer quantityLimit;

	/**
	 * 完成次数
	 */
	@ApiModelProperty(value="完成次数")
	private Integer num;
}
