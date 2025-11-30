package com.wyzy.hospital.admin.api.dto.consult;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Title: ConsultOrderDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/16 14:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultOrderDTO {

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 就诊卡id
     */
    @ApiModelProperty(value="就诊卡id")
    private Long cardId;

    /**
     * 会员Id
     */
    @ApiModelProperty(value="会员Id")
    private Long memberId;

    /**
     * 就诊人姓名
     */
    @ApiModelProperty(value="就诊人姓名")
    private String patientName;

    /**
     * 订单状态
     */
    @ApiModelProperty(value="订单状态")
    private String orderState;

    /**
     * 诊疗模式类型id
     */
    @ApiModelProperty(value="诊疗模式类型id")
    private Long consultTypeId;

    /**
     * 诊疗模式类型
     */
    @ApiModelProperty(value="诊疗模式类型")
    private  String consultType;

    /**
     * 疾病Id
     */
    @ApiModelProperty(value="疾病Id")
    private String diseaseId;

    /**
     * 疾病名字
     */
    @ApiModelProperty(value="疾病名字")
    private String diseaseName;

    /**
     * 支付金额
     */
     @ApiModelProperty(value="支付金额")
     private Double price;

    /**
     * 会诊时间
     */
    @ApiModelProperty(value="会诊时间")
    private LocalDateTime orderTime;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

}



