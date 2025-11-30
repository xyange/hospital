

package com.wyzy.hospital.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@Data
@TableName("user_coupon")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户优惠券")
public class UserCoupon extends Model<UserCoupon> {

    private static final long serialVersionUID = 1L;

    /**
     * upId
     */
    @TableId
    @ApiModelProperty(value="upId")
    private Long upId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value="用户ID")
    private Long userId;

    /**
     * 用户使用优惠券状态012
     */
    @ApiModelProperty(value="用户使用优惠券状态012")
    private String upIfuse;

    /**
     * 优惠券ID
     */
    @ApiModelProperty(value="优惠券ID")
    private Long upCouponCode;

}
