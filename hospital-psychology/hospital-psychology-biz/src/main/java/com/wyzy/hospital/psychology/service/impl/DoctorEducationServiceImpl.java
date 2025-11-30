
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.DoctorEducation;
import com.wyzy.hospital.psychology.mapper.DoctorEducationMapper;
import com.wyzy.hospital.psychology.service.DoctorEducationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 心理医生教育学历表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:40
 */
@Service
public class DoctorEducationServiceImpl extends ServiceImpl<DoctorEducationMapper, DoctorEducation> implements DoctorEducationService {

    /**
     * 通过id查询心理医生教育学历表
     * @param doctorId id
     * @return R
     */
    @Override
    public List<DoctorEducation> getDoctorEducationByDoctorId(Long doctorId) {
        return baseMapper.selectDoctorEducationByDoctorId(doctorId);
    }

    /**
     * 新增心理医生教育学历表
     * @param doctorEducation 心理医生教育学历表
     * @return R
     */
    @Override
    public boolean saveDoctorEducation(DoctorEducation doctorEducation) {
        Integer integer = baseMapper.selectDoctorEducationByDoctorEducation(doctorEducation);
        if (integer == 0){
            int insert = baseMapper.insert(doctorEducation);
            if (insert>0){
                return true;
            }
        }
        return false;
    }

}
