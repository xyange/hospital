

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
 * 心理医生荣誉名称表
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:10
 */
@Data
public class DoctorHonorDTO {
    private static final long serialVersionUID = 1L;
    /**
     * 荣誉名称
     */
    @ApiModelProperty(value="荣誉名称")
    private String honorName;
}
