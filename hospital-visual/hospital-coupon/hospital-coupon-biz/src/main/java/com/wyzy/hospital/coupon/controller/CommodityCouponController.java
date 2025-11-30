

package com.wyzy.hospital.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.coupon.entity.CommodityCoupon;
import com.wyzy.hospital.coupon.service.CommodityCouponService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-16 16:06:24
 */
@RestController
@AllArgsConstructor
@RequestMapping("/commoditycoupon" )
@Api(value = "commoditycoupon", tags = "商品优惠券表管理")
public class CommodityCouponController {

    private final  CommodityCouponService commodityCouponService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param commodityCoupon 商品优惠券表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('coupon_commoditycoupon_view')" )
    public R getCommodityCouponPage(Page page, CommodityCoupon commodityCoupon) {
        return R.ok(commodityCouponService.page(page, Wrappers.query(commodityCoupon)));
    }


    /**
     * 通过id查询商品优惠券表
     * @param comCouId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{comCouId}" )
    @PreAuthorize("@pms.hasPermission('coupon_commoditycoupon_view')" )
    public R getById(@PathVariable("comCouId" ) Long comCouId) {
        return R.ok(commodityCouponService.getById(comCouId));
    }

    /**
     * 新增商品优惠券表
     * @param commodityCoupon 商品优惠券表
     * @return R
     */
    @ApiOperation(value = "新增商品优惠券表", notes = "新增商品优惠券表")
    @SysLog("新增商品优惠券表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('coupon_commoditycoupon_add')" )
    public R save(@RequestBody CommodityCoupon commodityCoupon) {
        return R.ok(commodityCouponService.save(commodityCoupon));
    }

    /**
     * 修改商品优惠券表
     * @param commodityCoupon 商品优惠券表
     * @return R
     */
    @ApiOperation(value = "修改商品优惠券表", notes = "修改商品优惠券表")
    @SysLog("修改商品优惠券表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('coupon_commoditycoupon_edit')" )
    public R updateById(@RequestBody CommodityCoupon commodityCoupon) {
        return R.ok(commodityCouponService.updateById(commodityCoupon));
    }

    /**
     * 通过id删除商品优惠券表
     * @param comCouId id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品优惠券表", notes = "通过id删除商品优惠券表")
    @SysLog("通过id删除商品优惠券表" )
    @DeleteMapping("/{comCouId}" )
    @PreAuthorize("@pms.hasPermission('coupon_commoditycoupon_del')" )
    public R removeById(@PathVariable Long comCouId) {
        return R.ok(commodityCouponService.removeById(comCouId));
    }

}
