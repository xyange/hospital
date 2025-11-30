

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.dto.EffectDTO;
import com.wyzy.hospital.cyclopedia.entity.Effect;
import com.wyzy.hospital.cyclopedia.service.EffectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 功效表
 *
 * @author hospital code generator
 * @date 2021-04-29 08:26:13
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/effect" )
@Api(value = "effect", tags = "App功效表管理")
public class AppEffectController {

    private final  EffectService effectService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param effect 功效表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R getEffectPage(Page page, Effect effect) {
        return R.ok(effectService.page(page, Wrappers.query(effect)));
    }


    /**
     * 通过id查询功效表
     * @param effectId id
     * @return R
     */
    @ApiOperation(value = "功效表查一个", notes = "通过id查询")
    @GetMapping("/{effectId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R getById(@PathVariable("effectId" ) Long effectId) {
        return R.ok(effectService.getById(effectId));
    }


	/**
	 * 通过id(标签表)查询功效表
	 * @param eid eid
	 * @return R
	 */
	@ApiOperation(value = "通过标签表查询功效表", notes = "通过eid查询")
	@GetMapping("/Effect/{eid}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<EffectDTO>> getEffectTag(@PathVariable("eid" ) Long eid) {
		return R.ok(effectService.queryMyEffecTag(eid));
	}

	/**
	 * 查功效
	 * @return
	 */
	@ApiOperation(value = "查所有功效", notes = "查功效")
	@GetMapping("/selectEffect" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R <List<EffectDTO>>selectEffect() {
		return R.ok(effectService.selectEffect());
	}

}
