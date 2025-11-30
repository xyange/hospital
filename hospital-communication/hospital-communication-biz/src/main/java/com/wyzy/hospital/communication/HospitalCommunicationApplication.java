package com.wyzy.hospital.communication;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import com.wyzy.hospital.communication.utils.ApplicationUtils;
import com.wyzy.hospital.communication.websocket.WebsocketClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author aqie
 * <p>
 * 项目启动类
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableDiscoveryClient
@EnableHospitalResourceServer
@SpringBootApplication
@Slf4j
public class HospitalCommunicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalCommunicationApplication.class, args);
		WebsocketClient websocketClient = (WebsocketClient) ApplicationUtils.getBean("websocketClient");
		try {
			websocketClient.connect();
		}catch (Exception e) {
			log.error(e.getMessage());
		}

		log.error("WebsocketClient 初始化成功");
	}


}
