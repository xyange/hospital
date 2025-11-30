

package com.wyzy.hospital.codegen;

import com.wyzy.hospital.common.datasource.annotation.EnableDynamicDataSource;
import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2018/07/29 代码生成模块
 */
@EnableDynamicDataSource
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableDiscoveryClient
@EnableHospitalResourceServer
@SpringBootApplication
public class HospitalCodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalCodeGenApplication.class, args);
	}

}
