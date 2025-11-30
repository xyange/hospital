package com.wyzy.hospital.pharmacy.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.pharmacy.dto.ShopDTO;
import com.wyzy.hospital.pharmacy.entity.Shop;
import com.wyzy.hospital.pharmacy.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author aqie
 * Date on 2021/4/22  11:59
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/shop" )
@Api(value = "shop", tags = "app药房店铺表管理")
public class AppShopController {
	private final ShopService shopService;

	/**
	 * 分页查询
	 * @param query 分页对象
	 * @param shop 药房店铺表
	 * @return
	 */
	@ApiOperation(value = "app分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('app_pharmacy_shop_view')" )
	public R getShopPage(Query query, Shop shop) {
		// return R.ok(shopService.pageList(page, Wrappers.query(shop)));
		return R.ok(shopService.pageList(Condition.getPage(query), Wrappers.query(shop)));
	}

	/**
	 * 通过id查询药房店铺表
	 * @param shopId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{shopId}" )
	@PreAuthorize("@pms.hasPermission('app_pharmacy_shop_view')" )
	public R getById(@PathVariable("shopId" ) Long shopId) {
		ShopDTO detail = shopService.detail(shopId);
		return R.ok(detail);
	}
}
