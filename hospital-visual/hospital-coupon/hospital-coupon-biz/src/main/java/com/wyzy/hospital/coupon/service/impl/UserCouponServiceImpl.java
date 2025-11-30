
package com.wyzy.hospital.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.coupon.dto.UserCouponDTO;
import com.wyzy.hospital.coupon.entity.UserCoupon;
import com.wyzy.hospital.coupon.mapper.UserCouponMapper;
import com.wyzy.hospital.coupon.service.UserCouponService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@Service
public class UserCouponServiceImpl extends ServiceImpl<UserCouponMapper, UserCoupon> implements UserCouponService {

	@Override
	public List<UserCouponDTO> queryCouponUse(Long userId, String upIfuse) {
		List<UserCouponDTO> userCouponDTOList = baseMapper.selectCouponUse(userId, upIfuse);
		return userCouponDTOList;
	}

	@Override
	public Integer selectLimitNumber(Long userId, Long couponCode) {
		Integer limitNumber = baseMapper.selectLimitNumber(userId, couponCode);
		return limitNumber;
	}


}
