package com.wyzy.hospital.admin.api.dto.department;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class DepartmentTreeTwoDTO {
    @ApiModelProperty(value="科室ID")
    private Long sonId;

    @ApiModelProperty(value="科室名称")
    private String sonName;

    @ApiModelProperty(value="疾病集合")
    private List<DiseaseDTO> diseaseList;

}
