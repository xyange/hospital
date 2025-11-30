package com.wyzy.hospital.app.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author aqie
 * Date on 2021/6/10  10:19
 * @Function:
 */
@Data
public class AppEbookDTO {
	@ApiModelProperty(value="id")
	private Long id;

	@ApiModelProperty(value="id")
	private String bookId;

	@ApiModelProperty(value="文件名")
	private String fileName;

	/**
	 * 封面
	 */
	@ApiModelProperty(value="封面")
	private String cover;

	/**
	 * 书名
	 */
	@ApiModelProperty(value="书名")
	private String title;

	/**
	 * 作者
	 */
	@ApiModelProperty(value="作者")
	private String author;

	@ApiModelProperty(value="分类id")
	private Integer category;

	@ApiModelProperty(value="浏览量")
	private Integer views;
}
