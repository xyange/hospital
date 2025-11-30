

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.entity.EnDiseases;
import com.wyzy.hospital.admin.service.EnArticlesService;
import com.wyzy.hospital.admin.service.EnDiseasesService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:41
 */
@RestController
@AllArgsConstructor
@RequestMapping("/endiseases" )
@Api(value = "endiseases", tags = "疾病表管理")
public class EnDiseasesController {

    private final  EnDiseasesService enDiseasesService;

    private final  EnArticlesService enArticlesService;



    /**
     * 分页查询
     * @param page 分页对象
     * @param enDiseases 疾病表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_endiseases_view')" )
    public R getEnDiseasesPage(Page page, EnDiseases enDiseases) {
        return R.ok(enDiseasesService.page(page, Wrappers.query(enDiseases)));
    }


    /**
     * 通过id查询疾病表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_endiseases_view')" )

    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(enDiseasesService.getById(id));
    }

    /**
     * 新增疾病表
     * @param enDiseases 疾病表
     * @return R
     */
    @ApiOperation(value = "新增疾病表", notes = "新增疾病表")
    @SysLog("新增疾病表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_endiseases_add')" )
    public R save(@RequestBody EnDiseases enDiseases) {
        return R.ok(enDiseasesService.save(enDiseases));
    }

    /**
     * 修改疾病表
     * @param enDiseases 疾病表
     * @return R
     */
    @ApiOperation(value = "修改疾病表", notes = "修改疾病表")
    @SysLog("修改疾病表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_endiseases_edit')" )
    public R updateById(@RequestBody EnDiseases enDiseases) {
        return R.ok(enDiseasesService.updateById(enDiseases));
    }

    /**
     * 通过id删除疾病表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除疾病表", notes = "通过id删除疾病表")
    @SysLog("通过id删除疾病表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_endiseases_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(enDiseasesService.removeById(id));
    }

    /**
     * 通过diseaseName查询疾病表
     * @param diseaseName
     * @return R
     */
    @ApiOperation(value = "通过diseaseName查询", notes = "通过diseaseName查询")
    @GetMapping("/diseaseName/{diseaseName}" )
    @PreAuthorize("@pms.hasPermission('admin_endiseases_view')" )
    public R getById(@PathVariable("diseaseName" ) String diseaseName) {
        String articleName=diseaseName;
        enArticlesService.queryLikeName(articleName);
        return R.ok(enDiseasesService.queryDiseasesAndArticlesByName(diseaseName));
    }


}
