package com.wyzy.hospital.admin.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 本地附近 诊所
 *
 * @author wrk
 * @date 2021/05/19 14:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicNeighborhoodDTO {
    @ApiModelProperty(value="诊所id")
    private Long clinicId;
    @ApiModelProperty(value="诊所名称")
    private String clinicTitle;
    @ApiModelProperty(value="诊所图标")
    private String introduceIcon;
    @ApiModelProperty(value="诊疗项目")
    private String diagnosisNames;
    @ApiModelProperty(value="科室")
    private String deportments;
    @ApiModelProperty(value="区域名称")
    private String areaName;
    @ApiModelProperty(value="距离")
    private Double distance;
    @ApiModelProperty(value="经度")
    private Double longitude;
    @ApiModelProperty(value="纬度")
    private Double latitude;
}
