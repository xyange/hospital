package com.wyzy.hospital.integration.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.integration.dto.BpIntegralruleDTO;
import com.wyzy.hospital.integration.entity.BpIntegralrule;
import com.wyzy.hospital.integration.service.BpIntegralruleService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 积分规则表
 *
 * @author hospital code generator
 * @date 2021-05-10 11:18:22
 */
@RestController
@AllArgsConstructor
@RequestMapping("/bpintegralrule" )
@Api(value = "bpintegralrule", tags = "积分规则表管理")
public class BpIntegralruleController {

    private final  BpIntegralruleService bpIntegralruleService;

	/**
	 * 新增积分规则表
	 * @param bpIntegralrule 积分规则表
	 * @return R
	 */
	@ApiOperation(value = "新增积分规则表", notes = "新增积分规则表")
	@SysLog("新增积分规则表" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('integration_bpintegralrule_add')" )
	public R<Boolean> save(@RequestBody BpIntegralrule bpIntegralrule) {
		return R.ok(bpIntegralruleService.saveBpIntegralrule(bpIntegralrule));
	}

	/**
	 * 通过id删除积分规则表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除积分规则表", notes = "通过id删除积分规则表")
	@SysLog("通过id删除积分规则表" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegralrule_del')" )
	public R<Boolean> removeById(@PathVariable Long id) {
		return R.ok(bpIntegralruleService.removeById(id));
	}

	/**
	 * 修改积分规则表
	 * @param bpIntegralrule 积分规则表
	 * @return R
	 */
	@ApiOperation(value = "修改积分规则表", notes = "修改积分规则表")
	@SysLog("修改积分规则表" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('integration_bpintegralrule_edit')" )
	public R<Boolean> updateById(@RequestBody BpIntegralrule bpIntegralrule) {
		return R.ok(bpIntegralruleService.updateById(bpIntegralrule));
	}

	/**
	 * 通过id查询积分规则表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegralrule_view')" )
	public R<BpIntegralruleDTO> getBpIntegralruleById(@PathVariable("id" ) Long id) {
		BpIntegralruleDTO bpIntegralruleById = bpIntegralruleService.getBpIntegralruleById(id);
		if (bpIntegralruleById == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(bpIntegralruleById);
	}

    /**
     * 分页查询
     * @param page 分页对象
     * @param bpIntegralrule 积分规则表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('integration_bpintegralrule_view')" )
    public R getBpIntegralrulePage(Page page, BpIntegralrule bpIntegralrule) {
        return R.ok(bpIntegralruleService.page(page, Wrappers.query(bpIntegralrule)));
    }

	/**
	 * 修改每日任务
	 * @return R
	 */
	@ApiOperation(value = "修改每日任务", notes = "修改每日任务")
	@SysLog("修改每日任务" )
	@PutMapping("/isEveryday")
	@PreAuthorize("@pms.hasPermission('integration_bpintegralrule_edit')" )
	public R<Boolean> isEveryday(Long id,Integer isEveryday) {
		return R.ok(bpIntegralruleService.isEveryday(id,isEveryday));
	}

}
