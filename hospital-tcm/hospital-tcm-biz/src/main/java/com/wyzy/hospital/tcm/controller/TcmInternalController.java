

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmInternalDTO;
import com.wyzy.hospital.tcm.entity.TcmInternal;
import com.wyzy.hospital.tcm.service.TcmInternalService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 内科学表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:38
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcminternal" )
@Api(value = "tcminternal", tags = "内科学表管理")
public class TcmInternalController {

    private final  TcmInternalService tcmInternalService;

    /**
     * 新增内科学表
     * @param tcmInternal 内科学表
     * @return R
     */
    @ApiOperation(value = "新增内科学表", notes = "新增内科学表")
    @SysLog("新增内科学表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcminternal_add')" )
    public R<Boolean> save(@RequestBody TcmInternal tcmInternal) {
        return R.ok(tcmInternalService.saveTcmInternal(tcmInternal));
    }

	/**
	 * 通过id删除内科学表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除内科学表", notes = "通过id删除内科学表")
	@SysLog("通过id删除内科学表" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcminternal_del')" )
	public R<Boolean> removeById(@PathVariable Integer id) {
		return R.ok(tcmInternalService.removeById(id));
	}

	/**
	 * 修改内科学表
	 * @param tcmInternal 内科学表
	 * @return R
	 */
	@ApiOperation(value = "修改内科学表", notes = "修改内科学表")
	@SysLog("修改内科学表" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcminternal_edit')" )
	public R<Boolean> updateById(@RequestBody TcmInternal tcmInternal) {
		return R.ok(tcmInternalService.updatePojoById(tcmInternal));
	}

	/**
	 * 通过Id查询内科学表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过Id查询内科学表", notes = "通过Id查询内科学表")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcminternal_view')" )
	public R<TcmInternalDTO> getById(@PathVariable("id" ) Long id) {
		TcmInternalDTO byId = tcmInternalService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询内科学表DTO
	 * @param name name
	 * @return R
	 */
	@ApiOperation(value = "通过name查询内科学表", notes = "通过name查询内科学表")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcminternal_view')" )
	public R<TcmInternalDTO> selectTcmInternalByName(String name) {
		TcmInternalDTO tcmInternalDTO = tcmInternalService.selectTcmInternalDTOByName(name);
		if (tcmInternalDTO == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmInternalDTO);
	}

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "上线/下线疾病详情", notes = "上线/下线疾病详情")
	@SysLog("上线/下线疾病详情" )
	@PutMapping("/goOnlineById")
	@PreAuthorize("@pms.hasPermission('tcm_tcminternal_edit')" )
	public R<Boolean> goOnlineById(Long id,Integer isOnline) {
		return R.ok(tcmInternalService.goOnlineById(id,isOnline));
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcminternal_view')" )
	public R<IPage<TcmInternalDTO>> getTcmInternalPage(Query query) {
		return R.ok(tcmInternalService.getTcmInternalPage(Condition.getPage(query)));
	}
}
