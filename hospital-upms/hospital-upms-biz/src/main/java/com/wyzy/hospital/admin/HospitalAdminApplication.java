

package com.wyzy.hospital.admin;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2018年06月21日
 * <p>
 * 用户统一管理系统
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableHospitalResourceServer
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wyzy.hospital.admin.mapper")
public class HospitalAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAdminApplication.class, args);
	}

}
