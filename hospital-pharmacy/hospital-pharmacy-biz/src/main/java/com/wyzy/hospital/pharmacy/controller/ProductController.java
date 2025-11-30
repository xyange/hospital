

package com.wyzy.hospital.pharmacy.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.pharmacy.entity.Product;
import com.wyzy.hospital.pharmacy.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 药房商品表
 *
 * @author aqie
 * @date 2021-04-22 09:17:03
 */
@RestController
@AllArgsConstructor
@RequestMapping("/product" )
@Api(value = "product", tags = "药房商品表管理")
public class ProductController {

    private final  ProductService productService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param product 药房商品表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('pharmacy_product_view')" )
    public R getProductPage(Page page, Product product) {
        return R.ok(productService.page(page, Wrappers.query(product)));
    }


    /**
     * 通过id查询药房商品表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_product_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(productService.getById(id));
    }

    /**
     * 新增药房商品表
     * @param product 药房商品表
     * @return R
     */
    @ApiOperation(value = "新增药房商品表", notes = "新增药房商品表")
    @SysLog("新增药房商品表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_product_add')" )
    public R save(@RequestBody Product product) {
        return R.ok(productService.save(product));
    }

    /**
     * 修改药房商品表
     * @param product 药房商品表
     * @return R
     */
    @ApiOperation(value = "修改药房商品表", notes = "修改药房商品表")
    @SysLog("修改药房商品表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('pharmacy_product_edit')" )
    public R updateById(@RequestBody Product product) {
        return R.ok(productService.updateById(product));
    }

    /**
     * 通过id删除药房商品表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除药房商品表", notes = "通过id删除药房商品表")
    @SysLog("通过id删除药房商品表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('pharmacy_product_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(productService.removeById(id));
    }

}
