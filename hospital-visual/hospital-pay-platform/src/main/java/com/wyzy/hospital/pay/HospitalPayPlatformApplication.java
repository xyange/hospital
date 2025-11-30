

package com.wyzy.hospital.pay;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2019年05月27日17:25:38
 * <p>
 * 支付模块
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableDiscoveryClient
@EnableHospitalResourceServer
@SpringBootApplication
public class HospitalPayPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalPayPlatformApplication.class, args);
	}

}
