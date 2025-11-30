package com.wyzy.hospital.tcm.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmRecipesuperDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipesuper;
import com.wyzy.hospital.tcm.kit.TcmRecipesuperKitService;
import com.wyzy.hospital.tcm.service.TcmRecipesuperService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmrecipesuper" )
@Api(value = "tcmrecipesuper", tags = "方剂父级表管理")
public class TcmRecipesuperController {

    private final  TcmRecipesuperService tcmRecipesuperService;
	private final TcmRecipesuperKitService tcmRecipesuperKitService;

    /**
     * 新增方剂父级表
     * @param tcmRecipesuper 方剂父级表
     * @return R
     */
    @ApiOperation(value = "新增方剂父级表", notes = "新增方剂父级表")
    @SysLog("新增方剂父级表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmrecipesuper_add')" )
    public R<Boolean> save(@RequestBody  TcmRecipesuper tcmRecipesuper) {
        return R.ok(tcmRecipesuperService.saveTcmRecipesuper(tcmRecipesuper));
    }

	/**
	 * 通过方剂父级id删除方剂父级表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过方剂父级id删除方剂父级表", notes = "通过方剂父级id删除方剂父级表")
	@SysLog("通过方剂父级id删除方剂父级表" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipesuper_del')" )
	public R<Boolean> removeById(@PathVariable Long id) {
		boolean b = tcmRecipesuperKitService.removeTcmRecipesuperById(id);
		if (b){
			return R.ok(b);
		}else {
			return R.failed(b,"删除失败");
		}
	}

    /**
     * 修改方剂父级表
     * @param tcmRecipesuper 方剂父级表
     * @return R
     */
    @ApiOperation(value = "修改方剂父级表", notes = "修改方剂父级表")
    @SysLog("修改方剂父级表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmrecipesuper_edit')" )
    public R<Boolean> updateById(@RequestBody TcmRecipesuper tcmRecipesuper) {
        return R.ok(tcmRecipesuperService.updatePojoById(tcmRecipesuper));
    }

	/**
	 * 通过id查询方剂父级表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipesuper_view')" )
	public R<TcmRecipesuper> getById(@PathVariable("id" ) Long id) {
		TcmRecipesuper byId = tcmRecipesuperService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询方剂父级表
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "通过name查询", notes = "通过name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipesuper_view')" )
	public R<TcmRecipesuperDTO> getTcmRecipesuperByName(String name) {
		TcmRecipesuper tcmRecipesuper = tcmRecipesuperService.selectTcmRecipesuperByName(name);
		if (tcmRecipesuper == null){
			return R.error(CodeMsg.NO_DATA);
		}
		TcmRecipesuperDTO tcmRecipesuperDTO = new TcmRecipesuperDTO();
		BeanUtils.copyProperties(tcmRecipesuper,tcmRecipesuperDTO);
		return R.ok(tcmRecipesuperDTO);
	}

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmrecipesuper_view')" )
	public R<IPage<TcmRecipesuperDTO>> getTcmRecipesuperPage(Query query) {
		return R.ok(tcmRecipesuperService.getTcmRecipesuperpage(Condition.getPage(query)));
	}
}
