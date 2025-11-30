package com.wyzy.hospital.integration.kit;

import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.dto.BpIntegralruleDTO;
import com.wyzy.hospital.integration.dto.EveryDayDTO;

import java.util.List;

/**
 * 积分规则表
 *
 * @author hospital code generator
 * @date 2021-05-10 11:18:22
 */
public interface BpIntegralruleKitService {

	/**
	 * 每日任务列表
	 * @return R
	 */
	List<EveryDayDTO> getPojoByIsEveryday(Long memberId);
}
