package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmMedicalbookDTO;
import com.wyzy.hospital.tcm.entity.TcmMedicalbook;
import com.wyzy.hospital.tcm.service.TcmMedicalbookService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 医书表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:47:50
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmmedicalbook" )
@Api(value = "tcmmedicalbook", tags = "医书表管理")
public class TcmMedicalbookController {

    private final  TcmMedicalbookService tcmMedicalbookService;

    /**
     * 新增医书表
     * @param tcmMedicalbook 医书表
     * @return R
     */
    @ApiOperation(value = "新增医书表", notes = "新增医书表")
    @SysLog("新增医书表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmmedicalbook_add')" )
    public R<Boolean> save(@RequestBody TcmMedicalbook tcmMedicalbook) {
        return R.ok(tcmMedicalbookService.saveTcmMedicalbook(tcmMedicalbook));
    }

	/**
	 * 通过id删除医书表
	 * @param medicalbookId id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除医书表", notes = "通过id删除医书表")
	@SysLog("通过id删除医书表" )
	@DeleteMapping("/{medicalbookId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmedicalbook_del')" )
	public R<Boolean> removeById(@PathVariable Long medicalbookId) {
		return R.ok(tcmMedicalbookService.removeById(medicalbookId));
	}

    /**
     * 修改医书表
     * @param tcmMedicalbook 医书表
     * @return R
     */
    @ApiOperation(value = "修改医书表", notes = "修改医书表")
    @SysLog("修改医书表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmmedicalbook_edit')" )
    public R<Boolean> updateById(@RequestBody TcmMedicalbook tcmMedicalbook) {
        return R.ok(tcmMedicalbookService.updateTcmMedicalbookById(tcmMedicalbook));
    }

	/**
	 * 通过id查询医书表
	 * @param medicalbookId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{medicalbookId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmedicalbook_view')" )
	public R<TcmMedicalbookDTO> getById(@PathVariable("medicalbookId" ) Long medicalbookId) {
		TcmMedicalbookDTO byId = tcmMedicalbookService.getById(medicalbookId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询医书表
	 * @param name name
	 * @return R
	 */
	@ApiOperation(value = "通过name查询", notes = "通过name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmedicalbook_view')" )
	public R<TcmMedicalbookDTO> selectTcmMedicalbookByName(String name) {
		TcmMedicalbook tcmMedicalbook =tcmMedicalbookService.selectTcmMedicalbookByName(name);
		TcmMedicalbookDTO tcmMedicalbookDTO = new TcmMedicalbookDTO();
		BeanUtils.copyProperties(tcmMedicalbook,tcmMedicalbookDTO);
		return R.ok(tcmMedicalbookDTO);
	}

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "上线/下线疾病详情", notes = "上线/下线疾病详情")
	@SysLog("上线/下线疾病详情" )
	@PutMapping("/goOnlineById")
	@PreAuthorize("@pms.hasPermission('tcm_tcmmedicalbook_edit')" )
	public R<Boolean> goOnlineById(Long medicalbookId,Integer isOnline) {
		return R.ok(tcmMedicalbookService.goOnlineById(medicalbookId,isOnline));
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询(上下线)", notes = "分页查询(上下线)")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmmedicalbook_view')" )
	public R<IPage<TcmMedicalbookDTO>> getTcmMedicalbookPage(Query query) {
		return R.ok(tcmMedicalbookService.getTcmMedicalbookPage(Condition.getPage(query)));
	}
}
