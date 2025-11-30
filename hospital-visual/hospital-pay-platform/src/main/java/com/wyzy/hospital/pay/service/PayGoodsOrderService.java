

package com.wyzy.hospital.pay.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.pay.entity.PayGoodsOrder;

/**
 * 商品
 *
 * @author wyzy
 * @date 2019-05-28 23:58:27
 */
public interface PayGoodsOrderService extends IService<PayGoodsOrder> {

	/**
	 * 购买商品
	 * @param goodsOrder goods
	 * @param isMerge 是否是服务商
	 * @return
	 */
	Map<String, Object> buy(PayGoodsOrder goodsOrder, boolean isMerge);

}
