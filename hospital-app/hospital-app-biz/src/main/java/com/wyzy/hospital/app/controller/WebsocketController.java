package com.wyzy.hospital.app.controller;

import com.wyzy.hospital.common.core.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author aqie
 * Date on 2021/5/22  17:49
 * @Function:
 */
@RestController
@RequestMapping("websocket")
public class WebsocketController {
	@GetMapping("/test")
	public R<String> test(@RequestParam("content") String content) {
		return R.ok("test success app " + content);
	}
}
