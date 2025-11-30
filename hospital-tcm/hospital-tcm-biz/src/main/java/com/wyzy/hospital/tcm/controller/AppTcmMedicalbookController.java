package com.wyzy.hospital.tcm.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import com.wyzy.hospital.tcm.dto.TcmMedicalbookDTO;
import com.wyzy.hospital.tcm.kit.TcmSortKitService;
import com.wyzy.hospital.tcm.service.TcmMedicalbookService;
import com.wyzy.hospital.tcm.service.TcmUsermedicalbookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmmedicalbook" )
@Api(value = "apptcmmedicalbook", tags = "医书表APP管理")
public class AppTcmMedicalbookController {

    private final  TcmMedicalbookService tcmMedicalbookService;
	private final TcmUsermedicalbookService tcmUsermedicalbookService;

	/**
	 * 通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{medicalbookId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<TcmMedicalbookDTO> getById(@PathVariable("medicalbookId" ) Long medicalbookId) {
		HospitalUser user = SecurityUtils.getUser();
		TcmMedicalbookDTO byIdAPP = tcmMedicalbookService.getByIdAPP(user.getId(), medicalbookId);
		if (byIdAPP == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byIdAPP);
	}


	/**
	 * 通过Bookkattr值查询医书表
	 * @param classicsId 经典分类
	 * @param sectId 流派
	 * @param subjectId 学科
	 * @param writerId 作者
	 * @return
	 */
	@ApiOperation(value = "通过Bookkattr值查询医书表", notes = "通过Bookkattr值查询医书表")
	@GetMapping("/bookkattr" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmMedicalbookDTO>> getByMultivalued(Long classicsId,Long sectId,Long subjectId,Long writerId) {
		List<TcmMedicalbookDTO> byMultivalued = tcmMedicalbookService.getByMultivalued(classicsId, sectId, subjectId, writerId);
		if (byMultivalued == null || byMultivalued.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byMultivalued);
	}

	/**
	 * 医书收藏/取消收藏
	 */
	@ApiOperation(value = "医书收藏/取消收藏", notes = "1收藏 0取消收藏")
	@PostMapping("collectMedicalbook/{id}")
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<Integer> collectHospital(@PathVariable("id") Long medicalbookId){
		HospitalUser user = SecurityUtils.getUser();
		Integer i = tcmUsermedicalbookService.collectMedicalbook(user.getId(), medicalbookId);
		return R.ok(i);
	}


	/**
	 * 我的医书经典收藏
	 * @return R
	 */
	@ApiOperation(value = "查看书架", notes = "查看书架")
	@GetMapping("/collectMedicalbook" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmMedicalbookDTO>> getcollectMedicalbook() {
		HospitalUser user = SecurityUtils.getUser();
		List<TcmMedicalbookDTO> tcmMedicalbookDTOList = tcmMedicalbookService.getcollectMedicalbook(user.getId());
		if (tcmMedicalbookDTOList == null || tcmMedicalbookDTOList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmMedicalbookDTOList);
	}
}
