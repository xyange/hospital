
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyzy.hospital.admin.api.entity.DoctorServe;
import com.wyzy.hospital.admin.mapper.DoctorServiceMapper;
import com.wyzy.hospital.admin.service.DoctorServeService;
import org.springframework.stereotype.Service;

/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
@Service
public class DoctorServiceServiceImpl extends ServiceImpl<DoctorServiceMapper, DoctorServe> implements DoctorServeService {

    @Override
    public boolean save(DoctorServe entity) {
        if(baseMapper.save(entity)>0){
            return true;
        }
        return false;
    }
}
