

package com.wyzy.hospital.pharmacy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 商品品牌表
 *
 * @author aqie
 * @date 2021-04-23 17:40:02
 */
@Data
@TableName("ph_brand")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品品牌表")
public class Brand extends Model<Brand> {

    private static final long serialVersionUID = 1L;

    /**
     * brandId
     */
    @TableId
    @ApiModelProperty(value="brandId")
    private Long brandId;

    /**
     * brandName
     */
    @ApiModelProperty(value="brandName")
    private String brandName;

    /**
     * 品牌图片
     */
    @ApiModelProperty(value="品牌图片")
    private String brandImage;

    /**
     * 是否展示 0否1是
     */
    @ApiModelProperty(value="是否展示 0否1是")
    private Integer isShow;

    /**
     * 品牌描述
     */
    @ApiModelProperty(value="品牌描述")
    private String brandDesc;

    /**
     * 排序 0最前
     */
    @ApiModelProperty(value="排序 0最前")
    private Integer sortOrder;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;

}
