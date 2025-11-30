

package com.wyzy.hospital.admin.handler;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wyzy.hospital.admin.api.dto.UserDTO;
import com.wyzy.hospital.admin.api.dto.UserInfo;
import com.wyzy.hospital.admin.api.entity.Member;
import com.wyzy.hospital.admin.api.entity.SysUser;
import com.wyzy.hospital.admin.api.dto.huanxin.HuanxinAccount;
import com.wyzy.hospital.admin.service.HuanxinService;
import com.wyzy.hospital.admin.service.MemberService;
import com.wyzy.hospital.admin.service.SysUserService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.Func;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.wyzy.hospital.common.core.constant.CommonConstants.TENANT_ID_1_DEFAULT_PASSWORD;

/**
 * @author wyzy
 * @date 2018/11/18
 */
@Slf4j
@Component("SMS")
@AllArgsConstructor
public class SmsLoginHandler extends AbstractLoginHandler {

	private final SysUserService sysUserService;


	private final HuanxinService huanxinService;

	private final MemberService memberService;

	/**
	 * 验证码登录传入为手机号@TYPE
	 * @param mobile
	 * @return
	 */
	@Override
	public String identify(String mobile) {
		return mobile;
	}

	/**
	 * 如果手机号获取不到
	 * 1. 注册后台信息
	 * 2. 注册环信用户
	 * 通过mobile 获取用户信息
	 * @param identify 手机号@TYPE
	 * @return
	 */
	@Override
	public UserInfo info(String identify) {
		SysUser user = sysUserService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getPhone, identify));
		Long memberId;


		// 从会员表获取 memberId
		// 1. 手机号未注册则注册用户
		if (user == null) {
			log.info("手机号未注册:{}", identify);
			UserDTO userDto = new UserDTO();
			List<Integer> role = new ArrayList<Integer>(Collections.singletonList(1));
			userDto.setRole(role);
			userDto.setLockFlag("0");
			userDto.setUsername(identify);
			userDto.setPhone(identify);
			userDto.setTenantId(CommonConstants.TENANT_ID_1);
			userDto.setPassword(TENANT_ID_1_DEFAULT_PASSWORD);
			userDto.setDeptId(10);
			Long userId = sysUserService.saveUser(userDto);

			user = sysUserService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getPhone, identify));
			// 2. 注册环信
			if(Func.isNotEmpty(user)) {
				HuanxinAccount account = HuanxinAccount.builder()
						.username(identify).password(TENANT_ID_1_DEFAULT_PASSWORD).nickname(identify).build();
				huanxinService.registerHuanxin(account);
			}
			// 3. todo 判断是患者会员  才注册会员
			Member member = new Member();
			member.setNickname(identify);
			member.setPhone(identify);
			member.setUuid(UUID.fastUUID().toString());
			member.setUserId(userId);
			boolean save = memberService.save(member);
			memberId = member.getMemberId();
			log.info("会员注册 {} {} 会员id:{}", identify, save, memberId);
		} else {
			memberId = memberService.getMemberIdByUserId(user.getUserId());
		}
		return sysUserService.findUserInfoWithMemberId(user, memberId);
	}

	/**
	 * 绑定逻辑
	 * @param user 用户实体
	 * @param identify 渠道返回唯一标识
	 * @return
	 */
	@Override
	public Boolean bind(SysUser user, String identify) {
		user.setGiteeLogin(identify);
		sysUserService.updateById(user);
		return null;
	}

}
