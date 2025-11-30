

package com.wyzy.hospital.patients.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 家人表
 *
 * @author hospital code generator
 * @date 2021-04-13 09:44:46
 */
@Data
@TableName("patients_family")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "家人表")
public class PatientsFamily extends Model<PatientsFamily> {

    private static final long serialVersionUID = 1L;

    /**
     * 家属病人id
     */
    @TableId
    @ApiModelProperty(value="家属病人id")
    private Integer id;

    /**
     * 家属病人姓名
     */
    @ApiModelProperty(value="家属病人姓名")
    private String familyPatientName;

    /**
     * 病人id
     */
    @ApiModelProperty(value="病人id")
    private Integer patientsId;

/*    *//**
     * 家属病历id
     *//*
    @ApiModelProperty(value="家属病历id")
    private String medicalRecordId;*/

	/**
	 * 家属身份证号码
	 */
	@ApiModelProperty(value="家属身份证号码")
	private String familyIdNumber;

    /**
     * 家属电话
     */
    @ApiModelProperty(value="家属电话")
    private String familyIphone;

    /**
     * 家属医生id
     */
    @ApiModelProperty(value="家属医生id")
    private Integer doctorId;

    /**
     * 家属身高
     */
    @ApiModelProperty(value="家属身高")
    private Integer familyHeight;

    /**
     * 家属体重
     */
    @ApiModelProperty(value="家属体重")
    private Integer familyWeight;

    /**
     * 家属疾病史
     */
    @ApiModelProperty(value="家属疾病史")
    private String familyDisease;

    /**
     * 家属过敏史
     */
    @ApiModelProperty(value="家属过敏史")
    private String familyAllergy;

    /**
     * 家属手术史
     */
    @ApiModelProperty(value="家属手术史")
    private String familySurgery;

    /**
     * 家属个人习惯
     */
    @ApiModelProperty(value="家属个人习惯")
    private String familyHabits;

    /**
     * 医院id
     */
    @ApiModelProperty(value="医院id")
    private String hospitalId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createDate;

    /**
     * 更新日期
     */
    @ApiModelProperty(value="更新日期")
    private LocalDateTime updateDate;


}
