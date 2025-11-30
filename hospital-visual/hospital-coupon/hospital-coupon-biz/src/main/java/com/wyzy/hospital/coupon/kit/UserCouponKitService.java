package com.wyzy.hospital.coupon.kit;

import com.wyzy.hospital.coupon.dto.UserCouponDTO;
import com.wyzy.hospital.coupon.entity.UserCoupon;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/6/9  16:28
 */
public interface UserCouponKitService {

	List<UserCouponDTO>queryCouponUse(Long userId,String upIfuse);

	boolean addUserCoupon(UserCoupon userCoupon);


}
