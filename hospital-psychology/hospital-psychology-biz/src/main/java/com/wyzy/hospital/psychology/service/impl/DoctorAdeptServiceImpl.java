
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.dto.DoctorAdeptDTO;
import com.wyzy.hospital.psychology.api.entity.DoctorAdept;
import com.wyzy.hospital.psychology.mapper.DoctorAdeptMapper;
import com.wyzy.hospital.psychology.service.DoctorAdeptService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 心理医生擅长表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:14
 */
@Service
public class DoctorAdeptServiceImpl extends ServiceImpl<DoctorAdeptMapper, DoctorAdept> implements DoctorAdeptService {

    /**
     * 分页查询
     * @return
     */
    @Override
    public IPage<DoctorAdeptDTO> pageDoctorAdept(IPage<DoctorAdeptDTO> page) {
        List<DoctorAdeptDTO> doctorAdeptList = baseMapper.pageDoctorAdept(page);
        IPage<DoctorAdeptDTO> doctorAdeptDTOIPage = page.setRecords(doctorAdeptList);
        return doctorAdeptDTOIPage;
    }

    /**
     * 新增心理医生擅长表
     * @param doctorAdept 心理医生擅长表
     * @return R
     */
    @Override
    public boolean saveDoctorAdept(DoctorAdept doctorAdept) {
        DoctorAdept adept = baseMapper.selectDoctorAdeptByDoctorAdept(doctorAdept);
        if (adept == null){
            int insert = baseMapper.insert(doctorAdept);
            if (insert>0){
                return true;
            }
        }
        return false;
    }
}
