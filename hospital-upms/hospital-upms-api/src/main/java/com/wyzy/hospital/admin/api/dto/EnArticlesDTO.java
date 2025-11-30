package com.wyzy.hospital.admin.api.dto;

import com.wyzy.hospital.admin.api.entity.EnDiseases;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2021/4/20  15:46
 */
@Data
public class EnArticlesDTO extends EnDiseases {
    @ApiModelProperty(value="疾病列表")
    private List<EnDiseases> enDiseasesList;


}
