

package com.wyzy.hospital.psychology.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.DoctorEducation;

import java.util.List;

/**
 * 心理医生教育学历表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:40
 */
public interface DoctorEducationService extends IService<DoctorEducation> {

    /**
     * 通过id查询心理医生教育学历表
     * @param doctorId id
     * @return R
     */
    List<DoctorEducation> getDoctorEducationByDoctorId(Long doctorId);

    /**
     * 新增心理医生教育学历表
     * @param doctorEducation 心理医生教育学历表
     * @return R
     */
    boolean saveDoctorEducation(DoctorEducation doctorEducation);
}
