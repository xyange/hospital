

package com.wyzy.hospital.cyclopedia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

import java.time.LocalDateTime;

/**
 * 制药公司表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:10
 */
@Data
@TableName("cy_compay")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "制药公司表")
public class CyCompay extends Model<CyCompay> {

    private static final long serialVersionUID = 1L;

    /**
     * compayId
     */
    @TableId(value = "compay_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="compayId")
    private Long compayId;

    /**
     * compayName
     */
    @ApiModelProperty(value="compayName")
    private String compayName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;

}
