

package com.wyzy.hospital.coupon.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.List;

/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@Data
public class UserCouponDTO extends Model<UserCouponDTO> {

    private static final long serialVersionUID = 1L;

    /**
     * upId
     */
    private Long upId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户使用优惠券状态012
     */
    private String upIfuse;

    /**
     * 优惠券ID
     */
    private Long upCouponCode;

	/**
	 * 优惠券ID
	 */
	private String nickname;

	/**
	 * 优惠券集合
	 */
	private List<PpCouponDTO>ppCouponDTOList;

}
