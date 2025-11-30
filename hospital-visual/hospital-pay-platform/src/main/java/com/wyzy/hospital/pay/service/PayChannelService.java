

package com.wyzy.hospital.pay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.pay.entity.PayChannel;

/**
 * 渠道
 *
 * @author wyzy
 * @date 2019-05-28 23:57:58
 */
public interface PayChannelService extends IService<PayChannel> {

	/**
	 * 新增支付渠道
	 * @param payChannel 支付渠道
	 * @return
	 */
	Boolean saveChannel(PayChannel payChannel);

}
