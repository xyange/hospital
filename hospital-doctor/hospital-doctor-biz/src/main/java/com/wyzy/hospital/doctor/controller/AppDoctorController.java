package com.wyzy.hospital.doctor.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.doctor.entity.Doctor;
import com.wyzy.hospital.doctor.service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wrk
 */

@RestController
@AllArgsConstructor
@RequestMapping("/app/doctor" )
@Api(value = "appDoctor", tags = "App端医生")
public class AppDoctorController {
	private final DoctorService doctorService;
	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param doctor 医生
	 * @return
	 */
	@ApiOperation(value = "条件分页查询", notes = "条件分页查询")
	@GetMapping("/page" )
	public R getDoctorPage(Page page, Doctor doctor) {
		return R.ok(doctorService.page(page, Wrappers.query(doctor)));
	}
}
