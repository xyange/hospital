package com.wyzy.hospital.admin.kit.impl;


import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.*;
import com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO;
import com.wyzy.hospital.admin.api.dto.department.DiseaseDTO;
import com.wyzy.hospital.admin.api.entity.*;
import com.wyzy.hospital.admin.kit.ClinicKitService;
import com.wyzy.hospital.admin.service.ClinicDiagnosisService;
import com.wyzy.hospital.admin.service.ClinicTechnologyDetailsService;
import com.wyzy.hospital.admin.service.DoctorAttributionService;
import com.wyzy.hospital.admin.service.impl.*;
import com.wyzy.hospital.common.core.util.BeanUtil;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Title: ClinicKitServiceImpl
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/4/17 11:18
 */
@Service
@AllArgsConstructor
public class ClinicKitServiceImpl implements ClinicKitService {

    @Resource
    private ClinicServiceImpl clinicService;


    @Resource
    private ClinicDepartmentsServiceImpl clinicDepartmentsService;

    private DoctorServiceImpl doctorService;

    private DoctorAttributionService doctorAttributionService;

    private ClinicDiagnosisService clinicDiagnosisService;

    private ClinicTechnologyDetailsService clinicTechnologyDetailsService;

    private DoctorDiseaseServiceImpl doctorDiseaseService;


    private ClinicDiagnosisConnectServiceImpl clinicDiagnosisConnectService;

    private ClinicCommentServiceImpl clinicCommentService;

    private ClinicCommentsServiceImpl clinicCommentsService;

    private HospitalUser getUser(){
        return  SecurityUtils.getUser();
    }

    private String GetString(){
        String str= RandomStringUtils.randomAlphanumeric(11).toUpperCase();
        return str;
    }
    /**
     * 分页条件查询门诊列表
     * @param page
     * @param clinicDiagnosisDto
     * @return Page<HospitalsDTO>
     */
    @Override
    public IPage<ClinicDiagnosisServiceDto> getClinicPageByCondition(IPage page, ClinicDiagnosisDto clinicDiagnosisDto) {
        // 查询门诊表的数据
        List<ClinicDiagnosisServiceDto> clinicDiagnosisServiceDtoList = null;
        clinicDiagnosisServiceDtoList = clinicService.getClinicPageList(clinicDiagnosisDto,page);
            // 查询每个诊所的科室并装载数据到 clinicDiagnosisServiceDto
                for (int i = 0; i< clinicDiagnosisServiceDtoList.size(); i++
                ) {
                    String departmentsName = clinicDepartmentsService.selectDepartmentNameByClinicId(clinicDiagnosisServiceDtoList.get(i).getClinicId());
                    clinicDiagnosisServiceDtoList.get(i).setDepartmentsName(departmentsName);
                    //查询医生列表并赋值
                    List<Doctor> doctorList=doctorService.getDoctorList(clinicDiagnosisServiceDtoList.get(i).getClinicId());
                    clinicDiagnosisServiceDtoList.get(i).setDoctorList(doctorList);
                }
                return  page.setRecords(clinicDiagnosisServiceDtoList);
    }
    /**
    * @Description: 查询所有诊所
    * @Param: [page, clinic]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.Clinic>
    * @Author: songM
    * @Date: 2021/5/26
    */
    @Override
    public IPage<ClinicDTO> getAllClinic(IPage<ClinicDTO> page, Clinic clinic) {
        List<ClinicDTO>  clinicList = clinicService.getAllClinic(page,clinic);
        if(clinic.getLatitude()!=null && clinic.getLongitude()!=null){
            Double latDou= Convert.convert(Double.class, clinic.getLatitude());
            Double lonDou= Convert.convert(Double.class, clinic.getLongitude());
            SpatialContext geo = SpatialContext.GEO;
            for(ClinicDTO cli:clinicList){
                Double lonDouTwo=Convert.convert(Double.class,cli.getLongitude());
                Double latDouTwo= Convert.convert(Double.class,cli.getLatitude());
                double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                        * DistanceUtils.DEG_TO_KM;
                cli.setDistance(goDistance);
            }
            Collections.sort(clinicList, new Comparator<ClinicDTO>() {
                @Override
                public int compare(ClinicDTO o1, ClinicDTO o2) {
                    return  ((int)(o1.getDistance()*1000000)-(int)(o2.getDistance()*1000000));
                }
            });
        }
        for(int i =0;i<clinicList.size();i++){
            String departmentsName = clinicDepartmentsService.selectDepartmentNameByClinicId(clinicList.get(i).getClinicId());
            clinicList.get(i).setDepartmentsName(departmentsName.replace(","," "));
        }

        System.out.println(clinicList);
        return page.setRecords(clinicList);
    }

    /**
     * 根据门诊id查询医师团队
     * @param page
     * @param clinicId
     * @return
     */
    @Override
    public IPage<Doctor> getDoctorByClinicId(IPage<Doctor> page, Integer clinicId) {
      List<Doctor> doctorLsit = doctorService.getDoctorByClinicId(clinicId);
      return  page.setRecords(doctorLsit);
    }



    /**
     * 添加门诊
     * @param clinicDoctorDTO 诊所医生DTO
     * @return
     */
    @Override
    @Transactional
    public Boolean addClinic(ClinicDoctorDTO clinicDoctorDTO) {

        //添加诊所表
        Clinic clinic = new Clinic();
        BeanUtil.copyProperties(clinicDoctorDTO,clinic);
        clinic.setSalesmenId(this.getUser().getId());
        clinic.setSalesmenName(this.getUser().getUsername());
        clinic.setSalesmenPhone(this.getUser().getPhone());
        clinic.setApprove("0");
        clinic.setStatus("0");
        clinic.setDelFlag("0");
        clinic.setClinicNumber(GetString());
        boolean status =clinicService.save(clinic);
        if (status){
            //添加诊所科室表
            ClinicDepartments clinicDepartments = new ClinicDepartments();
            clinicDepartments.setClinicId(clinic.getClinicId());
            clinicDepartments.setDepartmentsId(clinic.getDepartmentsId());
            clinicDepartmentsService.save(clinicDepartments);
            for (DoctorDTO d: clinicDoctorDTO.getDoctorList()
            ) {
                //添加医生
                Doctor doctor = new Doctor();
                BeanUtil.copyProperties(d,doctor);
                doctor.setDoctorType(142L);
                doctorService.save(doctor);
                //添加医生诊所关系表
                DoctorAttribution doctorAttribution = new DoctorAttribution();
                doctorAttribution.setDoctorId(doctor.getDoctorId());
                doctorAttribution.setAttributionId(clinic.getClinicId());
                doctorAttribution.setAttributionType(132L);
                doctorAttributionService.add(doctorAttribution);
                //添加医生疾病关系表
                DoctorDisease doctorDisease = new DoctorDisease();
                doctorDisease.setDoctorId(doctor.getDoctorId());
                doctorDisease.setDiseaseId(d.getDiseaseId());
                doctorDiseaseService.save(doctorDisease);

            }

            for (ClinicDiagnosisTechnologyDTO cd: clinicDoctorDTO.getClinicDiagnosisList()
            ) {
                //添加诊疗方案表
                ClinicDiagnosis clinicDiagnosis = new ClinicDiagnosis();
                BeanUtil.copyProperties(cd,clinicDiagnosis);
                clinicDiagnosisService.add(clinicDiagnosis);
                //添加诊疗方案-技术连接表
                ClinicDiagnosisConnect clinicDiagnosisConnect = new ClinicDiagnosisConnect();
                clinicDiagnosisConnect.setClinicId(clinic.getClinicId());
                clinicDiagnosisConnect.setDiagnosisId(clinicDiagnosis.getDiagnosisId());
                clinicDiagnosisConnectService.save(clinicDiagnosisConnect);
                //添加诊疗技术表
                ClinicTechnologyDetails clinicTechnologyDetails = new ClinicTechnologyDetails();
                for( int i = 0; i<cd.getClinicTechnologyDetails().size(); i++){
                    BeanUtil.copyProperties(cd.getClinicTechnologyDetails().get(i),clinicTechnologyDetails);
                    clinicTechnologyDetails.setTechnologyDiagnosisId(clinicDiagnosis.getDiagnosisId());
                    clinicTechnologyDetailsService.save(clinicTechnologyDetails);
                }
                return true;
            }
        }
        return false;
    }

    /**
     *  获取审核列表
     * @param page
     * @param clinicDiagnosisDto
     * @return
     */
    @Override
    public IPage<ClinicDiagnosisDto> getReviewedList(IPage page, ClinicDiagnosisDto clinicDiagnosisDto) {
        // 查询门诊表的数据
        List<ClinicDiagnosisServiceDto> clinicDiagnosisServiceDtoList  = clinicService.getReviewedList(clinicDiagnosisDto,page);
        // 查询每个诊所的科室并装载数据到 clinicDiagnosisServiceDto
        for (int i = 0; i< clinicDiagnosisServiceDtoList.size(); i++
        ) {
            //查询科室列表
            String departmentsName = clinicDepartmentsService.selectDepartmentNameByClinicId(clinicDiagnosisServiceDtoList.get(i).getClinicId());
            clinicDiagnosisServiceDtoList.get(i).setDepartmentsName(departmentsName);
            //查询医生列表并赋值
            List<Doctor> doctorList=doctorService.getDoctorList(clinicDiagnosisServiceDtoList.get(i).getClinicId());
            clinicDiagnosisServiceDtoList.get(i).setDoctorList(doctorList);
        }
        return  page.setRecords(clinicDiagnosisServiceDtoList);
    }

    @Override
    public IPage<ClinicDiagnosisDto> getNoReviewedList(IPage page, ClinicDiagnosisDto clinicDiagnosisDto) {
        // 查询门诊表的数据
        List<ClinicDiagnosisServiceDto> clinicDiagnosisServiceDtoList  = clinicService.getNoReviewedList(clinicDiagnosisDto,page);
        // 查询每个诊所的科室并装载数据到 clinicDiagnosisServiceDto
        for (int i = 0; i< clinicDiagnosisServiceDtoList.size(); i++
        ) {
            //查询科室列表
            String departmentsName = clinicDepartmentsService.selectDepartmentNameByClinicId(clinicDiagnosisServiceDtoList.get(i).getClinicId());
            clinicDiagnosisServiceDtoList.get(i).setDepartmentsName(departmentsName);
            //查询医生列表并赋值
            List<Doctor> doctorList=doctorService.getDoctorList(clinicDiagnosisServiceDtoList.get(i).getClinicId());
            clinicDiagnosisServiceDtoList.get(i).setDoctorList(doctorList);
        }
        return  page.setRecords(clinicDiagnosisServiceDtoList);
    }

    /*******************************************************************************************************************************************************************app端*************************************************************************************************************************/
    /**
    * @Description: 根据疾病id查诊所
    * @Param: [diseaseId]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>>
    * @Author: songM
    * @Date: 2021/5/15
    */
    @Override
    public List<ClinicDTO> getClinicBydiseaseId(ClinicDTO clinic) {
            List<ClinicDTO> clinicList =clinicService.getClinicBydiseaseId(clinic.getDiseaseId());
            if(clinic.getLatitude()!=null && clinic.getLongitude()!=null){
            Double latDou= Convert.convert(Double.class, clinic.getLatitude());
            Double lonDou= Convert.convert(Double.class, clinic.getLongitude());
            SpatialContext geo = SpatialContext.GEO;
            for(ClinicDTO cli:clinicList){
                Double lonDouTwo=Convert.convert(Double.class,cli.getLongitude());
                Double latDouTwo= Convert.convert(Double.class,cli.getLatitude());
                double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                        * DistanceUtils.DEG_TO_KM;
                cli.setDistance(goDistance);
            }
            Collections.sort(clinicList, new Comparator<ClinicDTO>() {
                @Override
                public int compare(ClinicDTO o1, ClinicDTO o2) {
                    return  ((int)(o1.getDistance()*1000000)-(int)(o2.getDistance()*1000000));
                }
            });
        }
        for(int i =0;i<clinicList.size();i++){
            String departmentsName = clinicDepartmentsService.selectDepartmentNameByClinicId(clinicList.get(i).getClinicId());
            clinicList.get(i).setDepartmentsName(departmentsName.replace(","," "));
        }
            return clinicList;
    }

    /**
    * @Description: 根据诊所Id查所有的诊疗方案/诊疗技术
    * @Param: [clinicId] 诊所id
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisTechnologyDTO>
    * @Author: songM
    * @Date: 2021/5/17
    */
    @Override
    public ClinicDiagTechDTO getDiagnosisByClinicId(ClinicDTO clinicDTO) {
        List<ClinicDiagnosis> clinicDiagnosisList =clinicTechnologyDetailsService.getDiagnosisByClinicId(clinicDTO);
        List<ClinicTechnologyDetails> clinicTechnologyDetails =clinicTechnologyDetailsService.getClinicTechnologyByClinicId(clinicDTO);
        ClinicDiagTechDTO clinicDiagTechDTO = new ClinicDiagTechDTO();
        clinicDiagTechDTO.setClinicDiagnosisList(clinicDiagnosisList);
        clinicDiagTechDTO.setClinicTechnologyDetails(clinicTechnologyDetails);
        return clinicDiagTechDTO;
    }

    /**
    * @Description: 通过技术id查询诊疗技术
    * @Param: [technologyId] 技术id
    * @return: com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails
    * @Author: songM
    * @Date: 2021/5/17
    */
    @Override
    public ClinicTechnologyDetails getClinicTechnologyByTechnologyId(Integer technologyId) {
        return clinicTechnologyDetailsService.getClinicTechnologyByTechnologyId(technologyId);
    }

    /**
    * @Description: 根据科室id查询疾病列表
    * @Param: []
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.department.DepartmentDiseaseRewriteDTO>
    * @Author: songM
    * @Date: 2021/5/24
    */
    @Override
    public List<DepartmentDiseaseRewriteDTO> getDiseaseByDeptNum() {
        return clinicDepartmentsService.getDiseaseByDeptNum();
    }

    /**
    * @Description: 根据一级 二级科室id查询疾病列表
    * @Param: [departmentsId] 一级 二级科室id
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.department.DiseaseDTO>
    * @Author: songM
    * @Date: 2021/5/27
    */
    @Override
    public List<DiseaseDTO> getDiseaseByTwoDeptNum(Long departmentsId) {
        return clinicDepartmentsService.getDiseaseByTwoDeptNum(departmentsId);
    }
    /**
    * @Description: 通过诊疗项目id查诊所列表
    * @Param: [page, clinicDiagnosis]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>>
    * @Author: songM
    * @Date: 2021/5/27
    */
    @Override
    public IPage<ClinicDTO> getClinicByDiagnosisId(IPage<ClinicDTO> page, ClinicDTO clinic) {
      List<ClinicDTO>   clinicList    =clinicService.getClinicByDiagnosisId(page,clinic);
        if(clinic.getLatitude()!=null && clinic.getLongitude()!=null){
            Double latDou= Convert.convert(Double.class, clinic.getLatitude());
            Double lonDou= Convert.convert(Double.class, clinic.getLongitude());
            SpatialContext geo = SpatialContext.GEO;
            for(ClinicDTO cli:clinicList){
                Double lonDouTwo=Convert.convert(Double.class,cli.getLongitude());
                Double latDouTwo= Convert.convert(Double.class,cli.getLatitude());
                double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                        * DistanceUtils.DEG_TO_KM;
                cli.setDistance(goDistance);
            }
            Collections.sort(clinicList, new Comparator<ClinicDTO>() {
                @Override
                public int compare(ClinicDTO o1, ClinicDTO o2) {
                    return  ((int)(o1.getDistance()*1000000)-(int)(o2.getDistance()*1000000));
                }
            });
        }
        for(int i =0;i<clinicList.size();i++){
            String departmentsName = clinicDepartmentsService.selectDepartmentNameByClinicId(clinicList.get(i).getClinicId());
            clinicList.get(i).setDepartmentsName(departmentsName.replace(","," "));
        }
      return page.setRecords(clinicList);
    }

    /**
    * @Description: 根据科室id查询诊所列表
    * @Param: [page, clinicDTO]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/28
    */
    @Override
    public List<ClinicDTO> getClinicByDeptId(IPage<Object> page, ClinicDTO clinic) {
        List<ClinicDTO>   clinicList    = clinicService.getClinicByDeptId(page,clinic);
        if(clinic.getLatitude()!=null && clinic.getLongitude()!=null){
            Double latDou= Convert.convert(Double.class, clinic.getLatitude());
            Double lonDou= Convert.convert(Double.class, clinic.getLongitude());
            SpatialContext geo = SpatialContext.GEO;
            for(ClinicDTO cli:clinicList){
                Double lonDouTwo=Convert.convert(Double.class,cli.getLongitude());
                Double latDouTwo= Convert.convert(Double.class,cli.getLatitude());
                double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                        * DistanceUtils.DEG_TO_KM;
                cli.setDistance(goDistance);
            }
            Collections.sort(clinicList, new Comparator<ClinicDTO>() {
                @Override
                public int compare(ClinicDTO o1, ClinicDTO o2) {
                    return  ((int)(o1.getDistance()*1000000)-(int)(o2.getDistance()*1000000));
                }
            });
        }
        for(int i =0;i<clinicList.size();i++){
            String departmentsName = clinicDepartmentsService.selectDepartmentNameByClinicId(clinicList.get(i).getClinicId());
            clinicList.get(i).setDepartmentsName(departmentsName.replace(","," "));
        }
        return clinicList ;
    }

    /**
     * @Description: 根据商家名、医疗项目名查询本地诊所
     * @Param: [page, clinicDTO]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
     * @Author: songM
     * @Date: 2021/5/29
     */
    @Override
    public IPage<ClinicDTO> selectLocalClinicByKeyWord(IPage<Object> page, ClinicDTO clinicDTO) {
        return clinicService.selectLocalClinicByKeyWord(page,clinicDTO);
    }

    /**
    * @Description: 根据诊所id查诊所
    * @Param: [clinicDTO]
    * @return: com.wyzy.hospital.admin.api.dto.ClinicDiagnosisBusinessDTO
    * @Author: songM
    * @Date: 2021/5/29
    */
    @Override
    @Transactional
    public ClinicDiagnosisBusinessDTO getClinicByClinicId(ClinicDTO clinic) {
       ClinicDiagnosisBusinessDTO clinicDiagnosisBusiness = clinicService.getClinicByClinicId(clinic);
       if (clinicDiagnosisBusiness.getClinicDiagnosisList().size() < 5 ){
           clinicDiagnosisBusiness.setClinicDiagnosisList(clinicDiagnosisBusiness.getClinicDiagnosisList());
       }else {
           clinicDiagnosisBusiness.setClinicDiagnosisList(clinicDiagnosisBusiness.getClinicDiagnosisList().subList(0,5));
       }
        if(clinic.getLatitude()!=null && clinic.getLongitude()!=null){
            Double latDou= Convert.convert(Double.class, clinic.getLatitude());
            Double lonDou= Convert.convert(Double.class, clinic.getLongitude());
            SpatialContext geo = SpatialContext.GEO;
            Double lonDouTwo=Convert.convert(Double.class,clinicDiagnosisBusiness.getLongitude());
            Double latDouTwo= Convert.convert(Double.class,clinicDiagnosisBusiness.getLatitude());
            double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                        * DistanceUtils.DEG_TO_KM;
            clinicDiagnosisBusiness.setDistance(goDistance);
        }else{
            Double latDou= Convert.convert(Double.class, 39.915119);
            Double lonDou= Convert.convert(Double.class, 116.403963);
            SpatialContext geo = SpatialContext.GEO;
            Double lonDouTwo=Convert.convert(Double.class,clinicDiagnosisBusiness.getLongitude());
            Double latDouTwo= Convert.convert(Double.class,clinicDiagnosisBusiness.getLatitude());
            double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                    * DistanceUtils.DEG_TO_KM;
            clinicDiagnosisBusiness.setDistance(goDistance);
        }
       List<Doctor> doctorList =doctorService.getDoctorByClinicId(clinicDiagnosisBusiness.getClinicId());
        if (doctorList.size()<5){
            clinicDiagnosisBusiness.setDoctorList(doctorList);
        }else{
            clinicDiagnosisBusiness.setDoctorList(doctorList.subList(0,5));
        }
       return clinicDiagnosisBusiness;
    }

    /**
    * @Description: 根据诊疗项目id查诊疗技术列表
    * @Param: [page, clinicDTO]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicDiagnosis>
    * @Author: songM
    * @Date: 2021/5/31
    */
    @Override
    public IPage<ClinicTechnologyDetails> getTechnologyListByDiagnosisId(IPage<ClinicTechnologyDetails> page, ClinicDTO clinicDTO) {
        List<ClinicTechnologyDetails> clinicDiagnosisList = clinicTechnologyDetailsService.getTechnologyListByDiagnosisId(page,clinicDTO);
        return page.setRecords(clinicDiagnosisList);
    }
    /**
    * @Description: 查看诊所是否下线
    * @Param: [clinicId]
    * @return: java.lang.String
    * @Author: songM
    * @Date: 2021/6/1
    */
    @Override
    public String selectIfEndStatus(Long clinicId) {
        return clinicService.selectIfEndStatus(clinicId);
    }

  /**
  * @Description: 根据诊所id诊疗项目id查询所有评论
  * @Param: [page, clinicId, diagnosisId]
  * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComment>
  * @Author: songM
  * @Date: 2021/6/8
  */
    @Override
    public IPage<ClinicComment> getCommentListByClinicId(IPage<ClinicComment> page, Long clinicId,Long diagnosisId) {
       List<ClinicComment> clinicCommentLists =  clinicCommentService.getCommentListByClinicId(page,clinicId,diagnosisId);
       return page.setRecords(clinicCommentLists);
    }
    /**
    * @Description: 查询诊所通过诊所id
    * @Param: [clinicId]
    * @return: com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto
    * @Author: songM
    * @Date: 2021/6/7
    */
    @Override
    public ClinicDiagnosisServiceDto selectClinicByClinicId(Long clinicId) {
        ClinicDiagnosisServiceDto   clinic   = clinicService.selectClinicByClinicId(clinicId);
        List<Doctor> doctorList =doctorService.getDoctorByClinicId(clinicId);

        clinic.setDoctorList(doctorList);
        return clinic;
    }
    /**
    * @Description: 根据诊所id查询所有评论
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComments>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public IPage<ClinicCommentsDTO> getCommentsListByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        List<ClinicCommentsDTO> clinicCommentsList = clinicCommentsService.getCommentsListByClinicId(page,clinicId);
        return page.setRecords(clinicCommentsList);
    }

    /**
    * @Description: 获取服务环境好的评论
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public IPage<ClinicCommentsDTO> getGoodenvironmentByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        List<ClinicCommentsDTO> clinicCommentsList = clinicCommentsService.getGoodenvironmentByClinicId(page,clinicId);
        return page.setRecords(clinicCommentsList);
    }
    /**
    * @Description: 查询服务好的评论
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public IPage<ClinicCommentsDTO> getGoodServiceByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        List<ClinicCommentsDTO> clinicCommentsList = clinicCommentsService.getGoodServiceByClinicId(page,clinicId);
        return page.setRecords(clinicCommentsList);
    }

    /**
    * @Description: 查询医生棒的评论
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public IPage<ClinicCommentsDTO> getGoodDoctorByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        List<ClinicCommentsDTO> clinicCommentsList = clinicCommentsService.getGoodDoctorByClinicId(page,clinicId);
        return page.setRecords(clinicCommentsList);
    }
}
