

package com.wyzy.hospital.cyclopedia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 轮播图表
 *
 * @author hospital code generator
 * @date 2021-06-07 11:09:07
 */
@Data
@TableName("cy_photo")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "轮播图表")
public class CyPhoto extends Model<CyPhoto> {

    private static final long serialVersionUID = 1L;

    /**
     * photoId
     */
    @TableId
    @ApiModelProperty(value="photoId")
    private Long photoId;

    /**
     * imageName
     */
    @ApiModelProperty(value="imageName")
    private String imageName;

    /**
     * imageSrc
     */
    @ApiModelProperty(value="imageSrc")
    private String imageSrc;

    /**
     * imageCode
     */
    @ApiModelProperty(value="imageCode")
    private Long imageCode;

}
