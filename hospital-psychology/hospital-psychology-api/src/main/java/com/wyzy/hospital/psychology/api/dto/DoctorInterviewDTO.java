

package com.wyzy.hospital.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 心理咨询师访谈
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:52
 */
@Data
public class DoctorInterviewDTO {
    /**
     * 访谈标题
     */
    @ApiModelProperty(value="访谈标题")
    private String interviewTitle;

    /**
     * 访谈内容
     */
    @ApiModelProperty(value="访谈内容")
    private String interviewContent;
}
