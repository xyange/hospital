/*
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the wyzy.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author:  wyzy
 */

package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.UserInfo;
import com.wyzy.hospital.admin.api.entity.SysSocialDetails;
import com.wyzy.hospital.admin.api.entity.SysUser;
import com.wyzy.hospital.admin.handler.LoginHandler;
import com.wyzy.hospital.admin.mapper.SysSocialDetailsMapper;
import com.wyzy.hospital.admin.mapper.SysUserMapper;
import com.wyzy.hospital.admin.service.SysSocialDetailsService;
import com.wyzy.hospital.common.core.constant.CacheConstants;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wyzy
 * @date 2018年08月16日
 */
@Slf4j
@AllArgsConstructor
@Service("sysSocialDetailsService")
public class SysSocialDetailsServiceImpl extends ServiceImpl<SysSocialDetailsMapper, SysSocialDetails>
		implements SysSocialDetailsService {

	private final Map<String, LoginHandler> loginHandlerMap;

	private final CacheManager cacheManager;

	private final SysUserMapper sysUserMapper;

	/**
	 * 绑定社交账号
	 * @param type type
	 * @param code code
	 * @return
	 */
	@Override
	public Boolean bindSocial(String type, String code) {
		LoginHandler loginHandler = loginHandlerMap.get(type);
		// 绑定逻辑
		String identify = loginHandler.identify(code);
		SysUser sysUser = sysUserMapper.selectById(SecurityUtils.getUser().getId());
		loginHandler.bind(sysUser, identify);

		// 更新緩存
		cacheManager.getCache(CacheConstants.USER_DETAILS).evict(sysUser.getUsername());
		return Boolean.TRUE;
	}

	/**
	 * todo 这里并没有往下传type
	 * 根据入参查询用户信息
	 * @param inStr TYPE@code
	 * @return COMMA
	 */
	@Override
	public UserInfo getUserInfo(String inStr) {
		String[] inStrs = inStr.split(StringPool.AT);
		String type = inStrs[0];
		String loginStr = inStrs[1];
		if(inStrs.length > 2) {
			String userType = inStrs[2];
		}

		return loginHandlerMap.get(type).handle(loginStr);
	}

	public static void main(String[] args) {
		String inStr = "SMS@15533833058@user";
		String[] inStrs = inStr.split(StringPool.AT);
		String type = inStrs[0];
		String loginStr = inStrs[1];

		String userType = inStrs[2];
		System.out.println(type + " " + loginStr + " " + userType);
	}

}
