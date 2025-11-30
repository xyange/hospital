

package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmBookattrDTO;
import com.wyzy.hospital.tcm.entity.TcmBookattr;
import com.wyzy.hospital.tcm.service.TcmBookattrService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 医书属性表
 *
 * @author hospital code generator
 * @date 2021-05-20 09:51:02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmbookattr" )
@Api(value = "tcmbookattr", tags = "医书属性表管理")
public class TcmBookattrController {

    private final  TcmBookattrService tcmBookattrService;

    /**
     * 新增医书属性表
     * @param tcmBookattr 医书属性表
     * @return R
     */
    @ApiOperation(value = "新增医书属性表", notes = "新增医书属性表")
    @SysLog("新增医书属性表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmbookattr_add')" )
    public R<Boolean> save(@RequestBody TcmBookattr tcmBookattr) {
		return R.ok(tcmBookattrService.saveBookattr(tcmBookattr));
    }

	/**
	 * 通过id删除医书属性表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除医书属性表", notes = "通过id删除医书属性表")
	@SysLog("通过id删除医书属性表" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmbookattr_del')" )
	public R<Boolean> removeById(@PathVariable Long id) {
		return R.ok(tcmBookattrService.removeById(id));
	}

    /**
     * 修改医书属性表
     * @param tcmBookattr 医书属性表
     * @return R
     */
    @ApiOperation(value = "修改医书属性表", notes = "修改医书属性表")
    @SysLog("修改医书属性表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmbookattr_edit')" )
    public R<Boolean> updateById(@RequestBody TcmBookattr tcmBookattr) {
        return R.ok(tcmBookattrService.updateTcmBookattrById(tcmBookattr));
    }

	/**
	 * 通过id查询医书属性表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmbookattr_view')" )
	public R<TcmBookattr> getById(@PathVariable("id" ) Long id) {
		TcmBookattr byId = tcmBookattrService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询医书属性表
	 * @param name name
	 * @return R
	 */
	@ApiOperation(value = "通过name查询", notes = "通过name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmbookattr_view')" )
	public R<TcmBookattrDTO> selectByName(String name) {
		TcmBookattrDTO tcmBookattrDTO = tcmBookattrService.selectPojoDTOByName(name);
		if (tcmBookattrDTO == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmBookattrDTO);
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmbookattr_view')" )
	public R<IPage<TcmBookattrDTO>> getTcmBookattrPage(Integer type, Query query) {
		return R.ok(tcmBookattrService.Bookattrpage(type, Condition.getPage(query)));
	}

	/**
	 * 查询医书属性列表 1:典籍2学科3流派4作者
	 * @return
	 */
	@ApiOperation(value = "根据类型查询医书属性列表", notes = "根据类型查询医书属性列表")
	@GetMapping("/getByType" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmbookattr_view')" )
	public R<List<TcmBookattrDTO>> getTcmBookattrList(Integer type) {
		List<TcmBookattrDTO> tcmBookattrByType = tcmBookattrService.getTcmBookattrByType(type);
		if (tcmBookattrByType == null || tcmBookattrByType.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmBookattrByType);
	}

}
