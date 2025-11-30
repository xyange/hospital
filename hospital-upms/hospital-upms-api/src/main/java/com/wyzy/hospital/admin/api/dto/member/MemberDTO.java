package com.wyzy.hospital.admin.api.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/26  17:10
 * @Function:
 */
@Data
@ApiModel(value = "会员DTO")
public class MemberDTO {
    @ApiModelProperty(value="会员id")
    private Long memberId;

    @ApiModelProperty(value="身份证号")
    private String idCard;

    @ApiModelProperty(value="昵称")
    private String nickname;

    @ApiModelProperty(value="唯一id")
    private String uuid;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="是否付费(0-是 1-否)")
    private Integer paid;

    @ApiModelProperty(value="积分")
    private Integer integration;

    @ApiModelProperty(value="消费金额")
    private BigDecimal monetary;

    @ApiModelProperty(value="就诊人数量")
    private Integer patientNumber;

    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value="开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value="结束时间")
    private LocalDateTime endTime;

    /**
     * 就诊人列表
     */
    List<PatientCardDTO> patientCards;
}
