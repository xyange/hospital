

package com.wyzy.hospital.psychology.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.DoctorDetail;

/**
 * 心理医生详情表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:21
 */
public interface DoctorDetailService extends IService<DoctorDetail> {

    /**
     * 新增心理医生详情表
     * @param doctorDetail 心理医生详情表
     * @return R
     */
    boolean saveDoctorDetail(DoctorDetail doctorDetail);
}
