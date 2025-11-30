package com.wyzy.hospital.app.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.wyzy.hospital.app.api.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/27  8:45
 * @Function:
 */
@Data
public class CategoryTreeDTO {
	/**
	 * categoryId
	 */
	@TableId
	@ApiModelProperty(value="categoryId")
	private Long categoryId;

	/**
	 * pid
	 */
	@ApiModelProperty(value="pid")
	private Long pid;

	/**
	 * 层级
	 */
	@ApiModelProperty(value="层级")
	private Integer level;

	/**
	 * 祖先id 逗号分隔
	 */
	@ApiModelProperty(value="祖先id 逗号分隔")
	private String ancestors;

	/**
	 * categoryName
	 */
	@ApiModelProperty(value="categoryName")
	private String categoryName;

	/**
	 * 排序 0最前
	 */
	@ApiModelProperty(value="排序 0最前")
	private Integer sort;

	@ApiModelProperty(value="电子书 分类类型")
	private Integer type;

	private List<CategoryTreeDTO> childs;

	public CategoryTreeDTO(Category category) {
		this.categoryId = category.getCategoryId();
		this.pid = category.getPid();
		this.level = category.getLevel();
		this.ancestors = category.getAncestors();
		this.categoryName = category.getCategoryName();
		this.sort = category.getSort();
		this.type = category.getType();
	}
}
