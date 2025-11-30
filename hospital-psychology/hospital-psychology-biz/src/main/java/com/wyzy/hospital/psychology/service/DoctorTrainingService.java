

package com.wyzy.hospital.psychology.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.DoctorTraining;

import java.util.List;

/**
 * 心理医生培训表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:49
 */
public interface DoctorTrainingService extends IService<DoctorTraining> {

    /**
     * 通过doctorId查询心理医生培训表
     * @param doctorId id
     * @return R
     */
    List<DoctorTraining> getByDoctorId(Long doctorId);

    /**
     * 新增心理医生培训表
     * @param doctorTraining 心理医生培训表
     * @return R
     */
    boolean saveDoctorTraining(DoctorTraining doctorTraining);
}
