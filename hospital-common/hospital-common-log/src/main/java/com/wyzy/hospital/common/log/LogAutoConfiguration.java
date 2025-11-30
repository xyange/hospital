

package com.wyzy.hospital.common.log;

import com.wyzy.hospital.admin.api.feign.RemoteLogService;
import com.wyzy.hospital.common.core.util.KeyStrResolver;
import com.wyzy.hospital.common.log.aspect.SysLogAspect;
import com.wyzy.hospital.common.log.event.SysLogListener;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author wyzy
 * @date 2018/6/28
 * <p>
 * 日志自动配置
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

	private final RemoteLogService remoteLogService;

	@Bean
	public SysLogListener sysLogListener() {
		return new SysLogListener(remoteLogService);
	}

	@Bean
	public SysLogAspect sysLogAspect(ApplicationEventPublisher publisher, KeyStrResolver resolver) {
		return new SysLogAspect(publisher, resolver);
	}

}
