
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.DoctorTraining;
import com.wyzy.hospital.psychology.mapper.DoctorTrainingMapper;
import com.wyzy.hospital.psychology.service.DoctorTrainingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 心理医生培训表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:49
 */
@Service
public class DoctorTrainingServiceImpl extends ServiceImpl<DoctorTrainingMapper, DoctorTraining> implements DoctorTrainingService {

    /**
     * 通过doctorId查询心理医生培训表
     * @param doctorId id
     * @return R
     */
    @Override
    public List<DoctorTraining> getByDoctorId(Long doctorId) {
        return baseMapper.selectByDoctorId(doctorId);
    }

    /**
     * 新增心理医生培训表
     * @param doctorTraining 心理医生培训表
     * @return R
     */
    @Override
    public boolean saveDoctorTraining(DoctorTraining doctorTraining) {
        Integer integer = baseMapper.selectByDoctorTraining(doctorTraining);
        if (integer == 0){
            int insert = baseMapper.insert(doctorTraining);
            if (insert>0){
                return true;
            }
        }
        return false;
    }
}
