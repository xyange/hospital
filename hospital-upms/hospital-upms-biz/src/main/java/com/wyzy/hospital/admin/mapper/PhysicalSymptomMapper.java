

package com.wyzy.hospital.admin.mapper;


import com.wyzy.hospital.admin.api.entity.PhysicalSymptom;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 身体管理症状自查
 *
 * @author songM
 * @date 2021-06-17 10:28:22
 */
@Mapper
public interface PhysicalSymptomMapper extends HospitalBaseMapper<PhysicalSymptom> {
    /**
     * 查询树所有的数据列表
     * @return
     */
    List<PhysicalSymptom> symptomTree();
}
