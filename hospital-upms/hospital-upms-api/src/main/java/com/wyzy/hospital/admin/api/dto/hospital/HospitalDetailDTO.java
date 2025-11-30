package com.wyzy.hospital.admin.api.dto.hospital;

import com.wyzy.hospital.admin.api.dto.department.DepartmentTreeDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/20  9:40
 * @Function:
 */
@Data
public class HospitalDetailDTO {
    private Long id;
    @ApiModelProperty(value="医院名称")
    private String hospitalName;

    @ApiModelProperty(value="医院电话")
    private String hospitalTel;

    @ApiModelProperty(value="是否收藏 0-否 1-是")
    private Integer collect;

    @ApiModelProperty(value="医院性质 0-公立 1-私立")
    private String natureFlag;

    @ApiModelProperty(value="医院等级 0-三级甲等 1-三级乙等")
    private String gradeFlag;

    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="经度")
    private String lon;

    @ApiModelProperty(value="纬度")
    private String lat;

    @ApiModelProperty(value="特色科室id,逗号分隔")
    private String specialDepartments;

    @ApiModelProperty(value="挂号时间 周一、周二")
    private String registrationTime;

    @ApiModelProperty(value="挂号具体时间 08:00 放号")
    private String registrationDate;

    @ApiModelProperty(value="门诊时间")
    private String outpatientTime;

    @ApiModelProperty(value="急诊时间")
    private String emergencyTime;

    @ApiModelProperty(value="0-非定点 1-定点")
    private String fixedPointFlag;

    @ApiModelProperty(value="医院图片")
    private String hospitalImages;

    @ApiModelProperty(value="医院介绍.")
    private String description;

    @ApiModelProperty(value="线上医生数目")
    private Integer onlineDoctorNumber;

    @ApiModelProperty(value="医院科室")
    private List<DepartmentTreeDTO> departments;

    @ApiModelProperty(value="医院医生")
    private List<AppDoctorDTO> doctors;
}
