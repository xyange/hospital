package com.wyzy.hospital.communication.listener;

import com.wyzy.hospital.communication.event.RegisterNettyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author aqie
 * Date on 2021/4/30  9:02
 * @Function: netty注册监听者
 */
@Component
@Slf4j
public class RegisterNettyListener implements ApplicationListener<RegisterNettyEvent>{
	@Override
	public void onApplicationEvent(RegisterNettyEvent event) {
		log.info("listener receive {}", event.getMessage());
	}
}
