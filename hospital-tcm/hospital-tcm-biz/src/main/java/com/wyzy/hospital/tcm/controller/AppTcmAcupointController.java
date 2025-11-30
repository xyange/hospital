package com.wyzy.hospital.tcm.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmAcupointDTO;
import com.wyzy.hospital.tcm.service.TcmAcupointService;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmacupoint" )
@Api(value = "apptcmacupoint", tags = "穴位表APP管理")
public class AppTcmAcupointController {

    private final  TcmAcupointService tcmAcupointService;

	/**
	 * 查询经络腧穴:两级分类及数据表，三层
	 * @return R
	 */
	@ApiOperation(value = "APP查询经络腧穴列表", notes = "APP查询经络腧穴列表")
	@GetMapping("/acupointAPP" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmSortListVO>> getAcupointTcmSortListAPP() {
		List<TcmSortListVO> acupointTcmSortListAPP = tcmAcupointService.getAcupointTcmSortListAPP();
		if(acupointTcmSortListAPP == null || acupointTcmSortListAPP.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}else {
			return R.ok(acupointTcmSortListAPP);
		}
	}

    /**
     * 通过id查询穴位表
     * @param acupointId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{acupointId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<TcmAcupointDTO> getById(@PathVariable("acupointId" ) Long acupointId) {
		TcmAcupointDTO byId = tcmAcupointService.getById(acupointId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}else {
			return R.ok(byId);
		}
    }

}
