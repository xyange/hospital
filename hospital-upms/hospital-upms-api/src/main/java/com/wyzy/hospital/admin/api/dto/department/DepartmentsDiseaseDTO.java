package com.wyzy.hospital.admin.api.dto.department;

import com.wyzy.hospital.admin.api.entity.Disease;
import lombok.Data;

import java.util.List;

/**
 * 科室疾病实体类
 *
 * @author wrk
 * @date 2021/05/08 17:21
 **/
@Data
public class DepartmentsDiseaseDTO {
    private Long departmentId;
    private String departmentName;
    private String departmentImage;
    private List<Disease> diseaseList;
}
