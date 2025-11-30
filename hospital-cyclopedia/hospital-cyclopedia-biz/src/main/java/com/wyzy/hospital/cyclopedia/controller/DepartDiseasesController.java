

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.cyclopedia.entity.DepartDiseases;
import com.wyzy.hospital.cyclopedia.kit.AddDiseasesKitService;
import com.wyzy.hospital.cyclopedia.service.DepartDiseasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 科室疾病中间表
 *
 * @author hospital code generator
 * @date 2021-05-20 15:12:34
 */
@RestController
@AllArgsConstructor
@RequestMapping("/departdiseases" )
@Api(value = "departdiseases", tags = "科室疾病中间表管理")
public class DepartDiseasesController {

    private final  DepartDiseasesService departDiseasesService;
	private final AddDiseasesKitService addDiseasesKitService;
    /**
     * 分页查询
     * @param page 分页对象
     * @param departDiseases 科室疾病中间表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_departdiseases_view')" )
    public R getDepartDiseasesPage(Page page, DepartDiseases departDiseases) {
        return R.ok(departDiseasesService.page(page, Wrappers.query(departDiseases)));
    }


    /**
     * 通过id查询科室疾病中间表
     * @param departDiseasesId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{departDiseasesId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_departdiseases_view')" )
    public R getById(@PathVariable("departDiseasesId" ) Long departDiseasesId) {
        return R.ok(departDiseasesService.getById(departDiseasesId));
    }

    /**
     * 新增科室疾病中间表
     * @param departDiseases 科室疾病中间表
     * @return R
     */
    @ApiOperation(value = "新增科室疾病中间表", notes = "新增科室疾病中间表")
    @SysLog("新增科室疾病中间表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_departdiseases_add')" )
    public R save(@RequestBody DepartDiseases departDiseases) {
        return R.ok(departDiseasesService.save(departDiseases));
    }

    /**
     * 修改科室疾病中间表
     * @param departDiseases 科室疾病中间表
     * @return R
     */
    @ApiOperation(value = "修改科室疾病中间表", notes = "修改科室疾病中间表")
    @SysLog("修改科室疾病中间表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('cyclopedia_departdiseases_edit')" )
    public R updateById(@RequestBody DepartDiseases departDiseases) {
        return R.ok(departDiseasesService.updateById(departDiseases));
    }

    /**
     * 通过id删除科室疾病中间表
     * @param departDiseasesId id
     * @return R
     */
    @ApiOperation(value = "通过id删除科室疾病中间表", notes = "通过id删除科室疾病中间表")
    @SysLog("通过id删除科室疾病中间表" )
    @DeleteMapping("/{departDiseasesId}" )
    @PreAuthorize("@pms.hasPermission('cyclopedia_departdiseases_del')" )
    public R removeById(@PathVariable Long departDiseasesId) {
        return R.ok(departDiseasesService.removeById(departDiseasesId));
    }

}
