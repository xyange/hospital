package com.wyzy.hospital.app.controller;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.security.annotation.Inner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author aqie
 * Date on 2021/5/29  17:20
 * @Function: 给用户推送消息
 */
@Slf4j
@RequestMapping("app/push")
@RestController
public class PushController {

	@Inner(value = false)
	@GetMapping
	public R<Boolean> pushMessage(){
		log.info("推送消息成功");
		return R.ok();
	}
}
