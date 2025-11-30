

package com.wyzy.hospital.patients.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.patients.entity.Patients;
import com.wyzy.hospital.patients.service.PatientsService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 病人表
 *
 * @author hospital code generator
 * @date 2021-04-12 11:16:16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/patients" )
@Api(value = "patients", tags = "病人表管理")
public class PatientsController {

    private final  PatientsService patientsService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param patients 病人表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('patients_patients_view')" )
    public R getPatientsPage(Page page, Patients patients) {
        return R.ok(patientsService.page(page, Wrappers.query(patients)));
    }


    /**
     * 通过id查询病人表
     * @param  id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('patients_patients_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(patientsService.getById(id));
    }

    /**
     * 新增病人表
     * @param patients 病人表
     * @return R
     */
    @ApiOperation(value = "新增病人表", notes = "新增病人表")
    @SysLog("新增病人表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('patients_patients_add')" )
    public R save(@RequestBody Patients patients) {
        return R.ok(patientsService.save(patients));
    }

    /**
     * 修改病人表
     * @param patients 病人表
     * @return R
     */
    @ApiOperation(value = "修改病人表", notes = "修改病人表")
    @SysLog("修改病人表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('patients_patients_edit')" )
    public R updateById(@RequestBody Patients patients) {
        return R.ok(patientsService.updateById(patients));
    }

    /**
     * 通过id删除病人表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除病人表", notes = "通过id删除病人表")
    @SysLog("通过id删除病人表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('patients_patients_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(patientsService.removeById(id));
    }


	/**
	 * 通过病人表name和iphone查该病人病历信息
	 * @param name iphone
	 * @return R
	 */
	@GetMapping("/name/{name}/{iphone}" )
	@PreAuthorize("@pms.hasPermission('patients_patients_view')" )
	public R getMedicalRecords(@PathVariable("name") String name,@PathVariable("iphone") String iphone) {
		return R.ok(patientsService.QuerysMedicalRecords(name,iphone));
	}
}
