

package com.wyzy.hospital.psychology.api.entity;

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
 * 心理分类表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:29
 */
@Data
@TableName("psychology_category")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理分类表")
public class PsychologyCategory extends Model<PsychologyCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @TableId
    @ApiModelProperty(value="分类id")
    private Long categoryId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String categoryName;

    /**
     * 擅长详情
     */
    @ApiModelProperty(value="擅长详情")
    private String adeptDetail;

}
