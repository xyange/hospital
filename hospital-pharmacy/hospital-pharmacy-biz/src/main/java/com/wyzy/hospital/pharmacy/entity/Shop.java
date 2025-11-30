

package com.wyzy.hospital.pharmacy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 药房店铺表
 *
 * @author aqie
 * @date 2021-04-22 09:06:01
 */
@Data
@TableName("ph_shop")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药房店铺表")
public class Shop extends Model<Shop> {

    private static final long serialVersionUID = 1L;

    /**
     * shopId
     */
    @TableId
    @ApiModelProperty(value="shopId")
    private Long shopId;

    /**
     * 商家编码
     */
    @ApiModelProperty(value="商家编码")
    private String shopCode;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value="店铺名称")
    private String shopName;

    /**
     * 简介
     */
    @ApiModelProperty(value="简介")
    private String shopBrief;

    /**
     * 店铺账号
     */
    @ApiModelProperty(value="店铺账号")
    private String shopPhone;

    /**
     * 店铺密码
     */
    @ApiModelProperty(value="店铺密码")
    private String shopPassword;

    /**
     * 店铺负责人
     */
    @ApiModelProperty(value="店铺负责人")
    private String chargePersonName;

    /**
     * 负责人电话
     */
    @ApiModelProperty(value="负责人电话")
    private String chargePersonPhone;

    /**
     * 区域id
     */
    @ApiModelProperty(value="区域")
    private Integer areaId;

    /**
     * 店铺地址
     */
    @ApiModelProperty(value="店铺地址")
    private String shopAddress;

    /**
     * 店铺地址-省
     */
    @ApiModelProperty(value="店铺地址-省")
    private String shopAddressProvince;

    /**
     * 店铺地址-市
     */
    @ApiModelProperty(value="店铺地址-市")
    private String shopAddressCity;

    /**
     * 店铺地址-详细地址
     */
    @ApiModelProperty(value="店铺地址-详细地址")
    private String shopAddressDetail;

    /**
     * 店铺logo
     */
    @ApiModelProperty(value="店铺logo")
    private String shopLogo;

    /**
     * 生效日期  即时生效-设置当前时间 有值-指定日期生效
     */
    @ApiModelProperty(value="生效日期  即时生效-设置当前时间 有值-指定日期生效")
    private String effectiveDate;

    /**
     * 生效时限（年）
     */
    @ApiModelProperty(value="生效时限（年）")
    private Integer effectiveYear;

    /**
     * 合同状态 1-有效 0-无效
     */
    @ApiModelProperty(value="合同状态 1-有效 0-无效")
    private Integer contractState;

    /**
     * 认证状态 1-未认证 2-审核中 3-审核通过 4-审核失败 5-签约成功（使用中）
     */
    @ApiModelProperty(value="认证状态 1-未认证 2-审核中 3-审核通过 4-审核失败 5-签约成功（使用中）")
    private Integer authenticationState;

    /**
     * 入驻处理状态  0-未处理 1-通过 2-拒绝
     */
    @ApiModelProperty(value="入驻处理状态  0-未处理 1-通过 2-拒绝")
    private Integer checkState;

    /**
     * 是否启用 1-是 0-否
     */
	@TableLogic
    @ApiModelProperty(value="是否启用 0正常 1删除")
    private Integer delFlag;

    /**
     * 主体类型 1-个人 2-个体工商户 3-企业 4-其他组织
     */
    @ApiModelProperty(value="主体类型 1-个人 2-个体工商户 3-企业 4-其他组织")
    private Integer authenticationType;

    /**
     * 微信收款码
     */
    @ApiModelProperty(value="微信收款码")
    private String wxImage;

    /**
     * 支付宝收款码
     */
    @ApiModelProperty(value="支付宝收款码")
    private String ailpayImage;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private String createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private String updateTime;

	/**
	 * 店铺类型
	 */
	@ApiModelProperty(value="店铺类型")
	private Integer shopType;

	/**
	 * 营业时间
	 */
	@ApiModelProperty(value="营业时间")
	private String openHours;

	/**
	 * 商家资质
	 */
	@ApiModelProperty(value="商家资质")
	private String shopQualification;

	/**
	 * 商家服务
	 */
	@ApiModelProperty(value="商家服务")
	private String shopServices;

	/**
	 * 热线
	 */
	@ApiModelProperty(value="热线")
	private String hotline;
}
