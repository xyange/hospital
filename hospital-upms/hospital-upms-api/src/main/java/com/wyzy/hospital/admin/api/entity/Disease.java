

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-19 13:45:04
 */
@Data
@TableName("disease")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "疾病表")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Disease extends Model<Disease> {

    private static final long serialVersionUID = 1L;

    /**
     * 疾病ID
     */
    @TableId
    @ApiModelProperty(value="疾病ID")
    private Integer id;

    /**
     * 疾病名称
     */
    @ApiModelProperty(value="疾病名称")
    private String diseaseName;

    /**
     * 是否常见
     */
    @ApiModelProperty(value="是否常见  0 不常见 ，1 常见 ")
    private Integer common;
    /**
     * 是否显示在医生页
     */
    @ApiModelProperty(value="是否显示在医生页 0 不显示，1 显示")
    private Integer showOnDoctor;

    /**
     * 是否显示在医生页
     */
    @ApiModelProperty(value="是否显示在app患者端本地附近 0 不显示，1 显示")
    private Integer showOnNeighborhood;

    /**
     * 严重程度（0-100）
     */
    @ApiModelProperty(value="严重程度（0-100）")
    private String severity;

    /**
     * 排序码
     */
    @ApiModelProperty(value="排序码")
    private String sortCode;




    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;




}
