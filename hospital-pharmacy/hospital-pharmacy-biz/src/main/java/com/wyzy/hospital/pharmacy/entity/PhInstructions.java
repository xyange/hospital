

package com.wyzy.hospital.pharmacy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 药品说明书
 *
 * @author songM
 * @date 2021-06-04 14:29:57
 */
@Data
@TableName("ph_instructions")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药品说明书")
public class PhInstructions extends Model<PhInstructions> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId
    @ApiModelProperty(value="自增id")
    private Long id;

    /**
     * 药品id
     */
    @ApiModelProperty(value="药品id")
    private Long drugId;

    /**
     * 处方类型
     */
    @ApiModelProperty(value="处方类型")
    private String prescriptionType;

    /**
     * 成分
     */
    @ApiModelProperty(value="成分")
    private String component;

    /**
     * 主治功能
     */
    @ApiModelProperty(value="主治功能")
    private String indications;

    /**
     * 性状
     */
    @ApiModelProperty(value="性状")
    private String character;

    /**
     * 规格
     */
    @ApiModelProperty(value="规格")
    private String specifications;

    /**
     * 用法用量
     */
    @ApiModelProperty(value="用法用量")
    private String usageDosage;

    /**
     * 内服/外用
     */
    @ApiModelProperty(value="内服/外用")
    private String withinExternal;

    /**
     * 禁忌
     */
    @ApiModelProperty(value="禁忌")
    private String taboo;

    /**
     * 注意事项
     */
    @ApiModelProperty(value="注意事项")
    private String matters;

    /**
     * 药物相互作用
     */
    @ApiModelProperty(value="药物相互作用")
    private String effect;

    /**
     * 储藏
     */
    @ApiModelProperty(value="储藏")
    private String store;

    /**
     * 剂型
     */
    @ApiModelProperty(value="剂型")
    private String dosageForm;

    /**
     * 有效期
     */
    @ApiModelProperty(value="有效期")
    private String termValidity;

    /**
     * 批准文号
     */
    @ApiModelProperty(value="批准文号")
    private String approvalNum;

}
