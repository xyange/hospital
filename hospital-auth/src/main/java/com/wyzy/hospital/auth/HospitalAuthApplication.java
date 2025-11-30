

package com.wyzy.hospital.auth;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2020-02-08 认证授权中心
 */
@EnableHospitalFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAuthApplication.class, args);
	}

}
