

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author aqie
 * @date 2021-04-10 10:57:08
 */
@Data
@TableName("area")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Area extends Model<Area> {

    private static final long serialVersionUID = 1L;

    /**
     * 区域ID
     */
    @TableId
    @ApiModelProperty(value="区域ID")
    private Integer id;

    /**
     * 上级区域ID
     */
    @ApiModelProperty(value="上级区域ID")
    private Integer parentId;

    /**
     * 行政区域等级 1-省 2-市 3-区县 4-街道镇
     */
    @ApiModelProperty(value="行政区域等级 1-省 2-市 3-区县 4-街道镇")
    private Integer level;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 完整名称
     */
    @ApiModelProperty(value="完整名称")
    private String wholeName;

    /**
     * 本区域经度
     */
    @ApiModelProperty(value="本区域经度")
    private String lon;

    /**
     * 本区域维度
     */
    @ApiModelProperty(value="本区域维度")
    private String lat;

    /**
     * 电话区号
     */
    @ApiModelProperty(value="电话区号")
    private String cityCode;

    /**
     * 邮政编码
     */
    @ApiModelProperty(value="邮政编码")
    private String zipCode;

    /**
     * 行政区划代码
     */
    @ApiModelProperty(value="行政区划代码")
    private String areaCode;

    /**
     * 名称全拼
     */
    @ApiModelProperty(value="名称全拼")
    private String pinYin;

    /**
     * 首字母简拼
     */
    @ApiModelProperty(value="首字母简拼")
    private String simplePy;

    /**
     * 区域名称拼音的第一个字母
     */
    @ApiModelProperty(value="区域名称拼音的第一个字母")
    private String perPinYin;

}
