package com.wyzy.hospital.tcm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 经脉表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:28
 */
@Data
public class TcmMeridiansDTO {

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
	 * 一级分类名称
	 */
	@ApiModelProperty(value="一级分类名称")
	private String oneName;

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
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;
}
