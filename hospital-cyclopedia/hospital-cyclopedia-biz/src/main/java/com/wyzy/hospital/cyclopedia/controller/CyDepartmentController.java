

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.dto.CyDepartmentDTO;
import com.wyzy.hospital.cyclopedia.dto.CyOneDepartmentDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDepartment;
import com.wyzy.hospital.cyclopedia.exception.GlobalException;
import com.wyzy.hospital.cyclopedia.service.CyDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 百科科室表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:05:20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/cydepartment" )
@Api(value = "cydepartment", tags = "百科科室表管理")
public class CyDepartmentController {

    private final  CyDepartmentService cyDepartmentService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param cyDepartment 百科科室表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_view')" )
    public R getCyDepartmentPage(Page page, CyDepartment cyDepartment) {
        return R.ok(cyDepartmentService.page(page, Wrappers.query(cyDepartment)));
    }


    /**
     * 通过id查询百科科室表
     * @param departmentId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{departmentId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_view')" )
    public R getById(@PathVariable("departmentId" ) Long departmentId) {
        return R.ok(cyDepartmentService.getById(departmentId));
    }

    /**
     * 新增百科科室表
     * @param cyDepartment 百科科室表
     * @return R
     */
    @ApiOperation(value = "新增百科科室表", notes = "新增百科科室表")
    @SysLog("新增百科科室表" )
    @PostMapping("/addDepartment")
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_add')" )
    public R save(@RequestBody CyDepartment cyDepartment) {
		String departmentName = cyDepartmentService.getByName(cyDepartment.getDepartmentName());
        if (departmentName==null) {
			return R.ok(cyDepartmentService.save(cyDepartment));
		}else{
			throw new GlobalException(CodeMsg.CYCLOPEDIA_DATD_REPEAT);
		}
    }

    /**
     * 修改百科科室表
     * @param cyDepartment 百科科室表
     * @return R
     */
    @ApiOperation(value = "修改百科科室表", notes = "修改百科科室表")
    @SysLog("修改百科科室表" )
    @PutMapping("/updateDepartment")
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_edit')" )
    public R updateById(@RequestBody CyDepartment cyDepartment) {
        return R.ok(cyDepartmentService.updateById(cyDepartment));
    }

    /**
     * 通过id删除百科科室表
     * @param departmentId id
     * @return R
     */
    @ApiOperation(value = "通过id删除百科科室表", notes = "通过id删除百科科室表")
    @SysLog("通过id删除百科科室表" )
    @DeleteMapping("/{departmentId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_del')" )
    public R removeById(@PathVariable Long departmentId) {
        return R.ok(cyDepartmentService.removeById(departmentId));
    }

	/**
	 * 查一级科室下二级科室
	 * @param departmentId
	 * @return
	 */
	@ApiOperation(value = "查一级科室下二级科室", notes = "通过departmentId查询")
	@GetMapping("/queryDepartment/{departmentId}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_view')" )
	public R <List<CyOneDepartmentDTO>>queryDepartment(@PathVariable("departmentId" ) Long departmentId) {
		return R.ok(cyDepartmentService.queryDepartmentMapList(departmentId));
	}

	/**
	 * 查一级科室
	 * @return
	 */
	@ApiOperation(value = "查一级科室", notes = "查一级科室")
	@GetMapping("/queryOneDepartment" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_view')" )
	public R <List<CyDepartmentDTO>>queryOneDepartment() {
		return R.ok(cyDepartmentService.queryOneDepartment());
	}


	/**
	 * 根据一级查疾病
	 * @param aid
	 * @return
	 */
	@ApiOperation(value = "根据一级查疾病", notes = "根据一级查疾病")
	@GetMapping("/queryOneDiseases/{aid}" )
	@PreAuthorize("@pms.hasPermission('cyclopedia_cydepartment_view')" )
	public R <List<CyOneDepartmentDTO>> queryOneDiseases(@PathVariable("aid" ) Long aid) {
		return R.ok(cyDepartmentService.queryOneDiseases(aid));
	}
}
