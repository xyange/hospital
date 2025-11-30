

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-16 10:29:02
 */
@Data
@TableName("doctor")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医生")
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends Model<Doctor> {

    private static final long serialVersionUID = 1L;

    /**
     * 医生id
     */
    @TableId
    @ApiModelProperty(value="医生id")
    private Long doctorId;


    /**
     * 医生编码
     */
    @ApiModelProperty(value="医生编码")
    private String doctorCode;


    /**
     * 医生名称
     */
    @ApiModelProperty(value="医生名称")
    private String doctorName;

    /**
     * 医生性别
     */
    @ApiModelProperty(value="医生性别")
    private Integer sex;

    /**
     * 医生类型
     */
    @ApiModelProperty(value="医生类型")
    private Long doctorType;
    /**
     * 科室id
     */
    @ApiModelProperty(value="科室id")
    private Long departmentId;

    /**
     * 职称（等级ID）字典表
     */
    @ApiModelProperty(value="职称（等级ID）字典表")
    private Integer professionalTitleId;

    /**
     * 区域id
     */
    @ApiModelProperty(value="区域")
    private String area;

    /**
     * 服务人次
     */
    @ApiModelProperty(value="服务人次")
    private Integer peopleNumber;

    /**
     * 销售人（邀此医生入驻的人）
     */
    @ApiModelProperty(value="销售人（邀此医生入驻的人）")
    private String saleMan;


    /**
     * 执业经历
     */
    @ApiModelProperty(value="执业经历")
    private String experience;

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
    private LocalDate passDate;

    /**
     * 从业年限
     */
    @ApiModelProperty(value="从业年限")
    private String workYears;

    /**
     * 身份证正反面，逗号分隔
     */
    @ApiModelProperty(value="身份证正反面，逗号分隔")
    private String idCard;

    /**
     * 职业资格证,逗号分隔
     */
    @ApiModelProperty(value="职业资格证,逗号分隔")
    private String professionalCertificate;

    /**
     * 头像
     */
    @ApiModelProperty(value="头像")
    private String avatar;

    /**
     * 是否删除
     */
    @ApiModelProperty(value="是否删除")
    private Integer delFlag;

    /**
     * 销售电话
     */

    @ApiModelProperty(value="销售电话")
    private String salePhone;



    /**
     * 医生审核状态
     */
    @ApiModelProperty(value="医生审核状态")
    private Long examStatusId;

    /**
     * 医生审核详细结果
     */
    @ApiModelProperty(value="医生审核详细结果")
    private String examDetailResult;

    /**
     * 审核人id
     */
    @ApiModelProperty(value="审核人id")
    private Long examPersonId;

    /**
     * 医生寄语
     */
    @ApiModelProperty(value="医生寄语")
    private String wishes;

    /**
     * 租户id
     */
    @ApiModelProperty(value="租户id")
    private Long tenantId;

    @TableField(exist = false)
    @ApiModelProperty(value="擅长疾病/疾病名字")
    private String diseaseName;



}
