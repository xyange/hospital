

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
 * 科室疾病表
 *
 * @author hospital code generator
 * @date 2021-04-19 11:43:06
 */
@Data
@TableName("department_disease")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "科室疾病表")
public class DepartmentDisease extends Model<DepartmentDisease> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value="ID")
    private Integer id;

    /**
     * 科室ID
     */
    @ApiModelProperty(value="科室ID")
    private Integer departmentsId;

    /**
     * 疾病ID
     */
    @ApiModelProperty(value="疾病ID")
    private Integer diseaseId;

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
