

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
 * 百科科室表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:05:20
 */
@Data
@TableName("cy_department")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "百科科室表")
public class CyDepartment extends Model<CyDepartment> {

    private static final long serialVersionUID = 1L;

	/**
	 * 科室id
	 */
	@TableId(value ="department_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value="科室id")
	private Long departmentId;

	/**
	 * 科室姓名
	 */
	@ApiModelProperty(value="科室姓名")
	private String departmentName;

	/**
	 * 二级科室父类
	 */
	@ApiModelProperty(value="二级科室父类")
	private Long parentId;

	/**
	 * 科室等级
	 */
	@ApiModelProperty(value="科室等级")
	private Integer departmentLevel;

}
