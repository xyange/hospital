package com.wyzy.hospital.admin.api.dto;

import com.wyzy.hospital.admin.api.entity.EnArticles;
import com.wyzy.hospital.admin.api.entity.EnDiseases;
import com.wyzy.hospital.admin.api.entity.EnMedicine;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2021/4/20  15:46
 */
@Data
public class EnDiseasesDTO extends EnDiseases {

    @ApiModelProperty(value="疾病列表")
    private List<EnArticles> enArticlesList;

    @ApiModelProperty(value="药品列表")
    private List<EnMedicine> enMedicineList;


}
