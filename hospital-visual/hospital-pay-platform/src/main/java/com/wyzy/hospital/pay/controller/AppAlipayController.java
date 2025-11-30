package com.wyzy.hospital.pay.controller;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.security.annotation.Inner;
import com.wyzy.hospital.pay.entity.PayGoodsOrder;
import com.wyzy.hospital.pay.handler.PayOrderHandler;
import com.wyzy.hospital.pay.utils.PayChannelNameEnum;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author aqie
 * Date on 2021/6/17  9:52
 * @Function:
 */
@RestController
@RequestMapping("app/alipay")
@AllArgsConstructor
public class AppAlipayController {
    private final Map<String, PayOrderHandler> orderHandlerMap;


    @SneakyThrows
    @Inner(false)
    @PostMapping
    @SysLog("app支付宝支付")
    public R<Map<String, Object>> alipay(){
        PayOrderHandler orderHandler = orderHandlerMap.get(PayChannelNameEnum.ALIPAY_APP.name());
        PayGoodsOrder goodsOrder = new PayGoodsOrder();
        goodsOrder.setAmount("1");
        goodsOrder.setUserId("123");
        goodsOrder.setGoodsName("测试产品");
        goodsOrder.setGoodsId("10001");
        Object params = orderHandler.handle(goodsOrder);

        Map<String, Object> result = new HashMap<>(4);
        result.put("channel", PayChannelNameEnum.ALIPAY_APP.name());
        result.put("goods", goodsOrder);
        result.put("params", params);
        return R.ok(result);
    }
}
