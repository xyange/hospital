

package com.wyzy.hospital.pay.handler.impl;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ijpay.alipay.AliPayApi;
import com.ijpay.alipay.AliPayApiConfig;
import com.ijpay.alipay.AliPayApiConfigKit;
import com.wyzy.hospital.common.data.tenant.TenantContextHolder;
import com.wyzy.hospital.pay.entity.PayChannel;
import com.wyzy.hospital.pay.entity.PayGoodsOrder;
import com.wyzy.hospital.pay.entity.PayTradeOrder;
import com.wyzy.hospital.pay.mapper.PayChannelMapper;
import com.wyzy.hospital.pay.mapper.PayGoodsOrderMapper;
import com.wyzy.hospital.pay.mapper.PayTradeOrderMapper;
import com.wyzy.hospital.pay.utils.ChannelPayApiConfigKit;
import com.wyzy.hospital.pay.utils.OrderStatusEnum;
import com.wyzy.hospital.pay.utils.PayChannelNameEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wyzy
 * @date 2019-05-31
 * <p>
 * 支付宝 APP 支付
 */
@Slf4j
@Service("ALIPAY_APP")
@AllArgsConstructor
public class AlipayAppPayOrderHandler extends AbstractPayOrderHandler {

	private final PayTradeOrderMapper tradeOrderMapper;

	private final PayGoodsOrderMapper goodsOrderMapper;

	private final PayChannelMapper channelMapper;

	private final HttpServletRequest request;

	private final HttpServletResponse response;

	/**
	 * 准备支付参数
	 */
	@Override
	public PayChannel preparePayParams() {
		PayChannel channel = channelMapper.selectOne(
				Wrappers.<PayChannel>lambdaQuery().eq(PayChannel::getChannelId, PayChannelNameEnum.ALIPAY_APP.name()));

		if (channel == null) {
			throw new IllegalArgumentException("支付宝app支付渠道配置为空");
		}

		JSONObject params = JSONUtil.parseObj(channel.getParam());
		AliPayApiConfig aliPayApiConfig = AliPayApiConfig.builder().setAppId(channel.getAppId())
				.setPrivateKey(params.getStr("privateKey")).setCharset(CharsetUtil.UTF_8)
				.setAliPayPublicKey(params.getStr("publicKey")).setServiceUrl(params.getStr("serviceUrl"))
				.setSignType("RSA2").build();
		AliPayApiConfigKit.putApiConfig(aliPayApiConfig);
		return channel;
	}

	/**
	 * 创建交易订单
	 * @param goodsOrder
	 * @return
	 */
	@Override
	public PayTradeOrder createTradeOrder(PayGoodsOrder goodsOrder) {
		PayTradeOrder tradeOrder = new PayTradeOrder();
		tradeOrder.setOrderId(goodsOrder.getPayOrderId());
		tradeOrder.setAmount(goodsOrder.getAmount());
		tradeOrder.setChannelId(PayChannelNameEnum.ALIPAY_APP.getName());
		tradeOrder.setChannelMchId(AliPayApiConfigKit.getAliPayApiConfig().getAppId());
		tradeOrder.setClientIp(ServletUtil.getClientIP(request));
		tradeOrder.setCurrency("cny");
		tradeOrder.setExpireTime(30L);
		tradeOrder.setStatus(OrderStatusEnum.INIT.getStatus());
		tradeOrder.setBody(goodsOrder.getGoodsName());
		tradeOrderMapper.insert(tradeOrder);
		return tradeOrder;
	}

	/**
	 * 调起渠道支付
	 * @param goodsOrder 商品订单
	 * @param tradeOrder 交易订单
	 */
	@Override
	public String pay(PayGoodsOrder goodsOrder, PayTradeOrder tradeOrder) {
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody(tradeOrder.getBody());
		model.setSubject(tradeOrder.getBody());
		model.setOutTradeNo(tradeOrder.getOrderId());
		model.setTimeoutExpress("30m");

		// 分转成元 并且保留两位
		model.setTotalAmount(NumberUtil.div(tradeOrder.getAmount(), "100", 2).toString());
		model.setProductCode(goodsOrder.getGoodsId());
		model.setPassbackParams(String.valueOf(TenantContextHolder.getTenantId()));
		String orderInfo = "";
		try {
			log.info("拉起支付宝app 支付参数 {}", model);
			orderInfo = AliPayApi.appPayToResponse(model,
					ChannelPayApiConfigKit.get().getNotifyUrl() + "/pay/notify/ali/callbak").getBody();
		}
		catch (AlipayApiException e) {
			log.error("支付宝app 支付失败", e);
			tradeOrder.setErrMsg(e.getErrMsg());
			tradeOrder.setErrCode(e.getErrCode());
			tradeOrder.setStatus(OrderStatusEnum.FAIL.getStatus());
			goodsOrder.setStatus(OrderStatusEnum.FAIL.getStatus());
		}
		return orderInfo;
	}

	/**
	 * 更新订单信息
	 * @param goodsOrder 商品订单
	 * @param tradeOrder 交易订单
	 */
	@Override
	public void updateOrder(PayGoodsOrder goodsOrder, PayTradeOrder tradeOrder) {
		tradeOrderMapper.updateById(tradeOrder);
		goodsOrderMapper.updateById(goodsOrder);
	}

}
