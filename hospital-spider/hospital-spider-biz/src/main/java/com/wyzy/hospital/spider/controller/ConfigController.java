

package com.wyzy.hospital.spider.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.spider.entity.Config;
import com.wyzy.hospital.spider.service.ConfigService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 爬虫配置
 *
 * @author aqie
 * @date 2021-06-02 17:34:51
 */
@RestController
@AllArgsConstructor
@RequestMapping("/config" )
@Api(value = "config", tags = "爬虫配置管理")
public class ConfigController {

    private final  ConfigService configService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param config 爬虫配置
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('spider_config_view')" )
    public R getConfigPage(Page page, Config config) {
        return R.ok(configService.page(page, Wrappers.query(config)));
    }


    /**
     * 通过id查询爬虫配置
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('spider_config_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(configService.getById(id));
    }

    /**
     * 新增爬虫配置
     * @param config 爬虫配置
     * @return R
     */
    @ApiOperation(value = "新增爬虫配置", notes = "新增爬虫配置")
    @SysLog("新增爬虫配置" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('spider_config_add')" )
    public R save(@RequestBody Config config) {
        return R.ok(configService.save(config));
    }

    /**
     * 修改爬虫配置
     * @param config 爬虫配置
     * @return R
     */
    @ApiOperation(value = "修改爬虫配置", notes = "修改爬虫配置")
    @SysLog("修改爬虫配置" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('spider_config_edit')" )
    public R updateById(@RequestBody Config config) {
        return R.ok(configService.updateById(config));
    }

    /**
     * 通过id删除爬虫配置
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除爬虫配置", notes = "通过id删除爬虫配置")
    @SysLog("通过id删除爬虫配置" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('spider_config_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(configService.removeById(id));
    }

}
