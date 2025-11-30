

package com.wyzy.hospital.pharmacy.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.pharmacy.entity.Shop;
import com.wyzy.hospital.pharmacy.service.ShopService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 药房店铺表
 *
 * @author aqie
 * @date 2021-04-22 09:06:01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/shop" )
@Api(value = "shop", tags = "药房店铺表管理")
public class ShopController {

    private final ShopService shopService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param shop 药房店铺表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('pharmacy_shop_view')" )
    public R getShopPage(Page page, Shop shop) {
        return R.ok(shopService.page(page, Wrappers.query(shop)));
    }


    /**
     * 通过id查询药房店铺表
     * @param shopId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{shopId}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_shop_view')" )
    public R getById(@PathVariable("shopId" ) Long shopId) {
        return R.ok(shopService.getById(shopId));
    }

    /**
     * 新增药房店铺表
     * @param shop 药房店铺表
     * @return R
     */
    @ApiOperation(value = "新增药房店铺表", notes = "新增药房店铺表")
    @SysLog("新增药房店铺表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_shop_add')" )
    public R save(@RequestBody Shop shop) {
        return R.ok(shopService.save(shop));
    }

    /**
     * 修改药房店铺表
     * @param shop 药房店铺表
     * @return R
     */
    @ApiOperation(value = "修改药房店铺表", notes = "修改药房店铺表")
    @SysLog("修改药房店铺表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_shop_edit')" )
    public R updateById(@RequestBody Shop shop) {
        return R.ok(shopService.updateById(shop));
    }

    /**
     * 通过id删除药房店铺表
     * @param shopId id
     * @return R
     */
    @ApiOperation(value = "通过id删除药房店铺表", notes = "通过id删除药房店铺表")
    @SysLog("通过id删除药房店铺表" )
    @DeleteMapping("/{shopId}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_shop_del')" )
    public R removeById(@PathVariable Long shopId) {
        return R.ok(shopService.removeById(shopId));
    }

}
