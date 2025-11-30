

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生疾病关系表
 *
 * @author songM
 * @date 2021-05-27 16:43:37
 */
@Data
@TableName("doctor_disease")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医生疾病关系表")
public class DoctorDisease extends Model<DoctorDisease> {

    private static final long serialVersionUID = 1L;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 擅长的疾病id
     */
    @ApiModelProperty(value="擅长的疾病id")
    private Long diseaseId;

}
