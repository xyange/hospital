
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.DoctorDetail;
import com.wyzy.hospital.psychology.mapper.DoctorDetailMapper;
import com.wyzy.hospital.psychology.service.DoctorDetailService;
import org.springframework.stereotype.Service;

/**
 * 心理医生详情表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:53:21
 */
@Service
public class DoctorDetailServiceImpl extends ServiceImpl<DoctorDetailMapper, DoctorDetail> implements DoctorDetailService {

    /**
     * 新增心理医生详情表
     * @param doctorDetail 心理医生详情表
     * @return R
     */
    @Override
    public boolean saveDoctorDetail(DoctorDetail doctorDetail) {
        DoctorDetail detail = baseMapper.selectByPojo(doctorDetail);
        if (detail == null){
            int insert = baseMapper.insert(doctorDetail);
            if (insert > 0){
                return true;
            }
        }
        return false;
    }
}
