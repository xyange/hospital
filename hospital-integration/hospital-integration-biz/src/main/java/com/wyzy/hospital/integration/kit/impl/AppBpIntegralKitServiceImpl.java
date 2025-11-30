package com.wyzy.hospital.integration.kit.impl;

import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.integration.dto.AppBpIntegralDTO;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.dto.EveryDayDTO;
import com.wyzy.hospital.integration.kit.AppBpIntegralKitService;
import com.wyzy.hospital.integration.kit.BpIntegralKitService;
import com.wyzy.hospital.integration.kit.BpIntegralruleKitService;
import com.wyzy.hospital.integration.service.BpIntegralService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AppBpIntegralKitServiceImpl implements AppBpIntegralKitService {

	private final BpIntegralruleKitService bpIntegralruleKitService;
	private final BpIntegralService bpIntegralService;

	/**
	 * APP积分
	 */
	@Override
	public AppBpIntegralDTO AppBpIntegralDTO(Long memberId) {
		AppBpIntegralDTO appBpIntegralDTO = new AppBpIntegralDTO();
		/**
		 * 每日任务列表
		 * @return R
		 */
		List<EveryDayDTO> pojoByIsEveryday = bpIntegralruleKitService.getPojoByIsEveryday(memberId);
		if (pojoByIsEveryday == null || pojoByIsEveryday.size() == 0){
			return null;
		}
		appBpIntegralDTO.setEveryDayDTOList(pojoByIsEveryday);
		/**
		 * 收支详情
		 * @return R
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		List<BpIntegralDTO> bpIntegralDTOList = bpIntegralService.revenueExpenditureDetails(memberId, date);
		appBpIntegralDTO.setBpIntegralDTOList(bpIntegralDTOList);
		/**
		 * 积分
		 */
		Integer byId = bpIntegralService.getDeductionByMemberId(memberId);
		appBpIntegralDTO.setIntegral(byId);
		return appBpIntegralDTO;
	}
}
