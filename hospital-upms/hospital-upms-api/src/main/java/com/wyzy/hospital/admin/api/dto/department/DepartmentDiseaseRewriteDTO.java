package com.wyzy.hospital.admin.api.dto.department;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: DepartmentDiseaseRewriteDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/5/24 17:08
 */
@Data
@NoArgsConstructor
public class DepartmentDiseaseRewriteDTO {

    @ApiModelProperty(value="科室ID")
    private Long fatherId;

    @ApiModelProperty(value="科室名称")
    private String fatherName;

    @ApiModelProperty(value="二级科室集合")
    private List<DepartmentTreeTwoDTO> departmentTreeDTOList;
}
