package com.wyzy.hospital.communication.initializer;

import com.wyzy.hospital.communication.netty.WebsocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @Author aqie
 * Date on 2021/4/30  9:53
 * @Function:
 */
@Order(1)
@Slf4j
public class WebsocketServerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	@Override
	public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
		try {
			WebsocketServer.getInstance().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
