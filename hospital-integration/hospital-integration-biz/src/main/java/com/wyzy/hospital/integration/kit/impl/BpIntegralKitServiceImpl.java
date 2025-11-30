package com.wyzy.hospital.integration.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.integration.dto.BpIntegralruleDTO;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.entity.BpIntegralrule;
import com.wyzy.hospital.integration.kit.BpIntegralKitService;
import com.wyzy.hospital.integration.mapper.BpIntegralMapper;
import com.wyzy.hospital.integration.service.BpIntegralService;
import com.wyzy.hospital.integration.service.BpIntegralruleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
public class BpIntegralKitServiceImpl extends ServiceImpl<BpIntegralMapper, BpIntegral> implements BpIntegralKitService {
	private BpIntegralService bpIntegralService;
	private BpIntegralruleService bpIntegralruleService;
	private BpIntegralruleKitServiceImpl bpIntegralruleKitService;

	/**
	 * 新增积分表
	 * @param bpIntegral 积分表
	 * @return R
	 */
	@Override
	public boolean saveIntegration(BpIntegral bpIntegral) {
		/**
		 * 根据积分类型即积分规则ID 在积分规则表中，查询规则表信息信息
		 * TypeId 积分规则ID
		 */
		BpIntegralrule bpIntegralrule = bpIntegralruleService.getById(bpIntegral.getTypeId());
		/**
		 * 积分表添加积分方式名称 IntegralMethod
		 */
		bpIntegral.setTypeName(bpIntegralrule.getIntegralMethod());
		Integer quantityLimit = bpIntegralrule.getQuantityLimit();
		/**
		 * 当日完成数量
		 */
		Integer num = bpIntegralService.selectExecutionTimes(bpIntegral.getTypeId(),bpIntegral.getMemberId());
		if (quantityLimit.equals(num)){
			return false;
		}
		//当积分规则信息中签到方式状态为1时，为连续签到
		if (bpIntegralrule.getCheckstatus()==1){
			//连续签到积分数组
			List<Integer> integralDays = getIntegralruleList(bpIntegralrule.getContinuously());
			//针对连续签到获得积分
			bpIntegral = getContinuity(bpIntegral, bpIntegral.getTypeId(), integralDays);
			bpIntegral.setTypeName("连续"+bpIntegral.getTypeName());
		}else if (bpIntegralrule.getCheckstatus() == 3){
			//当积分规则信息中签到方式状态为3时，为支付积分
			/*支付获取积分比例*/
			double paymentAmount = bpIntegralrule.getPaymentAmount()*0.01;
			/*支付获取最高积分*/
			Integer highestScore = bpIntegralrule.getHighestScore();
			Integer integrationByPay = getIntegrationByPay(paymentAmount, highestScore, bpIntegral.getMonetary());
			if(highestScore<integrationByPay){
				integrationByPay = highestScore;
			}
			bpIntegral.setObtainIntegral(integrationByPay);
		}else {
			bpIntegral.setObtainIntegral(bpIntegralrule.getNumber());
		}
		/*插入过期时间*/
		if (bpIntegralrule.getExpirationRules() == 0){
			//永久有效，有效期设置为120年左右getExpirationTime(120*365)
			bpIntegral.setExpiration(getExpirationTime(120*365));
		} else if (bpIntegralrule.getExpirationRules() == 1){
			//根据日期失效，则传入具体时间
			bpIntegral.setExpiration(bpIntegralrule.getTime());
		} else if (bpIntegralrule.getExpirationRules() == 2){
			//N天以后失效getExpirationTime(N)
			bpIntegral.setExpiration(getExpirationTime(bpIntegralrule.getDays()));
		}
		//新增积分
		boolean returnboolean = bpIntegralService.saveIntegration(bpIntegral);
		return returnboolean;
	}

	/**
	 * 连续签到积分数组
	 * @param continuously id
	 * @return R
	 */
	public static List<Integer> getIntegralruleList(String continuously) {
		//连续签到转化为数组
		String[] split = continuously.split(",");
		List<Integer> integerList = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			integerList.add(Integer.parseInt(split[i]));
		}
		return integerList;
	}

	/**
	 * 获取连续签到应得积分
	 * @param bpIntegral 积分表实体类
	 * @param typeId 积分规则ID
	 * @param integralDays 连续签到积分数组
	 * @return
	 */
	public BpIntegral getContinuity(BpIntegral bpIntegral, Long typeId,List<Integer> integralDays){
		//手机号和签到类型获取连续登陆天数
		//Integer continueNumber = getPastDate(bpIntegral.getPhone(),typeId);
		Integer continueNumber = bpIntegralruleKitService.getDateNumber(bpIntegral.getMemberId(), typeId);
		Integer integer = integralDays.get((continueNumber- 1)%7);
		/*将积分数值赋值给实体类*/
		//积分
		bpIntegral.setObtainIntegral(integer);
		//连续签到天数
		bpIntegral.setContinueNumber(continueNumber);
		return bpIntegral;
	}


	/**
	 * 计算支付方式获得积分
	 * @param paymentAmount 反率
	 * @param highestScore 最高反积分量
	 * @param monetary 消费金额
	 * @return
	 */
	private Integer getIntegrationByPay(double paymentAmount,Integer highestScore,BigDecimal monetary){
		double integration = monetary.doubleValue() * paymentAmount;
		int integral =(int)integration;
		return integral;
	}

	/**
	 * 根据有效天数计算失效日期
	 * */
	private LocalDateTime getExpirationTime(Integer number){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calendar.add(Calendar.DATE, number);
		String three_days_after = sdf.format(calendar.getTime());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(three_days_after,df);
		return ldt;
	}


	/**
	 * 释放冻结积分
	 * @param phone 释放冻结积分
	 * @param obtainIntegral
	 * @return
	 */
	@Override
	public boolean releaseBpIntegral(String phone, Integer obtainIntegral,Long memberId) {
		BpIntegral bpIntegral = new BpIntegral();
		bpIntegral.setPhone(phone);
		bpIntegral.setTypeName("释放积分");
		bpIntegral.setObtainIntegral(obtainIntegral);
		bpIntegral.setFluctuate(2);
		bpIntegral.setMemberId(memberId);
		boolean updateObtainIntegral = bpIntegralService.saveIntegration(bpIntegral);
		if (updateObtainIntegral){
			return true;
		}
		return false;
	}

	/**
	 * 增减积分
	 * @param phone
	 * @param obtainIntegral
	 * @param type
	 */
	@Override
	public boolean addAndSubtract(String phone, Integer obtainIntegral,Integer type,Long memberId) {
		BpIntegral bpIntegral = new BpIntegral();
		bpIntegral.setPhone(phone);
		bpIntegral.setFluctuate(0);
		bpIntegral.setMemberId(memberId);
		if (type == 0){
			bpIntegral.setTypeName("增加积分");
			bpIntegral.setObtainIntegral(obtainIntegral);
			boolean b = bpIntegralService.saveIntegration(bpIntegral);
			return b;
		}else if (type == 1){
			bpIntegral.setTypeName("扣除积分");
			bpIntegral.setObtainIntegral(obtainIntegral*-1);
			boolean b = bpIntegralService.saveIntegration(bpIntegral);
			return b;
		}
		return false;
	}

	/**
	 * 冻结积分
	 * @param phone
	 * @param obtainIntegral
	 * @return
	 */
	@Override
	public boolean frozenIntegral(String phone, Integer obtainIntegral,Long memberId) {
		BpIntegral bpIntegral = new BpIntegral();
		bpIntegral.setPhone(phone);
		/*添加冻结积分*/
		bpIntegral.setFluctuate(2);
		bpIntegral.setTypeName("冻结积分");
		bpIntegral.setObtainIntegral(obtainIntegral*-1);
		bpIntegral.setMemberId(memberId);
		boolean b2 = bpIntegralService.saveIntegration(bpIntegral);
		return b2;
	}

	/**
	 * 消耗积分规则表
	 * @param phone 用户手机号
	 * @param obtainIntegral 消耗积分
	 * @param orderId 订单号
	 * @return R
	 */
	@Override
	public boolean saveUseByPhone(String phone, Integer obtainIntegral, String orderId,Long memberId) {
		BpIntegral bpIntegral = new BpIntegral();
		bpIntegral.setPhone(phone);
		/*添加冻结积分*/
		bpIntegral.setFluctuate(1);
		bpIntegral.setTypeName("消耗积分");
		bpIntegral.setObtainIntegral(obtainIntegral*-1);
		bpIntegral.setMemberId(memberId);
		boolean b2 = bpIntegralService.saveIntegration(bpIntegral);
		return b2;
	}
}
