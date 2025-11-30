
package com.wyzy.hospital.coupon.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.coupon.dto.PpCouponDTO;
import com.wyzy.hospital.coupon.entity.PpCoupon;
import com.wyzy.hospital.coupon.exception.GlobalException;
import com.wyzy.hospital.coupon.mapper.PpCouponMapper;
import com.wyzy.hospital.coupon.service.PpCouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-09 11:36:41
 */
@Service
public class PpCouponServiceImpl extends ServiceImpl<PpCouponMapper, PpCoupon> implements PpCouponService {

	@Resource
	PpCouponServiceImpl ppCouponService;

	@Override
	public List<PpCouponDTO> queryUseCoupon() {
		List<PpCouponDTO> ppCouponDTOList = baseMapper.selectUseCoupon();
		return ppCouponDTOList;
	}

	@Override
	public List<PpCouponDTO> queryCouponAduit(IPage<PpCouponDTO> page) {
		List<PpCouponDTO> couponDTOList = baseMapper.selectCouponAduit(page);
		return couponDTOList;
	}

	@Override
	public void alterCouponAduitStruts(Long couponId, String couponAduitStruts) {
		PpCouponDTO ppCouponDTO = new PpCouponDTO();
		ppCouponDTO.setCouponId(couponId);
		if ("0".equals(couponAduitStruts)) {
			ppCouponDTO.setCouponAduitStruts("1");
			baseMapper.updateCouponAduitStruts(couponId, ppCouponDTO.getCouponAduitStruts());
		} else if ("1".equals(couponAduitStruts)) {
			ppCouponDTO.setCouponAduitStruts("2");
			baseMapper.updateCouponAduitStruts(couponId, ppCouponDTO.getCouponAduitStruts());
		} else if ("2".equals(couponAduitStruts)) {
			ppCouponDTO.setCouponAduitStruts("1");
			baseMapper.updateCouponAduitStruts(couponId, ppCouponDTO.getCouponAduitStruts());
		} else {
			ppCouponDTO.setCouponAduitStruts("1");
			baseMapper.updateCouponAduitStruts(couponId, ppCouponDTO.getCouponAduitStruts());
		}
	}
//条件查询

	@Override
	public List<PpCouponDTO> selectConditionAuditCoupon(IPage<PpCouponDTO> page, String couponType, String couponName) {
		List<PpCouponDTO> couponDTOList = baseMapper.byConditionAuditCoupon(page,couponType,couponName);
		return couponDTOList;
	}

	@Override
	public List<PpCouponDTO> queryCouponTable(IPage<PpCouponDTO> page) {
		List<PpCouponDTO> ppCouponDTOList = baseMapper.selectCouponTable(page);
		return ppCouponDTOList;
	}

	@Override
	public boolean alterCouponExistStruts(Long couponId, String couponExistStruts) {
		PpCouponDTO ppCouponDTO = new PpCouponDTO();
		ppCouponDTO.setCouponId(couponId);
		if ("1".equals(couponExistStruts)) {
			ppCouponDTO.setCouponExistStruts("2");
			baseMapper.updateCouponExistStruts(couponId, ppCouponDTO.getCouponExistStruts());
		} else if ("2".equals(couponExistStruts)) {
			ppCouponDTO.setCouponExistStruts("1");
			baseMapper.updateCouponExistStruts(couponId, ppCouponDTO.getCouponExistStruts());
		}
		return true;
	}

	@Override
	public List<PpCouponDTO> selectConditionCouponTable(IPage<PpCouponDTO> page, String couponType, String couponGrantStruts, String couponName) {
		List<PpCouponDTO> couponDTOList = baseMapper.ConditionCouponTable(page,couponType,couponGrantStruts,couponName);
		return couponDTOList;
	}

	@Override
	public String queryCouponName(String couponName) {
		String selectCouponName = baseMapper.selectCouponName(couponName);
		return selectCouponName;
	}

	@Override
	public List<PpCoupon> queryCouponByCode(Long couponCode) {
		List<PpCoupon> ppCoupons = baseMapper.queryCouponByCode(couponCode);
		return ppCoupons;
	}

	@Override
	public List<PpCouponDTO> queryCouponAuditTable(IPage<PpCouponDTO> page) {
		List<PpCouponDTO> ppCouponDTOList = baseMapper.selectCouponAuditTable(page);
		return ppCouponDTOList;
	}

	@Override
	public List<PpCouponDTO> SeeConditionCouponAduitTable(IPage<PpCouponDTO> page, String couponType, String couponAduitStruts, String couponName) {
		List<PpCouponDTO> ppCouponDTOList = baseMapper.ConditionCouponAduitTable(page, couponType, couponAduitStruts, couponName);
		return ppCouponDTOList;
	}

	@Override
	public String queryAduitCause(Long couponId) {
		String aduitCause = baseMapper.selectAduitCause(couponId);
		return aduitCause;
	}

	@Override
	public boolean insertAduitCause(Long couponId, String couponAduitCause) {
		      String  aduitStruts= ppCouponService.getById(couponId).getCouponAduitStruts();
		if(aduitStruts.equals("2")) {
			boolean addAduitCause = baseMapper.addAduitCause(couponId, couponAduitCause);
			return addAduitCause;
		}else {
			throw new GlobalException(CodeMsg.COUPON_PDATEDATE_NOAPPLY);
		}

	}

	@Override
	public Integer queryLimitNum(Long couponCode) {
		return baseMapper.selectLimitNum(couponCode);
	}

	@Override
	public boolean alterCouponReceiveNum(Long couponCode) {
		return baseMapper.updateCouponReceiveNum(couponCode);
	}

	@Override
	public Integer queryUnclaimedByCode(Long couponCode) {
		Integer unclaimedByCode = baseMapper.selectUnclaimedByCode(couponCode);
		return unclaimedByCode;
	}


}
