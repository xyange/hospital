
package com.wyzy.hospital.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.PhysicalFitnessDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalFitness;
import com.wyzy.hospital.admin.mapper.PhysicalFitnessMapper;
import com.wyzy.hospital.admin.service.PhysicalFitnessService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 身体管理体能
 *
 * @author hospital code generator
 * @date 2021-06-16 15:13:44
 */
@Service
public class PhysicalFitnessServiceImpl extends ServiceImpl<PhysicalFitnessMapper, PhysicalFitness> implements PhysicalFitnessService {

    /**
     * 通过memberId查询身体管理体能
     * @param memberId id
     * @return R
     */
    @Override
    public IPage<PhysicalFitnessDTO> getByMemberId(IPage<PhysicalFitnessDTO> page, Long memberId) {
        List<PhysicalFitnessDTO> physicalFitnessList = baseMapper.getByMemberId(page,memberId);
        IPage<PhysicalFitnessDTO> physicalFitnessIPage = page.setRecords(physicalFitnessList);
        return physicalFitnessIPage;
    }


}
