

package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.service.MobileService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.security.annotation.Inner;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author wyzy
 * @date 2018/11/14
 * <p>
 * 手机验证码
 */
@RestController
@AllArgsConstructor
@RequestMapping("/mobile")
@Api(value = "mobile", tags = "手机管理模块")
public class MobileController {

	private final MobileService mobileService;

	@Inner(value = false)
	@GetMapping("/{mobile}")
	public R sendSmsCode(@PathVariable String mobile) {
		return mobileService.sendSmsCode(mobile);
	}

	@GetMapping("/test")
	public R<String> test(@RequestParam("content") String content) {
		return R.ok("test success admin mobile 2" + content);
	}
}
