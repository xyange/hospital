

package com.wyzy.hospital.admin.mapper;


import com.wyzy.hospital.admin.api.dto.ConsultSettingDTO;
import com.wyzy.hospital.admin.api.entity.ConsultSetting;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 远程会诊预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:52
 */
@Mapper
public interface ConsultSettingMapper extends HospitalBaseMapper<ConsultSetting> {

    /**
     * 修改预约状态
     * @param orderId
     * @return
     */
    boolean updateAlreadyById(@Param("orderId") Long orderId);

    /**
     * 查看医生可预约时间
     * @param doctorId
     * @return
     */
    List<ConsultSettingDTO> getTimeByDoctorId(@Param("doctorId") Long doctorId,@Param("substring") String substring);

    /**
     * 根据医生ID和预约时间查询
     * @param pojo
     * @return
     */
    ConsultSetting selectConsultSettingByPojo(@Param("pojo") ConsultSetting pojo);
}
