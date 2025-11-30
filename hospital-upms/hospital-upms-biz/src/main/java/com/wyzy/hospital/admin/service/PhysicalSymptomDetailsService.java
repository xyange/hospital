

package com.wyzy.hospital.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDetailsDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomDetails;

import java.util.List;

/**
 * 身体管理症状详情
 *
 * @author hospital code generator
 * @date 2021-06-17 09:19:36
 */
public interface PhysicalSymptomDetailsService extends IService<PhysicalSymptomDetails> {

    /**
     * 新增身体管理症状详情
     * @param physicalSymptomDetails 身体管理症状详情
     * @return R
     */
    Boolean savePhysicalSymptomDetails(PhysicalSymptomDetails physicalSymptomDetails);

    /**
     * 通过id查询身体管理症状详情
     * @param id id
     * @return R
     */
    PhysicalSymptomDetails getPhysicalSymptomDetailsById(Long id);

    /**
     * 通过symptomId查询身体管理症状详情
     * @param symptomId
     * @return
     */
    List<PhysicalSymptomDetailsDTO> getPhysicalSymptomDetailsBysymptomId(List<Long> symptomId);
}
