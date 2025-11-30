package com.wyzy.hospital.tcm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 内科学表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:38
 */
@Data
public class TcmInternalDTO{

	/**
	 * 内科学ID
	 */
	@TableId
	@ApiModelProperty(value="内科学ID")
	private Long id;

	/**
	 * 一级分类ID
	 */
	@ApiModelProperty(value="一级分类ID")
	private Long oneId;

	/**
	 * 内科分类ID
	 */
	@ApiModelProperty(value="内科分类ID")
	private Long internalsuperId;

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
	 * 内科学名称
	 */
	@ApiModelProperty(value="内科学名称")
	private String diseaseName;

	/**
	 * 临床表现
	 */
	@ApiModelProperty(value="临床表现")
	private String manifestation;

	/**
	 * 治法
	 */
	@ApiModelProperty(value="治法")
	private String treatment;

	/**
	 * 代表方剂
	 */
	@ApiModelProperty(value="代表方剂")
	private String recipeId;

	/**
	 * 本方组成
	 */
	@ApiModelProperty(value="本方组成")
	private String compose;

	/**
	 * 加减配伍
	 */
	@ApiModelProperty(value="加减配伍")
	private String compatibility;

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
	 * 上线：0下线1上线
	 */
	@ApiModelProperty(value="上线：0下线1上线")
	private Integer isOnline;
}
