package com.wyzy.hospital.admin.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDetail;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wrk
 */
@Service
public interface AppDoctorService {
    /**
     * app端查询医生
     *
     * @param keyWord             关键词  医生姓名/症状/科室/医院
     * @param area              区域
     * @param departmentId        科室id
     * @param sortCode            排序(综合排序，咨询人数)
     * @param serviceId           服务id
     * @param priceBegin          最低价格
     * @param priceEnd            最高价格
     * @param professionalTitleId （医生等级）职称
     * @param page                分页
     * @return List<DoctorDTO>
     */

    List<AppDoctorDTO> listAllDoctorBy(String keyWord, String area, Long departmentId,
                                       String sortCode, Long serviceId, Integer priceBegin,
                                       Integer priceEnd, Long professionalTitleId, Page page);

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
    List<AppDoctorDTO> listDoctorByHospital(Long beginNum, Integer pageSize, Long hospitalId);

    /**
     * 根据当前登录的用户查该用户收藏的医生
     *
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.appDoctor.AppDoctorDTO>
     * @author wrk
     * @date 2021/04/20 11:10
     */
    List<AppDoctorDTO> getCollectedDoctors();

    /**
     * 收藏医生/取消收藏医生
     *
     * @param sysUserId 当前登录的用户id
     * @param doctorId  医生id
     * @return R<Boolean>
     * @author
     * @date 2021/04/29 17:44
     */
    R<Boolean> collectedDoctor(Long sysUserId, Long doctorId);

    /**
     * 推荐同类科室的其他医生
     *
     * @param deportmentId
     * @param doctorId
     * @param deportmentName
     * @param doctorName
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>
     * @author wrk
     * @date 2021/05/24 14:10
     */
    List<AppDoctorDTO> appDoctorRecommend(Long deportmentId, Long doctorId, String deportmentName, String doctorName);

    /**
     * 医生详情
     *
     * @param id     医生id
     * @param userId 用户id
     * @return com.wyzy.hospital.admin.api.dto.appDoctor.AppDoctorDetail
     * @author wrk
     * @date 2021/05/11 10:05
     */
    AppDoctorDetail appDoctorDetail(Long id, Long userId);

    /**
     * 医生筛选
     * @param lng
     * @param lat
     * @param distance
     * @param query
     * @param area
     * @param diseaseId
     * @param diseaseName
     * @param deportmentId
     * @param doctorName
     * @param sortCode
     * @param serveId
     * @param priceBegin
     * @param priceEnd
     * @param professionalTitleId
     * @param wellKnown
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO>
     * @author wrk
     * @date 2021/06/02 09:45
     */
    List<AppDoctorDTO> getDoctorByFilter(String lng, String lat, Double distance, Query query, String area, Long diseaseId, String diseaseName, Long deportmentId, String doctorName,
                                         String sortCode, Long serveId, Integer priceBegin, Integer priceEnd,
                                         Long professionalTitleId,Integer wellKnown);
}
