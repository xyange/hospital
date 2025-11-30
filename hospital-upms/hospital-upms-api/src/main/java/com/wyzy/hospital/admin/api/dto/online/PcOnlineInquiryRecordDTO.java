package com.wyzy.hospital.admin.api.dto.online;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wyzy.hospital.admin.api.entity.OnlineInquiryRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/4/27  14:18
 * @Function:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PcOnlineInquiryRecordDTO extends OnlineInquiryRecord {
    /**
     * 问诊Id
     */
    @ApiModelProperty(value="问诊Id")
    private Long inquiryId;


    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String patientPhone;
    /**
     * 病人姓名
     */
    @ApiModelProperty(value="就诊人姓名")
    private String patientName;

    /**
     * 医生名称
     */
    @ApiModelProperty(value="医生名称")
    private String doctorName;

    /**
     * 问诊类型
     */
    @ApiModelProperty(value="问诊类型:123-图文咨询,124-音频咨询,125-私人医生,126-预约挂号",example ="123")
    private Integer inquireType;

    /**
     * 咨询方式
     */
    @ApiModelProperty(value="咨询方式")
    private String inquireTypeName;

    /**
     * 金额
     */
    @ApiModelProperty(value="金额")
    private String price;


}
