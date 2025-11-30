package com.wyzy.hospital.coupon.kit;

import com.wyzy.hospital.coupon.dto.AddPpCouponDTO;
import com.wyzy.hospital.coupon.entity.PpCoupon;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/6/9  16:28
 */
public interface PpCouponKitService {

	boolean addPpCouponDTOKitService(AddPpCouponDTO addPpCouponDTO);

	boolean reSubmitKitService(PpCoupon ppCoupon);

}
