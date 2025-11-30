

package com.wyzy.hospital.spider.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 爬虫字段
 *
 * @author aqie
 * @date 2021-06-02 17:36:13
 */
@Data
@TableName("spider_field")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "爬虫字段")
public class Field extends Model<Field> {

    private static final long serialVersionUID = 1L;

    /**
     * 字段ID
     */
    @TableId
    @ApiModelProperty(value="字段ID")
    private Integer fieldId;

    /**
     * 爬虫配置ID 
     */
    @ApiModelProperty(value="爬虫配置ID ")
    private Integer configId;

    /**
     * 字段 
     */
    @ApiModelProperty(value="字段 ")
    private String field;

    /**
     * 字段名称 
     */
    @ApiModelProperty(value="字段名称 ")
    private String fieldName;

    /**
     * 提取类型 
     */
    @ApiModelProperty(value="提取类型 ")
    private String extractType;

    /**
     * 提取规则 
     */
    @ApiModelProperty(value="提取规则 ")
    private String extractBy;

    /**
     * 常量值
     */
    @ApiModelProperty(value="常量值")
    private String constantValue;

    /**
     * 元素的索引 
     */
    @ApiModelProperty(value="元素的索引 ")
    private String extractIndex;

    /**
     * 处理规则 
     */
    @ApiModelProperty(value="处理规则 ")
    private String processRuleId;

    /**
     * 是否是根据元素取值 
     */
    @ApiModelProperty(value="是否是根据元素取值 ")
    private String extractAttrFlag;

    /**
     * 根据哪个元素取值 
     */
    @ApiModelProperty(value="根据哪个元素取值 ")
    private String extractAttr;

}
