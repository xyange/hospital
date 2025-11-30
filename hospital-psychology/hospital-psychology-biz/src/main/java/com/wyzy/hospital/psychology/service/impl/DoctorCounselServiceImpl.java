
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.DoctorCounsel;
import com.wyzy.hospital.psychology.mapper.DoctorCounselMapper;
import com.wyzy.hospital.psychology.service.DoctorCounselService;
import org.springframework.stereotype.Service;

/**
 * 心理医生 咨询类型关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:11
 */
@Service
public class DoctorCounselServiceImpl extends ServiceImpl<DoctorCounselMapper, DoctorCounsel> implements DoctorCounselService {

    /**
     * 新增心理医生 咨询类型关系表
     * @param doctorCounsel 心理医生 咨询类型关系表
     * @return R
     */
    @Override
    public boolean saveDoctorCounsel(DoctorCounsel doctorCounsel) {
        DoctorCounsel counsel = baseMapper.selectDoctorCounselBydoctorCounsel(doctorCounsel);
        if (counsel == null){
            int insert = baseMapper.insert(doctorCounsel);
            if (insert>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public DoctorCounsel selectDoctorCounselCounselTypeId(Integer counselId) {
        DoctorCounsel counsel = baseMapper.selectDoctorCounselCounselTypeId(counselId);
        return counsel;
    }
}
