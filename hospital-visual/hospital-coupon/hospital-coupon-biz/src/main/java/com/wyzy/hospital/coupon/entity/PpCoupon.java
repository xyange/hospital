

package com.wyzy.hospital.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-09 11:36:41
 */
@Data
@TableName("pp_coupon")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "优惠券表")
public class PpCoupon extends Model<PpCoupon> {

    private static final long serialVersionUID = 1L;

    /**
     * couponId
     */
    @TableId
    @ApiModelProperty(value="couponId")
    private Long couponId;

    /**
     * 优惠券名称
     */
    @ApiModelProperty(value="优惠券名称")
    private String couponName;

    /**
     * 优惠券码
     */
    @ApiModelProperty(value="优惠券码")
    private Long couponCode;

    /**
     * 优惠券图
     */
    @ApiModelProperty(value="优惠券图")
    private String couponImage;

    /**
     * 优惠券备注
     */
    @ApiModelProperty(value="优惠券备注")
    private String couponRemarks;

    /**
     * 满减打折数
     */
    @ApiModelProperty(value="满减打折数")
    private BigDecimal couponFullDiscountMoney;

    /**
     * 满减金额
     */
    @ApiModelProperty(value="满减金额")
    private BigDecimal couponFullMoney;

    /**
     * 直减金额
     */
    @ApiModelProperty(value="直减金额")
    private BigDecimal couponDirectMoney;

    /**
     * 满多少金额折扣多少钱
     */
    @ApiModelProperty(value="满多少金额折扣多少钱")
    private BigDecimal couponDiscountNum;

    /**
     * 折扣-消费金额
     */
    @ApiModelProperty(value="折扣-消费金额")
    private BigDecimal couponDiscountMoney;

    /**
     * 优惠券总数
     */
    @ApiModelProperty(value="优惠券总数")
    private Integer couponNumber;

    /**
     * 优惠券领取数量
     */
    @ApiModelProperty(value="优惠券领取数量")
    private Integer couponReceiveNum;

    /**
     * 优惠券使用数量
     */
    @ApiModelProperty(value="优惠券使用数量")
    private Integer couponUsedNum;

    /**
     * 优惠券过期数量
     */
    @ApiModelProperty(value="优惠券过期数量")
    private Integer couponOverdateNum;

    /**
     * 优惠券限领数量
     */
    @ApiModelProperty(value="优惠券限领数量")
    private Integer couponLimitNum;

    /**
     * 优惠券发放状态
     */
    @ApiModelProperty(value="优惠券发放状态")
    private String couponGrantStruts;

    /**
     * 删除状态
     */
	@TableLogic(value="0",delval="1")
    @ApiModelProperty(value="删除状态")
    private String couponDel;

    /**
     * 审核状态(0-待审核/1通过/未通过)
     */
    @ApiModelProperty(value="审核状态(0-待审核/1通过/未通过)")
    private String couponAduitStruts;

    /**
     * 优惠券审核未通过原因
     */
    @ApiModelProperty(value="优惠券审核未通过原因")
    private String couponAduitCause;

    /**
     * 优惠券上线状态
     */
    @ApiModelProperty(value="优惠券上线状态")
    private String couponExistStruts;

    /**
     * 适用范围(0-单件商品1-物品品类2-全场)
     */
    @ApiModelProperty(value="适用范围(0-单件商品1-物品品类2-全场)")
    private String couponRange;

    /**
     * 优惠券类型(0-满减1-折扣2-直减)
     */
    @ApiModelProperty(value="优惠券类型(0-满减1-折扣2-直减)")
    private String couponType;

    /**
     * 优惠券有效期
     */
    @ApiModelProperty(value="优惠券有效期")
    private LocalDateTime couponEffectiveDate;

    /**
     * 优惠券失效期
     */
    @ApiModelProperty(value="优惠券失效期")
    private LocalDateTime couponInvalidDate;

    /**
     * 优惠券发放日期
     */
    @ApiModelProperty(value="优惠券发放日期")
    private LocalDateTime couponStartDate;

    /**
     * 优惠券结束日期
     */
    @ApiModelProperty(value="优惠券结束日期")
    private LocalDateTime couponOverDate;

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
