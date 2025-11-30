
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.consult.ConsultDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.entity.ConsultDoctor;
import com.wyzy.hospital.admin.api.entity.ConsultOrder;
import com.wyzy.hospital.admin.mapper.AppDoctorMapper;
import com.wyzy.hospital.admin.mapper.ConsultDoctorMapper;
import com.wyzy.hospital.admin.service.ConsultDoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 远程会诊-诊疗模式医生关系表
 *
 * @author songM
 * @date 2021-06-15 15:01:43
 */
@Service
public class ConsultDoctorServiceImpl extends ServiceImpl<ConsultDoctorMapper, ConsultDoctor> implements ConsultDoctorService {

    private ConsultDoctorMapper consultDoctorMapper;

    @Resource
    private AppDoctorMapper appDoctorMapper;

    @Override
    public List<AppDoctorDTO> selectDoctorListById(IPage<AppDoctorDTO> page, ConsultDTO consultDTO) {
        return  appDoctorMapper.selectDoctorListById(page,consultDTO);

    }

    /**
     * 根据医生ID和服务ID查询服务价格
     * @param doctorId 医生ID
     * @return
     */
    @Override
    public BigDecimal selectPriceByDoctorId(Long doctorId) {
        return appDoctorMapper.selectPriceByDoctorId(doctorId);
    }


}
