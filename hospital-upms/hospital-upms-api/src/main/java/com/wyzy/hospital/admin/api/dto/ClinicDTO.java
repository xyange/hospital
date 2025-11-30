package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: ClinicDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/5/26 15:28
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClinicDTO {


    private static final long serialVersionUID = 1L;

    /**
     * 诊所id
     */
    @TableId
    @ApiModelProperty(value="诊所id")
    private Long clinicId;

    /**getClinicPageByCondition
     * 诊所编号
     */
    @ApiModelProperty(value="诊所编号")
    private String clinicNumber;

    /**
     * 诊所名
     */
    @ApiModelProperty(value="诊所名")
    private String clinicTitle;

    /**
     * 科室id
     */
    @ApiModelProperty(value="科室id")
    private Integer departmentsId;

    /**
     * 联系人姓名
     */
    @ApiModelProperty(value="联系人姓名")
    private String contactsName;

    /**
     * 联系人电话
     */
    @ApiModelProperty(value="联系人电话")
    private String contactsPhone;

    /**
     * 销售人id
     */
    @ApiModelProperty(value="销售人id")
    private Long salesmenId;

    /**
     * 销售人姓名
     */
    @ApiModelProperty(value="销售人姓名")
    private String salesmenName;

    /**
     * 销售人电话
     */
    @ApiModelProperty(value="销售人电话")
    private String salesmenPhone;

    /**
     * 营业时间
     */
    @ApiModelProperty(value="营业时间")
    private String businessHours;

    /**
     * 门诊介绍图
     */
    @ApiModelProperty(value="门诊介绍图")
    private String introducePic;


    /**
     * geohash编码
     */
    @ApiModelProperty(value="geohash编码")
    private String geoCode;


    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String address;

    /**
     * 经度
     */
    @ApiModelProperty(value="经度")
    private String longitude;

    /**
     * 维度
     */
    @ApiModelProperty(value="维度")
    private String latitude;


    /**
     * 距离
     */
    @ApiModelProperty(value="距离")
    private Double distance;

    /**
     * 科室名字
     */
    @ApiModelProperty(value="科室名字")
    private String departmentsName;

    /**
     * 区域
     */
    @ApiModelProperty(value="区域")
    private String area;

    /**
     * 诊疗项目id
     */
    @ApiModelProperty(value="诊疗项目id")
    private Long diagnosisId;

    /**
     * 疾病id
     */
    @ApiModelProperty(value="疾病id")
    private Integer diseaseId;


    /**
     * 诊疗项目名
     */
    @ApiModelProperty(value="诊疗项目名")
    private String diagnosisName;

    /**
     * 疾病名字
     */
    @ApiModelProperty(value="疾病名字")
    private String diseaseName;

}
