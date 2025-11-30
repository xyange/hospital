package com.wyzy.hospital.pharmacy.dto;

import com.wyzy.hospital.pharmacy.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/4/22  10:34
 * @Function:
 */
@Data
@NoArgsConstructor
public class CategoryDTO {
	private Long id;
	private Long pid;
	private String name;
	private String picture;
	private Integer level;

	public CategoryDTO(Category category){
		this.id = category.getId();
		this.pid = category.getPid();
		this.name = category.getName();
		this.picture = category.getPicture();
		this.level = category.getLevel();
	}
}
