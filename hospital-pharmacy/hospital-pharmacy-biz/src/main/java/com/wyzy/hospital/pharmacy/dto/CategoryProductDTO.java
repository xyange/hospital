package com.wyzy.hospital.pharmacy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/23  11:53
 * @Function:
 */
@Data
@NoArgsConstructor
public class CategoryProductDTO {
	private Long id;
	private Long pid;
	private String name;
	private String picture;
	private Integer level;
	private List<ProductDTO> products;
}
