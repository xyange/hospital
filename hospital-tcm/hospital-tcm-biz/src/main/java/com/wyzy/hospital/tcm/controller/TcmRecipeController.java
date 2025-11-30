package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import com.wyzy.hospital.tcm.kit.TcmRecipeKitService;
import com.wyzy.hospital.tcm.service.TcmRecipeService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:16:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmrecipe" )
@Api(value = "tcmrecipe", tags = "方剂表管理")
public class TcmRecipeController {

    private final  TcmRecipeService tcmRecipeService;
    private final  TcmRecipeKitService tcmRecipeKitService;

	/**
	 * 新增方剂表
	 * @param tcmRecipe 方剂表
	 * @return R
	 */
	@ApiOperation(value = "新增方剂表", notes = "新增方剂表")
	@SysLog("新增方剂表" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipe_add')" )
	public R<Boolean> save(@RequestBody TcmRecipe tcmRecipe) {
		return R.ok(tcmRecipeService.saveTcmRecipe(tcmRecipe));
	}

	/**
	 * 通过id删除方剂表
	 * @param recipeId id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除方剂表", notes = "通过id删除方剂表")
	@SysLog("通过id删除方剂表" )
	@DeleteMapping("/{recipeId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipe_del')" )
	public R<Boolean> removeById(@PathVariable Long recipeId) {
		return R.ok(tcmRecipeService.removeById(recipeId));
	}

	/**
	 * 修改方剂表
	 * @param tcmRecipe 方剂表
	 * @return R
	 */
	@ApiOperation(value = "修改方剂表", notes = "修改方剂表")
	@SysLog("修改方剂表" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipe_edit')" )
	public R<Boolean> updateById(@RequestBody TcmRecipe tcmRecipe) {
		return R.ok(tcmRecipeService.updatePojoById(tcmRecipe));
	}

	/**
	 * 通过id查询方剂表
	 * @param recipeId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{recipeId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipe_view')" )
	public R<TcmRecipe> getById(@PathVariable("recipeId" ) Long recipeId) {
		TcmRecipeDTO byId = tcmRecipeService.getById(recipeId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询方剂表
	 * @param name id
	 * @return R
	 */
	@ApiOperation(value = "通过name查询", notes = "通过name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipe_view')" )
	public R<TcmRecipeDTO> getTcmRecipeByName(String name) {
		TcmRecipeDTO recipeDTO = tcmRecipeService.selectTcmRecipeDTOByName(name);
		if (recipeDTO == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(recipeDTO);
	}

	/**
	 * 下线/上线详情
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "上线/下线详情", notes = "上线/下线详情")
	@SysLog("上线/下线详情" )
	@PutMapping("/goOnlineById")
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipe_edit')" )
	public R<Boolean> goOnlineById(Long recipeId,Integer isOnline) {
		return R.ok(tcmRecipeService.goOnlineById(recipeId,isOnline));
	}

    /**
     * 分页查询
     * @param --page 分页对象
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('tcm_tcmrecipe_view')" )
    public R<IPage<TcmRecipeDTO>> getTcmRecipePage(Query query) {
        return R.ok(tcmRecipeService.pageTcmRecipeDTO(Condition.getPage(query)));
    }

}
