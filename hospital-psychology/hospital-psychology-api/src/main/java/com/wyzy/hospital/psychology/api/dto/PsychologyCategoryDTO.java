

package com.wyzy.hospital.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 心理分类表
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:48
 */
@Data
public class PsychologyCategoryDTO {
    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String categoryName;

}
