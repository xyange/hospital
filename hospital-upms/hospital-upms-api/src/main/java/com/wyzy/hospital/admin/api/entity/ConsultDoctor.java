

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 远程会诊-诊疗模式医生关系表
 *
 * @author songM
 * @date 2021-06-15 15:01:43
 */
@Data
@TableName("consult_doctor")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "远程会诊-诊疗模式医生关系表")
public class ConsultDoctor extends Model<ConsultDoctor> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId
    @ApiModelProperty(value="自增id")
    private Integer id;

    /**
     * 诊疗模式类型-与字典表字典类型关联
     */
    @ApiModelProperty(value="诊疗模式类型-与字典表字典类型关联")
    private String consultType;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;

}
