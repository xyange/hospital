package com.wyzy.hospital.app.controller;

import com.wyzy.hospital.common.core.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
	@GetMapping("/test")
	public R<String> test(@RequestParam("content") String content) {
		return R.ok("test success app " + content);
	}
}
