

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
 * 经脉表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:28
 */
@Data
@TableName("tcm_meridians")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "经脉表")
public class TcmMeridians extends Model<TcmMeridians> {

    private static final long serialVersionUID = 1L;

    /**
     * 经脉ID
     */
	@TableId
    @ApiModelProperty(value="经脉ID")
    private Long meridiansId;

    /**
     * 经脉名称
     */
    @ApiModelProperty(value="经脉名称")
    private String meridiansName;

    /**
     * 经络ID
     */
    @ApiModelProperty(value="经络ID")
    private Long contextId;

    /**
     * 当令时长
     */
    @ApiModelProperty(value="当令时长")
    private String durationDuty;

    /**
     * 经脉循行原文
     */
    @ApiModelProperty(value="经脉循行原文")
    private String originalText;

    /**
     * 经脉循行译文
     */
    @ApiModelProperty(value="经脉循行译文")
    private String translation;

    /**
     * 主要病侯
     */
    @ApiModelProperty(value="主要病侯")
    private String mainSymptoms;

    /**
     * 主治概要
     */
    @ApiModelProperty(value="主治概要")
    private String outline;

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
