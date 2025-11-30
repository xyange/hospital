package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/17  8:56
 */
@Data
public class DrugDetailsDTO {
	/**
	 * 药品详情ID
	 */
	@TableId
	@ApiModelProperty(value="药品详情ID")
	private Long drugId;

	/**
	 * 药品名
	 */
	@ApiModelProperty(value="药品名")
	private String drugName;


	/**
	 * 药剂ID
	 */
	@TableId
	@ApiModelProperty(value="typeId")
	private Long typeId;

	/**
	 * 药剂名称
	 */
	@ApiModelProperty(value="药剂名称")
	private String drugTypeName;

	/**
	 * 药剂数量
	 */
	@ApiModelProperty(value="药剂数量")
	private Integer drugTypeNumber;


	/**
	 * 药品英文名称
	 */
	@ApiModelProperty(value="药品英文名称")
	private String drugEnglish;

	/**
	 * 病例内容
	 */
	@ApiModelProperty(value="病例内容")
	private String drugContent;

	/**
	 * 适应症状
	 */
	@ApiModelProperty(value="适应症状")
	private String drugIndications;

	/**
	 * 用法用量
	 */
	@ApiModelProperty(value="用法用量")
	private String drugTakeMethod;

	/**
	 * 注意事项
	 */
	@ApiModelProperty(value="注意事项")
	private String drugMedicineHint;

	/**
	 * 禁忌症
	 */
	@ApiModelProperty(value="禁忌症")
	private String drugContraindication;

	/**
	 * 不良反应
	 */
	@ApiModelProperty(value="不良反应")
	private String drugAdverseReactions;

	/**
	 * 药物相互作用
	 */
	@ApiModelProperty(value="药物相互作用")
	private String drugInteractions;

	/**
	 * 其他
	 */
	@ApiModelProperty(value="其他")
	private String drugOther;

	/**
	 * drugLevelId
	 */
	@ApiModelProperty(value="drugLevelId")
	private Long drugLevelId;

	/**
	 *  --删除状态(0-未删除   1-已删除)
	 */
	@ApiModelProperty(value=" --删除状态(0-未删除   1-已删除)")
	private String delectStatus;

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

	//药品类型Dto集合
	private List<DrugTypeDTO>drugTypeDTOList;

}
