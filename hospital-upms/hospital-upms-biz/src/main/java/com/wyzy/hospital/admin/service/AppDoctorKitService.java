package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.vo.AppDoctorDetailVO;

/**
 * @author wrk
 */
public interface AppDoctorKitService {
    /**
     * 医生详情
     *
     * @param id     医生id
     * @param userId 用户id
     * @return com.wyzy.hospital.admin.api.dto.appDoctor.AppDoctorDetail
     * @author wrk
     * @date 2021/05/11 10:05
     */
    AppDoctorDetailVO appDoctorDetailVo(Long id, Long userId);
}
