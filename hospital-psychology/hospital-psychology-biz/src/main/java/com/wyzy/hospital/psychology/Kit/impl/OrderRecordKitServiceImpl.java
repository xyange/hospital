
package com.wyzy.hospital.psychology.Kit.impl;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.wyzy.hospital.psychology.Kit.OrderRecordKitService;
import com.wyzy.hospital.psychology.api.dto.OrderSettingDTO;
import com.wyzy.hospital.psychology.api.entity.OrderRecord;
import com.wyzy.hospital.psychology.service.OrderRecordService;
import com.wyzy.hospital.psychology.service.OrderSettingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 预约记录表
 *
 * @author hospital code generator
 * @date 2021-06-08 08:43:43
 */
@Service
@AllArgsConstructor
public class OrderRecordKitServiceImpl implements OrderRecordKitService {

    @Resource
    private final OrderRecordService orderRecordService;
    @Resource
    private final OrderSettingService orderSettingService;

    /**
     * 新增预约记录表
     * @param memberId 会员ID
     * @param orderId 预约ID
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public boolean saveorderRecord(Long memberId, Long orderId) {
        /**
         * 根据预约ID查询预约信息
         */
        OrderSettingDTO byId = orderSettingService.getByOrderSettingDTOId(orderId);
        if (byId==null){
            return false;
        }
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setDoctorId(byId.getDoctorId());
        orderRecord.setMemberId(memberId);
        orderRecord.setOrderId(orderId);
        String orderTime = byId.getDateTime()+" "+byId.getOrderTime();
        DateTime dt = DateUtil.parse(orderTime);
        // Date对象转换为LocalDateTime
        LocalDateTime localDateTime = LocalDateTimeUtil.of(dt);
        orderRecord.setOrderTime(localDateTime);
        boolean save = orderRecordService.save(orderRecord);
        if (save){
            /**
             * 預約成功
             */
            Boolean b =orderSettingService.updateAlreadyByOrderId(orderId);
            if (b){
                return true;
            }
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return false;
    }
}
