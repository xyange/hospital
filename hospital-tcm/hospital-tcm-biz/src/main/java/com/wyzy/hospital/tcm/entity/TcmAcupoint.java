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
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
@Data
@TableName("tcm_acupoint")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "穴位表")
public class TcmAcupoint extends Model<TcmAcupoint> {

    private static final long serialVersionUID = 1L;

    /**
     * 穴位ID
     */
    @TableId
    @ApiModelProperty(value="穴位ID")
    private Long acupointId;

    /**
     * 穴位名称
     */
    @ApiModelProperty(value="穴位名称")
    private String acupointName;

	/**
	 * 穴位介绍
	 */
	@ApiModelProperty(value="穴位介绍")
	private String introduce;

    /**
     * 经络ID
     */
    @ApiModelProperty(value="经络ID")
    private Long contextId;

    /**
     * 穴位图片
     */
    @ApiModelProperty(value="穴位图片")
    private String acupointPicture;

    /**
     * 定位
     */
    @ApiModelProperty(value="定位")
    private String location;

    /**
     * 解剖
     */
    @ApiModelProperty(value="解剖")
    private String anatomy;

    /**
     * 主治
     */
    @ApiModelProperty(value="主治")
    private String indications;

    /**
     * 操作
     */
    @ApiModelProperty(value="操作")
    private String operation;

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
