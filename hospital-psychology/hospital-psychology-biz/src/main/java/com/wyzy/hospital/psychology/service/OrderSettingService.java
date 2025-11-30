

package com.wyzy.hospital.psychology.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.dto.OrderSettingDTO;
import com.wyzy.hospital.psychology.api.entity.OrderSetting;

/**
 * 预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-08 09:04:42
 */
public interface OrderSettingService extends IService<OrderSetting> {
    /**
     * 根据预约ID查询预约信息
     */
    OrderSettingDTO getByOrderSettingDTOId(Long orderId);

    /**
     * 預約成功
     * @param orderId
     * @return
     */
    Boolean updateAlreadyByOrderId(Long orderId);
}
