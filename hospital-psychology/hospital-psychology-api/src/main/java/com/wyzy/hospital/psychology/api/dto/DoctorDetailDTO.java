

package com.wyzy.hospital.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 线下工作室
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:03
 */
@Data
public class DoctorDetailDTO {


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
}
