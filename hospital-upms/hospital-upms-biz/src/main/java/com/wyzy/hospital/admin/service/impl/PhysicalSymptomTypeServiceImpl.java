
package com.wyzy.hospital.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomType;
import com.wyzy.hospital.admin.mapper.PhysicalSymptomTypeMapper;
import com.wyzy.hospital.admin.service.PhysicalSymptomTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 身体管理症状自查分类
 *
 * @author hospital code generator
 * @date 2021-06-16 17:33:23
 */
@Service
public class PhysicalSymptomTypeServiceImpl extends ServiceImpl<PhysicalSymptomTypeMapper, PhysicalSymptomType> implements PhysicalSymptomTypeService {

    /**
     * 分页查询
     * @param page
     * @return
     */
    @Override
    public IPage<PhysicalSymptomType> pagePhysicalSymptomType(IPage<PhysicalSymptomType> page) {
        List<PhysicalSymptomType> physicalSymptomTypeList = baseMapper.pagePhysicalSymptomType(page);
        IPage<PhysicalSymptomType> physicalSymptomTypeIPage = page.setRecords(physicalSymptomTypeList);
        return physicalSymptomTypeIPage;
    }

    /**
     * 新增身体管理症状自查分类
     * @param physicalSymptomType 身体管理症状自查分类
     * @return R
     */
    @Override
    public boolean savePhysicalSymptomType(PhysicalSymptomType physicalSymptomType) {
        /**
         * 根据名字查重
         */
        PhysicalSymptomType symptomType =baseMapper.selectBySymptomName(physicalSymptomType.getSymptomName());
        if (symptomType == null){
            int insert = baseMapper.insert(physicalSymptomType);
            if (insert>0){
                return true;
            }
        }
        return false;
    }
}
