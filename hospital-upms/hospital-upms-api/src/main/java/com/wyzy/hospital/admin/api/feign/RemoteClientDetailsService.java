

package com.wyzy.hospital.admin.api.feign;

import com.wyzy.hospital.admin.api.entity.SysOauthClientDetails;
import com.wyzy.hospital.common.core.constant.SecurityConstants;
import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author wyzy
 * @date 2020/12/05
 */
@FeignClient(contextId = "remoteClientDetailsService", value = ServiceNameConstants.UPMS_SERVICE)
public interface RemoteClientDetailsService {

	/**
	 * 通过clientId 查询客户端信息
	 * @param clientId 用户名
	 * @param from 调用标志
	 * @return R
	 */
	@GetMapping("/client/getClientDetailsById/{clientId}")
	R<SysOauthClientDetails> getClientDetailsById(@PathVariable("clientId") String clientId,
			@RequestHeader(SecurityConstants.FROM) String from);

}
