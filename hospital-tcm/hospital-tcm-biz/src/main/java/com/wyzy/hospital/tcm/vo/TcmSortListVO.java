

package com.wyzy.hospital.tcm.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wyzy.hospital.tcm.entity.TcmSort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
@Data
public class TcmSortListVO{

	/**
	 * 分类ID
	 */
	@TableId
	@ApiModelProperty(value="分类ID")
	private Long sortId;

	/**
	 * 分类名称
	 */
	@ApiModelProperty(value="分类名称")
	private String sortName;

	/**
	 * 子数量
	 */
	@ApiModelProperty(value="子数量")
	private Integer tcmSortVONumber;

	private List<TcmSortVO> tcmSortVOList;
}
