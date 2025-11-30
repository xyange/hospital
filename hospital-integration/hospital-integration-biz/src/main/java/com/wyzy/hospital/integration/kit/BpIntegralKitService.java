package com.wyzy.hospital.integration.kit;

import com.wyzy.hospital.integration.entity.BpIntegral;

public interface BpIntegralKitService {

	/**
	 * 新增积分表
	 * @param bpIntegral 积分表
	 * @return R
	 */
	boolean saveIntegration(BpIntegral bpIntegral);

	/**
	 * 释放冻结积分
	 * @param phone 释放冻结积分
	 */
	boolean releaseBpIntegral(String phone, Integer obtainIntegral,Long memberId);

	/**
	 * 增减积分
	 * @param phone
	 * @param obtainIntegral
	 * @return R
	 */
	boolean addAndSubtract(String phone, Integer obtainIntegral,Integer type,Long memberId);

	/**
	 * 冻结积分
	 * @param phone
	 * @param obtainIntegral
	 * @return R
	 */
	boolean frozenIntegral(String phone, Integer obtainIntegral,Long memberId);

	/**
	 * 消耗积分规则表
	 * @param phone 用户手机号
	 * @param obtainIntegral 消耗积分
	 * @param orderId 订单号
	 * @return R
	 */
	boolean saveUseByPhone(String phone, Integer obtainIntegral, String orderId,Long memberId);
}
