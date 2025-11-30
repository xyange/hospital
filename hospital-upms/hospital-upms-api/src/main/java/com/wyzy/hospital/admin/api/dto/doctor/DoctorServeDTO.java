package com.wyzy.hospital.admin.api.dto.doctor;

import com.wyzy.hospital.admin.api.entity.DoctorServe;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 医生服务扩展表
 *
 * @author wrk
 * @date 2021/04/16 16:01
 **/
@ApiModel(value = "医生服务详细信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorServeDTO extends DoctorServe {

    @ApiModelProperty(value="服务名字")
    private String serveName;


    public PrivateDoctorServeDTO createPrivateDoctorServeDTO(DoctorServeDTO doctorServeDTO){
        PrivateDoctorServeDTO privateDoctorServeDTO=new PrivateDoctorServeDTO();
        privateDoctorServeDTO.setServeName(doctorServeDTO.getServeName());
        privateDoctorServeDTO.setDocId(doctorServeDTO.getDocId());
        privateDoctorServeDTO.setServiceId(doctorServeDTO.getServiceId());
        privateDoctorServeDTO.setPrice(doctorServeDTO.getPrice());
        privateDoctorServeDTO.setIncome(doctorServeDTO.getIncome());
        return privateDoctorServeDTO;
    }
}
