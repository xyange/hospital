

package com.wyzy.hospital.admin.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 行政区划表
 *
 * @author aqie
 * @date 2021-04-10 14:05:23
 */
@Data
@TableName("sys_region")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "行政区划表")
public class Region extends Model<Region> {

    private static final long serialVersionUID = 1L;

    /**
     * 区划编号
     */
    @TableId
    @ApiModelProperty(value="区划编号")
    private String code;

    /**
     * 父区划编号
     */
    @ApiModelProperty(value="父区划编号")
    private String parentCode;

    /**
     * 祖区划编号
     */
    @ApiModelProperty(value="祖区划编号")
    private String ancestors;

    /**
     * 区划名称
     */
    @ApiModelProperty(value="区划名称")
    private String name;

    /**
     * 省级区划编号
     */
    @ApiModelProperty(value="省级区划编号")
    private String provinceCode;

    /**
     * 省级名称
     */
    @ApiModelProperty(value="省级名称")
    private String provinceName;

    /**
     * 市级区划编号
     */
    @ApiModelProperty(value="市级区划编号")
    private String cityCode;

    /**
     * 市级名称
     */
    @ApiModelProperty(value="市级名称")
    private String cityName;

    /**
     * 区级区划编号
     */
    @ApiModelProperty(value="区级区划编号")
    private String districtCode;

    /**
     * 区级名称
     */
    @ApiModelProperty(value="区级名称")
    private String districtName;

    /**
     * 镇级区划编号
     */
    @ApiModelProperty(value="镇级区划编号")
    private String townCode;

    /**
     * 镇级名称
     */
    @ApiModelProperty(value="镇级名称")
    private String townName;

    /**
     * 村级区划编号
     */
    @ApiModelProperty(value="村级区划编号")
    private String villageCode;

    /**
     * 村级名称
     */
    @ApiModelProperty(value="村级名称")
    private String villageName;

    /**
     * 层级
     */
    @ApiModelProperty(value="层级")
    private Integer level;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

}
