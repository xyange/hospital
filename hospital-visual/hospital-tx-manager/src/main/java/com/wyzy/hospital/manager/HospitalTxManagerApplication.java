

package com.wyzy.hospital.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LCN
 * @author wyzy tx-manager ，进行了代码逻辑和代码规范重构
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalTxManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalTxManagerApplication.class, args);
	}

}
