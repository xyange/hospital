

package com.wyzy.hospital.spider.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.spider.entity.FiledRule;
import com.wyzy.hospital.spider.service.FiledRuleService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 爬虫字段规则
 *
 * @author aqie
 * @date 2021-06-02 17:36:01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/filedrule" )
@Api(value = "filedrule", tags = "爬虫字段规则管理")
public class FiledRuleController {

    private final  FiledRuleService filedRuleService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param filedRule 爬虫字段规则
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('spider_filedrule_view')" )
    public R getFiledRulePage(Page page, FiledRule filedRule) {
        return R.ok(filedRuleService.page(page, Wrappers.query(filedRule)));
    }


    /**
     * 通过id查询爬虫字段规则
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('spider_filedrule_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(filedRuleService.getById(id));
    }

    /**
     * 新增爬虫字段规则
     * @param filedRule 爬虫字段规则
     * @return R
     */
    @ApiOperation(value = "新增爬虫字段规则", notes = "新增爬虫字段规则")
    @SysLog("新增爬虫字段规则" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('spider_filedrule_add')" )
    public R save(@RequestBody FiledRule filedRule) {
        return R.ok(filedRuleService.save(filedRule));
    }

    /**
     * 修改爬虫字段规则
     * @param filedRule 爬虫字段规则
     * @return R
     */
    @ApiOperation(value = "修改爬虫字段规则", notes = "修改爬虫字段规则")
    @SysLog("修改爬虫字段规则" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('spider_filedrule_edit')" )
    public R updateById(@RequestBody FiledRule filedRule) {
        return R.ok(filedRuleService.updateById(filedRule));
    }

    /**
     * 通过id删除爬虫字段规则
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除爬虫字段规则", notes = "通过id删除爬虫字段规则")
    @SysLog("通过id删除爬虫字段规则" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('spider_filedrule_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(filedRuleService.removeById(id));
    }

}
