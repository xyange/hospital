package com.wyzy.hospital.admin.api.dto.department;

import com.wyzy.hospital.admin.api.entity.Departments;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/27  16:51
 * @Function:
 */
@Data
public class DepartmentTreeDTO {
    @ApiModelProperty(value="科室ID")
    private Long id;

    @ApiModelProperty(value="科室名称")
    private String departmentName;

    @ApiModelProperty(value="上一级科室ID")
    private Long superiorId;

    @ApiModelProperty(value="科室图片")
    private String departmentImage;

    @ApiModelProperty(value="科室标签")
    private String noselectedImage;

    @ApiModelProperty(value="排序 0在前")
    private Integer sort;

    private List<DepartmentTreeDTO> childs;

    public DepartmentTreeDTO(Departments departments){
        this.id = departments.getId();
        this.departmentName = departments.getDepartmentName();
        this.superiorId = departments.getSuperiorId();
        this.departmentImage = departments.getDepartmentImage();
        this.sort = departments.getSort();
        this.noselectedImage = departments.getNoselectedImage();
    }
}
