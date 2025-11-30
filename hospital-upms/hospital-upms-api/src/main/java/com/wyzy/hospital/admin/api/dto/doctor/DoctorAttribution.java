package com.wyzy.hospital.admin.api.dto.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 医生归属
 *
 * @author wrk
 * @date 2021/05/11 11:07
 **/
@ApiModel(value = "医生归属")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAttribution {

    /**
     * 归属机构名称
     */
    @ApiModelProperty(value="归属机构名称")
    private Long attributionId;
    /**
     * 归属类型
     */
    @ApiModelProperty(value="归属于哪个租户（医院，诊所，个人）")
    private Integer attributionTypeId;

    /**
     * 归属类型
     */
    @ApiModelProperty(value="归属类型（医院，诊所，个人）字典表")
    private String attributionType;

    /**
     * 归属机构级别
     */
    @ApiModelProperty(value="归属机构级别 医院等级 0-三级甲等 1-三级乙等 2-二级甲等")
    private String organizationGrade;
    /**
     * 归属机构名称
     */
    @ApiModelProperty(value="归属机构名称")
    private String attributionName;

}
