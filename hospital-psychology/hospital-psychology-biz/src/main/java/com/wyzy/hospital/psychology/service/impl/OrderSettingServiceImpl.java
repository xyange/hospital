
package com.wyzy.hospital.psychology.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.dto.OrderSettingDTO;
import com.wyzy.hospital.psychology.api.entity.OrderSetting;
import com.wyzy.hospital.psychology.mapper.OrderSettingMapper;
import com.wyzy.hospital.psychology.service.OrderSettingService;
import org.springframework.stereotype.Service;

/**
 * 预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-08 09:04:42
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements OrderSettingService {
    /**
     * 根据预约ID查询预约信息
     */
    @Override
    public OrderSettingDTO getByOrderSettingDTOId(Long orderId) {
        return baseMapper.selectByOrderSettingDTOId(orderId);
    }

    /**
     * 預約成功
     * @param orderId
     * @return
     */
    @Override
    public Boolean updateAlreadyByOrderId(Long orderId) {
        return baseMapper.updateAlreadyByOrderId(orderId);
    }
}
