

package com.wyzy.hospital.tcm.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmRecipesuperDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipesuper;

import java.util.List;

/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
public interface TcmRecipesuperService extends IService<TcmRecipesuper> {
	IPage<TcmRecipesuperDTO> getTcmRecipesuperpage(IPage<TcmRecipesuperDTO> page);

	/**
	 * 新增
	 * @param tcmRecipesuper
	 * @return
	 */
	boolean saveTcmRecipesuper(TcmRecipesuper tcmRecipesuper);

	/**
	 * 通过id查询方剂父级表及方剂表集合
	 */
	List<TcmRecipesuperDTO> getTcmRecipesuperList();

	/**
	 * 修改方剂父级表
	 * @param tcmRecipesuper 方剂父级表
	 * @return R
	 */
	boolean updatePojoById(TcmRecipesuper tcmRecipesuper);

	/**
	 * 根据姓名查询
	 * @param name
	 * @return
	 */
	TcmRecipesuper selectTcmRecipesuperByName(String name);
}
