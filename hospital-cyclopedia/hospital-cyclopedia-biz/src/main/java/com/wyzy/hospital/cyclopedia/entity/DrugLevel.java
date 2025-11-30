

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
 * 药品等级表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:25
 */
@Data
@TableName("drug_level")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药品等级表")
public class DrugLevel extends Model<DrugLevel> {

    private static final long serialVersionUID = 1L;

    /**
     * 药品分类ID
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="药品分类ID")
    private Long id;

    /**
     * 药品分类名
     */
    @ApiModelProperty(value="药品分类名")
    private String drugLevelName;

    /**
     * 父类id
     */
    @ApiModelProperty(value="父类id")
    private Long parentId;

    /**
     *  --等级(0-一级类别   1-二级类别)
     */
    @ApiModelProperty(value=" --等级(0-一级类别   1-二级类别)")
    private Integer levels;




}
