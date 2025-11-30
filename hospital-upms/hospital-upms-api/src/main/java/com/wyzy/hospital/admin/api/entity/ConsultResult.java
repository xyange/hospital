

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会诊结果表
 * @author songM
 * @date 2021-06-17 18:04:03
 */
@Data
@TableName("consult_result")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "会诊结果表")
public class ConsultResult extends Model<ConsultResult> {

    private static final long serialVersionUID = 1L;

    /**
     * 会诊结果id
     */
    @TableId
    @ApiModelProperty(value="会诊结果id")
    private Long id;

    /**
     * 医生诊断
     */
    @ApiModelProperty(value="医生诊断")
    private String doctorDiagnosis;

    /**
     * 处方
     */
    @ApiModelProperty(value="处方")
    private String prescription;

    /**
     * 用法用量
     */
    @ApiModelProperty(value="用法用量")
    private String userDosage;

    /**
     * 注意事项
     */
    @ApiModelProperty(value="注意事项")
    private String carefulMatter;

}
