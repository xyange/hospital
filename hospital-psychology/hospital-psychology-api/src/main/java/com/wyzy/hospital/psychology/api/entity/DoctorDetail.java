

package com.wyzy.hospital.psychology.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 心理医生详情表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:21
 */
@Data
@TableName("doctor_detail")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生详情表")
public class DoctorDetail extends Model<DoctorDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * doctorId
     */
    @ApiModelProperty(value="doctorId")
    private Long doctorId;

    /**
     * 工作（0-咨询师，1-讲师）
     */
    @ApiModelProperty(value="工作（0-咨询师，1-讲师）")
    private Integer job;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 医生详情图片
     */
    @ApiModelProperty(value="医生详情图片")
    private String detailImg;

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
     * 工作室经度
     */
    @ApiModelProperty(value="工作室经度")
    private String workRoomLongitude;

    /**
     * 工作室纬度
     */
    @ApiModelProperty(value="工作室纬度")
    private String workRoomLatitude;

    /**
     * 工作室电话
     */
    @ApiModelProperty(value="工作室电话")
    private String workRoomPhone;

    /**
     * 区域
     */
    @ApiModelProperty(value="区域")
    private String area;

}
