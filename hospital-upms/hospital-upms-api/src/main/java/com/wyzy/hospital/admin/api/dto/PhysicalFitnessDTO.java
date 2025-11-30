

package com.wyzy.hospital.admin.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 身体管理体能
 *
 * @author hospital code generator
 * @date 2021-06-16 15:13:44
 */
@Data
public class PhysicalFitnessDTO {
    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long memberId;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 年纪
     */
    @ApiModelProperty(value="年纪")
    private Integer age;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String sex;

    /**
     * 身高
     */
    @ApiModelProperty(value="身高")
    private Float height;

    /**
     * 体重
     */
    @ApiModelProperty(value="体重")
    private Float weight;

    /**
     * 体脂率
     */
    @ApiModelProperty(value="体脂率")
    private Float bodyFat;

}
