

package com.wyzy.hospital.ureport;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyzy
 * @date 2020-10-15 报表模块
 * <p>
 * 此模块由于使用的是ureport 封装报表设计器，无法区分租户权限较大建议不提供具体租户使用。
 * <p>
 * http://127.0.0.1:5006/ureport/designer
 */
@EnableHospitalFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class HospitalBiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalBiApplication.class, args);
	}

}
