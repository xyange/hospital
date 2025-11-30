package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/20  15:51
 */
@Data
public class CyOneDepartmentDTO {


	/**
	 * 科室id
	 */
	@TableId
	@ApiModelProperty(value="科室id")
	private Long aid;

	/**
	 * 科室姓名
	 */
	@ApiModelProperty(value="科室姓名")
	private String aname;

	/**
	 * 科室等级
	 */
	@ApiModelProperty(value="科室等级")
	private Integer alevel;



	/**
	 * cyDepartmentList
	 */

	private List<CyTwoDepartmentDTO> cyTwoDepartmentDTOList;

}
