package com.wyzy.hospital.admin.api.dto;

import com.wyzy.hospital.admin.api.entity.ClinicDiagnosis;
import com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Title: ClinicDiagTechDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/5/29 16:48
 */
@Data
public class ClinicDiagTechDTO {
    /**
     * 诊疗技术集合
     */
    @ApiModelProperty(value="诊疗项目集合")
    private List<ClinicDiagnosis> clinicDiagnosisList;
    /**
     * 诊所id
     */
    @ApiModelProperty(value="诊疗技术集合")
    private List<ClinicTechnologyDetails> clinicTechnologyDetails;
}
