

package com.wyzy.hospital.gateway;

import com.wyzy.hospital.common.gateway.annotation.EnableHospitalDynamicRoute;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2018年06月21日 网关应用
 */
@EnableHospitalSwagger2
@EnableHospitalDynamicRoute
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalGatewayApplication.class, args);
	}

}
