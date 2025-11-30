

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
 * 心理医生服务表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:07
 */
@Data
@TableName("serve")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "心理医生服务表")
public class Serve extends Model<Serve> {

    private static final long serialVersionUID = 1L;

    /**
     * 服务id
     */
    @TableId
    @ApiModelProperty(value="服务id")
    private Long serveId;

    /**
     * 服务名称
     */
    @ApiModelProperty(value="服务名称")
    private String serveName;

}
