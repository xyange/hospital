

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
 * 科室疾病中间表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:12:34
 */
@Data
@TableName("depart_diseases")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "科室疾病中间表")
public class DepartDiseases extends Model<DepartDiseases> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value = "depart_diseases_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="id")
    private Long departDiseasesId;

    /**
     * 科室表id
     */
    @ApiModelProperty(value="科室表id")
    private Long departDisDeparmentId;

    /**
     * 疾病表id
     */
    @ApiModelProperty(value="疾病表id")
    private Long departDisDiseasesId;

}
