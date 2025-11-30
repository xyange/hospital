

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmDiseaseDTO;
import com.wyzy.hospital.tcm.entity.TcmDisease;
import com.wyzy.hospital.tcm.service.TcmDiseaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmdisease" )
@Api(value = "tcmdisease", tags = "中医疾病表管理")
public class TcmDiseaseController {

    private final  TcmDiseaseService tcmDiseaseService;

    /**
     * 新增疾病表
     * @param tcmDisease 疾病表
     * @return R
     */
    @ApiOperation(value = "新增疾病表", notes = "新增疾病表")
    @SysLog("新增疾病表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmdisease_add')" )
    public R<Boolean> save(@RequestBody TcmDisease tcmDisease) {
        return R.ok(tcmDiseaseService.saveTcmDisease(tcmDisease));
    }

	/**
	 * 通过id删除疾病表
	 * @param diseaseId id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除疾病表", notes = "通过id删除疾病表")
	@SysLog("通过id删除疾病表" )
	@DeleteMapping("/{diseaseId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmdisease_del')" )
	public R<Boolean> removeById(@PathVariable Long diseaseId) {
		return R.ok(tcmDiseaseService.removeById(diseaseId));
	}

    /**
     * 修改疾病表
     * @param tcmDisease 疾病表
     * @return R
     */
    @ApiOperation(value = "修改疾病表", notes = "修改疾病表")
    @SysLog("修改疾病表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmdisease_edit')" )
    public R<Boolean> updateById(@RequestBody TcmDisease tcmDisease) {
        return R.ok(tcmDiseaseService.updatePojoById(tcmDisease));
    }

	/**
	 * 通过id查询疾病表
	 * @param diseaseId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{diseaseId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmdisease_view')" )
	public R<TcmDiseaseDTO> getById(@PathVariable("diseaseId" ) Long diseaseId) {
		TcmDiseaseDTO byId = tcmDiseaseService.getById(diseaseId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询疾病表DTO
	 * @param name id
	 * @return R
	 */
	@ApiOperation(value = "通过name查询", notes = "通过name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmdisease_view')" )
	public R<TcmDiseaseDTO> selectTcmDiseaseByName(String name) {
		TcmDiseaseDTO tcmDiseaseDTO = tcmDiseaseService.selectTcmDiseaseDTOByName(name);
		if (tcmDiseaseDTO == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmDiseaseDTO);
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询(上下线)", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmdisease_view')" )
	public R<IPage<TcmDiseaseDTO>> getDiseasePage(Query query) {
		return R.ok(tcmDiseaseService.pageDisease(Condition.getPage(query)));
	}

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "上线/下线疾病详情", notes = "上线/下线疾病详情")
	@SysLog("上线/下线疾病详情" )
	@PutMapping("/goOnlineById")
	@PreAuthorize("@pms.hasPermission('tcm_tcmdisease_edit')" )
	public R<Boolean> goOnlineById(Long diseaseId,Integer isOnline) {
		return R.ok(tcmDiseaseService.goOnlineById(diseaseId,isOnline));
	}
}
