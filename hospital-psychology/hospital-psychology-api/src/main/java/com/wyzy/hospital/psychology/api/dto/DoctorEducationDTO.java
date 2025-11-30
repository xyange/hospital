

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
 * 心理医生教育学历表
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:28
 */
@Data
public class DoctorEducationDTO{
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
}
