

package com.wyzy.hospital.common.data.tenant;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;

/**
 * @author wyzy
 * @date 2020/4/29
 * <p>
 * 租户信息拦截
 */
@Configuration
public class HospitalTenantConfiguration {

	@Bean
	public RequestInterceptor hospitalFeignTenantInterceptor() {
		return new HospitalFeignTenantInterceptor();
	}

	@Bean
	public ClientHttpRequestInterceptor hospitalTenantRequestInterceptor() {
		return new TenantRequestInterceptor();
	}

}
