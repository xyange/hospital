

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
 * 电子书分类
 *
 * @author aqie
 * @date 2021-05-27 08:33:57
 */
@Data
@TableName("epub_category")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "电子书分类")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    /**
     * categoryId
     */
	@TableId(value = "category_id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
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
    private Integer delFlag;

	@ApiModelProperty(value="电子书 分类类型")
	private Integer type;

}
