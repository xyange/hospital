package com.wyzy.hospital.admin.controller;
import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDetailsDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomDetails;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.service.PhysicalSymptomDetailsService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * 身体管理症状详情
 *
 * @author hospital code generator
 * @date 2021-06-17 09:19:36
 */
@RestController
@AllArgsConstructor
@RequestMapping("/physicalsymptomdetails" )
@Api(value = "physicalsymptomdetails", tags = "身体管理症状详情管理")
public class PhysicalSymptomDetailsController {

    private final  PhysicalSymptomDetailsService physicalSymptomDetailsService;

    /**
     * 新增身体管理症状详情
     * @param physicalSymptomDetails 身体管理症状详情
     * @return R
     */
    @ApiOperation(value = "新增身体管理症状详情", notes = "新增身体管理症状详情")
    @SysLog("新增身体管理症状详情" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_physicalsymptomdetails_add')" )
    public R<Boolean> save(@RequestBody PhysicalSymptomDetails physicalSymptomDetails) {
        return R.ok(physicalSymptomDetailsService.savePhysicalSymptomDetails(physicalSymptomDetails));
    }

    /**
     * 修改身体管理症状详情
     * @param physicalSymptomDetails 身体管理症状详情
     * @return R
     */
    @ApiOperation(value = "修改身体管理症状详情", notes = "修改身体管理症状详情")
    @SysLog("修改身体管理症状详情" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_physicalsymptomdetails_edit')" )
    public R<Boolean> updateById(@RequestBody PhysicalSymptomDetails physicalSymptomDetails) {
        return R.ok(physicalSymptomDetailsService.updateById(physicalSymptomDetails));
    }

    /**
     * 通过id删除身体管理症状详情
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除身体管理症状详情", notes = "通过id删除身体管理症状详情")
    @SysLog("通过id删除身体管理症状详情" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_physicalsymptomdetails_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(physicalSymptomDetailsService.removeById(id));
    }


    /**
     * 通过symptomId查询身体管理症状详情
     * @param symptomId id
     * @return R
     */
    @ApiOperation(value = "通过symptomId查询", notes = "通过symptomId查询")
    @GetMapping("/symptomId" )
    @PreAuthorize("@pms.hasPermission('admin_physicalsymptomdetails_view')" )
    public R<List<PhysicalSymptomDetailsDTO>> getPhysicalSymptomDetailsBysymptomId(@RequestParam("id") List<Long> symptomId) {
        return R.ok(physicalSymptomDetailsService.getPhysicalSymptomDetailsBysymptomId(symptomId));
    }

    /**
     * 通过id查询身体管理症状详情
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_physicalsymptomdetails_view')" )
    public R<PhysicalSymptomDetails> getById(@PathVariable("id" ) Long id) {
        return R.ok(physicalSymptomDetailsService.getPhysicalSymptomDetailsById(id));
    }
}
