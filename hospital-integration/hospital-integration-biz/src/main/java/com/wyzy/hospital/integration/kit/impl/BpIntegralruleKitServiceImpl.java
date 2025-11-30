
package com.wyzy.hospital.integration.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.integration.dto.BpIntegralruleDTO;
import com.wyzy.hospital.integration.dto.EveryDayDTO;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.entity.BpIntegralrule;
import com.wyzy.hospital.integration.kit.BpIntegralruleKitService;
import com.wyzy.hospital.integration.mapper.BpIntegralruleMapper;
import com.wyzy.hospital.integration.service.BpIntegralService;
import com.wyzy.hospital.integration.service.BpIntegralruleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BpIntegralruleKitServiceImpl extends ServiceImpl<BpIntegralruleMapper, BpIntegralrule> implements BpIntegralruleKitService {
	private final  BpIntegralruleService bpIntegralruleService;
	private final  BpIntegralService bpIntegralService;
	/**
	 * 每日任务列表
	 * @return R
	 */
	@Override
	public List<EveryDayDTO> getPojoByIsEveryday(Long memberId) {
		/**
		 * 查询任务列表
		 * @return R
		 */
		List<EveryDayDTO> everyDayDTOS = bpIntegralruleService.getPojoByIsEveryday(memberId);
		for (EveryDayDTO everyDayDTO:everyDayDTOS){
			if (everyDayDTO.getNum() == null){
				everyDayDTO.setNum(0);
			}
			/**
			 * 连续签到
			 */
			if (everyDayDTO.getCheckstatus() == 1){
				List<Integer> integralruleList = BpIntegralKitServiceImpl.getIntegralruleList(everyDayDTO.getContinuously());
				Integer continueNumber = getDateNumber(memberId,everyDayDTO.getId());
				Integer integer = integralruleList.get((continueNumber- 1)%7);
				everyDayDTO.setNumber(integer);
			}
		}
		return everyDayDTOS;
	}

	/**
	 * 手机号和签到类型获取连续登陆天数
	 */
	public Integer getDateNumber(Long memberId,Long typeId) {
		/**
		 * 获取系统昨天日期"yyyy-MM-dd"
		 */
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,-24);
		String yesterdayDate=dateFormat.format(calendar.getTime());
		//获取昨天连续登录信息
		BpIntegral bpIntegral = bpIntegralService.getDateNumber(memberId,typeId,yesterdayDate);
		//如果没有连续登录记录，则返回1（初次连续签到）
		if (bpIntegral ==null){
			return 1 ;
		}
		Integer continueNumber;
		/*如果连续签到最新记录为昨天，则返回昨天记录+1*/
		continueNumber = bpIntegral.getContinueNumber();
		continueNumber++;
		return continueNumber;
	}
}
