

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
 * 心理咨询师访谈
 *
 * @author hospital code generator
 * @date 2021-06-11 09:52:56
 */
@Data
@TableName("doctor_interview")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理咨询师访谈")
public class DoctorInterview extends Model<DoctorInterview> {

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
     * 访谈标题
     */
    @ApiModelProperty(value="访谈标题")
    private String interviewTitle;

    /**
     * 访谈内容
     */
    @ApiModelProperty(value="访谈内容")
    private String interviewContent;

    /**
     * 排序码
     */
    @ApiModelProperty(value="排序码")
    private Long sortCode;

}
