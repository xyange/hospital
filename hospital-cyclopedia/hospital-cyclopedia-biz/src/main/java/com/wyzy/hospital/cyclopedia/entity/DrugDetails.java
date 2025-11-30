

package com.wyzy.hospital.cyclopedia.entity;

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
 * 药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:56
 */
@Data
@TableName("drug_details")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药品详情表")
public class DrugDetails extends Model<DrugDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 药品详情ID
     */
    @TableId(value = "drug_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="药品详情ID")
    private Long drugId;

    /**
     * 药品名
     */
    @ApiModelProperty(value="药品名")
    private String drugName;

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
	@TableLogic(value="0",delval="1")
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

}
