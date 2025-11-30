package com.wyzy.hospital.admin.api.dto.numberquantity;

import com.wyzy.hospital.admin.api.dto.doctor.DoctorServeDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 号源情况详情
 *
 * @author wrk
 * @date 2021/05/12 17:40
 **/
@ApiModel(value = "App号源情况")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberQuantityDetailsDTO {


    @ApiModelProperty(value = "医生id")
    private Long doctorId;
    @ApiModelProperty(value = "医生")
    private String doctorName;

    @ApiModelProperty(value = "职称id")
    private Integer professionalTitleId;
    @ApiModelProperty(value = "职称")
    private String professionalTitle;

    @ApiModelProperty(value = "服务人次")
    private Integer peopleNumber;

    @ApiModelProperty(value = "擅长")
    private String adept;

    @ApiModelProperty(value = "挂号费用")
    private BigDecimal registrationFee;

    @ApiModelProperty(value = "号源数量")
    private Integer totalQuantity;
    @ApiModelProperty(value = "号源剩余量")
    private Integer surplusQuantity;

    @ApiModelProperty(value = "0:上午/1：下午")
    private Integer timeSlot;

    @ApiModelProperty(value = "预约就诊日期")
    private LocalDate orderDate;

    @ApiModelProperty(value = "放号时间")
    private LocalDateTime numberAllocationTime;
    @ApiModelProperty(value = "医生服务")
    List<DoctorServeDTO> serve;


}
