

package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.common.core.util.R;

/**
 * @author wyzy
 * @date 2018/11/14
 */
public interface MobileService {

	/**
	 * 发送手机验证码
	 * @param mobile mobile
	 * @return code
	 */
	R<Boolean> sendSmsCode(String mobile);

}
