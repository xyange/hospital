

package com.wyzy.hospital.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.coupon.entity.UserCoupon;
import com.wyzy.hospital.coupon.kit.UserCouponKitService;
import com.wyzy.hospital.coupon.service.UserCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 用户优惠券
 *
 * @author hospital code generator
 * @date 2021-06-10 09:46:24
 */
@RestController
@AllArgsConstructor
@RequestMapping("/usercoupon" )
@Api(value = "usercoupon", tags = "用户优惠券管理")
public class UserCouponController {

    private final  UserCouponService userCouponService;

	private final UserCouponKitService userCouponKitService;
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
     * 新增用户优惠券
     * @param userCoupon 用户优惠券
     * @return R
     */
    @ApiOperation(value = "新增用户优惠券", notes = "新增用户优惠券")
    @SysLog("新增用户优惠券" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('coupon_usercoupon_add')" )
    public R save(@RequestBody UserCoupon userCoupon) {
        return R.ok(userCouponService.save(userCoupon));
    }

    /**
     * 修改用户优惠券
     * @param userCoupon 用户优惠券
     * @return R
     */
    @ApiOperation(value = "修改用户优惠券", notes = "修改用户优惠券")
    @SysLog("修改用户优惠券" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('coupon_usercoupon_edit')" )
    public R updateById(@RequestBody UserCoupon userCoupon) {
        return R.ok(userCouponService.updateById(userCoupon));
    }

    /**
     * 通过id删除用户优惠券
     * @param upId id
     * @return R
     */
    @ApiOperation(value = "通过id删除用户优惠券", notes = "通过id删除用户优惠券")
    @SysLog("通过id删除用户优惠券" )
    @DeleteMapping("/{upId}" )
    @PreAuthorize("@pms.hasPermission('coupon_usercoupon_del')" )
    public R removeById(@PathVariable Long upId) {
        return R.ok(userCouponService.removeById(upId));
    }

	/**
	 * 添加用户优惠券
	 * @param userCoupon 用户优惠券
	 * @return R
	 */
	@ApiOperation(value = "添加用户优惠券(判断)", notes = "新增用户优惠券")
	@SysLog("新增用户优惠券" )
	@PostMapping("/addUserCoupon")
	@PreAuthorize("@pms.hasPermission('coupon_usercoupon_add')" )
	public R addUserCoupon(@RequestBody UserCoupon userCoupon) {
		return R.ok(userCouponKitService.addUserCoupon(userCoupon));
	}


}
