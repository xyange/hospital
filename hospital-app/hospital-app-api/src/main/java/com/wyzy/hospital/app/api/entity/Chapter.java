

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
 * 电子书章节
 *
 * @author aqie
 * @date 2021-05-25 16:08:50
 */
@Data
@TableName("epub_chapter")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "电子书章节")
public class Chapter extends Model<Chapter> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 书籍id
     */
    @ApiModelProperty(value="书籍id")
    private String bookId;

    /**
     * 书名
     */
    @ApiModelProperty(value="书名")
    private String fileName;

    /**
     * 章节地址 
     */
    @ApiModelProperty(value="章节地址 ")
    private String text;

    /**
     * 章节标题 
     */
    @ApiModelProperty(value="章节标题 ")
    private String label;

    /**
     * 上级id 
     */
    @ApiModelProperty(value="上级id ")
    private Long pid;

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
