package com.wyzy.hospital.communication.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @Author aqie
 * Date on 2021/4/30  10:35
 * @Function:
 */
@Order(2)
@Slf4j
public class WebsocketClientInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {


	@Override
	public void initialize(ConfigurableApplicationContext configurableApplicationContext) {


	}
}
