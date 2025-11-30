package com.wyzy.hospital.pharmacy.dto;

import com.wyzy.hospital.pharmacy.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/22  10:15
 * @Function: 树状结果
 */
@Data
@NoArgsConstructor
public class CategoryTreeDTO {
	private Long id;
	private Long pid;
	private String name;
	private String picture;
	private Integer level;
	private Integer sort;
	private List<CategoryTreeDTO> childs = new ArrayList<>();

	public CategoryTreeDTO(Category category){
		this.id = category.getId();
		this.pid = category.getPid();
		this.name = category.getName();
		this.picture = category.getPicture();
		this.level = category.getLevel();
		this.sort = category.getSort();
	}
}
