

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

import java.time.LocalDateTime;

/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
@Data
@TableName("tcm_sort")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "中医模块分类表")
public class TcmSort extends Model<TcmSort> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
	@TableId
    @ApiModelProperty(value="分类ID")
    private Long sortId;

    /**
     * 上一级ID
     */
    @ApiModelProperty(value="上一级ID")
    private Long superiorId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String sortName;

    /**
     * 类型:1 经络分类, 2 中药分类, 3 内科分类表, 4 经络分类
     */
    @ApiModelProperty(value="类型:1 经络分类, 2 中药分类, 3 内科分类表, 4 医书经典")
    private Integer type;

	/**
	 * 介绍
	 */
	@ApiModelProperty(value="介绍")
	private String introduce;

    /**
     * 状态:1 正常, 0 失效
     */
	@TableLogic(value="0",delval="1")
    @ApiModelProperty(value="状态:1 失效, 0 正常")
    private Integer delFlag;

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
