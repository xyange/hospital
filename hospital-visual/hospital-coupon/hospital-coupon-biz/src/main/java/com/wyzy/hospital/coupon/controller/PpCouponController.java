

package com.wyzy.hospital.coupon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.coupon.dto.AddPpCouponDTO;
import com.wyzy.hospital.coupon.dto.PpCouponDTO;
import com.wyzy.hospital.coupon.entity.PpCoupon;
import com.wyzy.hospital.coupon.kit.PpCouponKitService;
import com.wyzy.hospital.coupon.service.PpCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 优惠券表
 *
 * @author hospital code generator
 * @date 2021-06-09 11:36:41
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ppcoupon" )
@Api(value = "ppcoupon", tags = "优惠券表管理")
public class PpCouponController {

    private final  PpCouponService ppCouponService;
	private final PpCouponKitService ppCouponKitService;

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
     * 新增优惠券表
     * @param ppCoupon 优惠券表
     * @return R
     */
    @ApiOperation(value = "新增优惠券表", notes = "新增优惠券表")
    @SysLog("新增优惠券表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('coupon_ppcoupon_add')" )
    public R save(@RequestBody PpCoupon ppCoupon) {
        return R.ok(ppCouponService.save(ppCoupon));
    }

    /**
     * 修改优惠券表
     * @param ppCoupon 优惠券表
     * @return R
     */
    @ApiOperation(value = "修改优惠券表", notes = "修改优惠券表")
    @SysLog("修改优惠券表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('coupon_ppcoupon_edit')" )
    public R updateById(@RequestBody PpCoupon ppCoupon) {
        return R.ok(ppCouponService.updateById(ppCoupon));
    }

    /**
     * 通过id删除优惠券表
     * @param couponId id
     * @return R
     */
    @ApiOperation(value = "通过id删除优惠券表", notes = "通过id删除优惠券表")
    @SysLog("通过id删除优惠券表" )
    @DeleteMapping("/{couponId}" )
    @PreAuthorize("@pms.hasPermission('coupon_ppcoupon_del')" )
    public R removeById(@PathVariable Long couponId) {
        return R.ok(ppCouponService.removeById(couponId));
    }

	/**
	 * 可领取优惠券
	 * @return
	 */
	@ApiOperation(value = "可领取优惠券", notes = "可领取优惠券")
	@GetMapping("/queryUseCoupon" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R queryUseCoupon() {
		return R.ok(ppCouponService.queryUseCoupon());
	}

	/**
	 * 优惠券审核
	 * @return
	 */
	@ApiOperation(value = "优惠券审核(后台)", notes = "优惠券审核")
	@GetMapping("/queryCouponAduit" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R<List<PpCouponDTO>> queryCouponAduit(Query query) {
		return R.ok(ppCouponService.queryCouponAduit(Condition.getPage(query)));
	}

	/**
	 * 优惠券审核(后台)
	 * @param ppCouponDTO
	 * @return
	 */
	@ApiOperation(value = "优惠券审核(后台)", notes = "优惠券审核(后台)")
	@SysLog("优惠券审核" )
	@PutMapping("/alterCouponAduitStruts")
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_edit')" )
	public void  alterCouponAduitStruts(@RequestBody PpCouponDTO ppCouponDTO) {
		String couponAduitStruts=ppCouponService.getById(ppCouponDTO.getCouponId()).getCouponAduitStruts();
		ppCouponService.alterCouponAduitStruts(ppCouponDTO.getCouponId(),couponAduitStruts);
	}

	/**
	 * 条件查询待审核优惠券
	 * @return
	 */
	@ApiOperation(value = "待审核优惠券(条件查询)", notes = "条件查询待审核优惠券")
	@GetMapping("/conditionAuditCoupon" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R<List<PpCouponDTO>> selectConditionAuditCoupon(Query query,String couponType,String couponName) {
		return R.ok(ppCouponService.selectConditionAuditCoupon(Condition.getPage(query),couponType,couponName));
	}

	/**
	 * 优惠券列表
	 * @return
	 */
	@ApiOperation(value = "优惠券列表(后台)", notes = "优惠券列表")
	@GetMapping("/queryCouponTable" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R<List<PpCouponDTO>> queryCouponTable(Query query) {
		return R.ok(ppCouponService.queryCouponTable(Condition.getPage(query)));
	}
	/**
	 * 优惠券上下线
	 * @param ppCouponDTO
	 * @return
	 */
	@ApiOperation(value = "优惠券上下线(后台)", notes = "优惠券上下线")
	@SysLog("优惠券上下线" )
	@PutMapping("/alterCouponExistStruts")
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_edit')" )
	public boolean  alterCouponExistStruts(@RequestBody PpCouponDTO ppCouponDTO) {
		String couponExistStruts=ppCouponService.getById(ppCouponDTO.getCouponId()).getCouponExistStruts();
		ppCouponService.alterCouponExistStruts(ppCouponDTO.getCouponId(),couponExistStruts);
	return true;
	}
	/**
	 * 优惠券列表(条件查询+分页)
	 * @return
	 */
	@ApiOperation(value = "优惠券列表条件查询(后台)", notes = "优惠券列表")
	@GetMapping("/selectConditionCouponTable" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R<List<PpCouponDTO>> selectConditionAuditCoupon(Query query,String couponType, String couponGrantStruts,String couponName) {
		return R.ok(ppCouponService.selectConditionCouponTable(Condition.getPage(query),couponType,couponGrantStruts,couponName));
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

	/**
	 * 添加优惠券表
	 * @param addPpCouponDTO 优惠券表
	 * @return R
	 */
	@ApiOperation(value = "添加优惠券表", notes = "添加优惠券表")
	@SysLog("添加优惠券表" )
	@PostMapping("/addPpCoupon")
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_add')" )
	public R addPpCouponDTOKitService(@RequestBody AddPpCouponDTO addPpCouponDTO) {
		return R.ok(ppCouponKitService.addPpCouponDTOKitService(addPpCouponDTO));
	}


	/**
	 * 优惠券审核列表
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "优惠券审核列表(后台)", notes = "优惠券审核列表")
	@GetMapping("/queryCouponAuditTable" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R queryCouponAuditTable(Query query) {
		return R.ok(ppCouponService.queryCouponAuditTable(Condition.getPage(query)));
	}

	/**
	 * 后台审核重新修改数据
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "后台审核重新修改数据", notes = "后台审核重新修改数据")
	@SysLog("后台审核重新修改数据" )
	@PutMapping("/reSubmitKitService")
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_edit')" )
	public R reSubmitKitService(@RequestBody PpCoupon ppCoupon) {
		return R.ok(ppCouponKitService.reSubmitKitService(ppCoupon));
	}

	/**
	 * 添加优惠券未通过审核原因
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "添加优惠券未通过审核原因", notes = "添加优惠券未通过审核原因")
	@SysLog("添加优惠券未通过审核原因" )
	@PutMapping("/insertAduitCause")
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_edit')" )
	public R insertAduitCause(Long couponId, String couponAduitCause) {
		return R.ok(ppCouponService.insertAduitCause(couponId,couponAduitCause));
	}

	/**
	 * 优惠券审核列表(条件查询)
	 * @return
	 */
	@ApiOperation(value = "优惠券审核列表(条件查询)", notes = "优惠券审核列表(条件查询)")
	@GetMapping("/SeeConditionCouponAduitTable" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R<List<PpCouponDTO>> SeeConditionCouponAduitTable(Query query,String couponType, String couponAduitStruts, String couponName) {
		return R.ok(ppCouponService.SeeConditionCouponAduitTable(Condition.getPage(query),couponType,couponAduitStruts,couponName));
	}

	/**
	 * 通过couponId查询未通过审核原因
	 * @param couponId id
	 * @return R
	 */
	@ApiOperation(value = "通过couponId查询未通过审核原因", notes = "通过couponId查询未通过审核原因")
	@GetMapping("/queryAduitCause/{couponId}" )
	@PreAuthorize("@pms.hasPermission('coupon_ppcoupon_view')" )
	public R queryAduitCause(@PathVariable("couponId" ) Long couponId) {
		return R.ok(ppCouponService.queryAduitCause(couponId));
	}




}
