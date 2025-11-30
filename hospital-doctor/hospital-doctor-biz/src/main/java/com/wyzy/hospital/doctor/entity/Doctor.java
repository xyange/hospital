

package com.wyzy.hospital.doctor.entity;

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
 * 医生
 *
 * @author wrk
 * @date 2021-04-12 16:50:44
 */
@Data
@TableName("doctor")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医生")
public class Doctor extends Model<Doctor> {

    private static final long serialVersionUID = 1L;

    /**
     * 医生id
     */
    @TableId
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 医生名称
     */
    @ApiModelProperty(value="医生名称")
    private String doctorName;

    /**
     * 科室id
     */
    @ApiModelProperty(value="科室id")
    private Long departmentId;

    /**
     * 职称
     */
    @ApiModelProperty(value="职称")
    private int professionalTitleId;

    /**
     * 区域id
     */
    @ApiModelProperty(value="区域")
    private String area;

    /**
     * 挂号费
     */
    @ApiModelProperty(value="挂号费")
    private Integer cost;

    /**
     * 服务人次
     */
    @ApiModelProperty(value="服务人次")
    private Integer peopleNumber;

    /**
     * 租户（医院）
     */
    @ApiModelProperty(value="租户（医院）",hidden=true)
    private Integer tenantId;

    /**
     * 销售人（邀此医生入驻的人）
     */
    @ApiModelProperty(value="销售人（邀此医生入驻的人）")
    private Long saleManId;

    /**
     * 擅长病症
     */
    @ApiModelProperty(value="擅长病症")
    private String adept;

    /**
     * 执业经历
     */
    @ApiModelProperty(value="执业经历")
    private String experience;

    /**
     * 身份证（图片地址，逗号分隔）
     */
    @ApiModelProperty(value="身份证（图片地址，逗号分隔）")
    private String idCard;

    /**
     * 职业资格证（图片地址，逗号分隔）
     */
    @ApiModelProperty(value="职业资格证（图片地址，逗号分隔）")
    private String license;

    /**
     * 联系电话
     */
    @ApiModelProperty(value="联系电话")
    private String phone;

    /**
     * 是否名医（0，否；1，是）
     */
    @ApiModelProperty(value="是否名医（0，否；1，是）")
    private Integer wellKnown;

    /**
     * 是否有个人诊所
     */
    @ApiModelProperty(value="是否有个人诊所")
    private Integer hasSurgery;

    /**
     * 获奖经历
     */
    @ApiModelProperty(value="获奖经历")
    private String awards;

    /**
     * 医生状态（0，下线；1上线）
     */
    @ApiModelProperty(value="医生状态（0，下线；1上线）")
    private Integer status;

    /**
     * 来源
     */
    @ApiModelProperty(value="来源")
    private String source;

    /**
     * 审核通过日期
     */
    @ApiModelProperty(value="审核通过日期")
    private LocalDateTime passDate;

}
