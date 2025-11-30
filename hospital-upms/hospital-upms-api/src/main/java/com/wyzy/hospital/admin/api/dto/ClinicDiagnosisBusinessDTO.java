package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wyzy.hospital.admin.api.entity.ClinicDiagnosis;
import com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails;
import com.wyzy.hospital.admin.api.entity.Doctor;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: ClinicDIagnosisServiceDto
 * @Description: 诊所
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/4/19 14:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClinicDiagnosisBusinessDTO {

    /**
     * 诊所id
     */
    @TableId
    @ApiModelProperty(value="诊所id")
    private Long clinicId;

    /**
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
     * 区域
     */
    @ApiModelProperty(value="区域")
    private String area;

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
     * geohash编码
     */
    @ApiModelProperty(value="geohash编码")
    private String geoCode;



    /**
     * 科室名字
     */
    @ApiModelProperty(value="科室名字")
    private  String departmentsName;

    /**
     * 距离
     */
    @ApiModelProperty(value="距离")
    private  Double distance;

    /**
     * 医生列表
     */
    @ApiModelProperty(value="医生列表")
    private List<Doctor> doctorList;


    /**
     * 诊疗项目列表
     */
    @ApiModelProperty(value="诊疗项目列表")
    private List<ClinicDiagnosis> clinicDiagnosisList;

    /**
     * 技术详情列表
     */
    @ApiModelProperty(value="技术详情列表")
    private List<ClinicTechnologyDetails> clinicTechnologyDetails;


}
