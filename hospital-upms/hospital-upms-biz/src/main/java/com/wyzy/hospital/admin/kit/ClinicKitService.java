package com.wyzy.hospital.admin.kit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.*;
import com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO;
import com.wyzy.hospital.admin.api.dto.department.DiseaseDTO;
import com.wyzy.hospital.admin.api.entity.*;

import java.util.List;


/**
 * @Title: ClinicKitService
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/4/17 11:19
 */
public interface ClinicKitService {
    /**
     * 分页条件查询诊所列表
     * @param page
     * @param clinic
     * @return
     */
    IPage<ClinicDiagnosisServiceDto> getClinicPageByCondition(IPage page, ClinicDiagnosisDto clinic);

    /**
     * 根据门诊id 查医师团队
     * @param page
     * @param clinicId
     * @return
     */
    IPage<Doctor> getDoctorByClinicId(IPage<Doctor> page, Integer clinicId);

    /**
     * 添加诊所信息
     * @param clinicDoctorDTO 诊所医生DTO
     * @return
     */
    Boolean addClinic(ClinicDoctorDTO clinicDoctorDTO);

    /**
     * 查看待审核列表
     * @param page
     * @param clinicDiagnosisDto
     * @return
     */
    IPage<ClinicDiagnosisDto> getReviewedList(IPage  page, ClinicDiagnosisDto clinicDiagnosisDto);

    /**
     * @Description: 查看审核拒绝列表
     * @Param: [page, clinicDiagnosisDto]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisDto>
     * @Author: songM
     * @Date: 2021/6/7
     */
    IPage<ClinicDiagnosisDto> getNoReviewedList(IPage<Object> page, ClinicDiagnosisDto clinicDiagnosisDto);

    /**
    * @Description: 根据疾病id查诊所
    * @Param: [diseaseId] 疾病id
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>>
    * @Author: songM
    * @Date: 2021/5/15
    */
    List<ClinicDTO> getClinicBydiseaseId(ClinicDTO clinicDTO);

    /**
    * @Description: 根据诊所Id查所有的诊疗方案
    * @Param: [clinicId] 诊所Id
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisTechnologyDTO>
    * @Author: songM
    * @Date: 2021/5/17
    */
    ClinicDiagTechDTO getDiagnosisByClinicId(ClinicDTO clinicDTO);
    /**
    * @Description: 根据技术id查询诊疗技术
    * @Param: [technologyId]
    * @return: com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails
    * @Author: songM
    * @Date: 2021/5/17
    */
    ClinicTechnologyDetails getClinicTechnologyByTechnologyId(Integer technologyId);
    /**
    * @Description: 根据科室查询疾病
    * @Param: []
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO>
    * @Author: songM
    * @Date: 2021/5/24
    */
    List<DepartmentDiseaseRewriteDTO> getDiseaseByDeptNum();
    /**
    * @Description: 查询所有的疾病根据二级科室id
    * @Param: [departmentsId] 二级科室id
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.department.DiseaseDTO>
    * @Author: songM
    * @Date: 2021/5/27
    */
    List<DiseaseDTO> getDiseaseByTwoDeptNum(Long departmentsId);
    /**
    * @Description: 查询所有诊所根据科室id
    * @Param: [page, clinic]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/27
    */
    IPage<ClinicDTO> getAllClinic(IPage<ClinicDTO> page, Clinic clinic);
      /**
      * @Description: 通过诊疗项目id查诊所列表
      * @Param: [page, clinicDiagnosis]
      * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
      * @Author: songM
      * @Date: 2021/5/27
      */  
    IPage<ClinicDTO> getClinicByDiagnosisId(IPage<ClinicDTO> page, ClinicDTO clinicDTO);
        /**
        * @Description: 根据科室id查询诊所列表
        * @Param: [page, clinicDTO]
        * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
        * @Author: songM
        * @Date: 2021/5/28
        */
    List<ClinicDTO> getClinicByDeptId(IPage<Object> page, ClinicDTO clinicDTO);

    /**
    * @Description: 根据商家名、医疗项目名查询本地诊所
    * @Param: [page, clinicDTO]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/29
    */
    IPage<ClinicDTO> selectLocalClinicByKeyWord(IPage<Object> page, ClinicDTO clinicDTO);
    /**
    * @Description: 根据诊所id查询诊所
    * @Param: [clinicDTO]
    * @return: com.wyzy.hospital.admin.api.dto.ClinicDiagnosisBusinessDTO
    * @Author: songM
    * @Date: 2021/5/29
    */
    ClinicDiagnosisBusinessDTO getClinicByClinicId(ClinicDTO clinicDTO);
    /**
    * @Description: 通过诊疗项目id查诊疗技术列表
    * @Param: [page, clinicDTO]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicDiagnosis>
    * @Author: songM
    * @Date: 2021/6/1
    */
    IPage<ClinicTechnologyDetails> getTechnologyListByDiagnosisId(IPage<ClinicTechnologyDetails> page, ClinicDTO clinicDTO);
    /**
    * @Description: 查看诊所是否下线
    * @Param: [clinicId]
    * @return: java.lang.String
    * @Author: songM
    * @Date: 2021/6/1
    */
    String selectIfEndStatus(Long clinicId);

   /**
   * @Description: 根据诊所id诊疗项目id查询所有评论
   * @Param: [page, clinicId, diagnosisId]
   * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComment>
   * @Author: songM
   * @Date: 2021/6/8
   */
    IPage<ClinicComment> getCommentListByClinicId(IPage<ClinicComment> page, Long clinicId,Long diagnosisId);
    /**
    * @Description: 查询诊所通过诊所id
    * @Param: [clinicId]
    * @return: java.lang.Object
    * @Author: songM
    * @Date: 2021/6/7
    */
    ClinicDiagnosisServiceDto selectClinicByClinicId(Long clinicId);

    /**
     * 根据诊所id诊疗项目id查询所有评论
     * @param page
     * @param clinicId
     * @return
     */
    IPage<ClinicCommentsDTO> getCommentsListByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
    /**
    * @Description: 获取好的服务环境的评论
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    IPage<ClinicCommentsDTO> getGoodenvironmentByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
    /**
    * @Description: 查询服务好的评论
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    IPage<ClinicCommentsDTO> getGoodServiceByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
    
    /**
    * @Description: 查询医生棒的
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    IPage<ClinicCommentsDTO> getGoodDoctorByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
}
