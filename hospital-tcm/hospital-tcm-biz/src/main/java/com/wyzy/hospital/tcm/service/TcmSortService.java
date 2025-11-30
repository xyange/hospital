

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.tcm.dto.TcmSortDTO;
import com.wyzy.hospital.tcm.entity.TcmSort;
import com.wyzy.hospital.tcm.vo.TcmSortVO;

import java.util.List;

/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
public interface TcmSortService extends IService<TcmSort> {

	/**
	 * 根据type查询一级分类列表
	 * @param type --类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return
	 */
	List<TcmSortDTO> getTcmSortOneList(Integer type);
	/**
	 * 根据一级分类ID查询二级分类
	 * @param superiorId
	 * @return
	 */
	List<TcmSortDTO> getTcmSortTwoList(Long superiorId);

	/**
	 * 根据一级分类ID查询二级分类列表
	 * @param sortId 类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return
	 */
	List<TcmSort> getTcmSortListBySuperiorId(Long sortId);


	/**
	 * 根据分类ID集合，查询内科学数据表列表
	 * @param list
	 * @return
	 */
	List<TcmSortVO> selectInternalTcmSortVOBySortIdList(List list);

	/**
	 * 根据分类ID集合，查询中药表数据表列表
	 * @param list
	 * @return
	 */
	List<TcmSortVO> selectCmTcmSortVOBySortIdList(List list);

	/**
	 * 根据姓名查询TcmSort
	 * @return
	 */
	TcmSort selectTcmSortByName(String sortName);

	/**
	 * 修改中医模块分类表
	 * @param tcmSort 中医模块分类表
	 * @return R
	 */
	boolean updatePojoById(TcmSort tcmSort);

	/**
	 * 查询所有分页
	 * @param page
	 * @return
	 */
	IPage<TcmSort> pageTcmSort(IPage<TcmSort> page);
}
