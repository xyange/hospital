package com.wyzy.hospital.admin.api.dto.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 私人医生
 *
 * @author wrk
 * @date 2021/05/26 10:53
 **/
@ApiModel(value = "私人医生服务详细信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivateDoctorServeDTO extends DoctorServeDTO {
    /**
     * 私人医生服务详情
     */
    @ApiModelProperty(value="私人医生服务详情")
    private Map<String,Object> privateDoctor;
}
