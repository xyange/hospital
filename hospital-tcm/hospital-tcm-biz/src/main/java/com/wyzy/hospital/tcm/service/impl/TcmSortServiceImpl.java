
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.tcm.dto.TcmSortDTO;
import com.wyzy.hospital.tcm.service.TcmSortService;
import com.wyzy.hospital.tcm.entity.TcmSort;
import com.wyzy.hospital.tcm.mapper.TcmSortMapper;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import com.wyzy.hospital.tcm.vo.TcmSortVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
@Service
public class TcmSortServiceImpl extends ServiceImpl<TcmSortMapper, TcmSort> implements TcmSortService {

	/**
	 * 根据type查询一级分类列表
	 * @param type --类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return
	 */
	@Override
	public List<TcmSortDTO> getTcmSortOneList(Integer type) {
		return baseMapper.selectTcmSortOneList(type);
	}
	/**
	 * 根据一级分类ID查询二级分类
	 * @param superiorId
	 * @return
	 */
	@Override
	public List<TcmSortDTO> getTcmSortTwoList(Long superiorId) {
		return baseMapper.selectTcmSortTwoList(superiorId);
	}


	/**
	 * 根据一级分类ID查询二级分类列表
	 * @param sortId
	 * @return
	 */
	@Override
	public List<TcmSort> getTcmSortListBySuperiorId(Long sortId) {
		return baseMapper.selectTcmSortListBySuperiorId(sortId);
	}

	/**
	 * 根据分类ID集合，查询内科学数据表列表
	 * @param list
	 * @return
	 */
	@Override
	public List<TcmSortVO> selectInternalTcmSortVOBySortIdList(List list) {
		return baseMapper.selectInternalTcmSortVOBySortIdList(list);
	}

	/**
	 * 根据分类ID集合，查询中药表数据表列表
	 * @param list
	 * @return
	 */
	@Override
	public List<TcmSortVO> selectCmTcmSortVOBySortIdList(List list) {
		return baseMapper.selectCmTcmSortVOBySortIdList(list);
	}

	/**
	 * 根据姓名查询TcmSort
	 * @return
	 */
	@Override
	public TcmSort selectTcmSortByName(String sortName) {
		TcmSort tcmSort = baseMapper.selectTcmSortByName(sortName);
		return tcmSort;
	}

	/**
	 * 修改中医模块分类表
	 * @param tcmSort 中医模块分类表
	 * @return R
	 */
	@Override
	public boolean updatePojoById(TcmSort tcmSort) {
		tcmSort.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		tcmSort.setDelFlag(0);
		return baseMapper.updatePojoById(tcmSort);
	}

	/**
	 * 查询所有分页
	 * @param page
	 * @return
	 */
	@Override
	public IPage<TcmSort> pageTcmSort(IPage<TcmSort> page) {
		List<TcmSort> tcmSortList = baseMapper.selectTcmSortAll();
		IPage<TcmSort> tcmSortIPage = page.setRecords(tcmSortList);
		return tcmSortIPage;
	}
}
