

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
 * 食物标签中间表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:25
 */
@Data
@TableName("food_tag")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "食物标签中间表")
public class FoodTag extends Model<FoodTag> {

    private static final long serialVersionUID = 1L;

    /**
     * foodTagId
     */
    @TableId(value = "food_tag_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="foodTagId")
    private Long foodTagId;

    /**
     * foodDetailsId
     */
    @ApiModelProperty(value="foodDetailsId")
    private Long foodDetailsId;

    /**
     * tagId
     */
    @ApiModelProperty(value="tagId")
    private Long tagId;

}
