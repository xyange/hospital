

package com.wyzy.hospital.coupon.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.coupon.dto.PpCouponDTO;
import com.wyzy.hospital.coupon.entity.PpCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-09 11:36:41
 */
@Mapper
public interface PpCouponMapper extends HospitalBaseMapper<PpCoupon> {



//可上线优惠券

	List<PpCouponDTO>selectUseCoupon();


	List<PpCouponDTO> selectCouponAduit(IPage<PpCouponDTO> page);

	void updateCouponAduitStruts(@Param("couponId")Long couponId, @Param("couponAduitStruts")String couponAduitStruts);

	//条件查询后台根据优惠券类型，名称

	List<PpCouponDTO>byConditionAuditCoupon(IPage<PpCouponDTO> page,
											@Param("couponType")String couponType,
											@Param("couponName")String couponName );

	//优惠券列表(后台)

	List<PpCouponDTO>selectCouponTable(IPage<PpCouponDTO> page);

	//上下线

	boolean updateCouponExistStruts(@Param("couponId")Long couponId, @Param("couponExistStruts")String couponExistStruts);

	//优惠审核列表(条件查询)

	List<PpCouponDTO>ConditionCouponTable(IPage<PpCouponDTO> page,
										  @Param("couponType")String couponType,
										  @Param("couponGrantStruts")String couponGrantStruts,
										  @Param("couponName")String couponName);

	//查优惠券名字

	String selectCouponName(String couponName);

	//根据优惠券码查优惠券

	List<PpCoupon> queryCouponByCode(Long couponCode);

	//优惠券审核列表

	List<PpCouponDTO>selectCouponAuditTable(IPage<PpCouponDTO> page);

	//优惠券审核列表（条件查询）

	List<PpCouponDTO>ConditionCouponAduitTable(IPage<PpCouponDTO> page,
											   @Param("couponType")String couponType,
											   @Param("couponAduitStruts")String couponAduitStruts,
											   @Param("couponName")String couponName);

	//查看优惠券审核原因

	String selectAduitCause(Long couponId);


	//添加审核原因

	boolean addAduitCause(@Param("couponId")Long couponId, @Param("couponAduitCause")String couponAduitCause);

	//优惠券先领数量

	Integer selectLimitNum(Long couponCode);

	//修改优惠券已领取数量根据用户领取情况

	boolean updateCouponReceiveNum(@Param("couponCode")Long couponCode);

	//查看优惠券库存

	Integer selectUnclaimedByCode( Long couponCode);


}
