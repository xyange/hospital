package com.wyzy.hospital.admin.api.dto.member;

import com.wyzy.hospital.admin.api.entity.PatientCard;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/4/26  17:38
 * @Function:
 */
@Data
@NoArgsConstructor
public class PatientCardDTO {
    @ApiModelProperty(value="就诊人id")
    private Long cardId;

    @ApiModelProperty(value="会员id")
    private Long memberId;

    @ApiModelProperty(value="病人姓名")
    private String patientName;

    @ApiModelProperty(value="病人身份证号")
    private String patientIdCard;

    @ApiModelProperty(value="病人手机号")
    private String patientPhone;

    @ApiModelProperty(value="病人体重")
    private Integer patientWeight;

    @ApiModelProperty(value="病人身高")
    private Integer patientHeight;

    @ApiModelProperty(value="病人疾病史")
    private String diseasesHistory;

    @ApiModelProperty(value="过敏史")
    private String allergicHistory;

    @ApiModelProperty(value="手术史")
    private String surgeryHistory;

    @ApiModelProperty(value="习惯")
    private String habit;

    /**
     * 和主体关系 0-我 1-父亲 2-母亲 3-孩子
     */
    @ApiModelProperty(value="和主体关系 0-我 1-父亲 2-母亲 3-孩子")
    private Integer relation;

    public PatientCardDTO(PatientCard patientCard) {
        this.cardId = patientCard.getCardId();
        this.memberId = patientCard.getMemberId();
        this.patientName = patientCard.getPatientName();
        this.patientIdCard = patientCard.getPatientIdCard();
        this.patientPhone = patientCard.getPatientPhone();
    }
}
