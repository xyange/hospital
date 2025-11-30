

package com.wyzy.hospital.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.coupon.entity.PpCoupon;
import com.wyzy.hospital.coupon.service.PpCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-09 11:36:41
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/ppcoupon" )
@Api(value = "ppcoupon", tags = "APP优惠券表管理")
public class AppPpCouponController {

    private final  PpCouponService ppCouponService;

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param ppCoupon 优惠券表
	 * @return
	 */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
    public R getPpCouponPage(Page page, PpCoupon ppCoupon) {
        return R.ok(ppCouponService.page(page, Wrappers.query(ppCoupon)));
    }
    /**
     * 通过id查询优惠券表
     * @param couponId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{couponId}" )
    @PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
    public R getById(@PathVariable("couponId" ) Long couponId) {
        return R.ok(ppCouponService.getById(couponId));
    }

	/**
	 * 查询优惠券名称
	 * @param couponName
	 * @return
	 */
	@ApiOperation(value = "查询优惠券名称", notes = "查询优惠券名称")
	@GetMapping("/queryCouponName/{couponName}" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R queryCouponName(@PathVariable("couponName" ) String couponName) {
		return R.ok(ppCouponService.queryCouponName(couponName));
	}






}
