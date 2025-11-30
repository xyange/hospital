

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO;
import com.wyzy.hospital.admin.api.dto.ClinicDTO;
import com.wyzy.hospital.admin.api.dto.ClinicDiagTechDTO;
import com.wyzy.hospital.admin.api.entity.Clinic;
import com.wyzy.hospital.admin.api.entity.ClinicComment;
import com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.kit.impl.ClinicKitServiceImpl;
import com.wyzy.hospital.admin.service.ClinicService;
import com.wyzy.hospital.admin.service.UserClinicService;
import com.wyzy.hospital.admin.service.impl.DoctorServiceImpl;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 诊所表_APP端
 *
 * @author songM
 * @date 2021-04-16 09:44:55
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/clinic" )
@Api(value = "appClinic", tags = "app诊所表管理")
public class AppClinicController {

    private final  ClinicService clinicService;

    private final ClinicKitServiceImpl clinicKitService;


    private final DoctorServiceImpl doctorService;


    private final UserClinicService userClinicService;

    /****************************************************************************************患者端******************************************************************************************************************/


    /**
    * @Description: 根据商家名、医疗项目名查询本地诊所
    * @Param: [query, clinicDTO]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>>
    * @Author: songM
    * @Date: 2021/5/29
    *  TODO :需要添加通过本地区域去查
    */
    @ApiOperation(value = "根据商家名、医疗项目名查询本地诊所", notes = "根据商家名、医疗项目名查询本地诊所")
    @GetMapping("/selectLocalClinicByKeyWord" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R<IPage<ClinicDTO>> selectLocalClinicByKeyWord(Query query, ClinicDTO clinicDTO) {
        return R.ok(clinicKitService.selectLocalClinicByKeyWord(Condition.getPage(query),clinicDTO));
    }
    

    /**
    * @Description: APP查询所有诊所
    * @Param: [query, clinic]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.Clinic>>
    * @Author: songM
    * @Date: 2021/5/26
    * TODO :需要添加通过本地区域去查
    */
    @ApiOperation(value = "APP查询所有诊所", notes = "查询所有诊所")
    @GetMapping("/getAllClinic" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R<IPage<ClinicDTO>> getAllClinic(Query query ,Clinic clinic) {
        return R.ok(clinicKitService.getAllClinic(Condition.getPage(query),clinic));
    }


    /**
     * 新增诊所
     * @param clinic 诊所表
     * @return R
     */
    @ApiOperation(value = "新增诊所表", notes = "新增诊所表")
    @SysLog("新增诊所表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R save(@RequestBody Clinic clinic) {
        return R.ok(clinicService.save(clinic));
    }

    /**
     * 修改诊所表
     * @param clinic 诊所表
     * @return R
     */
    @ApiOperation(value = "修改诊所表", notes = "修改诊所表")
    @SysLog("修改诊所表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R updateById(@RequestBody Clinic clinic) {
        return R.ok(clinicService.updateById(clinic));
    }

    /**
     * 通过id删除诊所
     * @param clinicId id
     * @return R
     */
    @ApiOperation(value = "通过id删除诊所", notes = "通过id删除诊所")
    @SysLog("通过id删除诊所" )
    @DeleteMapping("/{clinicId}" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R removeById(@PathVariable Long clinicId) {
        return R.ok(clinicService.removeById(clinicId));
    }


    /**
    * @Description: 根据医生id查询医生信息
    * @Param: [doctorId] 医生id
    * @return: com.wyzy.hospital.common.core.util.R<com.wyzy.hospital.admin.api.entity.Doctor>
    * @Author: songM
    * @Date: 2021/5/15
    */
    @ApiOperation(value = "根据医生id查询医生信息", notes = "根据医生id查询医生信息")
    @GetMapping("/getDoctorById" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R<Doctor> getDoctorById(@RequestParam("doctorId") Integer doctorId) {
        return R.ok(doctorService.getDoctorById(doctorId));
    }

    /**
    * @Description: 根据疾病id查诊所列表
    * @Param: [disease_id] 疾病id
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>>
    * @Author: songM
    * @Date: 2021/5/15
    * TODO :需要添加通过本地区域去查列表
    */
    @ApiOperation(value = "根据疾病id查诊所列表", notes = "根据疾病id查诊所列表")
    @GetMapping("/getClinicBydiseaseId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")")
    public R<List<ClinicDTO>> getClinicBydiseaseId(ClinicDTO clinicDTO){
        return R.ok(clinicKitService.getClinicBydiseaseId(clinicDTO));
    }

    /**
    * @Description: 根据诊所Id查所有的诊疗方案/技术
    * @Param: [clinicId] 诊所id
    * @return: com.wyzy.hospital.common.core.util.R<java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisTechnologyDTO>>
    * @Author: songM
    * @Date: 2021/5/17
    */
    @ApiOperation(value = "根据诊所Id查所有的诊疗方案/技术", notes = "根据诊所Id查所有的诊疗方案/技术")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clinicId", value = "诊所id", paramType = "query"),
    })
    @GetMapping("/getDiagnosisByClinicId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R<ClinicDiagTechDTO> getDiagnosisByClinicId(ClinicDTO clinicDTO){
        return R.ok(clinicKitService.getDiagnosisByClinicId(clinicDTO));
    }


    /**
    * @Description: 通过诊疗技术id查询诊疗技术
    * @Param: [technologyId] 诊疗技术id
    * @return: com.wyzy.hospital.common.core.util.R<com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails>
    * @Author: songM
    * @Date: 2021/5/17
    * *
    */
    @ApiOperation(value = "通过诊疗技术id查询诊疗技术", notes = "通过诊疗技术id查询诊疗技术")
    @GetMapping("/getClinicTechnologyByTechnologyId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<ClinicTechnologyDetails> getClinicTechnologyByTechnologyId(Integer technologyId){
        return R.ok(clinicKitService.getClinicTechnologyByTechnologyId(technologyId));
    }


    /**
    * @Description: 根据诊所id查询医师团队列表
    * @Param: [query, clinicId] 查询条件 ,诊所id
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.Doctor>>
    * @Author: songM
    * @Date: 2021/5/18
    */
    @ApiOperation(value = "根据诊所id查询医师团队列表", notes = "根据诊所id查询医师团队列表")
    @GetMapping("/getDoctorByClinicId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<IPage<Doctor>> getDoctorByClinicId(Query query, @RequestParam("clinicId") Integer clinicId) {
        return R.ok(clinicKitService.getDoctorByClinicId(Condition.getPage(query),clinicId));
    }

    /**
    * @Description: 诊所收藏/取消收藏
    * @Param: [clinicId] 诊所id
    * @return: com.wyzy.hospital.common.core.util.R<java.lang.Integer>
    * @Author: songM
    * @Date: 2021/5/18
    */
    @ApiOperation(value = "诊所收藏/取消收藏", notes = "1收藏 0取消收藏")
    @PostMapping("collectClinic/{clinicId}")
    public R<Integer> collectClinic(@PathVariable("clinicId") Long clinicId){
        HospitalUser user = SecurityUtils.getUser();
        Integer i = userClinicService.collectClinic(user.getId(), clinicId);
        return R.ok(i);
    }

    /**
     * 通过诊所id查询诊所
     * @param clinicDTO
     * @return R
     */
    @ApiOperation(value = "通过诊所id查询诊所", notes = "通过诊所id查询诊所")
    @GetMapping("/getClinicByClinicId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R getClinicByClinicId(ClinicDTO clinicDTO) {
        return R.ok(clinicKitService.getClinicByClinicId(clinicDTO));
    }

    /**
     * 通过诊疗项目id查诊所列表
     * @param query 分页条件
     * @param clinicDTO
     * @return
     */
    @ApiOperation(value = "通过诊疗项目id查诊所列表", notes = "通过诊疗项目id查诊所列表")
    @GetMapping("/getClinicByDiagnosisId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R<IPage<ClinicDTO>> getClinicByDiagnosisId( Query query , ClinicDTO clinicDTO) {
        return R.ok(clinicKitService.getClinicByDiagnosisId(Condition.getPage(query),clinicDTO));
    }


    /**
     * 通过诊疗项目id查诊所技术
     * @param query 分页条件
     * @param clinicDTO
     * @return
     */
    @ApiOperation(value = "通过诊疗项目id和诊所id查诊所技术列表", notes = "通过诊疗项目id查诊所技术列表")
    @GetMapping("/getTechnologyListByDiagnosisId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public R<IPage<ClinicTechnologyDetails>> getTechnologyListByDiagnosisId(Query query , ClinicDTO clinicDTO) {
        return R.ok(clinicKitService.getTechnologyListByDiagnosisId(Condition.getPage(query),clinicDTO));
    }

    /**
    * @Description: 根据科室id查询诊所列表
    * @Param: [query, clinicDTO]
    * @return: com.wyzy.hospital.common.core.util.R
    * @Author: songM
    * @Date: 2021/5/28
    */
    @ApiOperation(value = "根据科室id查询诊所列表", notes = "根据科室id查询诊所列表")
    @GetMapping("/getClinicByDeptId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public  R  getClinicByDeptId( Query query , ClinicDTO clinicDTO ) {
        return R.ok(clinicKitService.getClinicByDeptId(Condition.getPage(query),clinicDTO));
    }

    /**
    * @Description: 根据诊所id诊疗项目id查询所有评论
    * @Param: [query, clinicId, diagnosisId]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComment>>
    * @Author: songM
    * @Date: 2021/6/8
    */
    @ApiOperation(value = "根据诊所id诊疗项目id查询所有评论", notes = "根据诊所id诊疗项目id查询所有评论")
    @GetMapping("/getCommentListByClinicId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public  R<IPage<ClinicComment>>  getCommentListByClinicId(Query query , Long clinicId,Long diagnosisId ) {
        return R.ok(clinicKitService.getCommentListByClinicId(Condition.getPage(query),clinicId,diagnosisId));
    }



    /**
    * @Description: 根据诊所id诊疗项目id查询所有评论
    * @Param: [query, clinicId]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComments>>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @ApiOperation(value = "根据诊所id诊疗项目id查询所有评论", notes = "根据诊所id诊疗项目id查询所有评论")
    @GetMapping("/getCommentsListByClinicId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public  R<IPage<ClinicCommentsDTO>>  getCommentsListByClinicId(Query query , Long clinicId ) {
        return R.ok(clinicKitService.getCommentsListByClinicId(Condition.getPage(query),clinicId));
    }


    /**
     * @Description: 查询服务环境好的评论
     * @Param: [query, clinicId]
     * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComments>>
     * @Author: songM
     * @Date: 2021/6/9
     */
    @ApiOperation(value = "查询服务环境好的评论", notes = "查询服务环境好的评论")
    @GetMapping("/getGoodEnvironmentByClinicId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public  R<IPage<ClinicCommentsDTO>>  getGoodenvironmentByClinicId(Query query , Long clinicId ) {
        return R.ok(clinicKitService.getGoodenvironmentByClinicId(Condition.getPage(query),clinicId));
    }


    /**
     * @Description: 查询服务热情的评论
     * @Param: [query, clinicId]
     * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComments>>
     * @Author: songM
     * @Date: 2021/6/9
     */
    @ApiOperation(value = "查询服务热情的评论", notes = "查询服务热情的评论")
    @GetMapping("/getGoodServiceByClinicId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public  R<IPage<ClinicCommentsDTO>>  getGoodServiceByClinicId(Query query , Long clinicId ) {
        return R.ok(clinicKitService.getGoodServiceByClinicId(Condition.getPage(query),clinicId));
    }

    /**
     * @Description: 查询大夫棒的评论
     * @Param: [query, clinicId]
     * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComments>>
     * @Author: songM
     * @Date: 2021/6/9
     */
    @ApiOperation(value = "查询大夫棒的评论", notes = "查询大夫棒的评论")
    @GetMapping("/getGoodDoctorByClinicId" )
    @PreAuthorize("@pms.hasPermission("+CommonConstants.PATIENT_APP+")" )
    public  R<IPage<ClinicCommentsDTO>>  getGoodDoctorByClinicId(Query query , Long clinicId ) {
        return R.ok(clinicKitService.getGoodDoctorByClinicId(Condition.getPage(query),clinicId));
    }



}
