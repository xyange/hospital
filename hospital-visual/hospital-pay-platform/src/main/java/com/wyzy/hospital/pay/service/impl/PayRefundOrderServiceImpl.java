
package com.wyzy.hospital.pay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pay.entity.PayRefundOrder;
import com.wyzy.hospital.pay.mapper.PayRefundOrderMapper;
import com.wyzy.hospital.pay.service.PayRefundOrderService;
import org.springframework.stereotype.Service;

/**
 * 退款
 *
 * @author wyzy
 * @date 2019-05-28 23:58:11
 */
@Service
public class PayRefundOrderServiceImpl extends ServiceImpl<PayRefundOrderMapper, PayRefundOrder>
		implements PayRefundOrderService {

}
