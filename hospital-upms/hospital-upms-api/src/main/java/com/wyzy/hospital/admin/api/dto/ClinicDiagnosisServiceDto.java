package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.wyzy.hospital.admin.api.entity.Doctor;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
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
public class ClinicDiagnosisServiceDto  {

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
     * 门诊介绍图
     */
    @ApiModelProperty(value="门诊介绍图")
    private String introducePic;

    /**
     * 门诊介绍视频
     */
    @ApiModelProperty(value="门诊介绍视频")
    private String introduceVideo;

    /**
     * 门诊介绍图标
     */
    @ApiModelProperty(value="门诊介绍图标")
    private String introduceIcon;

    /**
     * 门诊服务环境
     */
    @ApiModelProperty(value="门诊服务环境")
    private String serviceEnvironment;

    /**
     * 门诊营业执照
     */
    @ApiModelProperty(value="门诊营业执照")
    private String businessLicense;

    /**
     * 门诊获奖证书
     */
    @ApiModelProperty(value="门诊获奖证书")
    private String awardCertificate;

    /**
     * 过审日期
     */
    @ApiModelProperty(value="过审日期")
    private Date reviewDate;


    /**
     * 0:下线 1：上线
     */
    @ApiModelProperty(value="0:下线 1：上线")
    private String status;


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
     * 审核通过1/不通过0
     */
    @ApiModelProperty(value="审核通过1/不通过0")
    private String approve;

    /**
     * 删除标志（0-删除，1-未删除）
     */
    @ApiModelProperty(value="删除标志（0-删除，1-未删除）")
    private String delFlag;


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
     * 过审日期开始时间
     */
    @ApiModelProperty(value="过审日期开始时间")
    private Date startReviewDate;

    /**
     * 过审日期结束时间
     */
    @ApiModelProperty(value="过审日期结束时间")
    private Date endReviewDate;

    /**
     * 区域
     */
    @ApiModelProperty(value="区域")
    private String area;


    /**
     * 诊疗项目列表
     */
    @ApiModelProperty(value="诊疗项目列表")
    private List<ClinicDiagnosisTechnologyDTO> clinicDiagnosisList;

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




}
