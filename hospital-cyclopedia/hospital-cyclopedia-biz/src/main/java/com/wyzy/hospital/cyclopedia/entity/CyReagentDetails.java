

package com.wyzy.hospital.cyclopedia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 公司药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:28
 */
@Data
@TableName("cy_reagent_details")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "公司药品详情表")
public class CyReagentDetails extends Model<CyReagentDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 公司制药详情表id
     */
    @TableId(value = "cy_reagent_details_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="公司制药详情表id")
    private Long cyReagentDetailsId;

	/**
	 * 别名
	 */
	@ApiModelProperty(value="别名")
	private String drugAlias;

	/**
     * 公司生产药表id
     */
    @ApiModelProperty(value="公司生产药表id")
    private Long cyReagentId;

    /**
     * 适应症状
     */
    @ApiModelProperty(value="适应症状")
    private String indications;

    /**
     * 用法用量
     */
    @ApiModelProperty(value="用法用量")
    private String takeMethod;

    /**
     * 注意事项
     */
    @ApiModelProperty(value="注意事项")
    private String medicineHint;

    /**
     * 禁忌
     */
    @ApiModelProperty(value="禁忌")
    private String contraindication;

    /**
     * 药品单位
     */
    @ApiModelProperty(value="药品单位")
    private String drugUnit;

    /**
     * 不良反应
     */
    @ApiModelProperty(value="不良反应")
    private String adverseReactions;

    /**
     * 药品剂量
     */
    @ApiModelProperty(value="药品剂量")
    private BigDecimal drugDose;

    /**
     * 相互作用
     */
    @ApiModelProperty(value="相互作用")
    private String drugInteractions;

	/**
	 * 人群用药
	 */
	@ApiModelProperty(value="人群用药")
	private String crowdMedication;

	/**
	 * 其他
	 */
	@ApiModelProperty(value="其他")
	private String drugOther;

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
