

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmCmDTO;
import com.wyzy.hospital.tcm.entity.TcmCm;
import com.wyzy.hospital.tcm.service.TcmCmService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:46
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmcm" )
@Api(value = "tcmcm", tags = "中药表管理")
public class TcmCmController {

    private final  TcmCmService tcmCmService;

	/**
	 * 新增中药表
	 * @param tcmCm 中药表
	 * @return R
	 */
	@ApiOperation(value = "新增中药表", notes = "新增中药表")
	@SysLog("新增中药表" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmcm_add')" )
	public R<Boolean> save(@RequestBody TcmCm tcmCm) {
		return R.ok(tcmCmService.saveTcmCm(tcmCm));
	}

    /**
     * 通过id删除中药表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除中药表", notes = "通过id删除中药表")
    @SysLog("通过id删除中药表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('tcm_tcmcm_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(tcmCmService.removeById(id));
    }

	/**
	 * 修改中药表
	 * @param tcmCm 中药表
	 * @return R
	 */
	@ApiOperation(value = "修改中药表", notes = "修改中药表")
	@SysLog("修改中药表" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmcm_edit')" )
	public R<Boolean> updateById(@RequestBody TcmCm tcmCm) {
		return R.ok(tcmCmService.updateTcmCmById(tcmCm));
	}

	/**
	 * 通过Id查询中药
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过Id查询中药", notes = "通过Id查询中药")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmcm_view')" )
	public R<TcmCmDTO> getById(@PathVariable("id" ) Long id) {
		TcmCmDTO byId = tcmCmService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询中药DTO
	 * @param name id
	 * @return R
	 */
	@ApiOperation(value = "通过name查询中药", notes = "通过name查询中药")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmcm_view')" )
	public R<TcmCmDTO> selectTcmCmByName(String name) {
		TcmCmDTO tcmCmDTO = tcmCmService.selectTcmCmDTOByName(name);
		if (tcmCmDTO == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmCmDTO);
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询(上下线)", notes = "分页查询(上下线)")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmcm_view')" )
	public R<IPage<TcmCmDTO>> getTcmCmPage(Query query) {
		IPage<TcmCmDTO> tcmCmPage = tcmCmService.getTcmCmPage(Condition.getPage(query));
		return R.ok(tcmCmPage);
	}

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "上线/下线疾病详情", notes = "上线/下线疾病详情")
	@SysLog("上线/下线疾病详情" )
	@PutMapping("/goOnlineById")
	@PreAuthorize("@pms.hasPermission('tcm_tcmcm_edit')" )
	public R<Boolean> goOnlineById(Long id,Integer isOnline) {
		return R.ok(tcmCmService.goOnlineById(id,isOnline));
	}
}
