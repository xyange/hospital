package com.wyzy.hospital.coupon.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.coupon.dto.AddPpCouponDTO;
import com.wyzy.hospital.coupon.entity.PpCoupon;
import com.wyzy.hospital.coupon.exception.GlobalException;
import com.wyzy.hospital.coupon.kit.PpCouponKitService;
import com.wyzy.hospital.coupon.mapper.PpCouponMapper;
import com.wyzy.hospital.coupon.service.PpCouponService;
import com.wyzy.hospital.coupon.service.UserCouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/6/9  16:28
 */
@Service
@AllArgsConstructor
public class PpCouponKitServiceImpl extends ServiceImpl<PpCouponMapper, PpCoupon> implements PpCouponKitService {

	private final PpCouponService ppCouponService;
	private final UserCouponService userCouponService;

	@Transactional
	@Override
	public boolean addPpCouponDTOKitService(AddPpCouponDTO addPpCouponDTO) {
		String couponName=ppCouponService.queryCouponName(addPpCouponDTO.getPpCoupon().getCouponName());
		if(couponName==null){
			ppCouponService.save(addPpCouponDTO.getPpCoupon());
		}else{
			throw new GlobalException(CodeMsg.CYCLOPEDIA_DATD_REPEAT);
		}
		return true;
	}


	@Override
	public boolean reSubmitKitService(PpCoupon ppCoupon) {
		ppCoupon.setCouponAduitStruts("0");
		boolean b=ppCouponService.updateById(ppCoupon);
		// ppCouponService.updateById(ppCoupon);
		return b;
	}

}
