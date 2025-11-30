package com.wyzy.hospital.admin.api.dto.hospital;

import com.wyzy.hospital.admin.api.entity.HospitalDepartment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HospitalDepartmentDTO extends HospitalDepartment {
    /**
     * 科室名称
     */
    @ApiModelProperty(value="科室名称")
    private String departmentName;
    /**
     * 科室简介
     */
    @ApiModelProperty(value="科室简介")
    private String introduce;

    /**
     * 科室位置
     */
    @ApiModelProperty(value="科室位置")
    private String position;

    /**
     * 科室照片
     */
    @ApiModelProperty(value="科室照片")
    private String photo;
}
