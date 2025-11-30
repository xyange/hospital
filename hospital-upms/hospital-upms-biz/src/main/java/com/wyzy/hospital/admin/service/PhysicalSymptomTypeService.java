

package com.wyzy.hospital.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomType;

/**
 * 身体管理症状自查分类
 *
 * @author hospital code generator
 * @date 2021-06-16 17:33:23
 */
public interface PhysicalSymptomTypeService extends IService<PhysicalSymptomType> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<PhysicalSymptomType> pagePhysicalSymptomType(IPage<PhysicalSymptomType> page);

    /**
     * 新增身体管理症状自查分类
     * @param physicalSymptomType 身体管理症状自查分类
     * @return R
     */
    boolean savePhysicalSymptomType(PhysicalSymptomType physicalSymptomType);
}
