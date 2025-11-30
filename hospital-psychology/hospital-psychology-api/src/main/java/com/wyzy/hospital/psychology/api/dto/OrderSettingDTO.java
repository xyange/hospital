package com.wyzy.hospital.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 *
 * @author hospital code generator
 * @date 2021-06-04 15:21:56
 */
@Data
public class OrderSettingDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Long orderId;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long doctorId;

    /**
     * 预约时间
     */
    @ApiModelProperty(value="预约时间")
    private String orderTime;

    /**
     * 预约日期
     */
    @ApiModelProperty(value="预约日期")
    private String dateTime;
}
