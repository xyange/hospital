package com.wyzy.hospital.doctor.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@ApiModel(value = "医生详细信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

	/**
	 * 医生id
	 */
	private Long doctorId;

	/**
	 * 医生姓名
	 */
	private String doctorName;

	/**
	 * 医生科室id
	 */
	private Long departmentId;

	/**
	 * 医生科室
	 */
	private String department;

	/**
	 * 医生职称id
	 */
	private Integer professionalTitleId;

	/**
	 * 医生职称
	 */
	private String professionalTitle;

	/**
	 * 医院级别
	 */
	private String hospitalGrade;

	/**
	 * 医院名称
	 */
	private String hospitalName;

	/**
	 * 医生服务
	 */
	private List<Map<String, Object>> hospitalService;

	/**
	 * 擅长
	 */
	private String adept;

	/**
	 * 挂号费
	 */
	private Integer cost;

	/**
	 * 服务人次
	 */
	private Integer peopleNumber;

	/**
	 * 医生头像
	 */
	private String headPictureUrl;
}
