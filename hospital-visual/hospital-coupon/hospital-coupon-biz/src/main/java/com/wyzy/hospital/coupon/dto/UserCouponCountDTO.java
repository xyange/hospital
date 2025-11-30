

package com.wyzy.hospital.coupon.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@Data
public class UserCouponCountDTO extends Model<UserCouponCountDTO> {


	/**
	 * 优惠券码
	 */
    private Long upCouponCode;

	/**
	 * 优惠券使用数量
	 */

	private Integer couponUsedNum;

	/**
	 * 优惠券过期数量
	 */

	private Integer couponOverdateNum;

}
