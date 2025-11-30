package com.wyzy.hospital.common.datasource.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wyzy
 * @date 2020/12/11
 */
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ClearTtlDsInterceptor()).addPathPatterns("/**");
	}

}