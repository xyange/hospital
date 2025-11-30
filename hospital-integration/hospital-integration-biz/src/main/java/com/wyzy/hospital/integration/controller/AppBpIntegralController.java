package com.wyzy.hospital.integration.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.integration.dto.AppBpIntegralDTO;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.dto.EveryDayDTO;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.kit.AppBpIntegralKitService;
import com.wyzy.hospital.integration.kit.BpIntegralKitService;
import com.wyzy.hospital.integration.kit.BpIntegralruleKitService;
import com.wyzy.hospital.integration.service.BpIntegralService;
import com.wyzy.hospital.integration.vo.BpIntegralVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/bpintegral" )
@Api(value = "bpintegral", tags = "APP积分表管理")
public class AppBpIntegralController {
	private final BpIntegralKitService bpIntegralKitService;
	private final AppBpIntegralKitService appBpIntegralKitService;

	/**
	 * todo 新增积分表(只根据规则增加积分，暂未完成根据活动添加)
	 * @param bpIntegral 积分表
	 * @return R
	 */
	@ApiOperation(value = "新增积分表", notes = "新增积分表")
	@SysLog("新增积分表" )
	@PostMapping("/saveIntegration")
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<Boolean> saveIntegration(@RequestBody BpIntegral bpIntegral) {
		return R.ok(bpIntegralKitService.saveIntegration(bpIntegral));
	}

	/**
	 * APP积分
	 * @return R
	 */
	@ApiOperation(value = "APP积分", notes = "APP积分")
	@GetMapping("/AppBpIntegralDTO" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<AppBpIntegralDTO> AppBpIntegralDTO(Long memberId) {
		AppBpIntegralDTO bpIntegralDTOList = appBpIntegralKitService.AppBpIntegralDTO(memberId);
		if (bpIntegralDTOList == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(bpIntegralDTOList);
	}
}
