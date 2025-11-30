
package com.wyzy.hospital.pay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pay.entity.PayNotifyRecord;
import com.wyzy.hospital.pay.mapper.PayNotifyRecordMapper;
import com.wyzy.hospital.pay.service.PayNotifyRecordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 异步通知记录
 *
 * @author wyzy
 * @date 2019-05-28 23:57:23
 */
@Slf4j
@Service
@AllArgsConstructor
public class PayNotifyRecordServiceImpl extends ServiceImpl<PayNotifyRecordMapper, PayNotifyRecord>
		implements PayNotifyRecordService {

}
