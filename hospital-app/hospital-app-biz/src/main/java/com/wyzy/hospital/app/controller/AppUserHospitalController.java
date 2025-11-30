package com.wyzy.hospital.app.controller;

import com.wyzy.hospital.app.entity.UserHospital;
import com.wyzy.hospital.app.service.UserHospitalService;
import com.wyzy.hospital.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author aqie
 * Date on 2021/6/4  17:28
 * @Function:
 */
@RestController
@RequestMapping("/app/userHospital")
@RequiredArgsConstructor
public class AppUserHospitalController {

	private final UserHospitalService userHospitalService;

	/**
	 * 用户收藏医院
	 * @param userHospital
	 * @return
	 */
	@PostMapping
	public R<Integer> add(@RequestBody UserHospital userHospital) {
		int add = userHospitalService.add(userHospital);
		return R.ok(add);
	}

	@GetMapping("list")
	public R<Page<UserHospital>> list(Integer pageNum, Integer pageSize){
		Page<UserHospital> list = userHospitalService.list(pageNum, pageSize);
		return R.ok(list);
	}

	@GetMapping("/{hospitalId}")
	public R<UserHospital> detail(@PathVariable("hospitalId") Long hospitalId){
		UserHospital detail = userHospitalService.detail(hospitalId);
		return R.ok(detail);
	}

    @DeleteMapping("/{hospitalId}")
	public R<Integer> delete(@PathVariable("hospitalId") Long hospitalId){
		int delete = userHospitalService.delete(hospitalId);
		return R.ok(delete);
	}
}
