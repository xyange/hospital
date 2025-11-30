

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.PhysicalFitnessDTO;
import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDTO;
import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDetailsDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalFitness;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptomDetails;
import com.wyzy.hospital.admin.kit.impl.PhysicalFitnessKitServiceImpl;
import com.wyzy.hospital.admin.service.PhysicalFitnessService;
import com.wyzy.hospital.admin.service.PhysicalSymptomDetailsService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 身体管理体能
 *
 * @author hospital code generator
 * @date 2021-06-16 15:13:44
 */
@RestController
@AllArgsConstructor
    @RequestMapping("/app/physicalfitness" )
@Api(value = "appphysicalfitness", tags = "app身体管理体能管理")
public class AppPhysicalFitnessController {

    private final  PhysicalFitnessService physicalFitnessService;

    private final PhysicalFitnessKitServiceImpl physicalFitnessKitService;

    private final PhysicalSymptomDetailsService physicalSymptomDetailsService;

    /**
     * 通过id查询身体管理体能
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<PhysicalFitness> getById(@PathVariable("id" ) Long id) {
        PhysicalFitness byId = physicalFitnessService.getById(id);
        return R.ok(byId);
    }

    /**
     * 新增身体管理体能
     * @param physicalFitness 身体管理体能
     * @return R
     */
    @ApiOperation(value = "新增身体管理体能", notes = "新增身体管理体能")
    @SysLog("新增身体管理体能" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R save(@RequestBody PhysicalFitness physicalFitness) {
        return R.ok(physicalFitnessService.save(physicalFitness));
    }

    /**
     * 修改身体管理体能
     * @param physicalFitness 身体管理体能
     * @return R
     */
    @ApiOperation(value = "修改身体管理体能", notes = "修改身体管理体能")
    @SysLog("修改身体管理体能" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R updateById(@RequestBody PhysicalFitness physicalFitness) {
        return R.ok(physicalFitnessService.updateById(physicalFitness));
    }

    /**
     * 通过id删除身体管理体能
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除身体管理体能", notes = "通过id删除身体管理体能")
    @SysLog("通过id删除身体管理体能" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R removeById(@PathVariable Long id) {
        return R.ok(physicalFitnessService.removeById(id));
    }

    /**
     * 通过memberId查询身体管理体能
     * @param memberId id
     * @return R    
     */
    @ApiOperation(value = "通过memberId查询", notes = "通过memberId查询")
    @GetMapping("/memberId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<IPage<PhysicalFitnessDTO>> getByMemberId(Query query, Long memberId) {
        return R.ok(physicalFitnessService.getByMemberId(Condition.getPage(query),memberId));
    }

    /**
    * @Description: 查询症状树
    * @Param: []
    * @return: com.wyzy.hospital.common.core.util.R<java.util.List<com.wyzy.hospital.admin.api.dto.PhysicalSymptomDTO>>
    * @Author: songM
    * @Date: 2021/6/17
    */
    @ApiOperation(value = "查询症状树", notes = "查询症状树")
    @GetMapping("/symptomTree" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<List<PhysicalSymptomDTO>> symptomTree() {
        return R.ok(physicalFitnessKitService.symptomTree());
    }

    /**
     * 通过symptomId查询身体管理症状详情
     * @param symptomId id
     * @return R
     */
    @ApiOperation(value = "通过symptomId查询", notes = "通过symptomId查询")
    @GetMapping("/symptomId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<List<PhysicalSymptomDetailsDTO>> getPhysicalSymptomDetailsBysymptomId(@RequestParam("id") List<Long> symptomId) {
        return R.ok(physicalSymptomDetailsService.getPhysicalSymptomDetailsBysymptomId(symptomId));
    }

    /**
     * 通过id查询身体管理症状详情
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过detailsId查询", notes = "通过detailsId查询")
    @GetMapping("/detailsId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")" )
    public R<PhysicalSymptomDetails> getPhysicalSymptomDetailsById(@PathVariable("id" ) Long id) {
        return R.ok(physicalSymptomDetailsService.getPhysicalSymptomDetailsById(id));
    }
}
