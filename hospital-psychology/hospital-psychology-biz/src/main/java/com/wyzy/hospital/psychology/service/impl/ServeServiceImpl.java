
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.DoctorServe;
import com.wyzy.hospital.psychology.api.entity.Serve;
import com.wyzy.hospital.psychology.mapper.DoctorServeMapper;
import com.wyzy.hospital.psychology.mapper.ServeMapper;
import com.wyzy.hospital.psychology.service.DoctorServeService;
import com.wyzy.hospital.psychology.service.ServeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 心理医生服务表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:07
 */
@Service
public class ServeServiceImpl extends ServiceImpl<ServeMapper, Serve> implements ServeService {
    @Resource
    DoctorServeService doctorServeService;
    /**
     * 通过id删除心理医生服务表
     * @param serveId id
     * @return R
     */
    @Override
    public boolean removeServeById(Long serveId) {
        List<DoctorServe> doctorServe = doctorServeService.selectDoctorServeByServeId(serveId);
        if (doctorServe == null || doctorServe.size() == 0){
            int i = baseMapper.deleteById(serveId);
            if (i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveServe(Serve serve) {
        /**
         * 根据名称查
         */
        Serve serveName = baseMapper.selectDoctorServeByServeName(serve.getServeName());
        if (serveName == null){
            int insert = baseMapper.insert(serve);
            if (insert>0){
                return true;
            }
        }
        return false;
    }
}
