

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
 * 积分活动表
 *
 * @author hospital code generator
 * @date 2021-05-08 16:09:33
 */
@Data
@TableName("bp_bpActivity")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "积分活动表")
public class BpBpactivity extends Model<BpBpactivity> {

    private static final long serialVersionUID = 1L;

    /**
     * 活动名称
     */
	@TableId(value = "id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="活动名称")
    private Long id;

    /**
     * 活动名称
     */
    @ApiModelProperty(value="活动名称")
    private Long activityname;

	/**
	 * 产品类型
	 */
	@ApiModelProperty(value="产品类型")
	private Long productStatus;

    /**
     * 积分返还率
     */
    @ApiModelProperty(value="积分返还率")
    private Integer returnrates;

    /**
     * 积分返还最大值
     */
    @ApiModelProperty(value="积分返还最大值")
    private Integer returnmax;

    /**
     * 购买次数限制
     */
    @ApiModelProperty(value="购买次数限制")
    private Integer returnnumber;

    /**
     * 是否上线(0不上线，1上线)
     */
    @ApiModelProperty(value="是否上线(0不上线，1上线)")
    private Integer fluctuate;

	/**
	 * 活动端口
	 */
	@ApiModelProperty(value="活动端口：1:医生端APP 2:患者端APP")
	private String source;

	/**
	 * 存在状态(0不上线，1删除)
	 */
	@TableLogic(value="0",delval="1")
	@ApiModelProperty(value="存在状态(0正常，1删除)")
	private Integer type;
}
