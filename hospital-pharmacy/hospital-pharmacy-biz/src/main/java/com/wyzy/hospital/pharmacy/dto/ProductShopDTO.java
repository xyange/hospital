package com.wyzy.hospital.pharmacy.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author aqie
 * Date on 2021/4/22  17:38
 * @Function:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductShopDTO {
	/**
	 * 商品id
	 */
	@ApiModelProperty(value="商品id")
	private Long productId;

	/**
	 * 商品图片
	 */
	@ApiModelProperty(value="商品图片")
	private String productImage;
	/**
	 * 商品名
	 */
	@ApiModelProperty(value="商品名")
	private String productName;
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
	 * 销量
	 */
	@ApiModelProperty(value="销量")
	private Integer sales;

}
