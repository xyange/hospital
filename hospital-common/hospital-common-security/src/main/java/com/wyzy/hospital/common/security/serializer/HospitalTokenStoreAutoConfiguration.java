package com.wyzy.hospital.common.security.serializer;

import cn.hutool.core.util.StrUtil;
import com.wyzy.hospital.common.core.constant.SecurityConstants;
import com.wyzy.hospital.common.core.util.KeyStrResolver;
import com.wyzy.hospital.common.security.component.HospitalRedisTokenStore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author wyzy
 * @date 2020/9/29
 * <p>
 * redis token store 自动配置
 */
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class HospitalTokenStoreAutoConfiguration {

	private final KeyStrResolver resolver;

	private final RedisConnectionFactory connectionFactory;

	@Bean
	public TokenStore tokenStore() {
		HospitalRedisTokenStore tokenStore = new HospitalRedisTokenStore(connectionFactory, resolver);
		tokenStore.setPrefix(SecurityConstants.PIGX_PREFIX + SecurityConstants.OAUTH_PREFIX);
		tokenStore.setAuthenticationKeyGenerator(new DefaultAuthenticationKeyGenerator() {
			@Override
			public String extractKey(OAuth2Authentication authentication) {
				// 增加租户隔离部分 租户ID:原生计算值
				return resolver.extract(super.extractKey(authentication), StrUtil.COLON);
			}
		});
		return tokenStore;
	}

}
