

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
 * 心理医生培训表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:49
 */
@Data
@TableName("doctor_training")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生培训表")
public class DoctorTraining extends Model<DoctorTraining> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 培训名称
     */
    @ApiModelProperty(value="培训名称")
    private String trainingName;

    /**
     * 开始日期
     */
    @ApiModelProperty(value="开始日期")
    private LocalDateTime startDate;

    /**
     * 结束日期
     */
    @ApiModelProperty(value="结束日期")
    private LocalDateTime endDate;

}
