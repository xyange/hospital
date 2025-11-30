

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
 * 药剂表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:18
 */
@Data
@TableName("drug_type")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药剂表")
public class DrugType extends Model<DrugType> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="ID")
    private Long id;

    /**
     * 药剂名称
     */
    @ApiModelProperty(value="药剂名称")
    private String drugTypeName;

    /**
     * 药品等级表cid
     */
    @ApiModelProperty(value="药品等级表cid")
    private Long drugDetailsId;

}
