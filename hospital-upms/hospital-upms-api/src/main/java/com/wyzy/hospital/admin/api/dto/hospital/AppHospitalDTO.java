package com.wyzy.hospital.admin.api.dto.hospital;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author aqie
 * Date on 2021/5/19  14:40
 * @Function:
 */
@Data
public class AppHospitalDTO {
    @ApiModelProperty(value="医院ID")
    private Long id;

    @ApiModelProperty(value="医院名称")
    private String hospitalName;

    @ApiModelProperty(value="医院电话")
    private String hospitalTel;

    @ApiModelProperty(value="挂号时间")
    private String registrationTime;

    @ApiModelProperty(value="挂号具体时间")
    private String registrationDate;

    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="医院等级 0-三级甲等 1-三级乙等")
    private String gradeFlag;

    @ApiModelProperty(value="线上医生数目")
    private Integer onlineDoctorNumber;

    @ApiModelProperty(value="线上医生起始数")
    private Integer doctorNumberStart;

    @ApiModelProperty(value="线上医生结束数")
    private Integer doctorNumberEnd;

    @ApiModelProperty(value="科室id")
    private Long departmentId;


    @ApiModelProperty(value="科室名称")
    private String departmentName;


    /**
     * 医院性质 0-公立 1-私立
     */
    @ApiModelProperty(value="医院性质 0-公立 1-私立")
    private String natureFlag;


    /**
     * 0-非定点 1-定点
     */
    @ApiModelProperty(value="0-非定点 1-定点")
    private String fixedPointFlag;

    @ApiModelProperty(value="医院图片")
    private String hospitalImages;

    @ApiModelProperty(value="0-综合排序 1-咨询人数")
    private String comprehensiveRank;
}
