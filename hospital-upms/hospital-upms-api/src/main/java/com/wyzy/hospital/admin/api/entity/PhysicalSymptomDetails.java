

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 身体管理症状详情
 *
 * @author hospital code generator
 * @date 2021-06-17 09:19:36
 */
@Data
@TableName("physical_symptom_details")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "身体管理症状详情")
public class PhysicalSymptomDetails extends Model<PhysicalSymptomDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 症状ID
     */
    @TableId
    @ApiModelProperty(value="症状ID")
    private Long id;

    /**
     * 症状ID
     */
    @ApiModelProperty(value="症状ID")
    private Long symptomId;

    /**
     * 症状名称
     */
    @ApiModelProperty(value="症状名称")
    private String symptomName;

    /**
     * 症状介绍
     */
    @ApiModelProperty(value="症状介绍")
    private String symptomIntroduce;

    /**
     * 症状
     */
    @ApiModelProperty(value="症状")
    private String symptom;

    /**
     * 传染性
     */
    @ApiModelProperty(value="传染性")
    private String diagnosis;

    /**
     * 多发人群
     */
    @ApiModelProperty(value="多发人群")
    private String prophylaxis;

    /**
     * 并发疾病
     */
    @ApiModelProperty(value="并发疾病")
    private String concurrentDiseases;

    /**
     * 治疗费用
     */
    @ApiModelProperty(value="治疗费用")
    private String treatmentCosts;

    /**
     * 治愈率
     */
    @ApiModelProperty(value="治愈率")
    private String cureRate;

    /**
     * 治疗周期
     */
    @ApiModelProperty(value="治疗周期")
    private String treatmentCycle;

    /**
     * 治疗方法
     */
    @ApiModelProperty(value="治疗方法")
    private String therapeuticMethod;

    /**
     * 相关检查
     */
    @ApiModelProperty(value="相关检查")
    private String relevantInspection;

    /**
     * 常用药品
     */
    @ApiModelProperty(value="常用药品")
    private String commonlyDrugs;

    /**
     * 最佳就诊时间
     */
    @ApiModelProperty(value="最佳就诊时间")
    private String bestVisitTime;

    /**
     * 就诊时长
     */
    @ApiModelProperty(value="就诊时长")
    private String lengthVisit;

    /**
     * 复诊频率/治疗周期
     */
    @ApiModelProperty(value="复诊频率/治疗周期")
    private String returnVisit;

    /**
     * 就诊前准备
     */
    @ApiModelProperty(value="就诊前准备")
    private String ready;

    /**
     * 状态：0正常1删除
     */
    @ApiModelProperty(value="状态：0正常1删除")
    private Integer delFlag;

    /**
     * 在线：0下线1上线
     */
    @ApiModelProperty(value="在线：0下线1上线")
    private Integer isOnline;

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

}
