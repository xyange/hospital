

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-15 15:42:23
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
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="医院ID")
    private Long id;

    /**
     * 编码
     */
    @ApiModelProperty(value="编码")
    private String uuid;

    /**
     * 医院名称
     */
    @ApiModelProperty(value="医院名称")
    private String hospitalName;

    /**
     * 医院电话
     */
    @ApiModelProperty(value="医院电话")
    private String hospitalTel;

    /**
     * 挂号时间 (周一、周二)
     */
    @ApiModelProperty(value="挂号时间")
    private String registrationTime;

    /**
     * 挂号具体时间 (08:00 放号)
     */
    @ApiModelProperty(value="挂号具体时间")
    private String registrationDate;

    /**
     * 门诊时间
     */
    @ApiModelProperty(value="门诊时间")
    private String outpatientTime;

    /**
     * 急诊时间
     */
    @ApiModelProperty(value="急诊时间")
    private String emergencyTime;

    /**
     * 省份
     */
    @ApiModelProperty(value="区域")
    private String area;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="经度")
    private String lon;

    @ApiModelProperty(value="纬度")
    private String lat;

    /**
     * 医院图片
     */
    @ApiModelProperty(value="医院图片")
    private String hospitalImages;

    /**
     * 特色科室id,逗号分隔
     */
    @ApiModelProperty(value="特色科室id,逗号分隔")
    private String specialDepartments;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDate buildTime;

    /**
     * 医院性质 0-公立 1-私立
     */
    @ApiModelProperty(value="医院性质 0-公立 1-私立")
    private String natureFlag;

    /**
     * 0-非定点 1-定点
     */
    @ApiModelProperty(value="0-非定点 1-定点")
    private String fixedPointFlag;

    /**
     * 医院等级 0-三级甲等 1-三级乙等
     */
    @ApiModelProperty(value="医院等级 0-三级甲等 1-三级乙等")
    private String gradeFlag;

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
     * 销售人id
     */
    @ApiModelProperty(value="销售人id")
    private Integer salesmanId;

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
     * 医院介绍.
     */
    @ApiModelProperty(value="医院介绍.")
    private String description;

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

    /**
     * 上线时间
     */
    @ApiModelProperty(value="上线时间")
    private LocalDate onlineTime;

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
     * 0:正常 1：删除
     */
    @TableLogic
    @ApiModelProperty(value="0:正常 1：删除")
    private String delFlag;

    /**
     * 0:正常 1：删除
     */
    @ApiModelProperty(value="0:待审核 1:通过 2:未通过")
    private String approve;

    /**
     * 0:正常 1：删除
     */
    @ApiModelProperty(value="0:下线 1：上线")
    private String status;

}
