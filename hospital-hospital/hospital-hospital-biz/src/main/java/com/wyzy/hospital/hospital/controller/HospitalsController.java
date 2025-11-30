

package com.wyzy.hospital.hospital.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.hospital.dto.HospitalDTO;
import com.wyzy.hospital.hospital.entity.Hospitals;
import com.wyzy.hospital.hospital.service.HospitalsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 医院表
 *
 * @author  aqie
 * @date 2 021-04-10 08:33:26
 */
@RestController
@AllArgsConstructor
@RequestMapping("/hospitals" )
@Api(value = "hospitals", tags = "医院表管理")
public class HospitalsController {

    private final  HospitalsService hospitalsService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param hospitals 医院表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('hospital_hospitals_view')" )
    public R getHospitalsPage(Page page, Hospitals hospitals) {
		LambdaQueryWrapper<Hospitals> likeQuery = new LambdaQueryWrapper<Hospitals>()
				.like(StringUtils.isNotBlank(hospitals.getName()),
						Hospitals::getName, hospitals.getName());
        return R.ok(hospitalsService.page(page, likeQuery));
    }


    /**
     * 通过id查询医院表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('hospital_hospitals_view')" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(hospitalsService.getById(id));
    }

    /**
     * 新增医院表
     * @param hospitals 医院表
     * @return R
     */
    @ApiOperation(value = "新增医院表", notes = "新增医院表")
    @SysLog("新增医院表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('hospital_hospitals_add')" )
    public R save(@RequestBody Hospitals hospitals) {
        return R.ok(hospitalsService.save(hospitals));
    }

    /**
     * 修改医院表
     * @param hospitals 医院表
     * @return R
     */
    @ApiOperation(value = "修改医院表", notes = "修改医院表")
    @SysLog("修改医院表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('hospital_hospitals_edit')" )
    public R updateById(@RequestBody Hospitals hospitals) {
        return R.ok(hospitalsService.updateById(hospitals));
    }

    /**
     * 通过id删除医院表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除医院表", notes = "通过id删除医院表")
    @SysLog("通过id删除医院表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('hospital_hospitals_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(hospitalsService.removeById(id));
    }

	/**
	 * 模糊查询医院
	 * @param name 医院名称
	 * @return R
	 */
	@ApiOperation(value = "根据医院名模糊查询医院", notes = "根据医院名模糊查询医院")
	@GetMapping("/listHospitalsByName" )
	@PreAuthorize("@pms.hasPermission('hospital_hospitals_view')" )
	public R listDepartmentByName(String name){
		return R.ok(hospitalsService.listHospitalsByName(name));
	}

	@GetMapping("/getHospitalsByDepartment" )
	public R<List<HospitalDTO>> getHospitalsByDepartment(){
		return R.ok(hospitalsService.listHospital());
	}

}
