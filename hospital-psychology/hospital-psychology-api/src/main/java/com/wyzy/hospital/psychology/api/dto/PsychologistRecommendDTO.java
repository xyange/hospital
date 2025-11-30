package com.wyzy.hospital.psychology.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 推荐心理医生
 *
 * @author wrk
 * @date 2021/05/07 16:07
 **/
@ApiModel(value = "app推荐心理医生")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsychologistRecommendDTO {

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
     * 区域
     */
    @ApiModelProperty(value="区域")
    private String area;

    /**
     * 从业年限
     */
    @ApiModelProperty(value="从业年限")
    private String workYears;

    /**
     * 荣誉称号
     */
    @ApiModelProperty(value="荣誉称号")
    private List<DoctorHonorDTO> doctorHonorDTOList;

    /**
     * 心理分类名称
     */
    @ApiModelProperty(value="心理分类名称")
    private List<PsychologyCategoryDTO> psychologyCategoryDTOList;

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

}
