

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.DoctorServe;
import com.wyzy.hospital.psychology.service.DoctorServeService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理医生服务关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctorserve" )
@Api(value = "doctorserve", tags = "心理医生服务关系表管理")
public class DoctorServeController {

    private final  DoctorServeService doctorServeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param doctorServe 心理医生服务关系表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorserve_view')" )
    public R getDoctorServePage(Page page, DoctorServe doctorServe) {
        return R.ok(doctorServeService.page(page, Wrappers.query(doctorServe)));
    }


    /**
     * 通过id查询心理医生服务关系表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorserve_view')" )
    public R<DoctorServe> getById(@PathVariable("id" ) Long id) {
        return R.ok(doctorServeService.getById(id));
    }

    /**
     * 新增心理医生服务关系表
     * @param doctorServe 心理医生服务关系表
     * @return R
     */
    @ApiOperation(value = "新增心理医生服务关系表", notes = "新增心理医生服务关系表")
    @SysLog("新增心理医生服务关系表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorserve_add')" )
    public R<Boolean> save(@RequestBody DoctorServe doctorServe) {
        return R.ok(doctorServeService.save(doctorServe));
    }

    /**
     * 修改心理医生服务关系表
     * @param doctorServe 心理医生服务关系表
     * @return R
     */
    @ApiOperation(value = "修改心理医生服务关系表", notes = "修改心理医生服务关系表")
    @SysLog("修改心理医生服务关系表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorserve_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorServe doctorServe) {
        return R.ok(doctorServeService.updateById(doctorServe));
    }

    /**
     * 通过id删除心理医生服务关系表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理医生服务关系表", notes = "通过id删除心理医生服务关系表")
    @SysLog("通过id删除心理医生服务关系表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorserve_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(doctorServeService.removeById(id));
    }

}
