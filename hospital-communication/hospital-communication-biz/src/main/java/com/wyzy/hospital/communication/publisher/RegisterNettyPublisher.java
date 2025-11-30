package com.wyzy.hospital.communication.publisher;

import com.wyzy.hospital.communication.event.RegisterNettyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author aqie
 * Date on 2021/4/30  9:17
 * @Function:
 */
@Component
public class RegisterNettyPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	public void publish(String message) {
		RegisterNettyEvent registerNettyEvent = new RegisterNettyEvent(this, message);
		applicationEventPublisher.publishEvent(registerNettyEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
}
