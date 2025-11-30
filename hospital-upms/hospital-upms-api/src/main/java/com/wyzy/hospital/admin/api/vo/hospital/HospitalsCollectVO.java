package com.wyzy.hospital.admin.api.vo.hospital;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 我收藏的医院VO
 *
 * @author wrk
 * @date 2021/05/25 15:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalsCollectVO {
    @ApiModelProperty(value="医院ID")
    private Long id;

    @ApiModelProperty(value="医院名称")
   private String hospitalName;

    @ApiModelProperty(value="医院等级 0-三级甲等 1-三级乙等")
    private String gradeFlag;

    @ApiModelProperty(value="医院图片")
    private String hospitalImages;

    @ApiModelProperty(value="医院地址")
    private String address;

    @ApiModelProperty(value="挂号具体时间")
    private String registrationDate;

    @ApiModelProperty(value="经度")
    private String lon;
    @ApiModelProperty(value="纬度")
    private String lat;
    @ApiModelProperty(value="距离")
    private Double distance;
}
