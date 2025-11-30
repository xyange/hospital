

package com.wyzy.hospital.coupon.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.coupon.dto.UserCouponDTO;
import com.wyzy.hospital.coupon.entity.UserCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@Mapper
public interface UserCouponMapper extends HospitalBaseMapper<UserCoupon> {
List<UserCouponDTO> selectCouponUse(@Param("userId")Long userId,@Param("upIfuse")String upIfuse);

Integer selectLimitNumber(@Param("userId")Long userId,@Param("couponCode")Long couponCode);



}
