package com.wyzy.hospital.psychology.controller;

import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.api.feign.RemoteHospitalService;
import com.wyzy.hospital.admin.api.feign.RemotePsychologyDoctorService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.Kit.OrderRecordKitService;
import com.wyzy.hospital.psychology.Kit.PsychologistRecommendDetailKitService;
import com.wyzy.hospital.psychology.Kit.PsychologistRecommendKitService;
import com.wyzy.hospital.psychology.api.dto.OrderRecordDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.api.entity.OrderRecord;
import com.wyzy.hospital.psychology.service.OrderRecordService;
import com.wyzy.hospital.psychology.service.PsychologistRecommendDetailService;
import com.wyzy.hospital.psychology.service.PsychologyImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * app心理
 *
 * @author wrk
 * @date 2021/05/08 08:53
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/app/psychologist")
@Api(value = "psychologist", tags = "APP心理")
public class AppPsychologistController {
	@Resource
	private PsychologyImgService psychologyImgService;
	@Resource
	RemotePsychologyDoctorService remotePsychologyDoctorService;
	@Resource
	RemoteHospitalService remoteHospitalService;
	@Resource
	PsychologistRecommendKitService PsychologistRecommendKitService;
	@Resource
	PsychologistRecommendDetailKitService psychologistRecommendDetailKitService;
	@Resource
	OrderRecordKitService orderRecordKitService;

	/**
	 * 查图片
	 *
	 * @param imgType 图片类型（0：心理咨询主页轮播图，1：心理测试页轮播图，2：其他类型）
	 * @return com.wyzy.hospital.common.core.util.R
	 * @author wrk
	 * @date 2021/05/08 09:50
	 */
	public R listImg(Integer imgType) {
		return R.ok(psychologyImgService.listImg(imgType));
	}

	/**
	 * 查心理医生ids
	 * @return
	 */
	@ApiOperation(value = "查心理医生ids", notes = "查心理医生ids")
	@GetMapping("/getPsychologyDoctorIds")
	@PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
	public R<List<Doctor>> getPsychologyDoctorIds(Integer sex,String area) {
		int i = 0;
		R<List<Doctor>> d = remotePsychologyDoctorService.getPsychologyDoctorIds(sex,area);
		return d;
	}

	/**
	 * app推荐心理医生
	 * @param sex 性别
	 * @param area 地址
	 * @param day 可见日期
	 * @param counselId  咨询类型
	 * @param minPrice 小价格
	 * @param maxPrice 大价格
	 * @return
	 */
	@ApiOperation(value = "app推荐心理医生", notes = "app推荐心理医生")
	@GetMapping("/getRecommendDoctorIds")
	@PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
	public R<List<PsychologistRecommendDTO>> getRecommendDoctorIds(Integer sex, String area, Integer day, Integer counselId, BigDecimal minPrice, BigDecimal maxPrice,Long categoryId,Long serveId) {
		List<PsychologistRecommendDTO> prDTOList = PsychologistRecommendKitService.getRecommendDoctorIds(sex,area,day,counselId,minPrice,maxPrice,categoryId,serveId);
		if (prDTOList == null || prDTOList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(prDTOList);
	}

	/**
	 * 心理医生详情
	 * @param doctorId
	 * @return
	 */
	@ApiOperation(value = "心理医生详情", notes = "心理医生详情")
	@GetMapping("/getRecommendDoctorParticulars")
	@PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
	public R<PsychologistRecommendDetailDTO> getRecommendDoctorParticulars(Long doctorId,String year,String month) {
		PsychologistRecommendDetailDTO prDTOList = psychologistRecommendDetailKitService.getRecommendDoctorParticulars(doctorId,year,month);
		if (prDTOList == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(prDTOList);
	}


	/**
	 * 新增预约记录表
	 * @param memberId 会员ID
	 * @param orderId 预约ID
	 * @return
	 */
	@ApiOperation(value = "新增预约记录表", notes = "新增预约记录表")
	@SysLog("新增预约记录表" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
	public R<Boolean> save(Long memberId,Long orderId) {
		return R.ok(orderRecordKitService.saveorderRecord(memberId,orderId));
	}

	/**
	 * 查询咨询记录
	 * @return
	 */
	@ApiOperation(value = "查询咨询记录", notes = "查询咨询记录")
	@GetMapping("/orderrecordDTO")
	@PreAuthorize("@pms.hasPermission(" + CommonConstants.PATIENT_APP + ")")
	public R<List<OrderRecordDTO>> getOrderrecordDTO(Long memberId) {
		List<OrderRecordDTO> orderrecordDTO = PsychologistRecommendKitService.getOrderrecordDTO(memberId);
		return R.ok(orderrecordDTO);
	}

}
