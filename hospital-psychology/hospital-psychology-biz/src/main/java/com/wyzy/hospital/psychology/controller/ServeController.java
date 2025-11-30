

package com.wyzy.hospital.psychology.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.Serve;
import com.wyzy.hospital.psychology.service.ServeService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理医生服务表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/serve" )
@Api(value = "serve", tags = "心理医生服务表管理")
public class ServeController {

    private final  ServeService serveService;

    /**
     * 分页查询
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorserve_view')" )
    public R getDoctorServePage(Page page, Serve serve) {
        return R.ok(serveService.page(page, Wrappers.query(serve)));
    }

    /**
     * 通过id查询心理医生服务表
     * @param serveId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{serveId}" )
    @PreAuthorize("@pms.hasPermission('psychology_serve_view')" )
    public R<Serve> getById(@PathVariable("serveId" ) Long serveId) {
        return R.ok(serveService.getById(serveId));
    }

    /**
     * 新增心理医生服务表
     * @param serve 心理医生服务表
     * @return R
     */
    @ApiOperation(value = "新增心理医生服务表", notes = "新增心理医生服务表")
    @SysLog("新增心理医生服务表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_serve_add')" )
    public R<Boolean> save(@RequestBody Serve serve) {
        return R.ok(serveService.saveServe(serve));
    }

    /**
     * 修改心理医生服务表
     * @param serve 心理医生服务表
     * @return R
     */
    @ApiOperation(value = "修改心理医生服务表", notes = "修改心理医生服务表")
    @SysLog("修改心理医生服务表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_serve_edit')" )
    public R<Boolean> updateById(@RequestBody Serve serve) {
        return R.ok(serveService.updateById(serve));
    }

    /**
     * 通过id删除心理医生服务表
     * @param serveId id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生服务表", notes = "通过id删除心理医生服务表")
    @SysLog("通过id删除心理医生服务表" )
    @DeleteMapping("/{serveId}" )
    @PreAuthorize("@pms.hasPermission('psychology_serve_del')" )
    public R<Boolean> removeById(@PathVariable Long serveId) {
        return R.ok(serveService.removeServeById(serveId));
    }

}
