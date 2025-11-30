

package com.wyzy.hospital.hospital.entity;

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
 * 医院表
 *
 * @author aqie
 * @date 2021-04-10 16:15:29
 */
@Data
@TableName("hospitals")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "医院表")
public class Hospitals extends Model<Hospitals> {

    private static final long serialVersionUID = 1L;

    /**
     * 医院ID
     */
    @TableId
    @ApiModelProperty(value="医院ID")
    private Integer id;

    /**
     * 医院名称
     */
    @ApiModelProperty(value="医院名称")
    private String name;

    /**
     * 医院电话
     */
    @ApiModelProperty(value="医院电话")
    private String tel;

    /**
     * 医院等级
     */
    @ApiModelProperty(value="医院等级")
    private String grade;

    /**
     * 工作日挂号时间
     */
    @ApiModelProperty(value="工作日挂号时间")
    private String workdayRegistrationTime;

    /**
     * 周末挂号时间
     */
    @ApiModelProperty(value="周末挂号时间")
    private String weekendRegistrationTime;

    /**
     * 工作日门诊时间
     */
    @ApiModelProperty(value="工作日门诊时间")
    private String workdayOutpatientTime;

    /**
     * 周末门诊时间
     */
    @ApiModelProperty(value="周末门诊时间")
    private String weekendOutpatientTime;

    /**
     * 急诊时间
     */
    @ApiModelProperty(value="急诊时间")
    private String emergencyTime;

    /**
     * 省份
     */
    @ApiModelProperty(value="省份")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty(value="城市")
    private String city;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String address;

    /**
     * 医院图片
     */
    @ApiModelProperty(value="医院图片")
    private String images;

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
     * delFlag
     */
    @ApiModelProperty(value="delFlag")
    private String delFlag;

    /**
     * 特色科室id,逗号分隔
     */
    @ApiModelProperty(value="特色科室id,逗号分隔")
    private String specialDepartments;

    /**
     * 公立医院 1-是 0-否
     */
    @ApiModelProperty(value="公立医院 1-是 0-否")
    private Integer isPublic;

    /**
     * 医院介绍.
     */
    @ApiModelProperty(value="医院介绍.")
    private String description;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime buildTime;

    /**
     * 编码
     */
    @ApiModelProperty(value="编码")
    private String uuid;

    /**
     * 0-医院 1-诊所 2-工作室 3-后台
     */
    @ApiModelProperty(value="0-医院 1-诊所 2-工作室 3-后台")
    private Integer type;

    /**
     * 联系人
     */
    @ApiModelProperty(value="联系人")
    private String contact;

    /**
     * 联系人电话
     */
    @ApiModelProperty(value="联系人电话")
    private String contactPhone;

    /**
     * 销售人
     */
    @ApiModelProperty(value="销售人")
    private String salesman;

    /**
     * 销售人电话
     */
    @ApiModelProperty(value="销售人电话")
    private String salesmanPhone;

    /**
     * 线上医生数目
     */
    @ApiModelProperty(value="线上医生数目")
    private Integer onlineDoctorNumber;

	/**
	 * 医院优势
	 */
	@ApiModelProperty(value="医院优势")
	private String advantage;

	/**
	 * 医院荣誉
	 */
	@ApiModelProperty(value="医院荣誉")
	private String honor;

}
