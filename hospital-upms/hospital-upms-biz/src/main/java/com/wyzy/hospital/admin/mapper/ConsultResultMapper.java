

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.entity.ConsultResult;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会诊结果表
 *
 * @author songM
 * @date 2021-06-17 18:04:03
 */
@Mapper
public interface ConsultResultMapper extends HospitalBaseMapper<ConsultResult> {
    /**
    * @Description: 查询会诊结果通过就诊卡id
    * @Param: [consultOrder]
    * @return: com.wyzy.hospital.admin.api.entity.ConsultResult
    * @Author: songM
    * @Date: 2021/6/18
    */
    List<ConsultResult> selectConsultResultsByCardId(@Param("consultOrder") ConsultOrderDTO consultOrder);
}
