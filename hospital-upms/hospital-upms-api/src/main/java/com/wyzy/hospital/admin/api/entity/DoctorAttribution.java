package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 医生归属
 *
 * @author wrk
 * @date 2021/04/28 16:48
 **/
@Data
@TableName("doctorAttribution")
@ApiModel(value = "医生")
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAttribution {
    @ApiModelProperty(value="医生id")
    private Long doctorId;
    @ApiModelProperty(value="归属于哪个租户（医院，诊所，个人）")
    private Long attributionId;
    @ApiModelProperty(value="归属类型（医院，诊所，个人）字典表")
    private Long attributionType;
}
