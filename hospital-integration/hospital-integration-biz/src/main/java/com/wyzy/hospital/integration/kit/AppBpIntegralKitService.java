package com.wyzy.hospital.integration.kit;

import com.wyzy.hospital.integration.dto.AppBpIntegralDTO;

import java.util.List;

public interface AppBpIntegralKitService {
	/**
	 *
	 * APP积分
	 * @param memberId
	 * @return
	 */
	AppBpIntegralDTO AppBpIntegralDTO(Long memberId);
}
