

package com.wyzy.hospital.psychology.api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 心理医生服务表
 *
 * @author hospital code generator
 * @date 2021-06-04 15:22:46
 */
@Data
public class ServeDTO {
    /**
     * 服务名称
     */
    @ApiModelProperty(value="服务名称")
    private String serveName;

}
