package com.wyzy.hospital.pharmacy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/4/22  14:54
 * @Function:
 */
@Data
@NoArgsConstructor
public class ShopDTO {
	private Long shopId;
	private String shopName;
	private String shopLogo;
	private String shopBrief;
	private String shopAddress;
	private String hotline;
	/**
	 * 销量
	 */
	private Integer salesNumber;
}
