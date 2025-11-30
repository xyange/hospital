package com.wyzy.hospital.admin.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * App疾病
 *
 * @author wrk
 * @date 2021/05/20 09:09
 **/
@Data
@ApiModel(value = "App疾病")
public class AppDiseaseVO {
    /**
     * 疾病ID
     */
    @ApiModelProperty(value="疾病ID")
    private Integer id;

    /**
     * 疾病名称
     */
    @ApiModelProperty(value="疾病名称")
    private String diseaseName;
}
