

package com.wyzy.hospital.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 心理医生培训表
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:33
 */
@Data
public class DoctorTrainingDTO {

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
