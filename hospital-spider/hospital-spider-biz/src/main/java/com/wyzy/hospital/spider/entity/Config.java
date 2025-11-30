

package com.wyzy.hospital.spider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 爬虫配置
 *
 * @author aqie
 * @date 2021-06-02 17:34:51
 */
@Data
@TableName("spider_config")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "爬虫配置")
public class Config extends Model<Config> {

    private static final long serialVersionUID = 1L;

    /**
     * 爬虫配置ID
     */
    @TableId
    @ApiModelProperty(value="爬虫配置ID")
    private Integer id;

    /**
     * 爬虫编码 
     */
    @ApiModelProperty(value="爬虫编码 ")
    private String spiderCode;

    /**
     * 爬虫名称 
     */
    @ApiModelProperty(value="爬虫名称 ")
    private String spiderName;

    /**
     * 入口地址
     */
    @ApiModelProperty(value="入口地址")
    private String entryUrls;

    /**
     * 目标URL正则 
     */
    @ApiModelProperty(value="目标URL正则 ")
    private String targetRegex;

    /**
     * 1:级联发现url  0:只从入口页面发现url
     */
    @ApiModelProperty(value="1:级联发现url  0:只从入口页面发现url")
	@TableField("`cascade`")
    private Integer cascade;

    /**
     * 存储的表名 
     */
    @ApiModelProperty(value="存储的表名 ")
    private String tableName;

    /**
     * 网站根域名 
     */
    @ApiModelProperty(value="网站根域名 ")
    private String domain;

    /**
     * 字符集 
     */
    @ApiModelProperty(value="字符集 ")
    private String charset;

    /**
     * 睡眠时间(ms) 
     */
    @ApiModelProperty(value="睡眠时间(ms) ")
    private Integer sleepTime;

    /**
     * 重试次数 
     */
    @ApiModelProperty(value="重试次数 ")
    private Integer retryTimes;

    /**
     * 线程数量 
     */
    @ApiModelProperty(value="线程数量 ")
    private Integer threadCount;

    /**
     * 使用代理 
     */
    @ApiModelProperty(value="使用代理 ")
    private Integer useProxy;

    /**
     * 打印日志 
     */
    @ApiModelProperty(value="打印日志 ")
    private Integer showLog;

}
