

package com.wyzy.hospital.doctor.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
@Data
@TableName("doctor_service")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医生服务关系表")
public class DoctorService extends Model<DoctorService> {

    private static final long serialVersionUID = 1L;

    /**
     * 医生id
     */
    @TableId
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 服务id
     */
    @ApiModelProperty(value="服务id")
    private Integer serviceId;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private Integer price;

    /**
     * 收入
     */
    @ApiModelProperty(value="收入")
    private String income;

}
