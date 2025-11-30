

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 诊疗项目表
 *
 * @author songM
 * @date 2021-04-17 10:49:36
 */
@Data
@TableName("clinic_diagnosis")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "诊疗项目表")
public class ClinicDiagnosis extends Model<ClinicDiagnosis> {

    private static final long serialVersionUID = 1L;

    /**
     * 诊疗项目id
     */
    @TableId
    @ApiModelProperty(value="诊疗项目id")
    private Long diagnosisId;

    /**
     * 诊疗项目名
     */
    @ApiModelProperty(value="诊疗项目名")
    private String diagnosisName;

    /**
     * 诊疗方案
     */
    @ApiModelProperty(value="诊疗方案")
    private String diagnosisProgramme;

    /**
     * 诊疗图片
     */
    @ApiModelProperty(value="诊疗图片")
    private String diagnosisPicture;

    /**
     * 诊所id
     */
    @ApiModelProperty(value="诊所id")
    private Long clinicId;

    /**
     * 是否是特色项目（0-不是，1-是）
     */
    @ApiModelProperty(value="是否是特色项目（0-不是，1-是）")
    private String isCharacteristic;

}
