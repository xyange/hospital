package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: CaseHistoryDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/18 16:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseHistoryDTO {

    /**
     * caseHistoryId
     */
    @TableId
    @ApiModelProperty(value="caseHistoryId")
    private Long caseHistoryId;

    /**
     * 病人/会员id
     */
    @ApiModelProperty(value="病人/会员id")
    private Long memberId;

    /**
     * 就诊卡id
     */
    @ApiModelProperty(value="就诊卡id")
    private Long cardId;

    /**
     * 就诊人姓名
     */
    @ApiModelProperty(value="就诊人姓名")
    private String patientName;

    /**
     * 就诊人身份证号
     */
    @ApiModelProperty(value="就诊人身份证号")
    private String patientIdCard;

    /**
     * 医院id
     */
    @ApiModelProperty(value="医院id")
    private Long hospitalId;

    /**
     * 医院名称
     */
    @ApiModelProperty(value="医院名称")
    private String hospitalName;

    /**
     * 科室id
     */
    @ApiModelProperty(value="科室id")
    private Long departmentId;

    /**
     * 科室名字
     */
    @ApiModelProperty(value="科室id")
    private String departmentName;


    /**
     * 主诉
     */
    @ApiModelProperty(value="主诉",example ="主诉")
    private String diseaseDescription;


    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 医生姓名
     */
    @ApiModelProperty(value="医生姓名")
    private String doctorName;



    /**
     * 病情图片
     */
    @ApiModelProperty(value="病情图片")
    private String diseaseImg;

    /**
     * 问诊类型
     */
    @ApiModelProperty(value="问诊类型:123-图文咨询,124-音频咨询,125-私人医生,126-预约挂号",example ="123")
    private Integer inquireType;

    /**
     * 就诊时间
     */
    @ApiModelProperty(value="就诊时间")
    private Integer clinicTime;

    /**
     * 症状
     */
    @ApiModelProperty(value="症状")
    private String symptom;

    /**
     * 处方
     */
    @ApiModelProperty(value="处方")
    private String recipe;

    /**
     * 检查
     */
    @ApiModelProperty(value="检查")
    private String inspection;
}
