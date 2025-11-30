

package com.wyzy.hospital.psychology.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.dto.OrderSettingDTO;
import com.wyzy.hospital.psychology.api.entity.OrderSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-08 09:04:42
 */
@Mapper
public interface OrderSettingMapper extends HospitalBaseMapper<OrderSetting> {
    /**
     * 根据预约ID查询预约信息
     * @param orderId
     * @return
     */
    OrderSettingDTO selectByOrderSettingDTOId(@Param("orderId") Long orderId);

    /**
     * 預約成功
     * @param orderId
     * @return
     */
    Boolean updateAlreadyByOrderId(@Param("orderId") Long orderId);
}
