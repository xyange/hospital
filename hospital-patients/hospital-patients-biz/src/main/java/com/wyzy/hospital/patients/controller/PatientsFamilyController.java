

package com.wyzy.hospital.patients.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.patients.entity.PatientsFamily;
import com.wyzy.hospital.patients.service.PatientsFamilyService;
import com.wyzy.hospital.patients.service.PatientsService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 家人表
 *
 * @author hospital code generator
 * @date 2021-04-13 09:44:46
 */
@RestController
@AllArgsConstructor
@RequestMapping("/patientsfamily" )
@Api(value = "patientsfamily", tags = "家人表管理")
public class PatientsFamilyController {

    private final  PatientsFamilyService patientsFamilyService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param patientsFamily 家人表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('patients_patientsfamily_view')" )
    public R getPatientsFamilyPage(Page page, PatientsFamily patientsFamily) {
        return R.ok(patientsFamilyService.page(page, Wrappers.query(patientsFamily)));
    }


    /**
     * 通过id查询家人表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('patients_patientsfamily_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(patientsFamilyService.getById(id));
    }

    /**
     * 新增家人表
     * @param patientsFamily 家人表
     * @return R
     */
    @ApiOperation(value = "新增家人表", notes = "新增家人表")
    @SysLog("新增家人表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('patients_patientsfamily_add')" )
    public R save(@RequestBody PatientsFamily patientsFamily) {
        return R.ok(patientsFamilyService.save(patientsFamily));
    }

    /**
     * 修改家人表
     * @param patientsFamily 家人表
     * @return R
     */
    @ApiOperation(value = "修改家人表", notes = "修改家人表")
    @SysLog("修改家人表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('patients_patientsfamily_edit')" )
    public R updateById(@RequestBody PatientsFamily patientsFamily) {
        return R.ok(patientsFamilyService.updateById(patientsFamily));
    }

    /**
     * 通过id删除家人表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除家人表", notes = "通过id删除家人表")
    @SysLog("通过id删除家人表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('patients_patientsfamily_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(patientsFamilyService.removeById(id));
    }


	/**
	 * 通过病人id查病人家属
	 * @param  patientsId
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过p.id查询")
	@GetMapping("/selectFamily/{patientsId}" )
	@PreAuthorize("@pms.hasPermission('patients_patientsfamily_view')" )
	public R selectFamily(@PathVariable("patientsId" ) Integer patientsId) {
		return R.ok(patientsFamilyService.QueryPatientsFamily(patientsId));
	}

	/**
	 * 通过病人id查病人家属以及病人家属病历
	 * @param  pid
	 * @return R
	 */
	@ApiOperation(value = "通过pid查询", notes = "通过p.id查询")
	@GetMapping("/QueryPatientsAndFamilyMedical/{pid}" )
	@PreAuthorize("@pms.hasPermission('patients_patientsfamily_view')" )
	public R selectFamilyMedical(@PathVariable("pid" ) Integer pid) {
		return R.ok(patientsFamilyService.QueryPatientsAndFamilyMedical(pid));
	}

	/**
	 * 通过fid查询病历表
	 * @param fid
	 * @return R
	 */
	@GetMapping("/LookFamilyMedicalrecord/{fid}" )
	@PreAuthorize("@pms.hasPermission('patients_patientsfamily_view')" )
	public R getByFamilyMedical(@PathVariable("fid" ) Integer fid) {

		return R.ok(patientsFamilyService.queryFamilyMedical(fid));
	}

}
