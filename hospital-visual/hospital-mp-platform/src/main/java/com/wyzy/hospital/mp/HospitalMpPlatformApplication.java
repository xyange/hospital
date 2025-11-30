

package com.wyzy.hospital.mp;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2019/03/25 微信公众号管理模块
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableHospitalResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalMpPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalMpPlatformApplication.class, args);
	}

}
