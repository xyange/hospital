

package com.wyzy.hospital.pharmacy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 药房商品表
 *
 * @author aqie
 * @date 2021-04-22 09:17:03
 */
@Data
@TableName("ph_product")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药房商品表")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId
    @ApiModelProperty(value="商品id")
    private Long productId;

    /**
     * 商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)
     */
    @ApiModelProperty(value="商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)")
    private Long shopId;

    /**
     * 商品图片
     */
    @ApiModelProperty(value="商品图片")
    private String productImage;

    /**
     * 轮播图
     */
    @ApiModelProperty(value="轮播图")
    private String sliderImage;

    /**
     * 商品名称
     */
    @ApiModelProperty(value="商品名称")
    private String productName;

    /**
     * 商品简介
     */
    @ApiModelProperty(value="商品简介")
    private String productInfo;

    /**
     * 商品描述（富文本）
     */
    @ApiModelProperty(value="商品描述（富文本）")
    private String productText;

    /**
     * 关键字
     */
    @ApiModelProperty(value="关键字")
    private String keyword;

    /**
     * 商品条码（一维码）
     */
    @ApiModelProperty(value="商品条码（一维码）")
    private String barCode;

    /**
     * 分类id
     */
    @ApiModelProperty(value="分类id")
    private Long cateId;

    /**
     * 商品价格
     */
    @ApiModelProperty(value="商品价格")
    private BigDecimal price;

    /**
     * 会员价格
     */
    @ApiModelProperty(value="会员价格")
    private BigDecimal vipPrice;

    /**
     * 市场价
     */
    @ApiModelProperty(value="市场价")
    private BigDecimal otPrice;

    /**
     * 邮费
     */
    @ApiModelProperty(value="邮费")
    private BigDecimal postage;

    /**
     * 单位名
     */
    @ApiModelProperty(value="单位名")
    private String unitName;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 销量
     */
    @ApiModelProperty(value="销量")
    private Integer sales;

    /**
     * 库存
     */
    @ApiModelProperty(value="库存")
    private Integer stock;

    /**
     * 状态（0：未上架，1：上架）
     */
    @ApiModelProperty(value="状态（0：未上架，1：上架）")
    private Integer isShow;

    /**
     * 是否热卖
     */
    @ApiModelProperty(value="是否热卖")
    private Integer isHot;

    /**
     * 是否优惠
     */
    @ApiModelProperty(value="是否优惠")
    private Integer isBenefit;

    /**
     * 是否精品
     */
    @ApiModelProperty(value="是否精品")
    private Integer isBest;

    /**
     * 是否新品
     */
    @ApiModelProperty(value="是否新品")
    private Integer isNew;

    /**
     * 添加时间
     */
    @ApiModelProperty(value="添加时间")
    private Integer addTime;

    /**
     * 是否包邮
     */
    @ApiModelProperty(value="是否包邮")
    private Integer isPostage;

    /**
     * 是否删除
     */
	@TableLogic
    @ApiModelProperty(value="是否删除")
    private Integer isDel;

    /**
     * 商户是否代理 0不可代理1可代理
     */
    @ApiModelProperty(value="商户是否代理 0不可代理1可代理")
    private Integer merUse;

    /**
     * 获得积分
     */
    @ApiModelProperty(value="获得积分")
    private BigDecimal giveIntegral;

    /**
     * 成本价
     */
    @ApiModelProperty(value="成本价")
    private BigDecimal cost;

    /**
     * 秒杀状态 0 未开启 1已开启
     */
    @ApiModelProperty(value="秒杀状态 0 未开启 1已开启")
    private Integer isSeckill;

    /**
     * 砍价状态 0未开启 1开启
     */
    @ApiModelProperty(value="砍价状态 0未开启 1开启")
    private Integer isBargain;

    /**
     * 是否优品推荐
     */
    @ApiModelProperty(value="是否优品推荐")
    private Integer isGood;

    /**
     * 是否单独分佣
     */
    @ApiModelProperty(value="是否单独分佣")
    private Integer isSub;

    /**
     * 虚拟销量
     */
    @ApiModelProperty(value="虚拟销量")
    private Integer virtualSales;

    /**
     * 浏览量
     */
    @ApiModelProperty(value="浏览量")
    private Integer browse;

    /**
     * 商品二维码地址(用户小程序海报)
     */
    @ApiModelProperty(value="商品二维码地址(用户小程序海报)")
    private String codePath;

    /**
     * 淘宝京东1688类型
     */
    @ApiModelProperty(value="淘宝京东1688类型")
    private String sourceLink;

    /**
     * 主图视频链接
     */
    @ApiModelProperty(value="主图视频链接")
    private String videoLink;

    /**
     * 运费模板ID
     */
    @ApiModelProperty(value="运费模板ID")
    private Integer tempId;

    /**
     * 规格 0单 1多
     */
    @ApiModelProperty(value="规格 0单 1多")
    private Integer specType;

    /**
     * 活动显示排序0=默认, 1=秒杀，2=砍价，3=拼团
     */
    @ApiModelProperty(value="活动显示排序0=默认, 1=秒杀，2=砍价，3=拼团")
    private String activity;

}
