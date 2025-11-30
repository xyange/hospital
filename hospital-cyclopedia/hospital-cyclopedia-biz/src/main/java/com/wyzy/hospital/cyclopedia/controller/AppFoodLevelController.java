

package com.wyzy.hospital.cyclopedia.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.dto.FoodBackstageDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodLevelDTO;
import com.wyzy.hospital.cyclopedia.mapper.FoodLevelMapper;
import com.wyzy.hospital.cyclopedia.service.FoodLevelService;
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
 * 食物一级表
 *
 * @author hospital code generator
 * @date 2021-04-27 08:56:39
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/foodlevel" )
@Api(value = "foodlevel", tags = "app食物分类表管理")
public class  AppFoodLevelController {

    private final  FoodLevelService foodLevelService;
    private final FoodLevelMapper foodLevelMapper;





	/**
	 * 查一级
	 * @return R
	 */
	@ApiOperation(value = "查一级", notes = "查一级")
	@GetMapping("/getFoodFirst" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R <List<FoodLevelDTO>>getFirstCount() {
		return R.ok(foodLevelService.queryFirstByLevel());
	}

	/**
	 * 通过一级查二级
	 * @param fid
	 * @return R
	 */
	@ApiOperation(value = "通过一级查二级", notes = "通过一级查二级")
	@GetMapping("/queryTwoByFid/{fid}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R <List<FoodLevelDTO>> getqueryTwoByFid(@PathVariable("fid" ) long fid) {
		return R.ok(foodLevelService.queryTwoByFid(fid));
	}

	/**
	 * 查询食物详情
	 * @param id
	 * @return R
	 */
	@ApiOperation(value = "根据食物查食物详情", notes = "根据食物id查食物详情")
	@GetMapping("/FoodDetailsBack/{id}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R <List<FoodBackstageDTO>>queryFoodDetailsBack(@PathVariable("id" ) long id) {
		return R.ok(foodLevelService.queryFoodDetailsBack(id));
	}

}
