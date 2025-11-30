package com.wyzy.hospital.psychology.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 预约记录表
 *
 * @author hospital code generator
 * @date 2021-06-08 08:43:43
 */
@Data
@TableName("order_record")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "预约记录表")
public class OrderRecord extends Model<OrderRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 预约记录id
     */
    @TableId
    @ApiModelProperty(value="预约记录id")
    private Long recordId;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;

    /**
     * 预约id
     */
    @ApiModelProperty(value="预约id")
    private Long orderId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 预约时间
     */
    @ApiModelProperty(value="预约时间")
    private LocalDateTime orderTime;

}
