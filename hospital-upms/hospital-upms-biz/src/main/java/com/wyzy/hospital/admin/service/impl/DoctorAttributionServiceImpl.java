package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.api.entity.DoctorAttribution;
import com.wyzy.hospital.admin.mapper.DoctorAttributionMapper;
import com.wyzy.hospital.admin.service.DoctorAttributionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 医生归属实现类
 *
 * @author wrk
 * @date 2021/04/28 17:09
 **/
@Service
public class DoctorAttributionServiceImpl implements DoctorAttributionService {
    @Resource
    private DoctorAttributionMapper doctorAttributionMapper;
    @Override
    public Boolean batchAddDoctorAttribution(List<DoctorAttribution> list) {
        Integer addFlag=doctorAttributionMapper.batchAddDoctorAttribution(list);
        if(addFlag>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchDeleteDoctorAttribution(Long id) {
        Integer num= doctorAttributionMapper.batchDeleteDoctorAttribution(id);
        if(num>0){
            return true;
        }
        return false;
    }

    @Override
    public int add(DoctorAttribution doctorAttribution) {
      return   doctorAttributionMapper.add(doctorAttribution);
    }
}
