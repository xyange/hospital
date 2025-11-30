

package com.wyzy.hospital.spider.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.spider.entity.Mission;
import com.wyzy.hospital.spider.service.MissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 爬虫任务
 *
 * @author aqie
 * @date 2021-06-02 17:35:48
 */
@RestController
@AllArgsConstructor
@RequestMapping("/mission" )
@Api(value = "mission", tags = "爬虫任务管理")
public class MissionController {

    private final  MissionService missionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param mission 爬虫任务
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('spider_mission_view')" )
    public R getMissionPage(Page page, Mission mission) {
        return R.ok(missionService.page(page, Wrappers.query(mission)));
    }


    /**
     * 通过id查询爬虫任务
     * @param missionId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{missionId}" )
    @PreAuthorize("@pms.hasPermission('spider_mission_view')" )
    public R getById(@PathVariable("missionId" ) Integer missionId) {
        return R.ok(missionService.getById(missionId));
    }

    /**
     * 新增爬虫任务
     * @param mission 爬虫任务
     * @return R
     */
    @ApiOperation(value = "新增爬虫任务", notes = "新增爬虫任务")
    @SysLog("新增爬虫任务" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('spider_mission_add')" )
    public R save(@RequestBody Mission mission) {
        return R.ok(missionService.save(mission));
    }

    /**
     * 修改爬虫任务
     * @param mission 爬虫任务
     * @return R
     */
    @ApiOperation(value = "修改爬虫任务", notes = "修改爬虫任务")
    @SysLog("修改爬虫任务" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('spider_mission_edit')" )
    public R updateById(@RequestBody Mission mission) {
        return R.ok(missionService.updateById(mission));
    }

    /**
     * 通过id删除爬虫任务
     * @param missionId id
     * @return R
     */
    @ApiOperation(value = "通过id删除爬虫任务", notes = "通过id删除爬虫任务")
    @SysLog("通过id删除爬虫任务" )
    @DeleteMapping("/{missionId}" )
    @PreAuthorize("@pms.hasPermission('spider_mission_del')" )
    public R removeById(@PathVariable Integer missionId) {
        return R.ok(missionService.removeById(missionId));
    }

}
