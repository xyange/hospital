package com.wyzy.hospital.app.service.impl;

import com.wyzy.hospital.admin.api.entity.Member;
import com.wyzy.hospital.admin.api.feign.RemoteMemberService;
import com.wyzy.hospital.app.entity.UserHospital;
import com.wyzy.hospital.app.repository.UserHospitalRepository;
import com.wyzy.hospital.app.service.UserHospitalService;
import com.wyzy.hospital.common.core.util.Func;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author aqie
 * Date on 2021/6/4  17:35
 * @Function:
 */
@Service
@RequiredArgsConstructor
public class UserHospitalServiceImpl implements UserHospitalService {

	private final UserHospitalRepository userHospitalRepository;

	private final RemoteMemberService memberService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(UserHospital userHospital) {
		int count = 0;
		HospitalUser user = SecurityUtils.getUser();
		Long memberId = user.getMemberId();

		if (Func.isEmpty(memberId)) {
			return 0;
		}
		// 根据memberId 获取 用户名 手机号
		R<Member> data = memberService.getMember(memberId);
		if(data.success()){
			Member member = data.getData();
			userHospital.setMemberId(memberId);
			userHospital.setNickname(member.getNickname());
			userHospital.setPhone(member.getPhone());
			userHospital.setCreateTime(new Date());
			UserHospital one = userHospitalRepository.findByMemberIdAndHospitalId(memberId, userHospital.getHospitalId());
			if(Func.isEmpty(one)) {
				userHospitalRepository.save(userHospital);
				count = 1;
			}
		}

		return count;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Long hospitalId) {
		HospitalUser user = SecurityUtils.getUser();
		return userHospitalRepository.deleteByMemberIdAndHospitalId(user.getMemberId(), hospitalId);
	}

	@Override
	public Page<UserHospital> list(Integer pageNum, Integer pageSize) {
		HospitalUser user = SecurityUtils.getUser();
		Pageable pageable = PageRequest.of(pageNum-1, pageSize);
		return userHospitalRepository.findByMemberId(user.getMemberId(), pageable);
	}

	@Override
	public UserHospital detail(Long hospitalId) {
		HospitalUser user = SecurityUtils.getUser();
		return userHospitalRepository.findByMemberIdAndHospitalId(user.getMemberId(), hospitalId);
	}
}
