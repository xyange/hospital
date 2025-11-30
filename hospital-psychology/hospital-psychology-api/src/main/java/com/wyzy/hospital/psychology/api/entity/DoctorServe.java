

package com.wyzy.hospital.psychology.api.entity;

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
 * 心理医生服务关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:02
 */
@Data
@TableName("doctor_serve")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生服务关系表")
public class DoctorServe extends Model<DoctorServe> {

    private static final long serialVersionUID = 1L;

    /**
     * doctorId
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
     * 服务id
     */
    @ApiModelProperty(value="服务id")
    private Long serveId;

}
