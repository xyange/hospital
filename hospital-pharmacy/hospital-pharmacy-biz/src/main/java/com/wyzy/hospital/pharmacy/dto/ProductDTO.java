package com.wyzy.hospital.pharmacy.dto;

import com.wyzy.hospital.pharmacy.entity.Product;
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
public class ProductDTO {
	private Long productId;
	private Long shopId;
	private String productImage;
	private String productName;
	private Long cateId;
	private BigDecimal price;

	public ProductDTO(Product product) {
		this.productId = product.getProductId();
		this.shopId = product.getShopId();
		this.productImage = product.getProductImage();
		this.productName = product.getProductName();
		this.cateId = product.getCateId();
		this.price = product.getPrice();
	}
}
