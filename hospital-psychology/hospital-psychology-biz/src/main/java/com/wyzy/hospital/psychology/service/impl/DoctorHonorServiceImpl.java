
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.DoctorHonor;
import com.wyzy.hospital.psychology.mapper.DoctorHonorMapper;
import com.wyzy.hospital.psychology.service.DoctorHonorService;
import org.springframework.stereotype.Service;

/**
 * 心理医生荣誉名称表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:32
 */
@Service
public class DoctorHonorServiceImpl extends ServiceImpl<DoctorHonorMapper, DoctorHonor> implements DoctorHonorService {

    /**
     * 新增心理医生荣誉名称表
     * @param doctorHonor 心理医生荣誉名称表
     * @return R
     */
    @Override
    public boolean saveDoctorHonor(DoctorHonor doctorHonor) {
        DoctorHonor honor = baseMapper.selectDoctorHonorByHonorName(doctorHonor);
        if (honor == null){
            int insert = baseMapper.insert(doctorHonor);
            if (insert>0){
                return true;
            }
        }
        return false;
    }
}
