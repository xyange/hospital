package com.wyzy.hospital.integration.dto;
import com.wyzy.hospital.integration.entity.BpIntegral;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
@Data
public class AppBpIntegralDTO {

	/**
	 * 积分
	 */
	@ApiModelProperty(value="积分")
	Integer integral;

	/**
	 * 每日任务
	 */
	@ApiModelProperty(value="每日任务")
	List<EveryDayDTO> everyDayDTOList;

	/**
	 * 收支详情
	 */
	@ApiModelProperty(value="收支详情")
	List<BpIntegralDTO> bpIntegralDTOList;
}
