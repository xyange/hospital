

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

/**
 * 功效表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:13
 */
@Data
@TableName("effect")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "功效表")
public class Effect extends Model<Effect> {

    private static final long serialVersionUID = 1L;

    /**
     * effectId
     */
    @TableId(value = "effect_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="effectId")
    private Long effectId;

    /**
     * effectName
     */
    @ApiModelProperty(value="effectName")
    private String effectName;


}
