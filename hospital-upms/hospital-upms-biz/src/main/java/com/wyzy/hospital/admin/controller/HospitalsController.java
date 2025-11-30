

package com.wyzy.hospital.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalsDTO;
import com.wyzy.hospital.admin.api.entity.Hospitals;
import com.wyzy.hospital.admin.kit.HospitalKitService;
import com.wyzy.hospital.admin.service.HospitalsService;
import com.wyzy.hospital.admin.service.RabbitmqService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-15 15:42:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/hospitals" )
@Api(value = "hospitals", tags = "医院表管理")
public class HospitalsController {

    private final HospitalKitService hospitalKitService;

    private final  HospitalsService hospitalsService;

    private final RabbitmqService rabbitmqService;


    /**
     * 分页查询
     * @param query 查询对象
     * @param hospitals 医院表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_hospitals_view')" )
    public R getHospitalsPage(Query query, HospitalsDTO hospitals) {
        IPage<HospitalsDTO> hospitalsPage = hospitalKitService.getHospitalsPage(Condition.getPage(query), hospitals);
        return R.ok(hospitalsPage);
    }


    /**
     * 通过id查询医院表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_hospitals_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(hospitalsService.getById(id));
    }

    /**
     * 新增医院表
     * @param hospitalsDTO 医院表
     * @return R
     */
    @ApiOperation(value = "新增医院表", notes = "新增医院表")
    @SysLog("新增医院表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_hospitals_add')" )
    public R save(@RequestBody HospitalsDTO hospitalsDTO) {

        return R.ok(hospitalKitService.save(hospitalsDTO));
    }

    /**
     * 修改医院表
     * @param hospitals 医院表
     * @return R
     */
    @ApiOperation(value = "修改医院表", notes = "修改医院表")
    @SysLog("修改医院表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_hospitals_edit')" )
    public R updateById(@RequestBody Hospitals hospitals) {
        rabbitmqService.updateHospital(hospitals);
        return R.ok(hospitalsService.updateById(hospitals));
    }

    /**
     * 通过id删除医院表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除医院表", notes = "通过id删除医院表")
    @SysLog("通过id删除医院表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_hospitals_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(hospitalsService.removeById(id));
    }



}
