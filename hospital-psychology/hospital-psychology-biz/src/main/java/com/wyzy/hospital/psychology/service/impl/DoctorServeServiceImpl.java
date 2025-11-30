
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.DoctorServe;
import com.wyzy.hospital.psychology.mapper.DoctorServeMapper;
import com.wyzy.hospital.psychology.service.DoctorServeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 心理医生服务关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:02
 */
@Service
public class DoctorServeServiceImpl extends ServiceImpl<DoctorServeMapper, DoctorServe> implements DoctorServeService {

    @Override
    public List<DoctorServe> selectDoctorServeByServeId(Long serveId) {
        return baseMapper.selectDoctorServeByServeId(serveId);
    }
}
