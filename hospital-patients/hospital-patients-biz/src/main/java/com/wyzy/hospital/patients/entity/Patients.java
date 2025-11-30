

package com.wyzy.hospital.patients.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 病人表
 *
 * @author hospital code generator
 * @date 2021-04-12 11:16:16
 */
@Data
@TableName("patients")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "病人表")
public class Patients extends Model<Patients> {

    private static final long serialVersionUID = 1L;

    /**
     * 病人id
     */
    @TableId
    @ApiModelProperty(value="病人id")
    private Integer id;

    /**
     * 病人姓名
     */
    @ApiModelProperty(value="病人姓名")
    private String patientName;



	/**
     * 身份证号码
     */
    @ApiModelProperty(value="身份证号码")
    private String idNumber;

    /**
     * 电话
     */
    @ApiModelProperty(value="电话")
    private String iphone;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Integer doctorId;

    /**
     * 身高
     */
    @ApiModelProperty(value="身高")
    private Integer height;

    /**
     * 体重
     */
    @ApiModelProperty(value="体重")
    private Integer weight;

    /**
     * 疾病史
     */
    @ApiModelProperty(value="疾病史")
    private String disease;

    /**
     * 过敏史
     */
    @ApiModelProperty(value="过敏史")
    private String allergy;

    /**
     * 手术史
     */
    @ApiModelProperty(value="手术史")
    private String surgery;

    /**
     * 个人习惯
     */
    @ApiModelProperty(value="个人习惯")
    private String habits;

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
