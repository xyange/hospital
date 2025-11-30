

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.dto.AddDrugCompanyDTO;
import com.wyzy.hospital.cyclopedia.dto.CyReagentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyReagent;
import com.wyzy.hospital.cyclopedia.kit.AddDrugKitService;
import com.wyzy.hospital.cyclopedia.service.CyReagentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 公司药品表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:37:00
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cyreagent" )
@Api(value = "cyreagent", tags = "公司药品表管理")
public class CyReagentController {

	private final CyReagentService cyReagentService;
	private final AddDrugKitService addDrugKitService;
	/**
	 * 分页查询
	 *
	 * @param page      分页对象
	 * @param cyReagent 公司药品表
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_view')")
	public R getCyReagentPage(Page page, CyReagent cyReagent) {
		return R.ok(cyReagentService.page(page, Wrappers.query(cyReagent)));
	}


	/**
	 * 通过id查询公司药品表
	 *
	 * @param cyReagentId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{cyReagentId}")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_view')")
	public R getById(@PathVariable("cyReagentId") Long cyReagentId) {
		return R.ok(cyReagentService.getById(cyReagentId));
	}

	/**
	 * 新增公司药品表
	 *
	 * @param cyReagent 公司药品表
	 * @return R
	 */
	@ApiOperation(value = "新增公司药品表", notes = "新增公司药品表")
	@SysLog("新增公司药品表")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_add')")
	public R save(@RequestBody CyReagent cyReagent) {
		return R.ok(cyReagentService.save(cyReagent));
	}

	/**
	 * 修改公司药品表
	 *
	 * @param cyReagent 公司药品表
	 * @return R
	 */
	@ApiOperation(value = "修改公司药品表", notes = "修改公司药品表")
	@SysLog("修改公司药品表")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_edit')")
	public R updateById(@RequestBody CyReagent cyReagent) {
		return R.ok(cyReagentService.updateById(cyReagent));
	}

	/**
	 * 通过id删除公司药品表
	 * @param cyReagentId id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除公司药品表", notes = "通过id删除公司药品表")
	@SysLog("通过id删除公司药品表")
	@DeleteMapping("/{cyReagentId}")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_del')")
	public R removeById(@PathVariable Long cyReagentId) {
		return R.ok(cyReagentService.removeById(cyReagentId));
	}

	/**
	 * 通过id查询公司药品表
	 *
	 * @param rid rid
	 * @return R
	 */
	@ApiOperation(value = "通过rid查询", notes = "通过rid查询")
	@GetMapping("/queryCompanyReagenDetails/{rid}")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_view')")
	public R queryCompanyReagenDetails(@PathVariable("rid") Long rid) {
		return R.ok(cyReagentService.queryCompanyReagenDetails(rid));
	}

	/**
	 * 药品的上线下线
	 *
	 * @param cyReagentDTO 公司药品表
	 * @return R
	 */
	@ApiOperation(value = "修改药品的上线下线状态", notes = "修改药品的上线下线状态")
	@SysLog("修改药品的上线下线状态")
	@PutMapping("/updateDrugExitsDtatus")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_edit')")
	public String updateDrugExitsDtatus(@RequestBody CyReagentDTO cyReagentDTO) {
		String existStruts = cyReagentService.getById(cyReagentDTO.getCyReagentId()).getExistStruts();
		String delStruts = cyReagentService.getById(cyReagentDTO.getCyReagentId()).getDelStruts();
		if (delStruts.equals("0")) {
			cyReagentService.movenDrugExitsDtatus(cyReagentDTO.getCyReagentId(), existStruts);
		}
		return "2";
	}

	/**
	 * 修改审核状态
	 * @param cyReagentDTO
	 */
	@ApiOperation(value = "修改审核状态", notes = "修改审核状态")
	@SysLog("修改审核状态" )
	@PutMapping("/DrugAuditDtatus")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_edit')" )
	public void updateStatusById(@RequestBody CyReagentDTO cyReagentDTO) {
		String auditStruts=cyReagentService.getById(cyReagentDTO.getCyReagentId()).getAuditStruts();
		cyReagentService.movenDrugAuditDtatus(cyReagentDTO.getCyReagentId(),auditStruts);
	}

	/**
	 * 未审核通过，重新提交
	 * @param cyReagentDTO
	 */
	@ApiOperation(value = "未审核通过，重新提交", notes = "修改审核状态")
	@SysLog("修改审核状态" )
	@PutMapping("/SubmitDrugAudit")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_edit')" )
	public void ReSubmitDrugAudit(@RequestBody CyReagentDTO cyReagentDTO) {
		String auditStruts=cyReagentService.getById(cyReagentDTO.getCyReagentId()).getAuditStruts();
		cyReagentService.movenReSubmitDrugAudit(cyReagentDTO.getCyReagentId(),auditStruts);
	}

	/**
	 *新增公司药品表
	 * @param addDrugCompanyDTO
	 * @return
	 */
	@ApiOperation(value = "新增公司药品表（后台）", notes = "新增公司药品表")
	@SysLog("新增公司药品表")
	@PostMapping("/addDrug")
	@PreAuthorize("@pms.hasPermission('cyclopedia_cyreagent_add')")
	public R save(@RequestBody AddDrugCompanyDTO addDrugCompanyDTO) {

		return R.ok(addDrugKitService.addDrugKitService(addDrugCompanyDTO));
	}



}
