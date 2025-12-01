package com.wyzy.hospital.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author Hospital archetype
 * <p>
 * 项目启动类
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableDiscoveryClient
@EnableHospitalResourceServer
@SpringBootApplication
@ServletComponentScan
public class HospitalAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalAppApplication.class, args);
    }

	@Bean
	public RequestContextListener requestContextListener(){
		return new RequestContextListener();
	}
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
		return converter;
	}
}
