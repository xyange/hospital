

package com.wyzy.hospital.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.*;
import com.wyzy.hospital.admin.api.entity.Clinic;
import com.wyzy.hospital.common.core.util.MinMaxLngLat;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门诊表
 *
 * @author songM
 * @date 2021-04-16 09:44:55
 */
@Mapper
public interface ClinicMapper extends HospitalBaseMapper<Clinic> {
    /**
    * @Description: 通过条件查询诊所列表
    * @Param: [clinicDiagnosisDto, page]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
    * @Author: songM
    * @Date: 2021/5/25
    */
    List<ClinicDiagnosisServiceDto> getClinicPageList(@Param("clinicDiagnosisDto") ClinicDiagnosisDto clinicDiagnosisDto, @Param("page") IPage page);
    /**
    * @Description: 查询审核列表
    * @Param: [clinicDiagnosisDto, page]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
    * @Author: songM
    * @Date: 2021/5/25
    */
    List<ClinicDiagnosisServiceDto> getReviewedList(@Param("clinicDiagnosisDto") ClinicDiagnosisDto clinicDiagnosisDto, @Param("page") IPage page);

    /**
     * @Description: 获取审核拒绝列表
     * @Param: [clinicDiagnosisDto, page]
     * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
     * @Author: songM
     * @Date: 2021/6/7
     */
    List<ClinicDiagnosisServiceDto> getNoReviewedList(@Param("clinicDiagnosisDto") ClinicDiagnosisDto clinicDiagnosisDto, @Param("page") IPage page);
    /**
     * @Description: 根据疾病id查诊所列表
     * @Param: [diseaseId] 疾病id
     * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
     * @Author: songM
     * @Date: 2021/5/18
     */
    List<ClinicDTO> getClinicBydiseaseId(@Param("diseaseId") Integer diseaseId);

    /**
     * @Description: 根据诊所id查询诊所信息
     * @Param: [clinicId] 诊所id
     * @return: com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto
     * @Author: songM
     * @Date: 2021/5/18
     */
    ClinicDiagnosisBusinessDTO getClinicByClinicId(@Param("clinicDTO") ClinicDTO clinicDTO);


    /**
     * app 多条件筛选诊所（本地附近）
     *
     * @param geoCode      地理geocode编码
     * @param deportmentId 科室id
     * @param diseaseId    疾病id
     * @param area       区域
     * @param keyWord      关键词
     * @param minMaxLngLat 最大最小经纬度范围
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
     * @author wrk
     * @date 2021/05/18 15:02
     */
    List<ClinicNeighborhoodDTO> getNeighborhoodClinics(@Param("geoCode") String geoCode,
                                                       @Param("deportmentId") Long deportmentId,
                                                       @Param("diseaseId") Long diseaseId,
                                                       @Param("area") String area,
                                                       @Param("keyWord") String keyWord,
                                                       @Param("minMaxLngLat") MinMaxLngLat minMaxLngLat);

    /**
     * 查收藏的诊所
     *
     * @param userId
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
     * @author wrk
     * @date 2021/05/25 11:11
     */
    List<ClinicDiagnosisServiceDto> getCollectedClinic(@Param("userId") Long userId);

    /**
    * @Description: 查询所有诊所 
    * @Param: [page, clinic]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.Clinic>
    * @Author: songM
    * @Date: 2021/5/26
    */
    List<ClinicDTO> getAllClinic(@Param("page") IPage page, @Param("clinic") Clinic clinic);

    /**
    * @Description: 通过诊疗项目id查诊所列表
    * @Param: [page, clinicDiagnosis]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/27
    */
    List<ClinicDTO> getClinicByDiagnosisId(@Param("page") IPage<ClinicDTO> page,  @Param("clinicDTO")ClinicDTO clinicDTO);
    /**
    * @Description: 根据科室id查询诊所列表
    * @Param: [clinic]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/28
    */
    List<ClinicDTO> getClinicByDeptId(@Param("clinic") ClinicDTO clinic);

    /**
    * @Description: 根据商家名、医疗项目名查询本地诊所
    * @Param: [page, clinicDTO]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/29
    */
    IPage<ClinicDTO> selectLocalClinicByKeyWord(@Param("page")IPage<Object> page,@Param("clinicDTO") ClinicDTO clinicDTO);
    /**
    * @Description: 查询是否下线
    * @Param: [clinicId]
    * @return: java.lang.String 0下线/1上线
    * @Author: songM
    * @Date: 2021/6/1
    */
    String selectIfEndStatus(@Param("clinicId") Long clinicId);
    /**
    * @Description: 查询诊所通过诊所id
    * @Param: [clinicId]
    * @return: com.wyzy.hospital.admin.api.entity.Clinic
    * @Author: songM
    * @Date: 2021/6/7
    */
    ClinicDiagnosisServiceDto selectClinicByClinicId(@Param("clinicId") Long clinicId);
}
