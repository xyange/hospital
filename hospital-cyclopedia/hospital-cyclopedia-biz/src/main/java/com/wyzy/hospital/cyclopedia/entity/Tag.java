

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
 * 食物标签
 *
 * @author hospital code generator
 * @date 2021-04-29 08:25:59
 */
@Data
@TableName("tag")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "食物标签")
public class Tag extends Model<Tag> {

    private static final long serialVersionUID = 1L;

    /**
     * tagId
     */
    @TableId(value = "tag_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="tagId")
    private Long tagId;

    /**
     * 标签名称
     */
    @ApiModelProperty(value="标签名称")
    private String tagName;

	/**
	 * 图片
	 */
	@ApiModelProperty(value="图片")
	private String tagImage;


}
