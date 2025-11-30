package com.wyzy.hospital.pharmacy.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Title: ShopProductDTO
 * @Description:商铺商品DTO
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/9 9:23
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopProductDTO {
	/**
	 * shopId
	 */
	@TableId
	@ApiModelProperty(value="shopId")
	private Long shopId;

	/**
	 * 店铺logo
	 */
	@ApiModelProperty(value="店铺logo")
	private String shopLogo;

	/**
	 * 店铺名称
	 */
	@ApiModelProperty(value="店铺名称")
	private String shopName;

	/**
	 * 销量
	 */
	@ApiModelProperty(value="销量")
	private Integer sales;

	/**
	 * 药店距离
	 */
	@ApiModelProperty(value="药店距离")
	private Double distance;

	/**
	 * 送达时间
	 */
	@ApiModelProperty(value="送达时间")
	private Date serviceTime;

	/**
	 * 商品商铺
	 */
	private List<ProductShopDTO> productShopDTO;

}
