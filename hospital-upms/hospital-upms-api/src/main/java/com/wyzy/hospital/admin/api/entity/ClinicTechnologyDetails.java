

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 诊所诊疗技术详情表
 *
 * @author songM
 * @date 2021-05-15 11:33:37
 */
@Data
@TableName("clinic_technology_details")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "诊所诊疗技术详情表")
public class ClinicTechnologyDetails extends Model<ClinicTechnologyDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 诊疗技术id
     */
    @TableId
    @ApiModelProperty(value="诊疗技术id")
    private Integer technologyId;

    /**
     * 诊疗技术名字
     */
    @ApiModelProperty(value="诊疗技术名字")
    private String technologyTitle;

    /**
     * 技术图片
     */
    @ApiModelProperty(value="技术图片")
    private String technologyPic;

    /**
     * 技术诞生年份
     */
    @ApiModelProperty(value="技术诞生年份")
    private String technologyBornDate;

    /**
     * 技术诞生国家
     */
    @ApiModelProperty(value="技术诞生国家")
    private String technologyBornCountry;

    /**
     * 技术适用
     */
    @ApiModelProperty(value="技术适用")
    private String technologyApply;

    /**
     * 技术特色
     */
    @ApiModelProperty(value="技术特色")
    private String technologyCharacteristic;

    /**
     * 技术原理
     */
    @ApiModelProperty(value="技术原理")
    private String technologyPrinciple;

    /**
     * 技术设备图片
     */
    @ApiModelProperty(value="技术设备图片")
    private String technologyEquipment;

    /**
     * 诊疗方案id
     */
    @ApiModelProperty(value="诊疗方案id")
    private Long technologyDiagnosisId;

}
