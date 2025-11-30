

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.cyclopedia.dto.FoodBackstageDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodLevelDTO;
import com.wyzy.hospital.cyclopedia.dto.FoodOneLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.FoodLevel;
import com.wyzy.hospital.cyclopedia.exception.GlobalException;
import com.wyzy.hospital.cyclopedia.mapper.FoodLevelMapper;
import com.wyzy.hospital.cyclopedia.service.FoodLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 食物一级表
 *
 * @author hospital code generator
 * @date 2021-04-27 08:56:39
 */
@RestController
@AllArgsConstructor
@RequestMapping("/foodlevel" )
@Api(value = "foodlevel", tags = "食物一级表管理")
public class FoodLevelController {

    private final  FoodLevelService foodLevelService;
    private final FoodLevelMapper foodLevelMapper;

    /**
     * 分页查询
     * @param page 分页对象
     * @param foodLevel 食物一级表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
    public R getFoodLevelPage(Page page, FoodLevel foodLevel) {
        return R.ok(foodLevelService.page(page, Wrappers.query(foodLevel)));
    }


    /**
     * 通过id查询食物一级表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(foodLevelService.getById(id));
    }

    /**
     * 新增食物一级表
     * @param foodLevel 食物一级表
     * @return R
     */
    @ApiOperation(value = "新增食物一级表", notes = "新增食物一级表")
    @SysLog("新增食物一级表" )
    @PostMapping("/addFoodLevel")
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_add')" )
    public R save(@RequestBody FoodLevel foodLevel) {
		String foodLevelName=foodLevelMapper.selectName(foodLevel.getFoodLevelName());
		if(foodLevelName==null) {
			return R.ok(foodLevelService.save(foodLevel));
		}else {
			throw new GlobalException(CodeMsg.CYCLOPEDIA_DATD_REPEAT);
		}
    }

    /**
     * 修改食物一级表
     * @param foodLevel 食物一级表
     * @return R
     */
    @ApiOperation(value = "修改食物一级表", notes = "修改食物一级表")
    @SysLog("修改食物一级表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_edit')" )
    public R updateById(@RequestBody FoodLevel foodLevel) {
        return R.ok(foodLevelService.updateById(foodLevel));
    }

    /**
     * 通过id删除食物一级表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除食物一级表", notes = "通过id删除食物一级表")
    @SysLog("通过id删除食物一级表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_del')" )
    public R removeById(@PathVariable Long id) {

    	int levels=foodLevelMapper.selectById(id).getLevels();
    	return R.ok(foodLevelService.movenFoodLevel(id,levels));
    }




	/**
	 * 查一级
	 * @return R
	 */
	@ApiOperation(value = "查一级", notes = "查一级")
	@GetMapping("/getFoodFirst" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
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
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<FoodLevelDTO>> getqueryTwoByFid(@PathVariable("fid" ) long fid) {
		return R.ok(foodLevelService.queryTwoByFid(fid));
	}


	/**
	 * 查二级表下所属食物的数量（删除判断）
	 * @param foodLevelId
	 * @return R
	 */
	@ApiOperation(value = "通过fid查询二级表下所属食物的数量", notes = "通过fid查询二级表下所属食物的数量")
	@GetMapping("/queryDetailsCount/{foodLevelId}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R getDetailsCount(@PathVariable("foodLevelId" ) long foodLevelId) {
		return R.ok(foodLevelService.queryDetailsCount(foodLevelId));
	}

	/**
	 * 查一级表下二级表的数量(删除判断)
	 * @param fid
	 * @return R
	 */
	@ApiOperation(value = "通过fid查询二级表数量", notes = "通过fid查询二级表数量")
	@GetMapping("/getFoodFirstCount/{fid}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R getFirstCount(@PathVariable("fid" ) long fid) {

		return R.ok(foodLevelService.queryFoodLevelCount(fid));
	}



	/**
	 * 查一级与二级食物下包含的食物总量(后台)
	 * @return R
	 */
	@ApiOperation(value = "查一级和二级食物下包含的食物总量", notes = "查一级和二级食物下包含的食物总量")
	@GetMapping("/FoodNumber" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R<List<FoodOneLevelDTO>> firstQueryFoodNumber() {
		return R.ok(foodLevelService.firstQueryFoodNumber());
	}



	/**
	 * 食物百科审核(后台)
	 *  @param query
	 * @return R
	 */
	@ApiOperation(value = "食物百科审核", notes = "食物百科审核")
	@GetMapping("/FoodBackstage" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<FoodBackstageDTO>> queryFoodBackstage(Query query) {
		return R.ok(foodLevelService.queryFoodBackstage(Condition.getPage(query)));
	}

	/**
	 * 食物百科列表(后台)
	 * @param query
	 * @return R
	 */
	@ApiOperation(value = "食物百科列表", notes = "食物百科列表")
	@GetMapping("/FoodBackTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<FoodBackstageDTO>> queryFoodBackTable(Query query) {

		return R.ok(foodLevelService.queryFoodBackTable(Condition.getPage(query)));
	}

	/**
	 * 食物百科审核列表(后台)
	 * @param query
	 * @return R
	 */
	@ApiOperation(value = "食物百科审核列表", notes = "食物百科审核列表")
	@GetMapping("/FoodBackExamineTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<FoodBackstageDTO>>queryFoodBackExamineTable(Query query) {
		return R.ok(foodLevelService.queryFoodBackExamineTable(Condition.getPage(query)));
	}


	/**
	 * 查询食物详情（后台）
	 * @param id
	 * @return R
	 */
	@ApiOperation(value = "根据食物id查食物详情", notes = "根据食物id查食物详情")
	@GetMapping("/FoodDetailsBack/{id}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<FoodBackstageDTO>>queryFoodDetailsBack(@PathVariable("id" ) long id) {
		return R.ok(foodLevelService.queryFoodDetailsBack(id));
	}

	/**
	 * 条件查询食物百科审核后台列表
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param foodName
	 * @param foodUploadAdmin
	 * @return
	 */
	@ApiOperation(value = "条件查询食物百科审核后台(分页)", notes = "条件查询食物后台")
	@GetMapping("/lookConditionFoodBackstage" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R<List<FoodBackstageDTO>> lookConditionFoodBackstage(Query query,LocalDateTime minTime, LocalDateTime maxTime,
													   String foodName, String foodUploadAdmin) {
		return R.ok(foodLevelService.lookConditionFoodBackstage(Condition.getPage(query),minTime,maxTime,foodName,foodUploadAdmin));
	}

	/**
	 * 条件查询食物后台列表(分页)
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param foodName
	 * @param foodExamineAdmin
	 * @return
	 */
	@ApiOperation(value = "条件查询食物后台列表(分页)", notes = "条件查询食物后台列表")
	@GetMapping("/lookConditionFoodTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R<List<FoodBackstageDTO>> lookConditionFoodTable(Query query,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodExamineAdmin) {
		return R.ok(foodLevelService.lookConditionFoodTable(Condition.getPage(query),minTime,maxTime,foodName,foodExamineAdmin));
	}

	/**
	 * 食物百科审核条件查询
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param foodName
	 * @param foodExamineAdmin
	 * @return
	 */
	@ApiOperation(value = "食物百科审核列表条件查询（分页）", notes = "食物百科审核条件查询")
	@GetMapping("/lookConditionAuditFoodTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R<List<FoodBackstageDTO>> lookConditionAuditFoodTable(Query query,LocalDateTime minTime, LocalDateTime maxTime, String foodName, String foodExamineAdmin) {
		return R.ok(foodLevelService.lookConditionAuditFoodTable(Condition.getPage(query),minTime,maxTime,foodName,foodExamineAdmin));
	}


}
