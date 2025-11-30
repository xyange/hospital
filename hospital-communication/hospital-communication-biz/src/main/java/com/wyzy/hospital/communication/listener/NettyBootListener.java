package com.wyzy.hospital.communication.listener;

import com.wyzy.hospital.communication.netty.WebsocketServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author aqie
 * Date on 2021/4/29  17:43
 * @Function:
 */
@Component
public class NettyBootListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		if (applicationContext.getParent() == null) {
			try {
				WebsocketServer.getInstance().start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
