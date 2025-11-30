

package com.wyzy.hospital.cyclopedia.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.service.FoodDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 食物详情表
 *
 * @author hospital code generator
 * @date 2021-04-25 11:08:01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/fooddetails" )
@Api(value = "fooddetails", tags = "App食物详情表管理")

public class AppFoodDetailsController {

    private final  FoodDetailsService foodDetailsService;


    /**
     * 通过id查询食物详情表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询食物详情表", notes = "通过id查询")
    @GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(foodDetailsService.getById(id));
    }


	/**
	 *  根据二级表查其下各自全部食物，并根据营养元素排序
	 * @param cid cid
	 * @return R
	 */
	@ApiOperation(value = "根据二级表查其下各自全部食物，并根据营养元素排序", notes = "根据二级表查其下各自全部食物，并根据营养元素排序")
	@GetMapping("/CidSelectFood/{cid}/{field}/{sort}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R getByCidSelectFood(@PathVariable("cid" ) Long cid ,@PathVariable("field" ) String field,@PathVariable("sort" ) String sort) {
		return R.ok(foodDetailsService.bySqlQueryFood(cid,field,sort));
	}


	/**
	 *  根据一级表查其下全部食物，并根据营养元素排序
	 * @param  fid field sort
	 * @return R
	 */
	@ApiOperation(value = "根据一级表查其下全部食物，并根据营养元素排序", notes = "根据一级表查其下全部食物，并根据营养元素排序")
	@GetMapping("/FidSelectFood/{fid}/{field}/{sort}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R getByFidSelectFood(@PathVariable("fid" ) Long fid ,@PathVariable("field" ) String field,@PathVariable("sort" ) String sort) {
		return R.ok(foodDetailsService.bySqlSelectAllFood(fid, field, sort));
	}


}
