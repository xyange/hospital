package com.wyzy.hospital.admin.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: PatientCardDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/18 15:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientCardDTO {

    /**
     * 就诊卡id
     */
    @ApiModelProperty(value="就诊卡id")
    private Long cardId;

    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;

    /**
     * 会员id
     */
    @ApiModelProperty(value="就诊人姓名")
    private String patientName;

    /**
     * 就诊人身份证
     */
    @ApiModelProperty(value="就诊人身份证")
    private String patientIdCard;


    /**
     * 就诊次数
     */
    @ApiModelProperty(value="就诊次数")
    private Integer patientNum;
}
