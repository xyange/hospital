

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
 * 爬虫任务
 *
 * @author aqie
 * @date 2021-06-02 17:35:48
 */
@Data
@TableName("spider_mission")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "爬虫任务")
public class Mission extends Model<Mission> {

    private static final long serialVersionUID = 1L;

    /**
     * 爬虫任务ID
     */
    @TableId
    @ApiModelProperty(value="爬虫任务ID")
    private Integer missionId;

    /**
     * 任务名称 
     */
    @ApiModelProperty(value="任务名称 ")
    private String missionName;

    /**
     * 爬虫配置ID
     */
    @ApiModelProperty(value="爬虫配置ID")
    private Integer spiderConfigId;

    /**
     * 入口地址
     */
    @ApiModelProperty(value="入口地址")
    private String entryUrls;

    /**
     * 任务状态 
     */
    @ApiModelProperty(value="任务状态 ")
    private String status;

    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间")
    private LocalDateTime endTime;

    /**
     * 爬取时间(单位秒)
     */
    @ApiModelProperty(value="爬取时间(单位秒)")
    private String timeCost;

    /**
     * 退出方式。DEFAULT，DURATION，URL_COUNT。
     */
    @ApiModelProperty(value="退出方式。DEFAULT，DURATION，URL_COUNT。")
    private String exitWay;

    /**
     * 退出方式值
     */
    @ApiModelProperty(value="退出方式值")
    private Integer exitWayCount;

    /**
     * 爬取数量
     */
    @ApiModelProperty(value="爬取数量")
    private Integer successNum;

    /**
     * cookieStr
     */
    @ApiModelProperty(value="cookieStr")
    private String cookieStr;

    /**
     * headerStr
     */
    @ApiModelProperty(value="headerStr")
    private String headerStr;

    /**
     * 部门ID
     */
    @ApiModelProperty(value="部门ID")
    private String deptId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value="用户ID")
    private String userId;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createBy;

    /**
     * createTime
     */
    @ApiModelProperty(value="createTime")
    private LocalDateTime createTime;

}
