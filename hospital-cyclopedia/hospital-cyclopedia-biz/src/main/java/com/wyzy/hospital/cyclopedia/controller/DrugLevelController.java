

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.cyclopedia.dto.DrugLevelDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugLevel;
import com.wyzy.hospital.cyclopedia.exception.GlobalException;
import com.wyzy.hospital.cyclopedia.mapper.DrugLevelMapper;
import com.wyzy.hospital.cyclopedia.service.DrugLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 药品等级表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/druglevel" )
@Api(value = "druglevel", tags = "药品等级表管理")
public class DrugLevelController {

    private final  DrugLevelService drugLevelService;
    private  final DrugLevelMapper drugLevelMapper;

    /**
     * 分页查询
     * @param page 分页对象
     * @param drugLevel 药品等级表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
    public R getDrugLevelPage(Page page, DrugLevel drugLevel) {
        return R.ok(drugLevelService.page(page, Wrappers.query(drugLevel)));
    }


    /**
     * 通过id查询药品等级表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(drugLevelService.getById(id));
    }

    /**
     * 新增药品等级表
     * @param drugLevel 药品等级表
     * @return R
     */
    @ApiOperation(value = "新增药品等级表", notes = "新增药品等级表")
    @SysLog("新增药品等级表" )
    @PostMapping("/addDrugLevel")
    @PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_add')" )
    public R save(@RequestBody DrugLevel drugLevel) {
		String drugLevelName=drugLevelMapper.selectName(drugLevel.getDrugLevelName());
		if(drugLevelName==null) {
			return R.ok(drugLevelService.save(drugLevel));
		}else {
			throw new GlobalException(CodeMsg.CYCLOPEDIA_DATD_REPEAT);
		}
    }

    /**
     * 修改药品等级表
     * @param drugLevel 药品等级表
     * @return R
     */
    @ApiOperation(value = "修改药品等级表", notes = "修改药品等级表")
    @SysLog("修改药品等级表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_edit')" )
    public R updateById(@RequestBody DrugLevel drugLevel) {
        return R.ok(drugLevelService.updateById(drugLevel));
    }

    /**
     * 通过id删除药品等级表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除药品等级表", notes = "通过id删除药品等级表")
    @SysLog("通过id删除药品等级表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_del')" )
    public R removeById(@PathVariable Long id) {
		int levels=drugLevelMapper.selectById(id).getLevels();
        return R.ok(drugLevelService.movenDrugLevel(id,levels));
    }

	/**
	 * 根据某一级药品查二级药品数量
	 * @return R
	 */
	@ApiOperation(value = "根据某一级药品查二级药品数量", notes = "根据某一级药品查二级药品数量")
	@GetMapping("/getByDrugNumber" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
	public R getByDrugNumber() {
		return R.ok(drugLevelService.queryOneTheDrugNumber());
	}

	/**
	 * 根据一级查药品
	 * @return R
	 */
	@ApiOperation(value = "根据一级查药品", notes = "根据一级查药品")
	@GetMapping("/queryTwoDrug" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
	public R queryTwoDrug() {
		return R.ok(drugLevelService.queryTwoDrug());
	}

	/**
	 * 通过id删除药品一级表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除药品一级表", notes = "通过id删除药品一级表")
	@SysLog("通过id删除药品一级表" )
	@DeleteMapping("/deleteLevsel/{id}/{levels}")
	@PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_del')" )
	public R DeleteLevsel(@PathVariable Long id,@PathVariable Integer levels ) {
		return R.ok (drugLevelService.movenDrugLevel(id, levels));
	}


	/**
	 * 后台药品审核
	 * @return R
	 */
	@ApiOperation(value = "查看后台药品审核", notes = "查看后台药品审核")
	@GetMapping("/queryDrugBackTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
	public R <List<DrugLevelDTO>> queryDrugBackTable(Query query) {
		return R.ok(drugLevelService.queryDrugBackTable(Condition.getPage(query)));
	}

	/**
	 * 通过cyReagentId后台查看药品
	 * @param cyReagentId cyReagentId
	 * @return R
	 */
	@ApiOperation(value = "通过cyReagentId后台查看药品", notes = "通过cyReagentId后台查看药品")
	@GetMapping("/queryBackDrug/{cyReagentId}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
	public R <List<DrugLevelDTO>>queryBackDrug(@PathVariable("cyReagentId" ) Long cyReagentId) {
		return R.ok(drugLevelService.queryBackDrug(cyReagentId));
	}

	/**
	 * 查看百科药品列表
	 * @param query
	 * @return R
	 */
	@ApiOperation(value = "通过cyReagentId查询百科药品列表", notes = "通过cyReagentId查询百科药品列表")
	@GetMapping("/queryBackCyDrug" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
	public R <List<DrugLevelDTO>>queryBackCyDrug(Query query) {
		return R.ok(drugLevelService.queryCyDrugTable(Condition.getPage(query)));
	}


	/**
	 * 后台百科审核列表
	 * 查审核未通过，未删除
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "后台百科审核列表", notes = "后台百科审核列表List")
	@GetMapping("/EncyclopediaAuditTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_druglevel_view')" )
	public R <List<DrugLevelDTO>>queryBackcyclopediaAuditList(Query query)
	{
		return R.ok(drugLevelService.queryDrugEncyclopediaAuditList(Condition.getPage(query)));
	}

	/**
	 * 药品百科审核(条件查询)
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param cyReagentName
	 * @param uploadAdmin
	 * @return
	 */
	@ApiOperation(value = "药品百科审核(条件查询)", notes = "药品百科审核(条件查询)")
	@GetMapping("/lookConditionDrug" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<DrugLevelDTO>>lookConditionDrug(Query query,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String uploadAdmin) {
		return R.ok(drugLevelService.lookConditionDrug(Condition.getPage(query),minTime,maxTime,cyReagentName,uploadAdmin));
	}

	/**
	 * 百科药品列表(条件查询)
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param cyReagentName
	 * @param auditAdmin
	 * @return
	 */
	@ApiOperation(value = "百科药品列表(条件查询)", notes = "百科药品列表(条件查询)")
	@GetMapping("/lookConditionDrugTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<DrugLevelDTO>>lookConditionDrugTable(Query query,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String auditAdmin) {
		return R.ok(drugLevelService.lookConditionDrugTable(Condition.getPage(query),minTime,maxTime,cyReagentName,auditAdmin));
	}

	/**
	 * 药品百科审核列表(条件查询)
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param cyReagentName
	 * @param auditAdmin
	 * @return
	 */
	@ApiOperation(value = "药品百科审核列表(条件查询)", notes = "药品百科审核列表(条件查询)")
	@GetMapping("/lookdrugEncycAuditTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<DrugLevelDTO>>lookdrugEncycAuditTable(Query query,LocalDateTime minTime, LocalDateTime maxTime, String cyReagentName, String auditAdmin) {
		return R.ok(drugLevelService.lookdrugEncycAuditTable(Condition.getPage(query),minTime,maxTime,cyReagentName,auditAdmin));
	}

}
