package com.wyzy.hospital.psychology.api.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * ClassName: MonthDate<br/>
 * Description: <br/>
 * date: 2021/6/7 14:58<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
@Data
public class MonthDate {
    /**
     * 日期
     */
    @ApiModelProperty(value="日期")
    private String dateTime;

    /**
     * 周日期
     */
    @ApiModelProperty(value="周日期")
    private String week;

    /**
     * 心理医生服务
     */
    @ApiModelProperty(value="心理医生服务")
    private List<String> time;
}
