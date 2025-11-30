

package com.wyzy.hospital.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2019年11月4日 监控中心
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalMonitorApplication.class, args);
	}

}
