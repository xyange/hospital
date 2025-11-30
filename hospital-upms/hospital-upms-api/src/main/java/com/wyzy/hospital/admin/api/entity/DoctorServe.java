

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
@Data
@TableName("doctor_serve")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医生服务关系表")
public class DoctorServe extends Model<DoctorServe> {

    private static final long serialVersionUID = 1L;

    /**
     * 医生id
     */
    @TableId(value = "doctor_id")
    @ApiModelProperty(value="医生id")
    private Long docId;

    /**
     * 服务id
     */
    @ApiModelProperty(value="服务id")
    private Integer serviceId;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 收入
     */
    @ApiModelProperty(value="收入")
    private BigDecimal income;

}
