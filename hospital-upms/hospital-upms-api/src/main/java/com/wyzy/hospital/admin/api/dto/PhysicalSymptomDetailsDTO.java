

package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 身体管理症状详情
 *
 * @author hospital code generator
 * @date 2021-06-17 09:19:36
 */
@Data
public class PhysicalSymptomDetailsDTO {
    /**
     * 症状ID
     */
    @TableId
    @ApiModelProperty(value="症状ID")
    private Long id;

    /**
     * 症状名称
     */
    @ApiModelProperty(value="症状名称")
    private String symptomName;

}
