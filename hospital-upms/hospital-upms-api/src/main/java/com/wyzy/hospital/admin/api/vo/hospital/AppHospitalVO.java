package com.wyzy.hospital.admin.api.vo.hospital;

import com.wyzy.hospital.admin.api.dto.hospital.AppHospitalDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/5/19  14:58
 * @Function:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppHospitalVO {
    @ApiModelProperty(value="医院ID")
    private Long id;

    @ApiModelProperty(value="医院名称")
    private String hospitalName;

    @ApiModelProperty(value="医院电话")
    private String hospitalTel;

    @ApiModelProperty(value="挂号时间")
    private String registrationTime;

    @ApiModelProperty(value="挂号具体时间")
    private String registrationDate;

    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="医院等级 0-三级甲等 1-三级乙等")
    private String gradeFlag;

    @ApiModelProperty(value="线上医生数目")
    private Integer onlineDoctorNumber;

    @ApiModelProperty(value="医院性质 0-公立 1-私立")
    private String natureFlag;


    @ApiModelProperty(value="0-非定点 1-定点")
    private String fixedPointFlag;

    @ApiModelProperty(value="医院图片")
    private String hospitalImages;

    public AppHospitalVO(AppHospitalDTO dto) {
        this.id = dto.getId();
        this.hospitalName = dto.getHospitalName();
        this.hospitalTel = dto.getHospitalTel();
        this.registrationTime = dto.getRegistrationTime();
        this.registrationDate = dto.getRegistrationDate();
        this.address = dto.getAddress();
        this.gradeFlag = dto.getGradeFlag();
        this.onlineDoctorNumber = dto.getOnlineDoctorNumber();
        this.natureFlag = dto.getNatureFlag();
        this.fixedPointFlag = dto.getFixedPointFlag();
        this.hospitalImages = dto.getHospitalImages();
    }

}
