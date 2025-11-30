package com.wyzy.hospital.tcm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:16:31
 */
@Data
public class TcmRecipeDTO extends TcmRecipe {

    /**
     * 方剂ID
     */
    @TableId
    @ApiModelProperty(value="方剂ID")
    private Long recipeId;

	/**
	 * 方剂父级名称
	 */
	@ApiModelProperty(value="方剂父级名称")
	private String recipesuperName;

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
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;

}
