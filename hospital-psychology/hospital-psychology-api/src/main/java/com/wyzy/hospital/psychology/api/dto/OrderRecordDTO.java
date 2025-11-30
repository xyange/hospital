package com.wyzy.hospital.psychology.api.dto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName: OrderRecordDTO<br/>
 * Description: <br/>
 * date: 2021/6/8 15:44<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
@Data
public class OrderRecordDTO {

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
     * 线下工作室名字
     */
    @ApiModelProperty(value="线下工作室名字")
    private String workRoomName;

    /**
     * 区域
     */
    @ApiModelProperty(value="区域")
    private String area;


    /**
     * 工作室详细地址
     */
    @ApiModelProperty(value="工作室详细地址")
    private String workRoomAddress;

    /**
     * 日期
     */
    @ApiModelProperty(value="日期")
    private String dateTime;

    /**
     * 时间
     */
    @ApiModelProperty(value="时间")
    private String orderTime;
}
