

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.dto.DiseasesDrugDTO;
import com.wyzy.hospital.cyclopedia.entity.DiseasesDrug;
import com.wyzy.hospital.cyclopedia.service.DiseasesDrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 药品_疾病表
 *
 * @author hospital code generator
 * @date 2021-05-06 09:31:00
 */
@RestController
@AllArgsConstructor
@RequestMapping("/diseasesdrug" )
@Api(value = "diseasesdrug", tags = "药品_疾病表管理")
public class DiseasesDrugController {

    private final  DiseasesDrugService diseasesDrugService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param diseasesDrug 药品_疾病表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_diseasesdrug_view')" )
    public R getDiseasesDrugPage(Page page, DiseasesDrug diseasesDrug) {
        return R.ok(diseasesDrugService.page(page, Wrappers.query(diseasesDrug)));
    }


    /**
     * 通过id查询药品_疾病表
     * @param diseasesDrugId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{diseasesDrugId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_diseasesdrug_view')" )
    public R getById(@PathVariable("diseasesDrugId" ) Long diseasesDrugId) {
        return R.ok(diseasesDrugService.getById(diseasesDrugId));
    }

    /**
     * 新增药品_疾病表
     * @param diseasesDrug 药品_疾病表
     * @return R
     */
    @ApiOperation(value = "新增药品_疾病表", notes = "新增药品_疾病表")
    @SysLog("新增药品_疾病表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_diseasesdrug_add')" )
    public R save(@RequestBody DiseasesDrug diseasesDrug) {
        return R.ok(diseasesDrugService.save(diseasesDrug));
    }

    /**
     * 修改药品_疾病表
     * @param diseasesDrug 药品_疾病表
     * @return R
     */
    @ApiOperation(value = "修改药品_疾病表", notes = "修改药品_疾病表")
    @SysLog("修改药品_疾病表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_diseasesdrug_edit')" )
    public R updateById(@RequestBody DiseasesDrug diseasesDrug) {
        return R.ok(diseasesDrugService.updateById(diseasesDrug));
    }

    /**
     * 通过id删除药品_疾病表
     * @param diseasesDrugId id
     * @return R
     */
    @ApiOperation(value = "通过id删除药品_疾病表", notes = "通过id删除药品_疾病表")
    @SysLog("通过id删除药品_疾病表" )
    @DeleteMapping("/{diseasesDrugId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_diseasesdrug_del')" )
    public R removeById(@PathVariable Long diseasesDrugId) {
        return R.ok(diseasesDrugService.removeById(diseasesDrugId));
    }

	/**
	 * 通过疾病eid查询药品
	 * @param eid eid
	 * @return R
	 */
	@ApiOperation(value = "通过疾病eid查询药品", notes = "通过eid查询")
	@GetMapping("/queryByDiseasesDrug/{eid}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_diseasesdrug_view')" )
	public R <List<DiseasesDrugDTO>> queryByDiseasesDrug(@PathVariable("eid" ) Long eid) {
		return R.ok(diseasesDrugService.queryByDiseasesDrug(eid));
	}



}
