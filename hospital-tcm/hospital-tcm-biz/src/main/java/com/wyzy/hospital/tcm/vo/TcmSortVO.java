

package com.wyzy.hospital.tcm.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wyzy.hospital.tcm.dto.TcmAcupointDTO;
import com.wyzy.hospital.tcm.dto.TcmCmDTO;
import com.wyzy.hospital.tcm.dto.TcmInternalDTO;
import com.wyzy.hospital.tcm.dto.TcmMedicalbookDTO;
import com.wyzy.hospital.tcm.entity.*;
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
public class TcmSortVO {

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
	 * 上一级ID
	 */
	@ApiModelProperty(value="上一级ID")
	private Long superiorId;

	/**
	 *类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 */
	private List<TcmAcupointVO> tcmAcupointVOList;

	private List<TcmCmVO> tcmCmVOList;

	private List<TcmInternalVO> tcmInternalVOList;

	private List<TcmMedicalbookVO> tcmMedicalbookVOList;
}
