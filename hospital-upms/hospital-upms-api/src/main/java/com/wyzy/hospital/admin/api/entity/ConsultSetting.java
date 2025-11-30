

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 远程会诊预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:52
 */
@Data
@TableName("consult_setting")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "远程会诊预约配置表")
public class ConsultSetting extends Model<ConsultSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Long orderId;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 预约时间
     */
    @ApiModelProperty(value="预约时间")
    private String orderTime;

    /**
     * 是否已经预约 （0-否，1-是）
     */
    @ApiModelProperty(value="是否已经预约 （0-否，1-是）")
    private Integer already;

    /**
     * 预约日期
     */
    @ApiModelProperty(value="预约日期")
    private LocalDate dateTime;

}
