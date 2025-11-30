

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
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-17 09:26:01
 */
@Data
@TableName("hospital_department")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医院科室详情")
public class HospitalDepartment extends Model<HospitalDepartment> {

    private static final long serialVersionUID = 1L;

    /**
     * 医院科室ID
     */
    @TableId
    @ApiModelProperty(value="医院科室ID")
    private Long id;

    /**
     * 科室ID
     */
    @ApiModelProperty(value="科室ID")
    private Long departmentsId;

    /**
     * 医院ID
     */
    @ApiModelProperty(value="医院ID")
    private Long hospitalId;

    /**
     * 科长ID
     */
    @ApiModelProperty(value="科长ID")
    private Long chiefid;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;

}
