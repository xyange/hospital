

package com.wyzy.hospital.psychology.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 心理分类表
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:48
 */
@Data
public class categoryAndIntroduceDTO {
    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String categoryName;

    /**
     * 分类介绍
     */
    @ApiModelProperty(value="分类介绍")
    private String adeptDetail;
}
