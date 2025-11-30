

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
 * 功效-标签中间表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:44
 */
@Data
@TableName("effect_tag")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "功效-标签中间表")
public class EffectTag extends Model<EffectTag> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * effectId
     */
    @ApiModelProperty(value="effectId")
    private Long effectId;

    /**
     * tagId
     */
    @ApiModelProperty(value="tagId")
    private Long tagId;

}
