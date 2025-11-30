
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.CounselType;
import com.wyzy.hospital.psychology.api.entity.DoctorCounsel;
import com.wyzy.hospital.psychology.mapper.CounselTypeMapper;
import com.wyzy.hospital.psychology.service.CounselTypeService;
import com.wyzy.hospital.psychology.service.DoctorCounselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 资讯类型表
 *
 * @author hospital code generator
 * @date 2021-06-11 14:40:23
 */
@Service
public class CounselTypeServiceImpl extends ServiceImpl<CounselTypeMapper, CounselType> implements CounselTypeService {

    @Resource
    DoctorCounselService doctorCounselService;
    /**
     * 通过id删除资讯类型表
     * @param counselId id
     * @return R
     */
    @Override
    public boolean removeCounselTypeById(Integer counselId) {
        DoctorCounsel doctorCounsel = doctorCounselService.selectDoctorCounselCounselTypeId(counselId);
        if (doctorCounsel == null){
            int i = baseMapper.deleteById(counselId);
            if (i>0){
                return true;
            }
        }
        return false;
    }
}
