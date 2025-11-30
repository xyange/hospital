

package com.wyzy.hospital.app.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 电子书
 *
 * @author aqie
 * @date 2021-05-25 16:09:00
 */
@Data
@TableName("epub_book")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "电子书")
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * id
     */
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


	@ApiModelProperty(value="浏览量")
    private Integer views;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;

    /**
     * 是否删除 0-否 1-是
     */
    @ApiModelProperty(value="是否删除 0-否 1-是")
    private String delFlag;

}
