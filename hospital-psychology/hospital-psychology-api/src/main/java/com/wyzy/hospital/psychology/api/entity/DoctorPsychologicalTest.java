

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
 * 心理测试
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:37
 */
@Data
@TableName("doctor_psychological_test")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理测试")
public class DoctorPsychologicalTest extends Model<DoctorPsychologicalTest> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Integer id;

    /**
     * 测试名称
     */
    @ApiModelProperty(value="测试名称")
    private String name;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 图片id
     */
    @ApiModelProperty(value="图片id")
    private Integer imgId;

}
