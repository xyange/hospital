

package com.wyzy.hospital.integration.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.integration.dto.BpBpactivityDTO;
import com.wyzy.hospital.integration.entity.BpBpactivity;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.service.BpBpactivityService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 积分活动表
 *
 * @author hospital code generator
 * @date 2021-05-08 16:09:33
 */
@RestController
@AllArgsConstructor
@RequestMapping("/bpbpactivity" )
@Api(value = "bpbpactivity", tags = "积分活动表管理")
public class BpBpactivityController {

    private final  BpBpactivityService bpBpactivityService;

    /**
     * 分页查询
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('integration_bpbpactivity_view')" )
    public R<IPage<BpBpactivityDTO>> getBpBpactivityPage(Query query) {
        return R.ok(bpBpactivityService.getBpBpactivityPage(Condition.getPage(query)));
    }

    /**
     * 通过id查询积分活动表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('integration_bpbpactivity_view')" )
    public R<BpBpactivity> getById(@PathVariable("id" ) Long id) {
		BpBpactivity byId = bpBpactivityService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
        return R.ok(byId);
    }

    /**
     * 新增积分活动表
     * @param bpBpactivity 积分活动表
     * @return R
     */
    @ApiOperation(value = "新增积分活动表", notes = "新增积分活动表")
    @SysLog("新增积分活动表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('integration_bpbpactivity_add')" )
    public R<Boolean> save(@RequestBody BpBpactivity bpBpactivity) {
        return R.ok(bpBpactivityService.save(bpBpactivity));
    }

    /**
     * 修改积分活动表
     * @param bpBpactivity 积分活动表
     * @return R
     */
    @ApiOperation(value = "修改积分活动表", notes = "修改积分活动表")
    @SysLog("修改积分活动表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('integration_bpbpactivity_edit')" )
    public R<Boolean> updateById(@RequestBody BpBpactivity bpBpactivity) {
        return R.ok(bpBpactivityService.updateById(bpBpactivity));
    }

    /**
     * 通过id删除逻辑积分活动表
	 * 当积分活动为上线状态时，不能删除
	 * 删除活动时，有相应订单时不可删除，订单完成后方可删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除逻辑积分活动表", notes = "通过id删除逻辑积分活动表")
    @SysLog("通过id删除逻辑积分活动表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('integration_bpbpactivity_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(bpBpactivityService.removeById(id));
    }

	/**
	 * 上线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	@ApiOperation(value = "上积分活动", notes = "上线积分活动")
	@SysLog("上线积分活动" )
	@PutMapping("/OnlineById")
	@PreAuthorize("@pms.hasPermission('integration_bpbpactivity_edit')" )
	public R<Boolean> OnlineById(Long id) {
		return R.ok(bpBpactivityService.OnlineById(id));
	}

	/**
	 * 下线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	@ApiOperation(value = "下线积分活动", notes = "下线积分活动")
	@SysLog("下线积分活动" )
	@PutMapping("/OfflineById")
	@PreAuthorize("@pms.hasPermission('integration_bpbpactivity_edit')" )
	public R<Boolean> OfflineById(Long id) {
		return R.ok(bpBpactivityService.OfflineById(id));
	}

}
