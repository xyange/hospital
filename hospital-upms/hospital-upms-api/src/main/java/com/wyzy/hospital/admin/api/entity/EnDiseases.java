

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:41
 */
@Data
@TableName("en_diseases")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "疾病表")
public class  EnDiseases extends Model<EnDiseases> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value="ID")
    private Long id;

    /**
     * 疾病名称
     */
    @ApiModelProperty(value="疾病名称")
    private String diseaseName;

    /**
     * 疾病别称
     */
    @ApiModelProperty(value="疾病别称")
    private String diseaseNicknames;

    /**
     * 科室id
     */
    @ApiModelProperty(value="科室id")
    private Integer departmentId;

    /**
     * 病例概述
     */
    @ApiModelProperty(value="病例概述")
    private String content;

    /**
     * 症状
     */
    @ApiModelProperty(value="症状")
    private String symptom;

    /**
     * 病因
     */
    @ApiModelProperty(value="病因")
    private String diseaseCause;

    /**
     * img
     */
    @ApiModelProperty(value="img")
    private String img;

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
