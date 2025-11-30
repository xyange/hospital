package com.wyzy.hospital.admin.api.dto.numberquantity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 号源情况
 *
 * @author wrk
 * @date 2021/05/12 16:19
 **/
@ApiModel(value = "App号源情况")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberQuantityDTO {
    @ApiModelProperty(value = "医院id")
    private Long hospitalId;
    @ApiModelProperty(value = "医院")
    private String hospitalName;

    @ApiModelProperty(value = "科室id")
    private Long deportmentId;
    @ApiModelProperty(value = "科室")
    private String departmentName;

    @ApiModelProperty(value = "医生id")
    private Long doctorId;
    @ApiModelProperty(value = "医生")
    private String doctorName;

    @ApiModelProperty(value = "号源总数量")
    private Integer totalQuantity;
    @ApiModelProperty(value = "号源剩余量")
    private Integer surplusQuantity;

    @ApiModelProperty(value = "预约就诊日期")
    private LocalDate orderDate;

    @ApiModelProperty(value = "放号时间")
    private LocalDateTime numberAllocationTime;

    @ApiModelProperty(value = "周几")
    private String week;

}
