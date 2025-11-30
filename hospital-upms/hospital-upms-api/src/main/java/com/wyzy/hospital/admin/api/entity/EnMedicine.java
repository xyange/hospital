

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 药品表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:35
 */
@Data
@TableName("en_medicine")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药品表")
public class EnMedicine extends Model<EnMedicine> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value="ID")
    private Long id;

    /**
     * 药品名称
     */
    @ApiModelProperty(value="药品名称")
    private String medicineName;

    /**
     * 疾病id
     */
    @ApiModelProperty(value="疾病id")
    private Integer diseaseId;

    /**
     * 病例概述
     */
    @ApiModelProperty(value="病例概述")
    private String content;

    /**
     * 适应症状
     */
    @ApiModelProperty(value="适应症状")
    private String indications;

    /**
     * 用法用量
     */
    @ApiModelProperty(value="用法用量")
    private String takeMethod;

    /**
     * 注意事项
     */
    @ApiModelProperty(value="注意事项")
    private String medicineHint;

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

}
