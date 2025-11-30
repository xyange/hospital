

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 就诊卡
 *
 * @author aqie
 * @date 2021-04-26 15:23:39
 */
@Data
@TableName("wyzy_patient_card")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "就诊卡")
public class PatientCard extends Model<PatientCard> {

    private static final long serialVersionUID = 1L;

    /**
     * 就诊人id
     */
    @TableId(value = "card_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="就诊人id")
    private Long cardId;

    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;

    /**
     * 病人姓名
     */
    @ApiModelProperty(value="病人姓名")
    private String patientName;

    /**
     * 病人身份证号
     */
    @ApiModelProperty(value="病人身份证号")
    private String patientIdCard;

    /**
     * 病人手机号
     */
    @ApiModelProperty(value="病人手机号")
    private String patientPhone;

    /**
     * 病人体重
     */
    @ApiModelProperty(value="病人体重")
    private Integer patientWeight;

    /**
     * 病人身高
     */
    @ApiModelProperty(value="病人身高")
    private Integer patientHeight;

    /**
     * 病人疾病史
     */
    @ApiModelProperty(value="病人疾病史")
    private String diseasesHistory;

    /**
     * 过敏史
     */
    @ApiModelProperty(value="过敏史")
    private String allergicHistory;

    /**
     * 手术史
     */
    @ApiModelProperty(value="手术史")
    private String surgeryHistory;

    /**
     * 习惯
     */
    @ApiModelProperty(value="习惯")
    private String habit;

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
     * 和主体关系 0-我 1-父亲 2-母亲 3-孩子
     */
    @ApiModelProperty(value="和主体关系 0-我 1-父亲 2-母亲 3-孩子")
    private Integer relation;

}
