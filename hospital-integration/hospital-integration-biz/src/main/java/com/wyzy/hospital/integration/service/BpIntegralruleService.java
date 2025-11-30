

package com.wyzy.hospital.integration.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.integration.dto.BpIntegralruleDTO;
import com.wyzy.hospital.integration.dto.EveryDayDTO;
import com.wyzy.hospital.integration.entity.BpIntegralrule;

import java.util.List;

/**
 * 积分规则表
 *
 * @author hospital code generator
 * @date 2021-05-10 11:18:22
 */
public interface BpIntegralruleService extends IService<BpIntegralrule> {

	/**
	 * 新增积分规则表
	 * @param bpIntegralrule 积分规则表
	 * @return R
	 */
	boolean saveBpIntegralrule(BpIntegralrule bpIntegralrule);

	/**
	 * 通过id查询积分规则表信息
	 * @param id id
	 * @return R
	 */
	BpIntegralruleDTO getBpIntegralruleById(Long id);

	/**
	 * 修改每日任务
	 * @return R
	 */
	boolean isEveryday(Long id,Integer isEveryday);

	/**
	 * 查询任务列表
	 * @return R
	 */
	List<EveryDayDTO> getPojoByIsEveryday(Long memberId);

	/**
	 * 获取抵扣状态及抵扣配置
	 * @return
	 */
	BpIntegralrule selectNewestState();
}
