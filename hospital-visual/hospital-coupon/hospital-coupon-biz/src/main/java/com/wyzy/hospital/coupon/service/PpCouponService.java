

package com.wyzy.hospital.coupon.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.coupon.dto.PpCouponDTO;
import com.wyzy.hospital.coupon.entity.PpCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-09 11:36:41
 */
public interface PpCouponService extends IService<PpCoupon> {

	//可上线优惠券

	List<PpCouponDTO>queryUseCoupon();

	//查看优惠券后台审核

	List<PpCouponDTO> queryCouponAduit(IPage<PpCouponDTO> page);

	//后台优惠券状态

	void alterCouponAduitStruts(Long couponId,String couponAduitStruts);

	//条件查询后台根据优惠券类型，名称

	List<PpCouponDTO>selectConditionAuditCoupon(IPage<PpCouponDTO> page, String couponType, String couponName);

	//优惠券列表(后台)

	List<PpCouponDTO>queryCouponTable(IPage<PpCouponDTO> page);

	//上下线

	boolean alterCouponExistStruts(@Param("couponId")Long couponId, @Param("couponExistStruts")String couponExistStruts);

	//优惠审核列表(条件查询)

	List<PpCouponDTO>selectConditionCouponTable(IPage<PpCouponDTO> page, String couponType, String couponGrantStruts, String couponName);

	//查优惠券名字

	String queryCouponName(String couponName);

   //根据优惠券码查优惠券

	List<PpCoupon> queryCouponByCode(Long couponCode);

	//优惠券审核列表

	List<PpCouponDTO>queryCouponAuditTable(IPage<PpCouponDTO> page);

	//优惠券审核列表（条件查询）

	List<PpCouponDTO>SeeConditionCouponAduitTable(IPage<PpCouponDTO> page,String couponType, String couponAduitStruts, String couponName);

	//查看优惠券审核原因

	String queryAduitCause(Long couponId);

	//添加审核原因

	boolean insertAduitCause(@Param("couponId")Long couponId, @Param("couponAduitCause")String couponAduitCause);

	//优惠券限领数量

	Integer queryLimitNum(Long couponCode);

	//修改优惠券已领取数量根据用户领取情况

	boolean alterCouponReceiveNum(@Param("couponCode")Long couponCode);

	//查看优惠券库存

	Integer queryUnclaimedByCode(Long couponCode);

}
