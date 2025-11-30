package com.wyzy.hospital.communication.config;

import com.wyzy.hospital.communication.websocket.WebsocketClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author aqie
 * Date on 2021/4/30  11:21
 * @Function:
 */
@Configuration
@Slf4j
public class ConfigBean {
	@Bean(name = "websocketClient")
	public WebsocketClient getWebsocket(){
		WebsocketClient client = null;
		try {
			client = new WebsocketClient(new URI("ws://192.168.0.113:8888/ws"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return client;
	}
}
