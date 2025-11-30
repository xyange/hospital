package com.wyzy.hospital.admin.api.dto;

import com.wyzy.hospital.admin.api.dto.doctor.DoctorAttribution;
import com.wyzy.hospital.admin.api.entity.Doctor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * 后台管理医生
 *
 * @author wrk
 * @date 2021/04/17 11:19
 **/
@ApiModel(value = "后台管理医生")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcDoctorDTO {

    /**
     * 审核通过日期
     */
    @ApiModelProperty(value="审核通过日期")
    private LocalDate passDate;
    /**
     * 来源
     */
    @ApiModelProperty(value="来源")
    private String source;
    /**
     * 来源
     */
    @ApiModelProperty(value="来源id")
    private String sourceId;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;


    /**
     * 医生性别
     */
    @ApiModelProperty(value="医生性别")
    private Integer sex;


    /**
     * 医生姓名
     */
    @ApiModelProperty(value="医生姓名")
    private String doctorName;

    /**
     * 医生类型
     */
    @ApiModelProperty(value="医生类型")
    private Long doctorType;

    /**
     * 医生电话
     */
    @ApiModelProperty(value="医生电话")
    private String phone;
    /**
     * 医生职称id
     */
    @ApiModelProperty(value="医生职称id")
    private Integer professionalTitleId;

    /**
     * 医生职称
     */
    @ApiModelProperty(value="医生职称")
    private String professionalTitle;

    /**
     * 医生科室id
     */
    @ApiModelProperty(value="医生科室id")
    private Long departmentId;

    /**
     * 医生科室
     */
    @ApiModelProperty(value="医生科室")
    private String department;


    /**
     * 挂号费
     */
    @ApiModelProperty(value="挂号费")
    private Integer registerPrice;

    /**
     * 挂号收入
     */
    @ApiModelProperty(value="挂号收入")
    private Integer registerIncome;
    /**
     * 图文资讯
     */
    @ApiModelProperty(value="图文资讯")
    private Integer picturePrice;

    /**
     * 图文资讯收入
     */
    @ApiModelProperty(value="图文资讯收入")
    private Integer pictureIncome;

    /**
     * 音频资讯
     */
    @ApiModelProperty(value="音频资讯")
    private Integer videoAudioPrice;

    /**
     * 音频资讯收入
     */
    @ApiModelProperty(value="音频资讯收入")
    private Integer videoAudioIncome;
    /**
     * 私人医生
     */
    @ApiModelProperty(value="私人医生")
    private Integer privatePrice;

    /**
     * 私人医生收入
     */
    @ApiModelProperty(value="私人医生收入")
    private Integer privateIncome;
    /**
     * 医生编码
     */
    @ApiModelProperty(value="医生编码")
    private String doctorCode;

    /**
     * 医生状态
     */
    @ApiModelProperty(value="医生状态")
    private String status;

    /**
     * 医生归属类型
     */
    @ApiModelProperty(value="医生归属类型")
    private String attrTypeName;
    /**
     * 医生审核状态
     */
    @ApiModelProperty(value="医生审核状态")
    private String examStatus;

    @ApiModelProperty(value="审核状态ID")
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
     * 医生归属
     */
    @ApiModelProperty(value="医生归属")
    private List<DoctorAttribution> doctorAttribution;
    /**
     * 头像
     */
    @ApiModelProperty(value="头像")
    private String avatar;
    @ApiModelProperty(value="销售人（邀此医生入驻的人）")
    private String saleMan;
    @ApiModelProperty(value="联系电话")
    private String salePhone;
    
    @ApiModelProperty(value="双向归属 机构一")
    private Long institutionOne;
    @ApiModelProperty(value="双向归属 机构二")
    private Long institutionTwo;
    @ApiModelProperty(value="双向归属 归属类型一")
    private Long attributionOne;
    @ApiModelProperty(value="双向归属 归属类型二")
    private Long attributionTwo;
    @ApiModelProperty(value="是否名医（0，否；1，是）")
    private Integer wellKnown;
    @ApiModelProperty(value="擅长")
    private String adept;
    @ApiModelProperty(value="服务")
    private String serve;

    @ApiModelProperty(value="身份证")
    private String idCard;
    @ApiModelProperty(value="从业年限")
    private String workYears;
    @ApiModelProperty(value="头像")
    private String awards;
    @ApiModelProperty(value="职业经经历")
    private String experience;
    @ApiModelProperty(value="职业资格证,逗号分隔")
    private String professionalCertificate;
    @ApiModelProperty(value="医生寄语")
    private String wishes;

    @ApiModelProperty(value="疾病名字")
    private String diseaseName;

    public Doctor transformDoctor() {
        return new Doctor(doctorId,doctorCode, doctorName, sex,doctorType,departmentId, professionalTitleId, null, 0, saleMan, experience, phone, wellKnown, awards, 1, source, passDate, workYears, idCard, professionalCertificate, avatar, 0, salePhone, examStatusId, examDetailResult, examPersonId, wishes,3L,diseaseName);
    }

}
