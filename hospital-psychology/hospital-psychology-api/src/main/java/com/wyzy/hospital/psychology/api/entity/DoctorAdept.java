

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
 * 心理医生擅长表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:14
 */
@Data
@TableName("doctor_adept")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生擅长表")
public class DoctorAdept extends Model<DoctorAdept> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * doctorId
     */
    @ApiModelProperty(value="doctorId")
    private Long doctorId;

    /**
     * 心理分类id
     */
    @ApiModelProperty(value="心理分类id")
    private Long adeptId;
}
