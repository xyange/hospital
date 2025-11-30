package com.wyzy.hospital.app.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/25  16:21
 * @Function:
 */
@Data
public class EbookDTO {
	@ApiModelProperty(value="id")
	private String bookId;

	/**
	 * 文件名
	 */
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

	/**
	 * 出版社
	 */
	@ApiModelProperty(value="出版社")
	private String publisher;

	/**
	 * 分类id
	 */
	@ApiModelProperty(value="分类id")
	private Integer category;

	/**
	 * 分类名
	 */
	@ApiModelProperty(value="分类名")
	private String categoryText;

	/**
	 * 语言
	 */
	@ApiModelProperty(value="语言")
	private String language;

	/**
	 * content.opf
	 */
	@ApiModelProperty(value="content.opf")
	private String rootFile;

	/**
	 * 原始名称
	 */
	@ApiModelProperty(value="原始名称")
	private String originalName;

	/**
	 * 上传路径
	 */
	@ApiModelProperty(value="上传路径")
	private String path;

	/**
	 * 解压路径
	 */
	@ApiModelProperty(value="解压路径")
	private String unzipPath;

	/**
	 * 章节目录
	 */
	@ApiModelProperty(value="解压路径")
	private List<ContentDTO> contentsTree;
}
