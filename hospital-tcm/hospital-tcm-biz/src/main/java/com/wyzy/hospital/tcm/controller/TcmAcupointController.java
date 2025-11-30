

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmAcupointDTO;
import com.wyzy.hospital.tcm.entity.TcmAcupoint;
import com.wyzy.hospital.tcm.service.TcmAcupointService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmacupoint" )
@Api(value = "tcmacupoint", tags = "穴位表管理")
public class TcmAcupointController {

    private final  TcmAcupointService tcmAcupointService;

	/**
	 * 新增穴位表
	 * @param tcmAcupoint 穴位表
	 * @return R
	 */
	@ApiOperation(value = "新增穴位表", notes = "新增穴位表")
	@SysLog("新增穴位表" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmacupoint_add')" )
	public R<Boolean> save(@RequestBody TcmAcupoint tcmAcupoint) {
		return R.ok(tcmAcupointService.saveTcmAcupoint(tcmAcupoint));
	}

	/**
	 * 通过id删除穴位表
	 * @param acupointId id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除穴位表", notes = "通过id删除穴位表")
	@SysLog("通过id删除穴位表" )
	@DeleteMapping("/{acupointId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmacupoint_del')" )
	public R<Boolean> removeById(@PathVariable Long acupointId) {
		return R.ok(tcmAcupointService.removeById(acupointId));
	}

	/**
	 * 修改穴位表
	 * @param tcmAcupoint 穴位表
	 * @return R
	 */
	@ApiOperation(value = "修改穴位表", notes = "修改穴位表")
	@SysLog("修改穴位表" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmacupoint_edit')" )
	public R<Boolean> updateById(@RequestBody TcmAcupoint tcmAcupoint) {
		return R.ok(tcmAcupointService.updateTcmAcupointById(tcmAcupoint));
	}

	/**
	 * 通过id查询穴位表
	 * @param acupointId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{acupointId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmacupoint_view')" )
	public R<TcmAcupointDTO> getById(@PathVariable("acupointId" ) Long acupointId) {
		TcmAcupointDTO byId = tcmAcupointService.getById(acupointId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询穴位表
	 * @param name id
	 * @return R
	 */
	@ApiOperation(value = "通过name查询", notes = "通过name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmacupoint_view')" )
	public R<TcmAcupointDTO> getTcmAcupointByName(String name) {
		TcmAcupointDTO tcmAcupointDTO = tcmAcupointService.getTcmAcupointDTOByName(name);
		if (tcmAcupointDTO == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmAcupointDTO);
	}

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "上线/下线疾病详情", notes = "上线/下线疾病详情")
	@SysLog("上线/下线疾病详情" )
	@PutMapping("/goOnlineById")
	@PreAuthorize("@pms.hasPermission('tcm_tcmacupoint_edit')" )
	public R<Boolean> goOnlineById(Long acupointId,Integer isOnline) {
		return R.ok(tcmAcupointService.goOnlineById(acupointId,isOnline));
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmacupoint_view')" )
	public R<IPage<TcmAcupointDTO>> getTcmAcupointPage(Query query) {
		return R.ok(tcmAcupointService.pageTcmAcupointDTO(Condition.getPage(query)));
	}

}
