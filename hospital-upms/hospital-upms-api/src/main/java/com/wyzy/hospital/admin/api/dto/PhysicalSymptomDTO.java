package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptom;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: PhysicalSymptomDTO
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/17 10:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhysicalSymptomDTO {

    /**
     * 症状ID
     */
    @TableId
    @ApiModelProperty(value="症状ID")
    private Long id;


    /**
     * 症状名称
     */
    @ApiModelProperty(value="症状名称")
    private String symptomName;

    /**
     * 上一级ID
     */
    @ApiModelProperty(value="上一级ID")
    private Long superiorId;

    /**
     * 子列表
     */
    private List<PhysicalSymptom> children;

}
