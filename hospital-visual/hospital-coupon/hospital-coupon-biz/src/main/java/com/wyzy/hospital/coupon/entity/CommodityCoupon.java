

package com.wyzy.hospital.coupon.entity;

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
 * 商品优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-16 16:06:24
 */
@Data
@TableName("commodity_coupon")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品优惠券表")
public class CommodityCoupon extends Model<CommodityCoupon> {

    private static final long serialVersionUID = 1L;

    /**
     * comCouId
     */
    @TableId
    @ApiModelProperty(value="comCouId")
    private Long comCouId;

    /**
     * 商品id
     */
    @ApiModelProperty(value="商品id")
    private Long commodityId;

    /**
     * 优惠券id
     */
    @ApiModelProperty(value="优惠券id")
    private Long comCouponId;

}
