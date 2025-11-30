

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.cyclopedia.dto.AddCyDiseasesDTO;
import com.wyzy.hospital.cyclopedia.dto.CyDiseasesDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDiseases;
import com.wyzy.hospital.cyclopedia.kit.AddDiseasesKitService;
import com.wyzy.hospital.cyclopedia.service.CyDiseasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-05-08 14:37:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cydiseases" )
@Api(value = "cydiseases", tags = "疾病表管理")
public class CyDiseasesController {

    private final  CyDiseasesService cyDiseasesService;
    private final AddDiseasesKitService addDiseasesKitService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param cyDiseases 疾病表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
    public R getCyDiseasesPage(Page page, CyDiseases cyDiseases) {
        return R.ok(cyDiseasesService.page(page, Wrappers.query(cyDiseases)));
    }


    /**
     * 通过id查询疾病表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(cyDiseasesService.getById(id));
    }

    /**
     * 新增疾病表
     * @param cyDiseases 疾病表
     * @return R
     */
    @ApiOperation(value = "新增疾病表", notes = "新增疾病表")
    @SysLog("新增疾病表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_add')" )
    public R save(@RequestBody CyDiseases cyDiseases) {
        return R.ok(cyDiseasesService.save(cyDiseases));
    }

    /**
     * 修改疾病表
     * @param cyDiseases 疾病表
     * @return R
     */
    @ApiOperation(value = "修改疾病表", notes = "修改疾病表")
    @SysLog("修改疾病表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_edit')" )
    public R updateById(@RequestBody CyDiseases cyDiseases) {
        return R.ok(cyDiseasesService.updateById(cyDiseases));
    }

    /**
     * 通过id删除疾病表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除疾病表", notes = "通过id删除疾病表")
    @SysLog("通过id删除疾病表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(cyDiseasesService.removeById(id));
    }


	/**
	 * 随机查询9种疾病
	 * @return R
	 */
	@GetMapping("/RandDiseases" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
	public R<List<CyDiseasesDTO>> RandDiseases() {
		return R.ok(cyDiseasesService.queryRandDiseases());
	}

	/**
	 * 查询疾病数量
	 * @return R
	 */
	@GetMapping("/queryNumber" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
	public R QueryNumber() {
		return R.ok(cyDiseasesService.queryNumberEnDiseases());
	}


	/**
	 *百科疾病审核
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "百科疾病审核", notes = "百科疾病审核")
	@GetMapping("/queryCheckDiseases" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
	public R<List<CyDiseasesDTO>> queryCheckDiseases(Query query) {
		return R.ok(cyDiseasesService.queryCheckDiseases(Condition.getPage(query)));
	}

	/**
	 *百科疾病列表
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "百科疾病列表", notes = "百科疾病列表")
	@GetMapping("/queryCyDiseasesTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
	public R<List<CyDiseasesDTO>> queryCyDiseasesTable(Query query) {
		return R.ok(cyDiseasesService.queryCyDiseasesTable(Condition.getPage(query)));
	}

	/**
	 *疾病百科审核列表
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "疾病百科审核列表", notes = "疾病百科审核列表")
	@GetMapping("/queryCyDiseasesCheckTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
	public R<List<CyDiseasesDTO>> queryCyDiseasesCheckTable(Query query) {
		return R.ok(cyDiseasesService.queryCyDiseasesCheckTable(Condition.getPage(query)));
	}

	/**
	 * 通过disId查询疾病表
	 * @param disId disId
	 * @return R
	 */
	@ApiOperation(value = "通过disId查询疾病表", notes = "通过disId查询")
	@GetMapping("/queryCyDiseasesById/{disId}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_view')" )
	public R <List<CyDiseasesDTO>> queryCyDiseasesById(@PathVariable("disId" ) Long disId) {
		return R.ok(cyDiseasesService.queryCyDiseasesById(disId));
	}

	/**
	 * 修改疾病审核状态
	 * @param cyDiseasesDTO
	 * @return
	 */

	@ApiOperation(value = "修改疾病审核状态", notes = "修改疾病审核状态")
	@SysLog("修改疾病审核状态" )
	@PutMapping("/alterDiseasesCheckStruts")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_edit')" )
	public void alterDiseasesCheckStruts(@RequestBody CyDiseasesDTO cyDiseasesDTO) {
		String disCheckStruts=cyDiseasesService.getById(cyDiseasesDTO.getDisId()).getDisCheckStruts();
		cyDiseasesService.alterDiseasesCheckStruts(cyDiseasesDTO.getDisId(),disCheckStruts);
	}

	/**
	 * 重新提交
	 * @param cyDiseasesDTO
	 * @return
	 */

	@ApiOperation(value = "重新提交", notes = "重新提交")
	@SysLog("重新提交" )
	@PutMapping("/alterSubmitDiseasesCheckStruts")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_edit')" )
	public void alterSubmitDiseasesCheckStruts(@RequestBody CyDiseasesDTO cyDiseasesDTO) {
		String disCheckStruts=cyDiseasesService.getById(cyDiseasesDTO.getDisId()).getDisCheckStruts();
		cyDiseasesService.alterSubmitDiseasesCheckStruts(cyDiseasesDTO.getDisId(),disCheckStruts);
	}

	/**
	 * 上线下线
	 * @param cyDiseasesDTO
	 */
	@ApiOperation(value = "上线下线", notes = "上线下线")
	@SysLog("上线下线" )
	@PutMapping("/alterDisExistStruts")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_edit')" )
	public void alterDisExistStruts(@RequestBody CyDiseasesDTO cyDiseasesDTO) {
		String disExistStruts=cyDiseasesService.getById(cyDiseasesDTO.getDisId()).getDisExistStruts();
		cyDiseasesService.alterDisExistStruts(cyDiseasesDTO.getDisId(),disExistStruts);
	}

	/**
	 *添加疾病表
	 * @param addCyDiseasesDTO
	 * @return
	 */
	@ApiOperation(value = "添加疾病表", notes = "添加疾病表")
	@SysLog("添加疾病表" )
	@PostMapping("/addDiseases")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydiseases_add')" )
	public R addDiseases(@RequestBody  AddCyDiseasesDTO addCyDiseasesDTO) {
		return R.ok(addDiseasesKitService.addDiseasesKitService(addCyDiseasesDTO));
	}

	/**
	 * 根据条件查后台疾病列表
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param disName
	 * @param uploadAdmin
	 * @return
	 */
	@ApiOperation(value = "根据条件查后台疾病列表", notes = "根据条件查后台疾病列表")
	@GetMapping("/lookConditionDiseases" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<CyDiseasesDTO>>lookConditionDiseases(Query query,LocalDateTime minTime, LocalDateTime maxTime, String  disName, String uploadAdmin) {
		return R.ok(cyDiseasesService.lookConditionDiseases(Condition.getPage(query),minTime,maxTime,disName,uploadAdmin));
	}

	/**
	 * 疾病百科列表（查询）
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param disName
	 * @param disCheckAdmin
	 * @return
	 */
	@ApiOperation(value = "疾病百科列表（条件查询）", notes = "疾病百科列表（查询）")
	@GetMapping("/lookConditionDiseasesTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<CyDiseasesDTO>>lookConditionDiseasesTable(Query query,LocalDateTime minTime, LocalDateTime maxTime, String  disName, String disCheckAdmin) {
		return R.ok(cyDiseasesService.lookConditionDiseasesTable(Condition.getPage(query),minTime,maxTime,disName,disCheckAdmin));
	}

	/**
	 * 根据条件查后台疾病审核列表
	 * @param query
	 * @param minTime
	 * @param maxTime
	 * @param disName
	 * @param uploadAdmin
	 * @return
	 */
	@ApiOperation(value = "根据条件查后台疾病审核列表", notes = "根据条件查后台疾病审核列表")
	@GetMapping("/looktheCondDisBackTable" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_foodlevel_view')" )
	public R <List<CyDiseasesDTO>>looktheCondDisBackTable(Query query,LocalDateTime minTime, LocalDateTime maxTime, String  disName, String uploadAdmin) {
		return R.ok(cyDiseasesService.looktheCondDisBackTable(Condition.getPage(query),minTime,maxTime,disName,uploadAdmin));
	}

}
