

package com.wyzy.hospital.tcm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
@Data
public class TcmAcupointDTO {

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
	 * 一级分类名称
	 */
	@ApiModelProperty(value="一级分类名称")
	private String oneName;

	/**
	 * 二级分类名称
	 */
	@ApiModelProperty(value="二级分类名称")
	private String twoName;

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
