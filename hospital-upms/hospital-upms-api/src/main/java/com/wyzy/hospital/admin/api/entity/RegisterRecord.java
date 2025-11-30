

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 挂号记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:25
 */
@Data
@TableName("wyzy_register_record")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "挂号记录")
public class RegisterRecord extends Model<RegisterRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 挂号id
     */

    @TableId(value = "registerId", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="挂号id")
    private Long registerId;

    /**
     * 就诊卡id
     */
    @ApiModelProperty(value="就诊卡id")
    private Long cardId;

    /**
     * 医院id
     */
    @ApiModelProperty(value="医院id")
    private Long hospitalId;

    /**
     * 科室id
     */
    @ApiModelProperty(value="科室id")
    private Long departmentId;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 挂号时间
     */
    @ApiModelProperty(value="挂号时间")
    private Integer registerTime;

    /**
     * 挂号编号
     */
    @ApiModelProperty(value="挂号编号")
    private String registerCode;

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
