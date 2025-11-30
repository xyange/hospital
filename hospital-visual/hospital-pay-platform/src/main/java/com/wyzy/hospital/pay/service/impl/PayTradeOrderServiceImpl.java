
package com.wyzy.hospital.pay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pay.entity.PayTradeOrder;
import com.wyzy.hospital.pay.mapper.PayTradeOrderMapper;
import com.wyzy.hospital.pay.service.PayTradeOrderService;
import org.springframework.stereotype.Service;

/**
 * 支付
 *
 * @author wyzy
 * @date 2019-05-28 23:58:18
 */
@Service
public class PayTradeOrderServiceImpl extends ServiceImpl<PayTradeOrderMapper, PayTradeOrder>
		implements PayTradeOrderService {

}
