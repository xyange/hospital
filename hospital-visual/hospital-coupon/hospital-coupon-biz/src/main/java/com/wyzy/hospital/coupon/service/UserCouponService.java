

package com.wyzy.hospital.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.coupon.dto.UserCouponDTO;
import com.wyzy.hospital.coupon.entity.UserCoupon;

import java.util.List;

/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
public interface UserCouponService extends IService<UserCoupon> {

	List<UserCouponDTO> queryCouponUse(Long userId, String upIfuse);

	//查询用户领取优惠券数量

	Integer selectLimitNumber(Long userId,Long couponCode);

}
