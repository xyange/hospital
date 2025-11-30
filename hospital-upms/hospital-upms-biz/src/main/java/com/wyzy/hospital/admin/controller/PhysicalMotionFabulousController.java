

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.entity.PhysicalMotionFabulous;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.service.PhysicalMotionFabulousService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 身体管理运动步数点赞
 *
 * @author hospital code generator
 * @date 2021-06-18 10:54:08
 */
@RestController
@AllArgsConstructor
@RequestMapping("/physicalmotionfabulous" )
@Api(value = "physicalmotionfabulous", tags = "身体管理运动步数点赞管理")
public class PhysicalMotionFabulousController {

    private final  PhysicalMotionFabulousService physicalMotionFabulousService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param physicalMotionFabulous 身体管理运动步数点赞
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionfabulous_view')" )
    public R getPhysicalMotionFabulousPage(Page page, PhysicalMotionFabulous physicalMotionFabulous) {
        return R.ok(physicalMotionFabulousService.page(page, Wrappers.query(physicalMotionFabulous)));
    }


    /**
     * 通过id查询身体管理运动步数点赞
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionfabulous_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(physicalMotionFabulousService.getById(id));
    }

    /**
     * 新增身体管理运动步数点赞
     * @param physicalMotionFabulous 身体管理运动步数点赞
     * @return R
     */
    @ApiOperation(value = "新增身体管理运动步数点赞", notes = "新增身体管理运动步数点赞")
    @SysLog("新增身体管理运动步数点赞" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionfabulous_add')" )
    public R save(@RequestBody PhysicalMotionFabulous physicalMotionFabulous) {
        return R.ok(physicalMotionFabulousService.save(physicalMotionFabulous));
    }

    /**
     * 修改身体管理运动步数点赞
     * @param physicalMotionFabulous 身体管理运动步数点赞
     * @return R
     */
    @ApiOperation(value = "修改身体管理运动步数点赞", notes = "修改身体管理运动步数点赞")
    @SysLog("修改身体管理运动步数点赞" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionfabulous_edit')" )
    public R updateById(@RequestBody PhysicalMotionFabulous physicalMotionFabulous) {
        return R.ok(physicalMotionFabulousService.updateById(physicalMotionFabulous));
    }

    /**
     * 通过id删除身体管理运动步数点赞
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除身体管理运动步数点赞", notes = "通过id删除身体管理运动步数点赞")
    @SysLog("通过id删除身体管理运动步数点赞" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_physicalmotionfabulous_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(physicalMotionFabulousService.removeById(id));
    }

}
