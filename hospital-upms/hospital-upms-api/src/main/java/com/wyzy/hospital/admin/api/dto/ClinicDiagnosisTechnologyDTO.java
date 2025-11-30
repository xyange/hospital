package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: ClinicDiagnosisTechnology
 * @Description: 诊疗技术类
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/5/15 11:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicDiagnosisTechnologyDTO {

    /**
     * 诊疗项目id
     */
    @TableId
    @ApiModelProperty(value="诊疗项目id")
    private Long diagnosisId;

    /**
     * 诊疗项目名
     */
    @ApiModelProperty(value="诊疗项目名")
    private String diagnosisName;

    /**
     * 诊疗方案
     */
    @ApiModelProperty(value="诊疗方案")
    private String diagnosisProgramme;

    /**
     * 诊疗图片
     */
    @ApiModelProperty(value="诊疗图片")
    private String diagnosisPicture;
    
    /**
     * 诊所id
     */
    @ApiModelProperty(value="诊所id")
    private Long clinicId;

    /**
     * 技术详情列表
     */
    @ApiModelProperty(value="技术详情列表")
    private List<ClinicTechnologyDetails> clinicTechnologyDetails;

    /**
     * 是否是特色项目（0-不是，1-是）
     */
    @ApiModelProperty(value="是否是特色项目（0-不是，1-是）")
    private String isCharacteristic;
}
