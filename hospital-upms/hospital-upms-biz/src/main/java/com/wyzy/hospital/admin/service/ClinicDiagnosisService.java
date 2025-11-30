

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.ClinicDiagnosis;

import java.util.List;

/**
 * 诊疗项目表
 *
 * @author songM
 * @date 2021-04-17 10:49:36
 */
public interface ClinicDiagnosisService extends IService<ClinicDiagnosis> {
    /**
     * 根据诊所id查询诊疗项目列表
     * @param diagnosisQuery
     * @return List<ClinicDiagnosis>
     */
    List<ClinicDiagnosis> selectList(LambdaQueryWrapper<ClinicDiagnosis> diagnosisQuery);

    /**
     * 添加
     * @param clinicDiagnosis
     * @return
     */
    boolean add(ClinicDiagnosis clinicDiagnosis);
}
