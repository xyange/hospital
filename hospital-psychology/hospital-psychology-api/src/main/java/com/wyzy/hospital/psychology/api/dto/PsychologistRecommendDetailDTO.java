package com.wyzy.hospital.psychology.api.dto;

import com.wyzy.hospital.psychology.api.entity.MonthDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 名师详情
 *
 * @author wrk
 * @date 2021/05/07 16:38
 **/
@ApiModel(value = "app名师详情")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsychologistRecommendDetailDTO {
    /**
     * 医生ID
     */
    @ApiModelProperty(value="医生ID")
    private Long doctorId;

    /**
     * 医生名称
     */
    @ApiModelProperty(value="医生名称")
    private String doctorName;

    /**
     * 医生手机号
     */
    @ApiModelProperty(value="医生手机号")
    private String phone;

    /**
     * 医生头像
     */
    @ApiModelProperty(value="医生头像")
    private String avatar;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 职位
     */
    @ApiModelProperty(value="职位")
    private String job;

    /**
     * 从业年限
     */
    @ApiModelProperty(value="从业年限")
    private String workYears;

    /**
     * 区域
     */
    @ApiModelProperty(value="区域")
    private String area;

    /**
     * 心理医生服务
     */
    @ApiModelProperty(value="心理医生服务")
    private List<ServeDTO> serveDTOList;

    /**
     * 咨询类型名称
     */
    @ApiModelProperty(value="咨询类型名称")
    private List<CounselTypeDTO> counselTypeDTOList;

    /**
     * 荣誉称号
     */
    @ApiModelProperty(value="荣誉称号")
    private List<DoctorHonorDTO> doctorHonorDTOList;

    /**
     * 心理分类名称
     */
    @ApiModelProperty(value="心理分类名称")
    private List<categoryAndIntroduceDTO> categoryAndIntroduceDTOList;


    /**
     * 教育与培训
     */
    @ApiModelProperty(value="教育与培训")
    private List<DoctorTrainingDTO> doctorTrainingDTOList;


    /**
     * 荣誉称号
     */
    @ApiModelProperty(value="荣誉称号")
    private List<DoctorInterviewDTO> doctorInterviewDTOList;


    /**
     * 咨询时长（min）
     */
    @ApiModelProperty(value="咨询时长（min）")
    private Integer timeLength;

    /**
     * 线下工作室名字
     */
    @ApiModelProperty(value="线下工作室名字")
    private String workRoomName;

    /**
     * 线下工作室图片
     */
    @ApiModelProperty(value="线下工作室图片")
    private String workRoomImg;

    /**
     * 工作室详细地址
     */
    @ApiModelProperty(value="工作室详细地址")
    private String workRoomAddress;

    /**
     * 工作室电话
     */
    @ApiModelProperty(value="工作室电话")
    private String workRoomPhone;

    /**
     * 预约时间
     */
    @ApiModelProperty(value="预约时间")
    private List<MonthDate> monthDateList;
}
