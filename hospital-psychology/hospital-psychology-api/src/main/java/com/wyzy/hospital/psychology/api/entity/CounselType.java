

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
 * 资讯类型表
 *
 * @author hospital code generator
 * @date 2021-06-11 14:40:23
 */
@Data
@TableName("counsel_type")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "资讯类型表")
public class CounselType extends Model<CounselType> {

    private static final long serialVersionUID = 1L;

    /**
     * counselId
     */
    @TableId
    @ApiModelProperty(value="counselId")
    private Integer counselId;

    /**
     * 咨询类型名称
     */
    @ApiModelProperty(value="咨询类型名称")
    private String counselName;

}
