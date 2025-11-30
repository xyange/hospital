package com.wyzy.hospital.admin.api.dto.consult;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: ConsultDTO
 * @Description: 会诊DTO
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/15 15:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultDTO {

    @ApiModelProperty(value="疾病id")
    private Long diseaseId;

    @ApiModelProperty(value="诊疗模式类型id")
    private Long consultType;

}
