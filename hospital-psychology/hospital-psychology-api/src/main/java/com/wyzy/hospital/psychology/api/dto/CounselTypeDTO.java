

package com.wyzy.hospital.psychology.api.dto;

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
 * @author hospital code generator
 * @date 2021-06-04 15:22:24
 */
@Data
public class CounselTypeDTO {
    /**
     * 咨询类型名称
     */
    @ApiModelProperty(value="咨询类型名称")
    private String counselName;

}
