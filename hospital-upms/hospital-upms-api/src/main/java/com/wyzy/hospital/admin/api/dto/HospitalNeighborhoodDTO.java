package com.wyzy.hospital.admin.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 本地附近 医院
 *
 * @author wrk
 * @date 2021/05/20 17:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalNeighborhoodDTO {
    @ApiModelProperty(value="医院id")
    private Long hospitalId;
    @ApiModelProperty(value="医院名称")
    private String hospitalName;
    @ApiModelProperty(value="医院图标")
    private String hospitalIcon;

    @ApiModelProperty(value="医院地址")
    private String address;

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
