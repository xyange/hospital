

package com.wyzy.hospital.psychology.api.entity;

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
 * 心理医生荣誉名称表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:32
 */
@Data
@TableName("doctor_honor")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生荣誉名称表")
public class DoctorHonor extends Model<DoctorHonor> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 医生ID
     */
    @ApiModelProperty(value="医生ID")
    private Long doctorId;

    /**
     * 荣誉名称
     */
    @ApiModelProperty(value="荣誉名称")
    private String honorName;

    /**
     * 获得日期
     */
    @ApiModelProperty(value="获得日期")
    private LocalDateTime achieveTime;


}
