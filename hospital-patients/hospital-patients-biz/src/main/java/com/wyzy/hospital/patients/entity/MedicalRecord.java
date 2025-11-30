

package com.wyzy.hospital.patients.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 病历表
 *
 * @author hospital code generator
 * @date 2021-04-14 15:01:00
 */
@Data
@TableName("medical_record")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "病历表")
public class MedicalRecord extends Model<MedicalRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 病例ID
     */
    @TableId
    @ApiModelProperty(value="病例ID")
    private Integer id;

    /**
     * 医生ID
     */
    @ApiModelProperty(value="医生ID")
    private String doctorId;

    /**
     * 病人ID
     */
    @ApiModelProperty(value="病人ID")
    private Integer patientsId;

    /**
     * 病例内容
     */
    @ApiModelProperty(value="病例内容")
    private String content;

    /**
     * 病人家属ID
     */
    @ApiModelProperty(value="病人家属ID")
    private Integer patientsFamilyId;

    /**
     * 医院ID
     */
    @ApiModelProperty(value="医院ID")
    private String hospitalId;

    /**
     * 诊断时间
     */
    @ApiModelProperty(value="诊断时间")
    private LocalDateTime time;

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
     * img
     */
    @ApiModelProperty(value="img")
    private String img;

}
