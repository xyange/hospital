

package com.wyzy.hospital.coupon.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wyzy.hospital.coupon.entity.PpCoupon;
import com.wyzy.hospital.coupon.entity.UserCoupon;
import lombok.Data;

/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@Data
public class addUserCouponDTO extends Model<addUserCouponDTO> {

private UserCoupon userCoupon;
private PpCoupon ppCoupon;

}
