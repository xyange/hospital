

package com.wyzy.hospital.admin.mapper;


import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDetailsDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomDetails;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 身体管理症状详情
 *
 * @author hospital code generator
 * @date 2021-06-17 09:19:36
 */
@Mapper
public interface PhysicalSymptomDetailsMapper extends HospitalBaseMapper<PhysicalSymptomDetails> {

  /**
   * 通过pojo查询身体管理症状详情
   * @param id id
   * @return R
   */
  PhysicalSymptomDetails selectPhysicalSymptomDetailsByPojo(@Param("symptomDetails") PhysicalSymptomDetails symptomDetails);

  /**
   * 通过symptomId查询身体管理症状详情
   * @param symptomId
   * @return
   */
  List<PhysicalSymptomDetailsDTO> selectPhysicalSymptomDetailsBysymptomId(@Param("symptomId") List<Long> symptomId);
}
