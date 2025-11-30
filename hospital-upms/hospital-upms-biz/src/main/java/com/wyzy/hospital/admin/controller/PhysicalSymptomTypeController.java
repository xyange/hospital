

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomType;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.service.PhysicalSymptomTypeService;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 身体管理症状自查分类
 *
 * @author hospital code generator
 * @date 2021-06-16 17:33:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/physicalsymptomtype" )
@Api(value = "physicalsymptomtype", tags = "身体管理症状自查分类管理")
public class PhysicalSymptomTypeController {

    private final  PhysicalSymptomTypeService physicalSymptomTypeService;

    /**
     * 分页查询
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    //@PreAuthorize("@pms.hasPermission('admin_physicalsymptomtype_view')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<IPage<PhysicalSymptomType>> getPhysicalSymptomTypePage(Query query) {
        return R.ok(physicalSymptomTypeService.pagePhysicalSymptomType(Condition.getPage(query)));
    }


    /**
     * 通过id查询身体管理症状自查分类
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('admin_physicalsymptomtype_view')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(physicalSymptomTypeService.getById(id));
    }

    /**
     * 新增身体管理症状自查分类
     * @param physicalSymptomType 身体管理症状自查分类
     * @return R
     */
    @ApiOperation(value = "新增身体管理症状自查分类", notes = "新增身体管理症状自查分类")
    @SysLog("新增身体管理症状自查分类" )
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('admin_physicalsymptomtype_add')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<Boolean> save(@RequestBody PhysicalSymptomType physicalSymptomType) {
        return R.ok(physicalSymptomTypeService.savePhysicalSymptomType(physicalSymptomType));
    }

    /**
     * 修改身体管理症状自查分类
     * @param physicalSymptomType 身体管理症状自查分类
     * @return R
     */
    @ApiOperation(value = "修改身体管理症状自查分类", notes = "修改身体管理症状自查分类")
    @SysLog("修改身体管理症状自查分类" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('admin_physicalsymptomtype_edit')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R updateById(@RequestBody PhysicalSymptomType physicalSymptomType) {
        return R.ok(physicalSymptomTypeService.updateById(physicalSymptomType));
    }

    /**
     * 通过id删除身体管理症状自查分类
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除身体管理症状自查分类", notes = "通过id删除身体管理症状自查分类")
    @SysLog("通过id删除身体管理症状自查分类" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('admin_physicalsymptomtype_del')" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R removeById(@PathVariable Long id) {
        return R.ok(physicalSymptomTypeService.removeById(id));
    }

}
