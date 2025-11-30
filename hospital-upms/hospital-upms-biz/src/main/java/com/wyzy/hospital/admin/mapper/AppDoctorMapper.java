package com.wyzy.hospital.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.consult.ConsultDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDetail;
import com.wyzy.hospital.common.core.util.MinMaxLngLat;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * @author Wrk
 */

public interface AppDoctorMapper {
    /**
     * app端查询医生
     *
     * @param doctorIds           医生ids
     * @param keyWord             关键词 医生姓名/症状/科室/医院
     * @param area              区域
     * @param departmentId        科室id
     * @param sortCode            排序(综合排序，咨询人数)
     * @param serviceId           服务id
     * @param priceBegin          最低价格
     * @param priceEnd            最高价格
     * @param professionalTitleId （医生等级）职称
     * @param pageBegin           分页
     * @param pageSize            分页大小
     * @return List<DoctorDTO>
     */

    List<AppDoctorDTO> listAllDoctorBy(@Param("keyWord") String keyWord, @Param("doctorIds") String doctorIds, @Param("area") String area, @Param("departmentId") Long departmentId,
                                       @Param("sortCode") String sortCode, @Param("serviceId") Long serviceId, @Param("priceBegin") Integer priceBegin,
                                       @Param("priceEnd") Integer priceEnd, @Param("professionalTitleId") Long professionalTitleId, @Param("pageBegin") Integer pageBegin,
                                       @Param("pageSize") Integer pageSize);

    /**
     * 根据医院查医生
     *
     * @param beginNum   开始
     * @param pageSize   页大小
     * @param hospitalId 医院id
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.appDoctor.AppDoctorDTO>
     * @author
     * @date 2021/04/20 11:10
     */
    List<AppDoctorDTO> listDoctorByHospital(@Param("beginNum") Long beginNum, @Param("pageSize") Integer pageSize, @Param("hospitalId") Long hospitalId);

    /**
     * 根据当前登录的用户查该用户收藏的医生
     *
     * @param id
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.appDoctor.AppDoctorDTO>
     * @author wrk
     * @date 2021/04/29 17:27
     */
    List<AppDoctorDTO> getCollectedDoctors(@Param("id") Long id);

    /**
     * 收藏医生
     *
     * @param doctorId  医生id
     * @param sysUserId 用户id
     * @return java.lang.Integer
     * @author wrk
     * @date 2021/04/29 17:33
     */
    Integer collectDoctor(@Param("doctorId") Long doctorId, @Param("sysUserId") Long sysUserId);

    /**
     * 取消收藏医生
     *
     * @param doctorId  医生id
     * @param sysUserId 用户id
     * @return java.lang.Integer
     * @author wrk
     * @date 2021/04/29 17:33
     */
    Integer cancelCollectDoctor(@Param("doctorId") Long doctorId, @Param("sysUserId") Long sysUserId);


    /**
     * 根据疾病查医生id
     *
     * @param keyWord
     * @return java.lang.String
     * @author wrk
     * @date 2021/05/08 14:53
     */
    String listDoctorIdByDisease(@Param("keyWord") String keyWord);

    /**
     * 推荐同类科室的其他医生
     *
     * @param deportmentId
     * @param doctorId
     * @param deportmentName
     * @param doctorName
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>
     * @author wrk
     * @date 2021/05/24 14:12
     */
    List<AppDoctorDTO> appDoctorRecommend(@Param("deportmentId") Long deportmentId, @Param("doctorId") Long doctorId,
                                          @Param("deportmentName") String deportmentName, @Param("doctorName") String doctorName);

    /**
     * 医生详情
     *
     * @param id     医生id
     * @param userId 用户id
     * @return com.wyzy.hospital.admin.api.dto.appDoctor.AppDoctorDetail
     * @author wrk
     * @date 2021/05/11 10:07
     */

    AppDoctorDetail appDoctorDetail(@Param("id") Long id, @Param("userId") Long userId);

    /**
     * 查是否收藏
     *
     * @param doctorId
     * @param userId
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author wrk
     * @date 2021/05/21 18:32
     */
    Map<String, Object> isCollect(@Param("doctorId") Long doctorId, @Param("userId") Long userId);

    /**
     * 医生筛选
     *
     * @param sortCode
     * @param doctorIds
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>
     * @author wrk
     * @date 2021/06/01 08:44
     */
    List<AppDoctorDTO> getDoctorByFilter(@Param("sortCode") String sortCode, @Param("doctorIds") String doctorIds);

    /**
     * 筛选出医生id
     * @param minMaxLngLat
     * @param pageBegin
     * @param pageSize
     * @param area
     * @param diseaseId
     * @param diseaseName
     * @param deportmentId
     * @param doctorName
     * @param serveId
     * @param priceBegin
     * @param priceEnd
     * @param professionalTitleId
     * @param wellKnown
     * @return java.lang.String
     * @author wrk
     * @date 2021/06/02 08:50
     */
    String getDoctorIdByFilter(@Param("minMaxLngLat")MinMaxLngLat minMaxLngLat,@Param("pageBegin") Integer pageBegin, @Param("pageSize") Integer pageSize,
                               @Param("area") String area, @Param("diseaseId") Long diseaseId, @Param("diseaseName") String diseaseName,
                               @Param("deportmentId") Long deportmentId, @Param("doctorName") String doctorName,
                               @Param("serveId") Long serveId,
                               @Param("priceBegin") Integer priceBegin,
                               @Param("priceEnd") Integer priceEnd,
                               @Param("professionalTitleId") Long professionalTitleId,@Param("wellKnown")Integer wellKnown);


    /**
     * @Description: 查询平台专家通过疾病id和诊疗模式id
     * @Param: [page, consultDTO]
     * @return: java.util.List<com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>
     * @Author: songM
     * @Date: 2021/6/15
     */
    List<AppDoctorDTO> selectDoctorListById(@Param("page") IPage<AppDoctorDTO> page, @Param("consultDTO") ConsultDTO consultDTO);

    /**
     * 根据医生ID和服务ID查询服务价格
     * @return
     */
    BigDecimal selectPriceByDoctorId(@Param("doctorId") Long doctorId);
}
