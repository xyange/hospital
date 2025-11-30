

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.dto.AddFoodDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodDetails;
import com.wyzy.hospital.cyclopedia.exception.GlobalException;
import com.wyzy.hospital.cyclopedia.kit.AddFoodKitService;
import com.wyzy.hospital.cyclopedia.service.FoodDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 食物详情表
 *
 * @author hospital code generator
 * @date 2021-04-25 11:08:01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/fooddetails" )
@Api(value = "fooddetails", tags = "食物详情表管理")

public class FoodDetailsController {

    private final  FoodDetailsService foodDetailsService;

	private final AddFoodKitService addFoodKitService;
	/**
     * 分页查询
     * @param page 分页对象
     * @param foodDetails 食物详情表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_view')" )
    public R getFoodDetailsPage(Page page, FoodDetails foodDetails) {
        return R.ok(foodDetailsService.page(page, Wrappers.query(foodDetails)));
    }


    /**
     * 通过id查询食物详情表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(foodDetailsService.getById(id));
    }

    /**
     * 新增食物详情表
     * @param foodDetails 食物详情表
     * @return R
     */
    @ApiOperation(value = "新增食物详情表", notes = "新增食物详情表")
    @SysLog("新增食物详情表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_add')" )
    public R save(@RequestBody FoodDetails foodDetails) {
		String foodName=foodDetailsService.selectByFoodName(foodDetails.getFoodName());
        if(foodName==null) {
			return R.ok(foodDetailsService.save(foodDetails));
		}else {
			throw new GlobalException(CodeMsg.CYCLOPEDIA_DATD_REPEAT);
		}
    }


    /**
     * 修改食物详情表
     * @param foodDetails 食物详情表
     * @return R
     */
    @ApiOperation(value = "修改食物详情表", notes = "修改食物详情表")
    @SysLog("修改食物详情表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_edit')" )
    public R updateById(@RequestBody FoodDetails foodDetails) {
        return R.ok(foodDetailsService.updateById(foodDetails));
    }

    /**
     * 通过id删除食物详情表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除食物详情表", notes = "通过id删除食物详情表")
    @SysLog("通过id删除食物详情表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(foodDetailsService.removeById(id));
    }

	/**
	 * 根据二级分类以及营养元素查询食物并升序降序
	 * @param cid cid
	 * @return R
	 */
	@ApiOperation(value = "根据二级分类以及营养元素查询食物并升序降序", notes = "根据二级分类以及营养元素查询食物并升序降序")
	@GetMapping("/CidSelectFood/{cid}/{field}/{sort}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_view')" )
	public R<List<FoodDetailsDTO>> getByCidSelectFood(@PathVariable("cid" ) Long cid , @PathVariable("field" ) String field, @PathVariable("sort" ) String sort) {
		return R.ok(foodDetailsService.bySqlQueryFood(cid,field,sort));
	}


	/**根据一级分类以及营养元素查询食物并升序降序
	 * @param  fid field sort
	 * @return R
	 */
	@ApiOperation(value = "根据一级分类以及营养元素查询食物并升序降序", notes = "通过tid查询")
	@GetMapping("/FidSelectFood/{fid}/{field}/{sort}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_view')" )
	public R<List<FoodDetailsDTO>>getByFidSelectFood(@PathVariable("fid") Long fid ,@PathVariable("field") String field,@PathVariable("sort") String sort) {
		return R.ok(foodDetailsService.bySqlSelectAllFood(fid, field, sort));
	}

	/**
	 * 修改审核状态
	 * @param foodDetails,status 修改审核状态
	 */
	@ApiOperation(value = "修改审核状态", notes = "修改审核状态")
	@SysLog("修改审核状态" )
	@PutMapping("/ChangeFoodStatus")
	@PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_edit')" )
	public void updateStatusById(@RequestBody FoodDetails foodDetails) {
		String status=foodDetailsService.getById(foodDetails.getFoodId()).getFoodAuditStatus();
		foodDetailsService.ChangeFoodStatus(foodDetails.getFoodId(),status);
	}


	/**
	 * 重新提交
	 * @param foodDetails
	 */
	@ApiOperation(value = "重新提交审核", notes = "重新提交审核")
	@SysLog("重新提交审核" )
	@PutMapping("/reSubmitAlterStatus")
	@PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_edit')" )
	public void reSubmitAlterStatus(@RequestBody FoodDetails foodDetails) {
		String status=foodDetailsService.getById(foodDetails.getFoodId()).getFoodAuditStatus();
		foodDetailsService.ReSubmitAlterStatus(foodDetails.getFoodId(),status);
	}

	/**
	 * 上线下线
	 * @param foodDetails
	 */
	@ApiOperation(value = "上线下线", notes = "上线下线")
	@SysLog("上线下线" )
	@PutMapping("/updateExFoodById")
	@PreAuthorize("@pms.hasPermission('cyclopedia_fooddetails_edit')" )
	public void updateFoodStatus(@RequestBody FoodDetails foodDetails) {
		String foodExistStatus=foodDetailsService.getById(foodDetails.getFoodId()).getFoodExistStatus();
		foodDetailsService.updateFoodStatus(foodDetails.getFoodId(),foodExistStatus);
	}


	/**
	 * 新增添加食物表
	 * @param addFoodDTO
	 * @return
	 */
	@ApiOperation(value = "新增添加食物表（后台）", notes = "新增添加食物表")
	@SysLog("新增公司药品表")
	@PostMapping("/addFood")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_add')")
	public R save(@RequestBody AddFoodDTO addFoodDTO) {
		return R.ok(addFoodKitService.addFoodKitService(addFoodDTO));
	}

}
