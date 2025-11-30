

package com.wyzy.hospital.tcm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:16:31
 */
@Data
@TableName("tcm_recipe")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "方剂表")
public class TcmRecipe extends Model<TcmRecipe> {

    private static final long serialVersionUID = 1L;

    /**
     * 方剂ID
     */
	@TableId
    @ApiModelProperty(value="方剂ID")
    private Long recipeId;

    /**
     * 方剂父级ID
     */
    @ApiModelProperty(value="方剂父级ID")
    private Long recipesuperId;

    /**
     * 方剂分类名称
     */
    @ApiModelProperty(value="方剂分类名称")
    private String recipeName;

    /**
     * 出处
     */
    @ApiModelProperty(value="出处")
    private String source;

    /**
     * 组成
     */
    @ApiModelProperty(value="组成")
    private String compose;

    /**
     * 用法
     */
    @ApiModelProperty(value="用法")
    private String usages;

    /**
     * 功用
     */
    @ApiModelProperty(value="功用")
    private String functions;

    /**
     * 主治
     */
    @ApiModelProperty(value="主治")
    private String indications;

    /**
     * 证治机理
     */
    @ApiModelProperty(value="证治机理")
    private String mechanism;

    /**
     * 方解
     */
    @ApiModelProperty(value="方解")
    private String recipeAnalysis;

    /**
     * 配伍特点
     */
    @ApiModelProperty(value="配伍特点")
    private String compatibility;

    /**
     * 特点
     */
    @ApiModelProperty(value="特点")
    private String characteristic;

    /**
     * 辩证要点
     */
    @ApiModelProperty(value="辩证要点")
    private String dialecticalPoints;

    /**
     * 使用禁忌
     */
    @ApiModelProperty(value="使用禁忌")
    private String tabooUse;

    /**
     * 附方
     */
    @ApiModelProperty(value="附方")
    private String attachedParty;

    /**
     * 鉴别
     */
    @ApiModelProperty(value="鉴别")
    private String identify;

	/**
	 * 状态:1 正常, 0 失效
	 */
	@TableLogic(value="0",delval="1")
	@ApiModelProperty(value="状态:1 失效, 0 正常")
	private Integer delFlag;

	/**
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;

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

}
