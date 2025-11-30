package com.wyzy.hospital.communication.controller;

import com.alibaba.fastjson.JSONArray;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.communication.entity.ChatMsg;
import com.wyzy.hospital.communication.entity.DataContent;
import com.wyzy.hospital.communication.publisher.RegisterNettyPublisher;
import com.wyzy.hospital.communication.websocket.WebsocketClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aqie
 */
@RequestMapping("test")
@RestController
@AllArgsConstructor
@Slf4j
public class TestController {
	private final RegisterNettyPublisher publisher;


	private final WebsocketClient websocketClient;

	@GetMapping("/test")
	public R<String> test(@RequestParam("content") String content) {
		publisher.publish(content);
		return R.ok("test success Communication " + content);
	}

	@GetMapping("/sendMsg")
	public R sendMsg(String content){
		DataContent dataContent = new DataContent();
		dataContent.setAction(2);
		ChatMsg chatMsg = ChatMsg.builder()
				.senderId("1")
				.receiverId("2")
				.msgId("001")
				.msg(content).build();
		dataContent.setChatMsg(chatMsg);
		// 发送消息
		websocketClient.send(JSONArray.toJSON(dataContent).toString());
		log.error(JSONArray.toJSON(dataContent).toString());
		return R.ok();
	}
}
