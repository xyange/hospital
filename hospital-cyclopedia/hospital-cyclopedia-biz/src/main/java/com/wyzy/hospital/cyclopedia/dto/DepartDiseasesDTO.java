package com.wyzy.hospital.cyclopedia.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/20  15:54
 */
@Data
public class DepartDiseasesDTO {
	/**
	 * id
	 */
	@TableId
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
