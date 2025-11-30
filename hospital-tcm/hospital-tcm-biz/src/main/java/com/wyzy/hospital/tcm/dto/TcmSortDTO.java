package com.wyzy.hospital.tcm.dto;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.wyzy.hospital.tcm.entity.TcmSort;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 中医模块分类表DTO
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
@Data
public class TcmSortDTO {

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
	 * 类型:1 方剂分类, 2 中药分类, 3 内科分类表, 4 经络分类
	 */
	@ApiModelProperty(value="类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典")
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

	/**
	 * 子分类数量
	 */
	@ApiModelProperty(value="子分类量")
	private Integer tcmSortNumber;

	/**
	 * 子分类集合
	 */
	@ApiModelProperty(value="子分类集合")
	private List<TcmSort> tcmSortList;

}
