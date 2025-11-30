

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-07 11:01:27
 */
@Data
@TableName("clinic_comment")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "诊所评论表")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClinicComment extends Model<ClinicComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId
    @ApiModelProperty(value="评论id")
    private Long commentId;

    /**
     * 评论的类型 1-诊所 2-服务
     */
    @ApiModelProperty(value="评论的类型 1-诊所 2-服务")
    private Integer commentType;

    /**
     * 诊所或者对应服务的id 
     */
    @ApiModelProperty(value="诊所或者对应服务的id ")
    private Integer idValue;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String userName;

    /**
     * 评论内容
     */
    @ApiModelProperty(value="评论内容")
    private String content;

    /**
     * 诊所或服务对应的星级 1-5星，由数字代替
     */
    @ApiModelProperty(value="诊所或服务对应的星级 1-5星，由数字代替")
    private Integer commentRank;

    /**
     * 是否被管理员批准显示
     */
    @ApiModelProperty(value="是否被管理员批准显示")
    private Integer status;

    /**
     * 评论的父级id,取值该表的comment_id 字段；如果该字段为0，则是一个普通评论，否则该条评论就是该字段的值所对应的评论的回复
     */
    @ApiModelProperty(value="评论的父级id,取值该表的comment_id 字段；如果该字段为0，则是一个普通评论，否则该条评论就是该字段的值所对应的评论的回复")
    private Integer parentId;

    /**
     *  发表该评论的用户的用户id
     */
    @ApiModelProperty(value=" 发表该评论的用户的用户id")
    private Integer userId;

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
     * 评论图片
     */
    @ApiModelProperty(value="评论图片")
    private String commentImg;

    /**
     * 用户头像
     */
    @TableField(exist = false)
    @ApiModelProperty(value="用户头像")
    private String  avatar;
}
