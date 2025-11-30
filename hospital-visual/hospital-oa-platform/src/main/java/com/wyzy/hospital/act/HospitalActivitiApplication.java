

package com.wyzy.hospital.act;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2018/9/25 工作流管理模块
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableHospitalResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalActivitiApplication.class, args);
	}

}
