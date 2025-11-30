

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 文章表
 *
 * @author hospital code generator
 * @date 2021-04-20 17:06:46
 */
@Data
@TableName("en_articles")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "文章表")
public class EnArticles extends Model<EnArticles> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value="ID")
    private Long id;

    /**
     * 文章名称/标题
     */
    @ApiModelProperty(value="文章名称/标题")
    private String articleName;

    /**
     * 文章分类
     */
    @ApiModelProperty(value="文章分类")
    private String articleLevel;

    /**
     * 文章内容
     */
    @ApiModelProperty(value="文章内容")
    private String articleContent;

    /**
     * 文章视频
     */
    @ApiModelProperty(value="文章视频")
    private String articleVideo;

    /**
     * articleImg
     */
    @ApiModelProperty(value="articleImg")
    private String articleImg;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Long enDiseasesId;



}
