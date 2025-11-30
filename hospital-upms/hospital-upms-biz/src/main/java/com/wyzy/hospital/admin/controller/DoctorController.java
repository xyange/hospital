

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.PcDoctorDTO;
import com.wyzy.hospital.admin.api.dto.department.DiseaseDTO;
import com.wyzy.hospital.admin.kit.DoctorKitService;
import com.wyzy.hospital.admin.service.ClinicDepartmentsService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.service.DoctorService;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 医生
 *
 * @author wrk
 * @date 2021-04-16 10:29:02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctor")
@Api(value = "doctor", tags = "医生管理")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorKitService doctorKitService;
    private final ClinicDepartmentsService clinicDepartmentsService;

    /**
     * 新增医生
     *
     * @param pcDoctor 医生
     * @return R
     */
    @ApiOperation(value = "新增医生", notes = "新增医生")
    @SysLog("新增医生")
    @PostMapping("saveDoctor")
    @PreAuthorize("@pms.hasPermission('admin_doctor_add')")
    public R saveDoctor(@RequestBody PcDoctorDTO pcDoctor) {
        return doctorKitService.addDoctor(pcDoctor);
    }


    /**
     * 通过id删除医生
     *
     * @param doctorId id
     * @return R
     */
    @ApiOperation(value = "通过id删除医生", notes = "通过id删除医生")
    @SysLog("通过id删除医生")
    @DeleteMapping("/{doctorId}")
    @PreAuthorize("@pms.hasPermission('admin_doctor_del')")
    public R removeById(@PathVariable Long doctorId) {
        return R.ok(doctorService.deleteDoctorById(doctorId));
    }


    /**
     * 后台管理医生筛选
     *
     * @param passDateBegin 审核通过日期
     * @param passDateEnd   审核通过日期
     * @param nameOrPhone   姓名或者电话
     * @param source        信息来源（医院，诊所，工作室,后台）
     * @param status        状态
     * @param inComeType    收入类型
     * @param inComeBegin   收入
     * @param inComeEnd     收入
     * @param salePhone     销售人电话
     * @param departmentIds 科室id
     * @param page          分页
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.PcDoctorDTO>
     * @author
     * @date 2021/04/17 11:54
     */

    @ApiOperation(value = "后台管理医生筛选", notes = "后台管理医生筛选")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "分页", paramType = "query"),
            @ApiImplicitParam(name = "passDateBegin", value = "审核通过日期", paramType = "query"),
            @ApiImplicitParam(name = "passDateEnd", value = "审核通过日期", paramType = "query"),
            @ApiImplicitParam(name = "nameOrPhone", value = "姓名或者电话", paramType = "query"),
            @ApiImplicitParam(name = "source", value = "信息来源（医院，诊所，工作室,后台）", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", paramType = "query"),
            @ApiImplicitParam(name = "inComeType", value = "收入类型", paramType = "query"),
            @ApiImplicitParam(name = "inComeBegin", value = "收入", paramType = "query"),
            @ApiImplicitParam(name = "inComeEnd", value = "收入", paramType = "query"),
            @ApiImplicitParam(name = "salePhone", value = "销售人电话", paramType = "query"),
            @ApiImplicitParam(name = "departmentIds", value = "科室id", paramType = "query"),
    })
    @GetMapping("/getDoctorByPage")
    @PreAuthorize("@pms.hasPermission('admin_doctor_view')")
    public R getDoctorByPage(Page page, String passDateBegin, String passDateEnd,
                             String nameOrPhone, Integer source,
                             Integer status, Long inComeType,
                             Long inComeBegin, Long inComeEnd,
                             String salePhone, String departmentIds) {
        return R.ok(doctorService.pcListDoctorBy(passDateBegin, passDateEnd, nameOrPhone, source, status, inComeType, inComeBegin, inComeEnd, salePhone, departmentIds, page));
    }

    /**
     * 根据归属类型查机构
     *
     * @param id   归属类型
     * @param name 医院/诊所名称
     * @return com.wyzy.hospital.common.core.util.R
     * @author wrk
     * @date 2021/04/30 09:28
     */
    @ApiOperation(value = "根据归属类型查机构", notes = "根据归属类型查机构")
    @GetMapping("/getInstitutions")
    @PreAuthorize("@pms.hasPermission('admin_doctor_add')")
    public R getInstitutions(Long id, String name) {
        return R.ok(doctorService.listInstitutions(id, name));
    }


    /**
     * 根据id查医生
     *
     * @param id 医生id
     * @return com.wyzy.hospital.common.core.util.R
     * @author
     * @date 2021/04/29 15:26
     */
    @ApiOperation(value = "根据id查询", notes = "根据id查询")
    @GetMapping("/getDoctorById")
    @PreAuthorize("@pms.hasPermission('admin_doctor_view')")
    public R getDoctorById(Long id) {
        return R.ok(doctorService.getDoctorById(id));
    }

    /**
     * 根据id修改医生
     *
     * @param doctor 医生
     * @return com.wyzy.hospital.common.core.util.R
     * @author
     * @date 2021/04/29 15:26
     */
    @ApiOperation(value = "根据id查询", notes = "根据id查询")
    @GetMapping("/editDoctorById")
    @PreAuthorize("@pms.hasPermission('admin_doctor_edit')")
    public R editDoctorById(@RequestBody PcDoctorDTO doctor) {
        return R.ok(doctorKitService.editDoctorById(doctor));
    }


    /**
     * 医生审核
     *
     * @param doctorId         医生id
     * @param examStatusId     审核状态
     * @param examDetailResult 审核结果详情
     * @return com.wyzy.hospital.common.core.util.R
     * @author wrk
     * @date 2021/04/30 10:26
     */
    @ApiOperation(value = "医生审核", notes = "医生审核")
    @GetMapping("/examDoctor")
    @PreAuthorize("@pms.hasPermission('admin_doctor_exam')")
    public R editDoctorById(Long doctorId, Long examStatusId, String examDetailResult) {
        Long examPersonId = SecurityUtils.getUser().getId().longValue();
        return R.ok(doctorService.examDoctor(doctorId, examStatusId, examDetailResult, examPersonId));
    }


    /**
     * @param departmentId
     * @return com.wyzy.hospital.common.core.util.R<java.util.List < com.wyzy.hospital.admin.api.dto.department.DiseaseDTO>>
     * @author
     * @date 2021/06/01 17:20
     */
    @ApiOperation(value = "根据一级 二级科室查询疾病", notes = "根据一级 二级科室查询疾病")
    @GetMapping("/getDiseaseByDept/{departmentsId}" )
    @PreAuthorize("@pms.hasPermission('admin_doctor_view')" )
    public R<List<DiseaseDTO>> getDiseaseByDept(@PathVariable Long departmentId) {
        return R.ok(clinicDepartmentsService.getDiseaseByTwoDeptNum(departmentId));
    }



}
