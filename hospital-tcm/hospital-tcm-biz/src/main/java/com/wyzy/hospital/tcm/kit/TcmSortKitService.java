

package com.wyzy.hospital.tcm.kit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmSortDTO;
import com.wyzy.hospital.tcm.entity.TcmSort;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import com.wyzy.hospital.tcm.vo.TcmSortVO;

import java.util.List;

/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
public interface TcmSortKitService {

	/**
	 * 中药：内科学：根据一级分类ID查询二级分类及数据表列表
	 * @param type 类型:1 经络分类, 2 中药分类, 3 内科分类表
	 * @return R
	 */
	List<TcmSortVO> returnSecondaryData(Integer type,Long sortId);

	/**
	 * 通过id逻辑删除中医模块分类表
	 * 如果存在下级分类则不可删除
	 * @param sortId id
	 */
	boolean removeById(Long sortId);


	/**
	 * 新增中医模块分类表
	 * @param tcmSort 中医模块分类表
	 * @return R
	 */
	boolean saveTcmSort(TcmSort tcmSort);

	/**
	 * 根据type查询一级分类列表
	 * @param type --类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return
	 */
	List<TcmSortDTO> getTcmSortOneList(Integer type);

}
