package com.wyzy.hospital.communication.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author aqie
 * Date on 2021/4/30  9:00
 * @Function: 注册netty事件
 */
public class RegisterNettyEvent extends ApplicationEvent {
	private String message;
	public RegisterNettyEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
