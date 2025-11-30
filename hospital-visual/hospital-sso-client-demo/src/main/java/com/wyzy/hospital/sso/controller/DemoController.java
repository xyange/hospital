

package com.wyzy.hospital.sso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyzy
 * @date 2018/1/27 demo controller
 */
@RestController
public class DemoController {

	@GetMapping("/user")
	public Authentication user(Authentication authentication) {
		return authentication;
	}

}
