

package com.wyzy.hospital.psychology.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author hospital code generator
 * @date 2021-06-04 15:21:56
 */
@Data
@TableName("order_setting")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class OrderSetting extends Model<OrderSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Long orderId;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 预约时间
     */
    @ApiModelProperty(value="预约时间")
    private String orderTime;

    /**
     * 预约日期
     */
    @ApiModelProperty(value="预约日期")
    private String dateTime;

    /**
     * 是否已经预约 （0-否，1-是）
     */
    @ApiModelProperty(value="是否已经预约 （0-否，1-是）")
    private Integer already;

}
