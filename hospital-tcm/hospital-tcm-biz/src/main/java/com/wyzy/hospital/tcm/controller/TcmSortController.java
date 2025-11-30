package com.wyzy.hospital.tcm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.tcm.dto.TcmSortDTO;
import com.wyzy.hospital.tcm.entity.TcmSort;
import com.wyzy.hospital.tcm.kit.TcmSortKitService;
import com.wyzy.hospital.tcm.service.TcmSortService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tcmsort" )
@Api(value = "tcmsort", tags = "中医模块分类表管理")
public class TcmSortController {


    private final  TcmSortService tcmSortService;
	private final TcmSortKitService tcmSortKitService;

	/**
	 * 分页查询
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmsort_view')" )
	public R<IPage<TcmSort>> getTcmSortPage(Query query) {
		return R.ok(tcmSortService.pageTcmSort(Condition.getPage(query)));
	}

    /**
     * 新增中医模块分类表
     * @param tcmSort 中医模块分类表
     * @return R
     */
    @ApiOperation(value = "新增中医模块分类表", notes = "新增中医模块分类表")
    @SysLog("新增中医模块分类表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmsort_add')" )
    public R<Boolean> save(@RequestBody TcmSort tcmSort) {
        return R.ok(tcmSortKitService.saveTcmSort(tcmSort));
    }

	/**
	 * 通过id逻辑删除中医模块分类表
	 * 如果存在下级分类则不可删除
	 * @param sortId id
	 * @return R
	 */
	@ApiOperation(value = "通过id逻辑删除中医模块分类表", notes = "通过id逻辑删除中医模块分类表")
	@SysLog("通过id逻辑删除中医模块分类表" )
	@DeleteMapping("/{sortId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmsort_del')" )
	public R<Boolean> removeById(@PathVariable Long sortId) {
		Boolean flag=tcmSortKitService.removeById(sortId);
		if(flag){
			return R.ok(flag);
		}else{
			return R.failed(flag,"删除失败");
		}

	}


	/**
     * 修改中医模块分类表
     * @param tcmSort 中医模块分类表
     * @return R
     */
    @ApiOperation(value = "修改中医模块分类表", notes = "修改中医模块分类表")
    @SysLog("修改中医模块分类表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('tcm_tcmsort_edit')" )
    public R<Boolean> updateById(@RequestBody TcmSort tcmSort) {
        return R.ok(tcmSortService.updatePojoById(tcmSort));
    }

	/**
	 * 通过id查询中医模块分类表
	 * @param sortId id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{sortId}" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmsort_view')" )
	public R<TcmSort> getById(@PathVariable("sortId" ) Integer sortId) {
		TcmSort byId = tcmSortService.getById(sortId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 通过name查询中医模块分类表
	 * @param name id
	 * @return R
	 */
	@ApiOperation(value = "通过Name查询", notes = "通过Name查询")
	@GetMapping("/name" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmsort_view')" )
	public R<TcmSortDTO> selectTcmSortByName(String name) {
		TcmSort tcmSort = tcmSortService.selectTcmSortByName(name);
		if (tcmSort == null){
			return R.error(CodeMsg.NO_DATA);
		}
		TcmSortDTO tcmSortDTO = new TcmSortDTO();
		BeanUtils.copyProperties(tcmSort,tcmSortDTO);
		return R.ok(tcmSortDTO);
	}


	/**
	 * 根据type查询一级分类列表
	 * 添加二级分类是，需要先选择一级分类
	 * @param type 类型:1 经络分类, 2 中药分类, 3 内科分类表
	 * @return R
	 */
	@ApiOperation(value = "根据type查询一级分类列表", notes = "根据type查询一级分类列表")
	@GetMapping("/tcmSortOneList" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmsort_view')" )
	public R<List<TcmSortDTO>> getTcmSortOneList(Integer type) {
		List<TcmSortDTO> tcmSortOneList = tcmSortService.getTcmSortOneList(type);
		if (tcmSortOneList == null || tcmSortOneList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmSortOneList);
	}

	/**
	 * 根据一级分类ID查询二级分类
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表
	 * superiorId 一级分类ID
	 * @return R
	 */
	@ApiOperation(value = "根据一级分类ID查询二级分类", notes = "根据一级分类ID查询二级分类")
	@GetMapping("/tcmSortTwoList" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmsort_view')" )
	public R<List<TcmSortDTO>> getTcmSortTwoList(Long superiorId) {
		List<TcmSortDTO> tcmSortTwoList = tcmSortService.getTcmSortTwoList(superiorId);
		if (tcmSortTwoList == null || tcmSortTwoList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(tcmSortTwoList);
	}

	/**
	 * 类型
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表
	 * superiorId 一级分类ID
	 * @return R
	 */
	@ApiOperation(value = "类型", notes = "类型")
	@GetMapping("/returnType" )
	@PreAuthorize("@pms.hasPermission('tcm_tcmsort_view')" )
	public R<Map<Integer,String>> returnType() {
		HashMap<Integer,String> map = new HashMap<>();
		map.put(1,"经络分类");
		map.put(2,"中药分类");
		map.put(3,"内科分类");
		return R.ok(map);
	}
}
