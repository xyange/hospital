package com.wyzy.hospital.daemon.quartz;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author frwcloud
 * @date 2019/01/23 定时任务模块
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableHospitalResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalDaemonQuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalDaemonQuartzApplication.class, args);
	}

}
