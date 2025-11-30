

package com.wyzy.hospital.tcm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;

import java.util.List;

/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:16:31
 */
public interface TcmRecipeService extends IService<TcmRecipe> {

	/**
	 * 根据父级ID查询方剂表集合列表，下线
	 * @param recipesuperId
	 * @return
	 */
	List<TcmRecipeDTO> selectTcmRecipeByrecipesuperId(Long recipesuperId);
	/**
	 * 根据父级ID查询方剂表集合列表，所有
	 * @param id
	 * @return
	 */
	List<TcmRecipeDTO> selectAllTcmRecipeByrecipesuperId(Long id);

	/**
	 * 通过id查询方剂表
	 * @param recipeId id
	 * @return R
	 */
	TcmRecipeDTO getById(Long recipeId);

	/**
	 * 新增方剂表
	 * @param tcmRecipe 方剂表
	 * @return R
	 */
	boolean saveTcmRecipe(TcmRecipe tcmRecipe);

	/**
	 * 查询方剂表所有数据
	 * @return
	 */
	List<TcmRecipe> selectAll();

	/**
	 * 下线/上线疾病详情
	 * @param
	 * @return R
	 */
	boolean goOnlineById(Long recipeId, Integer isOnline);

	/**
	 * 分页
	 * @param page
	 * @return
	 */
	IPage<TcmRecipeDTO> pageTcmRecipeDTO(IPage<TcmRecipeDTO> page);

	/**
	 * APP分页
	 * @param page
	 * @return
	 */
	IPage<TcmRecipeDTO> pageTcmRecipeDTOAPP(IPage<TcmRecipeDTO> page);

	/**
	 * 修改方剂表
	 * @param tcmRecipe 方剂表
	 * @return R
	 */
	boolean updatePojoById(TcmRecipe tcmRecipe);

	/**
	 * 通过name查询方剂表
	 * @param name id
	 * @return R
	 */
	TcmRecipeDTO selectTcmRecipeDTOByName(String name);
}
