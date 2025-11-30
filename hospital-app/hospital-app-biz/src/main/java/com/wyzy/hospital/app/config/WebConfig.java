package com.wyzy.hospital.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author aqie
 * Date on 2021/5/25  11:15
 * @Function:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${upload.staticAccessPath}")
	private String staticAccessPath;

	@Value("${upload.uploadFolder}")
	private String uploadFolder;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);	}
}
