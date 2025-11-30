/*
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author:  wyzy
 */

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 科室表
 *
 * @author hospital code generator
 * @date 2021-04-12 13:56:39
 */
@Data
@TableName("departments")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "科室表")
public class Departments extends Model<Departments> {

    private static final long serialVersionUID = 1L;

    /**
     * 科室ID
     */
    @TableId
    @ApiModelProperty(value="科室ID")
    private Long id;

    /**
     * 科室名称
     */
    @ApiModelProperty(value="科室名称")
    private String departmentName;

    /**
     * 上一级科室ID
     */
    @ApiModelProperty(value="上一级科室ID")
    private Long superiorId;

    /**
     * 子科室个数
     */
    @ApiModelProperty(value="子科室个数")
    private Integer departmentNumber;

    @ApiModelProperty(value="科室图片")
    private String departmentImage;

    @ApiModelProperty(value="科室标签")
    private String noselectedImage;

    @ApiModelProperty(value="科室简介")
    private String description;

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

    /**
     * 状态, 1正常，0失效
     */
    @ApiModelProperty(value="状态, 0正常 1删除")
    private Integer delFlag;

    /**
     * 是否显示在app医生页
     */
    @ApiModelProperty(value="是否显示在app医生页 0 不显示，1 显示")
    private Integer showOnDoctor;



    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

}
