package com.wyzy.hospital.app.service;

import com.wyzy.hospital.app.entity.UserHospital;
import org.springframework.data.domain.Page;

/**
 * @Author aqie
 * Date on 2021/6/4  17:35
 * @Function:
 */
public interface UserHospitalService {
	/**
	 * 添加关注
	 */
	int add(UserHospital userHospital);

	/**
	 * 取消关注
	 */
	int delete(Long hospitalId);

	/**
	 * 获取用户关注列表
	 */
	Page<UserHospital> list(Integer pageNum, Integer pageSize);

	/**
	 * 获取用户关注详情
	 */
	UserHospital detail(Long hospitalId);
}
