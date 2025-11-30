

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.ClinicDiagnosisDto;
import com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto;
import com.wyzy.hospital.admin.api.dto.ClinicDoctorDTO;
import com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO;
import com.wyzy.hospital.admin.api.dto.department.DiseaseDTO;
import com.wyzy.hospital.admin.api.entity.Clinic;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.kit.impl.ClinicKitServiceImpl;
import com.wyzy.hospital.admin.service.ClinicService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 诊所表
 *
 * @author songM
 * @date 2021-04-16 09:44:55
 */
@RestController
@AllArgsConstructor
@RequestMapping("/clinic" )
@Api(value = "clinic", tags = "诊所表管理")
public class ClinicController {

    private final  ClinicService clinicService;

    private final ClinicKitServiceImpl clinicKitService;

    /**
     * 诊所条件分页查询
     * @param  query 查询条件
     * @param clinicDiagnosisDto  诊所和治疗项目的DTO类
     * @return R
     */
    @ApiOperation(value = "诊所条件分页查询", notes = "诊所条件分页查询")
    @GetMapping("/getClinicPageByCondition" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_view')" )
    public R<IPage<ClinicDiagnosisServiceDto>> getClinicPageByCondition(Query query, ClinicDiagnosisDto clinicDiagnosisDto) {
        return R.ok(clinicKitService.getClinicPageByCondition(Condition.getPage(query),clinicDiagnosisDto));
    }

    /**
     * 通过id查询诊所表
     * @param clinicId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{clinicId}" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_view')" )
    public R getById(@PathVariable("clinicId" ) Long clinicId) {
        return R.ok(clinicKitService.selectClinicByClinicId(clinicId));
    }

    /**
    * @Description:新增诊所表
    * @Param: [clinicDoctorDTO]
    * @return: com.wyzy.hospital.common.core.util.R
    * @Author: songM
    * @Author: songM
    * @Date: 2021/5/18
    */
    @ApiOperation(value = "新增诊所表", notes = "新增诊所表")
    @SysLog("新增诊所表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_clinic_add')" )
    public R save( @RequestBody ClinicDoctorDTO clinicDoctorDTO) {
        return R.ok(clinicKitService.addClinic(clinicDoctorDTO));
    }

    /**
     * 修改诊所表
     * @param clinic 诊所表
     * @return R
     */
    @ApiOperation(value = "修改诊所表", notes = "修改诊所表")
    @SysLog("修改诊所表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_clinic_edit')" )
    public R updateById(@RequestBody Clinic clinic) {
        return R.ok(clinicService.updateById(clinic));
    }

    /**
    * @Description: 通过id删除诊所:伪删除
    * @Param: [clinicId]
    * @return: com.wyzy.hospital.common.core.util.R
    * @Author: songM
    * @Date: 2021/5/18
    */
    @ApiOperation(value = "通过id删除诊所", notes = "通过id删除诊所")
    @SysLog("通过id删除诊所" )
    @DeleteMapping("/{clinicId}" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_del')" )
    public R removeById(@PathVariable Long clinicId) {
        Clinic clinic = new Clinic();
        clinic.setDelFlag("1");
        clinic.setClinicId(clinicId);
        // 查询门诊是否下线，下线以后方可删除
        String status =clinicKitService.selectIfEndStatus(clinicId);
        if ("1".equals(status)){
              return   R.failed("请先下线诊所");
        }
        return R.ok(clinicService.delClinicById(clinic));
    }



    /**
     * 诊所上线下线功能
     * @param
     * @return R
     */
    @ApiOperation(value = "诊所上线下线功能", notes = "诊所上线下线功能")
    @SysLog("诊所上线下线功能" )
    @PutMapping("/changeState")
    @PreAuthorize("@pms.hasPermission('admin_clinic_edit')" )
    public R changeState(@RequestBody Clinic clinic ) {
        return R.ok(clinicService.changeState(clinic));
    }


    /**
     * 根据诊所id查询医师团队
     * @param  query 查询条件
     * @param clinicId  诊所Id
     * @return R<IPage<Doctor>>
     */
    @ApiOperation(value = "根据诊所id查询医师团队", notes = "根据诊所id查询医师团队")
    @GetMapping("/getDoctorByClinicId" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_view')" )
    public R<IPage<Doctor>> getDoctorByClinicId(Query query, @RequestParam("clinicId") Integer clinicId) {
        return R.ok(clinicKitService.getDoctorByClinicId(Condition.getPage(query),clinicId));
    }



    /**
     * 诊所审核 0待审核 1审核中 2审核拒绝
     * @param clinic
     * @return
     */
    @ApiOperation(value = "诊所审核 0待审核 1审核中 2审核拒绝", notes = "诊所审核 0待审核 1审核中 2审核拒绝")
    @SysLog("诊所审核 0待审核 1审核中 2审核拒绝" )
    @PutMapping("/toExamine")
    @PreAuthorize("@pms.hasPermission('admin_clinic_edit')" )
    public R toExamine(@RequestBody Clinic clinic ) {
        return R.ok(clinicService.toExamine(clinic));
    }

    /**
     * 查看待审核列表
     */
    @ApiOperation(value = "查看待审核列表", notes = "查看待审核列表")
    @GetMapping("/getReviewedList" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_view')" )
    public R<IPage<ClinicDiagnosisDto>> getReviewedList(Query query, ClinicDiagnosisDto clinicDiagnosisDto) {
        return R.ok(clinicKitService.getReviewedList(Condition.getPage(query),clinicDiagnosisDto));
    }

    /**
     * 查看审核拒绝列表
     */
    @ApiOperation(value = "查看审核拒绝列表", notes = "查看审核拒绝列表")
    @GetMapping("/getNoReviewedList" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_view')" )
    public R<IPage<ClinicDiagnosisDto>> getNoReviewedList(Query query, ClinicDiagnosisDto clinicDiagnosisDto) {
        return R.ok(clinicKitService.getNoReviewedList(Condition.getPage(query),clinicDiagnosisDto));
    }


    @ApiOperation(value = "根据科室查询疾病", notes = "根据科室查询疾病")
    @GetMapping("/getDiseaseByDeptNum" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_view')" )
    public R<List<DepartmentDiseaseRewriteDTO>> getDiseaseByDeptNum() {
        return R.ok(clinicKitService.getDiseaseByDeptNum());
    }

    @ApiOperation(value = "根据一级 二级科室查询疾病", notes = "根据一级 二级科室查询疾病")
    @GetMapping("/getDiseaseByTwoDeptNum/{departmentsId}" )
    @PreAuthorize("@pms.hasPermission('admin_clinic_view')" )
    public R<List<DiseaseDTO>> getDiseaseByTwoDeptNum(@PathVariable Long departmentsId) {
        return R.ok(clinicKitService.getDiseaseByTwoDeptNum(departmentsId));
    }

}
