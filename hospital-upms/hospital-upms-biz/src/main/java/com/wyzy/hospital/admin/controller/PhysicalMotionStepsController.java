

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.entity.PhysicalMotionSteps;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.service.PhysicalMotionStepsService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 身体管理运动步数
 *
 * @author hospital code generator
 * @date 2021-06-18 10:53:34
 */
@RestController
@AllArgsConstructor
@RequestMapping("/physicalmotionsteps" )
@Api(value = "physicalmotionsteps", tags = "身体管理运动步数管理")
public class PhysicalMotionStepsController {

    private final  PhysicalMotionStepsService physicalMotionStepsService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param physicalMotionSteps 身体管理运动步数
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionsteps_view')" )
    public R getPhysicalMotionStepsPage(Page page, PhysicalMotionSteps physicalMotionSteps) {
        return R.ok(physicalMotionStepsService.page(page, Wrappers.query(physicalMotionSteps)));
    }


    /**
     * 通过id查询身体管理运动步数
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionsteps_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(physicalMotionStepsService.getById(id));
    }

    /**
     * 新增身体管理运动步数
     * @param physicalMotionSteps 身体管理运动步数
     * @return R
     */
    @ApiOperation(value = "新增身体管理运动步数", notes = "新增身体管理运动步数")
    @SysLog("新增身体管理运动步数" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionsteps_add')" )
    public R save(@RequestBody PhysicalMotionSteps physicalMotionSteps) {
        return R.ok(physicalMotionStepsService.save(physicalMotionSteps));
    }

    /**
     * 修改身体管理运动步数
     * @param physicalMotionSteps 身体管理运动步数
     * @return R
     */
    @ApiOperation(value = "修改身体管理运动步数", notes = "修改身体管理运动步数")
    @SysLog("修改身体管理运动步数" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionsteps_edit')" )
    public R updateById(@RequestBody PhysicalMotionSteps physicalMotionSteps) {
        return R.ok(physicalMotionStepsService.updateById(physicalMotionSteps));
    }

    /**
     * 通过id删除身体管理运动步数
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除身体管理运动步数", notes = "通过id删除身体管理运动步数")
    @SysLog("通过id删除身体管理运动步数" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionsteps_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(physicalMotionStepsService.removeById(id));
    }

}
