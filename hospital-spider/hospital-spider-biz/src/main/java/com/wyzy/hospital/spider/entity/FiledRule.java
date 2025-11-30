

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
 * 爬虫字段规则
 *
 * @author aqie
 * @date 2021-06-02 17:36:01
 */
@Data
@TableName("spider_filed_rule")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "爬虫字段规则")
public class FiledRule extends Model<FiledRule> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Integer id;

    /**
     * 字段ID 
     */
    @ApiModelProperty(value="字段ID ")
    private String fieldId;

    /**
     * 数据处理规则 
     */
    @ApiModelProperty(value="数据处理规则 ")
    private String processType;

    /**
     * 替换正则
     */
    @ApiModelProperty(value="替换正则")
    private String replacereg;

    /**
     * 替换内容 
     */
    @ApiModelProperty(value="替换内容 ")
    private String replacement;

    /**
     * 截取字符串目标 
     */
    @ApiModelProperty(value="截取字符串目标 ")
    private String substrTarget;

    /**
     * 排序 
     */
    @ApiModelProperty(value="排序 ")
    private Integer sort;

}
