package com.wyzy.hospital.hospital.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wyzy.hospital.common.core.constant.CacheConstants;
import com.wyzy.hospital.common.core.constant.SecurityConstants;
import com.wyzy.hospital.common.core.constant.enums.LoginTypeEnum;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.doctor.api.feign.RemoteDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RequestMapping
@RestController
@AllArgsConstructor
public class TestController {

	private final RemoteDoctorService remoteDoctorService;

	private final RedisTemplate redisTemplate;

	@GetMapping("/test")
	public R<String> test(@RequestParam("content") String content) {
		redisTemplate.opsForValue().set(
				CacheConstants.DEFAULT_CODE_KEY + LoginTypeEnum.SMS.getType() + StringPool.AT + content, "1234",
				SecurityConstants.CODE_TIME, TimeUnit.SECONDS);
		String s = (String)redisTemplate.opsForValue()
				.get(CacheConstants.DEFAULT_CODE_KEY + LoginTypeEnum.SMS.getType() + StringPool.AT + content);
		return R.ok("test success hospital " + s);
	}

	@GetMapping("/testDoctor")
	public R<String> testDoctor(@RequestParam("content") String content) {
		return remoteDoctorService.testDoctor(content);
	}
}
