package com.wyzy.hospital.pharmacy.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: ShopProductQueryParamDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/9 9:17
 */
@Data
@NoArgsConstructor
public class ShopProductQueryParamDTO {
	/**
	 * 商家名
	 */
	@ApiModelProperty(value="shopName")
	private String shopName;

	/**
	 * 商品名
	 */
	@ApiModelProperty(value="productName")
	private String productName;
}
