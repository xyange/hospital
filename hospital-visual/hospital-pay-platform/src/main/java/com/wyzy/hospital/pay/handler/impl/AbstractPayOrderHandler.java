

package com.wyzy.hospital.pay.handler.impl;

import com.wyzy.hospital.common.sequence.sequence.Sequence;
import com.wyzy.hospital.pay.entity.PayChannel;
import com.wyzy.hospital.pay.entity.PayGoodsOrder;
import com.wyzy.hospital.pay.entity.PayTradeOrder;
import com.wyzy.hospital.pay.handler.PayOrderHandler;
import com.wyzy.hospital.pay.mapper.PayGoodsOrderMapper;
import com.wyzy.hospital.pay.utils.ChannelPayApiConfigKit;
import com.wyzy.hospital.pay.utils.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wyzy
 * @date 2019-05-31
 */
public abstract class AbstractPayOrderHandler implements PayOrderHandler {

	@Autowired
	private PayGoodsOrderMapper goodsOrderMapper;

	@Autowired
	private Sequence paySequence;

	/**
	 * 创建商品订单
	 * @param goodsOrder 商品订单
	 * @return
	 */
	@Override
	public void createGoodsOrder(PayGoodsOrder goodsOrder) {
		goodsOrder.setPayOrderId(paySequence.nextNo());
		goodsOrder.setStatus(OrderStatusEnum.INIT.getStatus());
		goodsOrderMapper.insert(goodsOrder);
	}

	/**
	 * 调用入口
	 * @return
	 */
	@Override
	public Object handle(PayGoodsOrder payGoodsOrder) {
		PayChannel payChannel = preparePayParams();
		ChannelPayApiConfigKit.put(payChannel);

		createGoodsOrder(payGoodsOrder);
		PayTradeOrder tradeOrder = createTradeOrder(payGoodsOrder);
		Object result = pay(payGoodsOrder, tradeOrder);
		updateOrder(payGoodsOrder, tradeOrder);
		// 情况ttl
		ChannelPayApiConfigKit.remove();
		return result;
	}

}
