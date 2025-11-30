package com.wyzy.hospital.admin.api.dto;

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
public class EnMedicineDTO extends EnMedicine {
    @ApiModelProperty(value="疾病对象列表")
    private List<EnDiseases> enDiseasesList;


}
