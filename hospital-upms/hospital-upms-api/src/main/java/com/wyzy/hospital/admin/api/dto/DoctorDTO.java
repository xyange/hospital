package com.wyzy.hospital.admin.api.dto;

import com.wyzy.hospital.admin.api.entity.Doctor;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: DoctorDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/5/26 14:03
 */
@Data
public class DoctorDTO extends Doctor {

    @ApiModelProperty(value="疾病id")
    private Long diseaseId;

    @ApiModelProperty(value="擅长疾病/疾病名字")
    private String diseaseName;

}
