
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.ClinicDiagnosis;
import com.wyzy.hospital.admin.mapper.ClinicDiagnosisMapper;
import com.wyzy.hospital.admin.service.ClinicDiagnosisService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 诊疗项目表
 *
 * @author songM
 * @date 2021-04-17 10:49:36
 */
@Service
public class ClinicDiagnosisServiceImpl extends ServiceImpl<ClinicDiagnosisMapper, ClinicDiagnosis> implements ClinicDiagnosisService {
    /**
     * 根据诊所id 查询诊所列表
     * @param diagnosisQuery
     * @return
     */
    @Override
    public List<ClinicDiagnosis> selectList(LambdaQueryWrapper<ClinicDiagnosis> diagnosisQuery) {
        return baseMapper.selectList(diagnosisQuery);
    }

    /**
     * 添加诊疗项目
     * @param clinicDiagnosis
     * @return
     */
    @Override
    public boolean add(ClinicDiagnosis clinicDiagnosis) {
       int code = baseMapper.insert(clinicDiagnosis);
        if (code>0){
            return true;
        }
        return false;
    }
}
