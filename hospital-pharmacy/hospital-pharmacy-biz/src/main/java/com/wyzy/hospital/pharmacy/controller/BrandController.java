

package com.wyzy.hospital.pharmacy.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.pharmacy.entity.Brand;
import com.wyzy.hospital.pharmacy.service.BrandService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 商品品牌表
 *
 * @author aqie
 * @date 2021-04-23 17:40:02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/brand" )
@Api(value = "brand", tags = "商品品牌表管理")
public class BrandController {

    private final  BrandService brandService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param brand 商品品牌表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('pharmacy_brand_view')" )
    public R getBrandPage(Page page, Brand brand) {
        return R.ok(brandService.page(page, Wrappers.query(brand)));
    }


    /**
     * 通过id查询商品品牌表
     * @param brandId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{brandId}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_brand_view')" )
    public R getById(@PathVariable("brandId" ) Long brandId) {
        return R.ok(brandService.getById(brandId));
    }

    /**
     * 新增商品品牌表
     * @param brand 商品品牌表
     * @return R
     */
    @ApiOperation(value = "新增商品品牌表", notes = "新增商品品牌表")
    @SysLog("新增商品品牌表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_brand_add')" )
    public R save(@RequestBody Brand brand) {
        return R.ok(brandService.save(brand));
    }

    /**
     * 修改商品品牌表
     * @param brand 商品品牌表
     * @return R
     */
    @ApiOperation(value = "修改商品品牌表", notes = "修改商品品牌表")
    @SysLog("修改商品品牌表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_brand_edit')" )
    public R updateById(@RequestBody Brand brand) {
        return R.ok(brandService.updateById(brand));
    }

    /**
     * 通过id删除商品品牌表
     * @param brandId id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品品牌表", notes = "通过id删除商品品牌表")
    @SysLog("通过id删除商品品牌表" )
    @DeleteMapping("/{brandId}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_brand_del')" )
    public R removeById(@PathVariable Long brandId) {
        return R.ok(brandService.removeById(brandId));
    }

}
