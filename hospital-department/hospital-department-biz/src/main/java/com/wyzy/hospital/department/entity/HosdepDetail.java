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

package com.wyzy.hospital.department.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-13 08:30:05
 */
@Data
@TableName("hosdep_detail")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医院科室详情")
public class HosdepDetail extends Model<HosdepDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 科室ID
     */
    @TableId
    @ApiModelProperty(value="科室ID")
    private Integer departmentsId;

    /**
     * 医院ID
     */
    @ApiModelProperty(value="医院ID")
    private Integer hospitalId;

    /**
     * 科长ID
     */
    @ApiModelProperty(value="科长ID")
    private Integer chiefid;

    /**
     * 科室简介
     */
    @ApiModelProperty(value="科室简介")
    private String introduce;

    /**
     * 科室位置
     */
    @ApiModelProperty(value="科室位置")
    private String position;

    /**
     * 科室照片
     */
    @ApiModelProperty(value="科室照片")
    private String photo;

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
