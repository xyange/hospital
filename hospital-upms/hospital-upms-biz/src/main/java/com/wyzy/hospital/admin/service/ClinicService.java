

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.*;
import com.wyzy.hospital.admin.api.entity.Clinic;

import java.util.List;

/**
 * 门诊表
 *
 * @author songM
 * @date 2021-04-16 09:44:55
 */
public interface ClinicService extends IService<Clinic> {

    List<Clinic> selectList(LambdaQueryWrapper<Clinic> likeQuery);
    /**
    * @Description: 删除诊所
    * @Param: [clinic]
    * @return: java.lang.Object
    * @Author: songM
    * @Date: 2021/6/1
    */
    Object delClinicById(Clinic clinic);
    /**
    * @Description: 获取诊所分页列表
    * @Param: [clinicDiagnosisDto, page]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
    * @Author: songM
    * @Date: 2021/6/1
    */
    List<ClinicDiagnosisServiceDto> getClinicPageList(ClinicDiagnosisDto clinicDiagnosisDto, IPage page);

    /**
     * 改变诊所状态 1-上线 0-下线
     *
     * @param clinic
     * @return
     */
    Object changeState(Clinic clinic);

    /**
     * 审核状态
     *
     * @param clinic
     * @return
     */
    Object toExamine(Clinic clinic);


    /**
     * 分页条件查询门诊列表
     *
     * @param clinicDiagnosisDto
     * @return
     */
    List<ClinicDiagnosisServiceDto> getReviewedList(ClinicDiagnosisDto clinicDiagnosisDto, IPage page);

    /**
     * @Description: 根据疾病id查诊所
     * @Param: [diseaseId] 疾病id
     * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage < com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>>
     * @Author: songM
     * @Date: 2021/5/15
     */
    List<ClinicDTO> getClinicBydiseaseId(Integer diseaseId);

    /**
     * @Description: 根据诊所id查询诊所信息
     * @Param: [clinicId]
     * @return: com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto
     * @Author: songM
     * @Date: 2021/5/18
     */
    ClinicDiagnosisBusinessDTO getClinicByClinicId(ClinicDTO clinicDTO);


    /**
     * app 多条件筛选诊所（本地附近）
     *
     * @param distance     距离
     * @param lon          经度
     * @param lat          纬度
     * @param deportmentId 科室id
     * @param diseaseId    疾病id
     * @param area       区域
     * @param keyWord      医生姓名或者诊所名称
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
     * @author wrk
     * @date 2021/05/18 14:40
     */
    List<ClinicNeighborhoodDTO> getNeighborhoodClinics(Double distance, String lon, String lat, Long deportmentId, Long diseaseId, String area, String keyWord);

    /**
     * 查收藏的诊所
     *
     * @param lon 经度
     * @param lat 纬度
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
     * @author wrk
     * @date 2021/05/25 11:22
     */
    IPage<ClinicDiagnosisServiceDto> getCollectedClinic(IPage page, String lon, String lat);

    /**
    * @Description: 查询所有诊所列表
    * @Param: [page, clinic]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/27
    */
    List<ClinicDTO> getAllClinic(IPage<ClinicDTO> page, Clinic clinic);

    /**
    * @Description:  根据诊疗项目id查诊所
    * @Param: [page, clinicDiagnosis]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/27
    */
    List<ClinicDTO> getClinicByDiagnosisId(IPage<ClinicDTO> page, ClinicDTO clinicDTO);

    /**
    * @Description: 通过科室id查询诊所
    * @Param: [page, clinic]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/28
    */
    List<ClinicDTO> getClinicByDeptId(IPage<Object> page, ClinicDTO clinic);

    /**
    * @Description: 根据商家名、医疗项目名查询本地诊所
    * @Param: [page, clinicDTO]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/29
    */
    IPage<ClinicDTO> selectLocalClinicByKeyWord(IPage<Object> page, ClinicDTO clinicDTO);
    /**
    * @Description: 查看诊所是否下线
    * @Param: [clinicId]
    * @return: java.lang.String
    * @Author: songM
    * @Date: 2021/6/1
    */
    String selectIfEndStatus(Long clinicId);
    /**
    * @Description: 获取审核拒绝列表
    * @Param: [clinicDiagnosisDto, page]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
    * @Author: songM
    * @Date: 2021/6/7
    */
    List<ClinicDiagnosisServiceDto> getNoReviewedList(ClinicDiagnosisDto clinicDiagnosisDto, IPage page);

    /**
    * @Description: 查询诊所通过诊所id
    * @Param: [clinicId]
    * @return: com.wyzy.hospital.admin.api.entity.Clinic
    * @Author: songM
    * @Date: 2021/6/7
    */
    ClinicDiagnosisServiceDto selectClinicByClinicId(Long clinicId);
}
