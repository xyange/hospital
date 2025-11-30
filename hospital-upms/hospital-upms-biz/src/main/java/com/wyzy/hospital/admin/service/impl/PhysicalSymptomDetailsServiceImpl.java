
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDetailsDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomDetails;
import com.wyzy.hospital.admin.mapper.PhysicalSymptomDetailsMapper;
import com.wyzy.hospital.admin.service.PhysicalSymptomDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 身体管理症状详情
 *
 * @author hospital code generator
 * @date 2021-06-17 09:19:36
 */
@Service
public class PhysicalSymptomDetailsServiceImpl extends ServiceImpl<PhysicalSymptomDetailsMapper, PhysicalSymptomDetails> implements PhysicalSymptomDetailsService {

    /**
     * 新增身体管理症状详情
     * @param physicalSymptomDetails 身体管理症状详情
     * @return R
     */
    @Override
    public Boolean savePhysicalSymptomDetails(PhysicalSymptomDetails physicalSymptomDetails) {
        PhysicalSymptomDetails symptomDetails = new PhysicalSymptomDetails();
        symptomDetails.setSymptomId(physicalSymptomDetails.getSymptomId());
        symptomDetails.setSymptomName(physicalSymptomDetails.getSymptomName());
        PhysicalSymptomDetails details = baseMapper.selectPhysicalSymptomDetailsByPojo(symptomDetails);
        if (details == null){
            int insert = baseMapper.insert(physicalSymptomDetails);
            if (insert>0){
                return true;
            }
        }
        return null;
    }

    /**
     * 通过id查询身体管理症状详情
     * @param id id
     * @return R
     */
    @Override
    public PhysicalSymptomDetails getPhysicalSymptomDetailsById(Long id) {
        PhysicalSymptomDetails symptomDetails = new PhysicalSymptomDetails();
        symptomDetails.setId(id);
        symptomDetails.setIsOnline(1);
        symptomDetails.setDelFlag(0);
        PhysicalSymptomDetails details = baseMapper.selectPhysicalSymptomDetailsByPojo(symptomDetails);
        return details;
    }

    /**
     * 通过symptomId查询身体管理症状详情
     * @param symptomId
     * @return
     */
    @Override
    public List<PhysicalSymptomDetailsDTO> getPhysicalSymptomDetailsBysymptomId(List<Long> symptomId) {
        return baseMapper.selectPhysicalSymptomDetailsBysymptomId(symptomId);
    }
}
