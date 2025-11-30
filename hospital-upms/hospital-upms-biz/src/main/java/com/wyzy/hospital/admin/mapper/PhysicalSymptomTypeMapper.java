

package com.wyzy.hospital.admin.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomType;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 身体管理症状自查分类
 *
 * @author hospital code generator
 * @date 2021-06-16 17:33:23
 */
@Mapper
public interface PhysicalSymptomTypeMapper extends HospitalBaseMapper<PhysicalSymptomType> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<PhysicalSymptomType> pagePhysicalSymptomType(IPage<PhysicalSymptomType> page);

    /**
     * 根据名字查重
     * @param symptomName
     * @return
     */
    PhysicalSymptomType selectBySymptomName(@Param("symptomName") String symptomName);
}
