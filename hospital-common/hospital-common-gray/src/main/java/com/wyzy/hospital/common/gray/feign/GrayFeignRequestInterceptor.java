

package com.wyzy.hospital.common.gray.feign;

import cn.hutool.core.util.StrUtil;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.WebUtils;
import com.wyzy.hospital.common.gray.support.NonWebVersionContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wyzy
 * @date 2020/1/12
 * <p>
 * feign 请求VERSION 传递
 */
@Slf4j
public class GrayFeignRequestInterceptor implements RequestInterceptor {

	/**
	 * Called for every request. Add data using methods on the supplied
	 * {@link RequestTemplate}.
	 * @param template
	 */
	@Override
	public void apply(RequestTemplate template) {
		String reqVersion = WebUtils.getRequest() != null ? WebUtils.getRequest().getHeader(CommonConstants.VERSION)
				: NonWebVersionContextHolder.getVersion();

		if (StrUtil.isNotBlank(reqVersion)) {
			log.debug("feign gray add header version :{}", reqVersion);
			template.header(CommonConstants.VERSION, reqVersion);
		}
	}

}
