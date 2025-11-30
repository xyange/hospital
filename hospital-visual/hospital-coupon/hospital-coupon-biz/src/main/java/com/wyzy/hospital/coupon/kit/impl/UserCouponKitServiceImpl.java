package com.wyzy.hospital.coupon.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.coupon.dto.UserCouponDTO;
import com.wyzy.hospital.coupon.entity.UserCoupon;
import com.wyzy.hospital.coupon.exception.GlobalException;
import com.wyzy.hospital.coupon.kit.UserCouponKitService;
import com.wyzy.hospital.coupon.mapper.UserCouponMapper;
import com.wyzy.hospital.coupon.service.PpCouponService;
import com.wyzy.hospital.coupon.service.UserCouponService;
import com.wyzy.hospital.coupon.util.TimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/6/9  16:28
 */
@Service
@AllArgsConstructor
public class UserCouponKitServiceImpl extends ServiceImpl<UserCouponMapper, UserCoupon> implements UserCouponKitService {
	private final UserCouponMapper userCouponMapper;
	private final UserCouponService userCouponService;
	private final PpCouponService ppCouponService;

	@Transactional
	@Override

	public List<UserCouponDTO> queryCouponUse(Long userId, String upIfuse) {
		List<UserCouponDTO> userCouponDTOList = userCouponMapper.selectCouponUse(userId, upIfuse);
		return userCouponDTOList;
	}


	@Transactional
	@Override
	public boolean addUserCoupon(UserCoupon userCoupon) {

		Integer limitNumber = userCouponService.selectLimitNumber(userCoupon.getUserId(), userCoupon.getUpCouponCode());
		Integer limitNum = ppCouponService.queryLimitNum(userCoupon.getUpCouponCode());
		Integer couponUnclaimed = ppCouponService.queryUnclaimedByCode(userCoupon.getUpCouponCode());
		LocalDateTime localDateTime = TimeUtil.utilTime();
		if(limitNumber<limitNum&&couponUnclaimed!=0) {
	       boolean addUserCoupon = userCouponService.save(userCoupon);
	       if(addUserCoupon==true){
			return  ppCouponService.alterCouponReceiveNum(userCoupon.getUpCouponCode());
		   }else{
	       	return false;
		   }
		}else {
			throw new GlobalException(CodeMsg.COUPON_INSERTDATE_ERROR);
		}
	}




}
