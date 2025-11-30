
package com.wyzy.hospital.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.mp.entity.WxAccountFans;

/**
 * 微信公众号粉丝
 *
 * @author wyzy
 * @date 2019-03-26 22:08:08
 */
public interface WxAccountFansService extends IService<WxAccountFans> {

	/**
	 * 同步指定公众号粉丝
	 * @param appId
	 * @return
	 */
	Boolean syncAccountFans(String appId);

}
