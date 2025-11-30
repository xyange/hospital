
package com.wyzy.hospital.pay.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pay.entity.PayGoodsOrder;
import com.wyzy.hospital.pay.handler.PayOrderHandler;
import com.wyzy.hospital.pay.mapper.PayGoodsOrderMapper;
import com.wyzy.hospital.pay.service.PayGoodsOrderService;
import com.wyzy.hospital.pay.utils.PayChannelNameEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品
 *
 * @author wyzy
 * @date 2019-05-28 23:58:27
 */
@Slf4j
@Service
@AllArgsConstructor
public class PayGoodsOrderServiceImpl extends ServiceImpl<PayGoodsOrderMapper, PayGoodsOrder>
		implements PayGoodsOrderService {

	private final Map<String, PayOrderHandler> orderHandlerMap;

	private final HttpServletRequest request;

	/**
	 * 下单购买
	 * @param goodsOrder
	 * @param isMerge
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> buy(PayGoodsOrder goodsOrder, boolean isMerge) {
		// 是否聚合支付
		String ua = isMerge ? "MERGE_PAY" : request.getHeader(HttpHeaders.USER_AGENT);

		Enum channel = PayChannelNameEnum.getChannel(ua);
		PayOrderHandler orderHandler = orderHandlerMap.get(channel.name());
		goodsOrder.setGoodsName("测试产品");
		goodsOrder.setGoodsId("10001");
		Object params = orderHandler.handle(goodsOrder);

		Map<String, Object> result = new HashMap<>(4);
		result.put("channel", channel.name());
		result.put("goods", goodsOrder);
		result.put("params", params);
		return result;
	}

}
