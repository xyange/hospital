

package com.wyzy.hospital.patients.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.patients.entity.MedicalRecord;
import com.wyzy.hospital.patients.service.MedicalRecordService;
import com.wyzy.hospital.patients.service.PatientsFamilyService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 病历表
 *
 * @author hospital code generator
 * @date 2021-04-14 15:01:00
 */
@RestController
@AllArgsConstructor
@RequestMapping("/medicalrecord" )
@Api(value = "medicalrecord", tags = "病历表管理")
public class MedicalRecordController {

    private final  MedicalRecordService medicalRecordService;
	private final PatientsFamilyService patientsFamilyService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param medicalRecord 病历表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('patients_medicalrecord_view')" )
    public R getMedicalRecordPage(Page page, MedicalRecord medicalRecord) {
        return R.ok(medicalRecordService.page(page, Wrappers.query(medicalRecord)));
    }


    /**
     * 通过id查询病历表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('patients_medicalrecord_view')" )
    public R getById(@PathVariable("id" ) String id) {
        return R.ok(medicalRecordService.getById(id));
    }

    /**
     * 新增病历表
     * @param medicalRecord 病历表
     * @return R
     */
    @ApiOperation(value = "新增病历表", notes = "新增病历表")
    @SysLog("新增病历表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('patients_medicalrecord_add')" )
    public R save(@RequestBody MedicalRecord medicalRecord) {
        return R.ok(medicalRecordService.save(medicalRecord));
    }

    /**
     * 修改病历表
     * @param medicalRecord 病历表
     * @return R
     */
    @ApiOperation(value = "修改病历表", notes = "修改病历表")
    @SysLog("修改病历表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('patients_medicalrecord_edit')" )
    public R updateById(@RequestBody MedicalRecord medicalRecord) {
        return R.ok(medicalRecordService.updateById(medicalRecord));
    }

    /**
     * 通过id删除病历表
     * @param  id
     * @return R
     */
    @ApiOperation(value = "通过id删除病历表", notes = "通过id删除病历表")
    @SysLog("通过id删除病历表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('patients_medicalrecord_del')" )
    public R removeById(@PathVariable String id) {
        return R.ok(medicalRecordService.removeById(id));
    }

	/**
	 * 通过fid查询病历表
	 * @param fid
	 * @return R
	 */
	@GetMapping("/SelectFamilyMedicalrecord/{fid}" )
	@PreAuthorize("@pms.hasPermission('patients_medicalrecord_view')" )
	public R getById(@PathVariable("fid" ) Integer fid) {
		return R.ok(medicalRecordService.QueryFamilyMedical(fid));
	}

	/**
	 * 通过fid删除病人家属及病人病历
	 * @param  fid
	 * @return R
	 */
	@DeleteMapping("/remove/{fid}" )
	@PreAuthorize("@pms.hasPermission('patients_medicalrecord_del')" )
	public void  removeFamilyFid(@PathVariable Integer fid) {
		  System.out.println(fid);
		  Integer id=fid;
		  patientsFamilyService.removeById(id);
		 medicalRecordService.removerPatientsFamily(fid);
	}
}
