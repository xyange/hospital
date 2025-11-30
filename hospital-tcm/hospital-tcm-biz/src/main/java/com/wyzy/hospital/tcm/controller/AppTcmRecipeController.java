

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import com.wyzy.hospital.tcm.kit.TcmRecipeKitService;
import com.wyzy.hospital.tcm.service.TcmRecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:16:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/tcmrecipe" )
@Api(value = "apptcmrecipe", tags = "方剂表APP管理")
public class AppTcmRecipeController {

    private final  TcmRecipeService tcmRecipeService;

	/**
	 * APP分页查询
	 * @param --page 分页对象
	 * @return
	 */
	@ApiOperation(value = "APP分页查询", notes = "APP分页查询")
	@GetMapping("/pageAPP" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<IPage<TcmRecipeDTO>> getTcmRecipePageAPP(Query query) {
		IPage<TcmRecipeDTO> tcmRecipeDTOIPage = tcmRecipeService.pageTcmRecipeDTOAPP(Condition.getPage(query));
		return R.ok(tcmRecipeDTOIPage);
	}

    /**
     * 通过id查询方剂表
     * @param recipeId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{recipeId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<TcmRecipeDTO> getById(@PathVariable("recipeId" ) Long recipeId) {
		TcmRecipeDTO byId = tcmRecipeService.getById(recipeId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
    }

	/**
	 * 通过recipesuperId查询方剂表
	 * @param recipesuperId id
	 * @return R
	 */
	@ApiOperation(value = "通过recipesuperId查询", notes = "通过recipesuperId查询")
	@GetMapping("/recipesuperId/{recipesuperId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<TcmRecipeDTO>> getByrecipesuperId(@PathVariable Long recipesuperId) {
		List<TcmRecipeDTO> tcmRecipeDTOList = tcmRecipeService.selectTcmRecipeByrecipesuperId(recipesuperId);
		if (tcmRecipeDTOList == null || tcmRecipeDTOList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmRecipeDTOList);
	}

}
