package com.wyzy.hospital.admin.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author aqie
 * Date on 2021/4/20  11:22
 * @Function:
 */
@Data
public class DepartmentDetailDTO {

    private Integer id;
    @ApiModelProperty(value="上级科室名")
    private String superiorName;
    @ApiModelProperty(value="科室名字")
    private String departmentName;
    @ApiModelProperty(value="医院名字")
    private String hospitalName;
}
