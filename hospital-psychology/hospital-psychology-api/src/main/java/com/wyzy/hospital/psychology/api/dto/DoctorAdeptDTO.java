

package com.wyzy.hospital.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 心理医生擅长表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:14
 */
@Data
public class DoctorAdeptDTO {

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

    /**
     * 心理分类name
     */
    @ApiModelProperty(value="心理分类name")
    private String adeptName;

    /**
     * 擅长详情
     */
    @ApiModelProperty(value="擅长详情")
    private String adeptDetail;

}
