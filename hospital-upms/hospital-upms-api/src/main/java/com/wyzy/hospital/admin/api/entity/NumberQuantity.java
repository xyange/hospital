package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 号源情况
 *
 * @author wrk
 * @date 2021/05/12 15:48
 **/
@Data
@TableName("wzyz_number_quantity")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "号源情况")
@AllArgsConstructor
@NoArgsConstructor
public class NumberQuantity extends Model<NumberQuantity> {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "医院id")
    private Long hospitalId;
    @ApiModelProperty(value = "科室id")
    private Long deportmentId;
    @ApiModelProperty(value = "医生id")
    private Long doctorId;
    @ApiModelProperty(value = "号源总数量")
    private Integer allQuantity;
    @ApiModelProperty(value = "号源剩余量")
    private Integer surplusQuantity;
    @ApiModelProperty(value = "预约就诊日期")
    private LocalDate orderDate;
    @ApiModelProperty(value = "0：上午/ 1：下午")
    private Integer timeSlot;
    @ApiModelProperty(value = "放号时间")
    private LocalDateTime numberAllocationTime;
    @ApiModelProperty(value = "号源创建时间")
    private LocalDateTime numberCreateTime;

    @ApiModelProperty(value = "号源创建人")
    private Long numberCreatePerson;



}
