

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 病历表
 *
 * @author aqie
 * @date 2021-04-26 15:27:03
 */
@Data
@TableName("wyzy_case_history")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "病历表")
public class CaseHistory extends Model<CaseHistory> {

    private static final long serialVersionUID = 1L;

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
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;

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

    /**
     * 会诊结果id
     */
    @ApiModelProperty(value="会诊结果id")
    private Long resultId;

    /**
     * 问诊记录id
     */
    @ApiModelProperty(value="问诊记录id")
    private Long inquiryId;
}
