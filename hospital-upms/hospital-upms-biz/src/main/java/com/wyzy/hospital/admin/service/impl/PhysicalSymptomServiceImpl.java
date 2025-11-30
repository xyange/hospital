
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptom;
import com.wyzy.hospital.admin.mapper.PhysicalSymptomMapper;
import com.wyzy.hospital.admin.service.PhysicalSymptomService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 身体管理症状自查
 *
 * @author songM
 * @date 2021-06-17 10:28:22
 */
@Service
public class PhysicalSymptomServiceImpl extends ServiceImpl<PhysicalSymptomMapper, PhysicalSymptom> implements PhysicalSymptomService {
    @Override
    public List<PhysicalSymptom> symptomTree() {
        return baseMapper.symptomTree();
    }
}
