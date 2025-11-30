

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
 * 心理医生 咨询类型关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:11
 */
@Data
@TableName("doctor_counsel")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生 咨询类型关系表")
public class DoctorCounsel extends Model<DoctorCounsel> {

    private static final long serialVersionUID = 1L;

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
     * 资讯类型id
     */
    @ApiModelProperty(value="资讯类型id")
    private Long counselTypeId;

}
