package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmMeridiansDTO;
import com.wyzy.hospital.tcm.entity.TcmMeridians;
import com.wyzy.hospital.tcm.service.TcmMeridiansService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 经脉表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmmeridians" )
@Api(value = "tcmmeridians", tags = "经脉表管理")
public class TcmMeridiansController {

    private final  TcmMeridiansService tcmMeridiansService;

	/**
	 * 新增经脉表
	 * @param tcmMeridians 经脉表
	 * @return R
	 */
	@ApiOperation(value = "新增经脉表", notes = "新增经脉表")
	@SysLog("新增经脉表" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmmeridians_add')" )
	public R<Boolean> save(@RequestBody TcmMeridians tcmMeridians) {
		return R.ok(tcmMeridiansService.saveTcmMeridians(tcmMeridians));
	}

	/**
	 * 通过id删除经脉表
	 * @param meridiansId id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除经脉表", notes = "通过id删除经脉表")
	@SysLog("通过id删除经脉表" )
	@DeleteMapping("/{meridiansId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmeridians_del')" )
	public R<Boolean> removeById(@PathVariable Long meridiansId) {
		return R.ok(tcmMeridiansService.removeById(meridiansId));
	}

	/**
	 * 修改经脉表
	 * @param tcmMeridians 经脉表
	 * @return R
	 */
	@ApiOperation(value = "修改经脉表", notes = "修改经脉表")
	@SysLog("修改经脉表" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmmeridians_edit')" )
	public R<Boolean> updateById(@RequestBody TcmMeridians tcmMeridians) {
		return R.ok(tcmMeridiansService.updatePojoById(tcmMeridians));
	}

	/**
	 * 通过id查询经脉表
	 * @param meridiansId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{meridiansId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmeridians_view')" )
	public R<TcmMeridiansDTO> getById(@PathVariable("meridiansId" ) Long meridiansId) {
		TcmMeridiansDTO byId = tcmMeridiansService.getById(meridiansId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询经脉表DTO
	 * @param name name
	 * @return R
	 */
	@ApiOperation(value = "通过name查询", notes = "通过name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmeridians_view')" )
	public R<TcmMeridiansDTO> selectTcmMeridiansByName(String name) {
		TcmMeridiansDTO tcmMeridiansDTO = tcmMeridiansService.selectTcmMeridiansDTOByName(name);
		if (tcmMeridiansDTO == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmMeridiansDTO);
	}

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "上线/下线经脉详情", notes = "上线/下线经脉详情")
	@SysLog("上线/下线疾病详情" )
	@PutMapping("/goOnlineById")
	@PreAuthorize("@pms.hasPermission('tcm_tcmmeridians_edit')" )
	public R<Boolean> goOnlineById(Long meridiansId,Integer isOnline) {
		return R.ok(tcmMeridiansService.goOnlineById(meridiansId,isOnline));
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询(上下线)", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmeridians_view')" )
	public R<IPage<TcmMeridians>> getTcmMeridiansPage(Query query) {
		return R.ok(tcmMeridiansService.getTcmMeridiansPage(Condition.getPage(query)));
	}

}
