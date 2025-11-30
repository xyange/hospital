

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
 * 心理医生教育学历表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:40
 */
@Data
@TableName("doctor_education")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生教育学历表")
public class DoctorEducation extends Model<DoctorEducation> {

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
     * 院校
     */
    @ApiModelProperty(value="院校")
    private String college;

    /**
     * 专业
     */
    @ApiModelProperty(value="专业")
    private String profession;

    /**
     * 学位
     */
    @ApiModelProperty(value="学位")
    private String degree;

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
