package com.wyzy.hospital.admin.api.dto.department;

import com.wyzy.hospital.admin.api.entity.Departments;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/4/27  9:46
 * @Function:
 */
@Data
@NoArgsConstructor
public class DepartmentSimpleDTO {
    @ApiModelProperty(value="科室ID")
    private Long id;

    @ApiModelProperty(value="科室名称")
    private String departmentName;

    public DepartmentSimpleDTO(Departments departments){
        this.id = departments.getId();
        this.departmentName = departments.getDepartmentName();
    }
}
