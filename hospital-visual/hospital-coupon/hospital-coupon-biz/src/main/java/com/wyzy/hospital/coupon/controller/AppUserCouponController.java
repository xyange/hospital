

package com.wyzy.hospital.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.coupon.entity.UserCoupon;
import com.wyzy.hospital.coupon.service.UserCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/usercoupon" )
@Api(value = "usercoupon", tags = "App用户优惠券管理")
public class AppUserCouponController {

    private final  UserCouponService userCouponService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param userCoupon 用户优惠券
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('coupon_usercoupon_view')" )
    public R getUserCouponPage(Page page, UserCoupon userCoupon) {
        return R.ok(userCouponService.page(page, Wrappers.query(userCoupon)));
    }


    /**
     * 通过id查询用户优惠券
     * @param upId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{upId}" )
    @PreAuthorize("@pms.hasPermission('coupon_usercoupon_view')" )
    public R getById(@PathVariable("upId" ) Long upId) {
        return R.ok(userCouponService.getById(upId));
    }

	/**
	 *用户使用优惠券详情
	 * @param userId
	 * @param upIfuse
	 * @return
	 */
	@ApiOperation(value = "用户使用优惠券详情", notes = "用户使用优惠券详情")
	@GetMapping("/queryCouponUse/{userId}/{upIfuse}" )
	@PreAuthorize("@pms.hasPermission('coupon_usercoupon_view')" )
	public R userCouponService(@PathVariable("userId" ) Long userId,@PathVariable("upIfuse" ) String upIfuse) {
		return R.ok(userCouponService.queryCouponUse(userId,upIfuse));
	}





}
