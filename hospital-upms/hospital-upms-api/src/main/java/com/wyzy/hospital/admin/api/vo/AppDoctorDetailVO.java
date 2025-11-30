package com.wyzy.hospital.admin.api.vo;

import com.wyzy.hospital.admin.api.dto.doctor.DoctorAttribution;
import com.wyzy.hospital.admin.api.dto.doctor.DoctorServeDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * appDoctorDetailVo
 *
 * @author wrk
 * @date 2021/05/26 11:32
 **/
@ApiModel(value = "App医生详情")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppDoctorDetailVO {
    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 医生姓名
     */
    @ApiModelProperty(value="医生姓名")
    private String doctorName;

    /**
     * 医生科室id
     */
    @ApiModelProperty(value="医生科室id")
    private Long departmentId;

    /**
     * 医生科室
     */
    @ApiModelProperty(value="医生科室")
    private String department;

    /**
     * 医生职称id
     */
    @ApiModelProperty(value="医生职称id")
    private Integer professionalTitleId;

    /**
     * 医生职称
     */
    @ApiModelProperty(value="医生职称")
    private String professionalTitle;

    /**
     * 医生服务
     */
    @ApiModelProperty(value="医生服务")
    private List<Object> doctorServe;
    /**
     * 医生归属
     */
    @ApiModelProperty(value="医生归属")
    private List<DoctorAttribution> doctorAttribution;

    /**
     * 擅长
     */
    @ApiModelProperty(value="擅长")
    private String adept;


    /**
     * 服务人次
     */
    @ApiModelProperty(value="服务人次")
    private Integer peopleNumber;

    /**
     * 医生头像
     */
    @ApiModelProperty(value="医生头像")
    private String headPictureUrl;

    /**
     * 执业经历
     */
    @ApiModelProperty(value="执业经历")
    private String experience;

    /**
     * 医生寄语
     */
    @ApiModelProperty(value="医生寄语")
    private String wishes;

    /**
     * 医生是否收藏
     */
    @ApiModelProperty(value="医生是否收藏 1 收藏; 0 未收藏")
    private Integer doctorCollect;

}
