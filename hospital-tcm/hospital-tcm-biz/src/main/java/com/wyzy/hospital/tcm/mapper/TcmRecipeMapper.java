

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:16:31
 */
@Mapper
public interface TcmRecipeMapper extends HospitalBaseMapper<TcmRecipe> {

	/**
	 * 根据父级ID查询方剂表集合列表
	 * @param recipesuperId
	 * @return
	 */
	@Select("SELECT recipe_id,recipesuper_name,recipe_name," +
			"source,compose,usages,functions,Indications," +
			"mechanism,recipe_analysis,compatibility," +
			"characteristic,dialectical_points,taboo_use," +
			"attached_party,identify from tcm_recipe e ," +
			"tcm_recipesuper r where e.is_online = 1 AND  e.recipesuper_id = #{recipesuperId} " +
			"and r.id = e.recipesuper_id ORDER BY recipe_id DESC")
	List<TcmRecipeDTO> selectTcmRecipeByrecipesuperId(@Param("recipesuperId") Long recipesuperId);

	/**
	 * 根据父级ID查询方剂表集合列表
	 * @param recipesuperId
	 * @return
	 */
	List<TcmRecipeDTO> selectAllTcmRecipeByrecipesuperId(@Param("recipesuperId") Long id);

	/**
	 * 通过方剂recipeId查询方剂表
	 * @param recipeId
	 *  @return R
	 */
	@Select("SELECT recipe_id,recipesuper_name,recipe_name," +
			"source,compose,usages,functions,Indications," +
			"mechanism,recipe_analysis,compatibility," +
			"characteristic,dialectical_points,taboo_use," +
			"attached_party,identify from tcm_recipe e ," +
			"tcm_recipesuper r where e.recipe_id = #{recipeId} " +
			"and r.id = e.recipesuper_id ORDER BY recipe_id DESC")
	TcmRecipeDTO getById(@Param("recipeId") Long recipeId);

	/**
	 * 根据名称查询TcmRecipe
	 * @param recipeName
	 * @return
	 */
	TcmRecipe selectTcmRecipeByName(@Param("recipeName") String recipeName);

	/**
	 * 通过name查询方剂表DTO
	 * @param name
	 * @return R
	 */
	TcmRecipeDTO selectTcmRecipeDTOByName(@Param("recipeName") String name);

	/**
	 * 删除
	 * @param recipeId
	 * @return
	 */
	@Delete("delete from tcm_recipe where recipe_id = #{recipeId}")
	int deleteTcmRecipeById(@Param("recipeId") Long recipeId);

	/**
	 * 添加数据+ID
	 * @param tcmRecipe
	 * @return
	 */
	int insertTcmRecipe(@Param("tcmRecipe") TcmRecipe tcmRecipe);

	@Select("select recipe_id,recipesuper_id,recipe_name,source,compose,usages,functions,Indications," +
			"mechanism,recipe_analysis,compatibility,characteristic,dialectical_points,taboo_use," +
			"attached_party,identify,del_flag,create_time,update_time,is_online " +
			"from tcm_recipe where is_online = 1 and del_flag = 0 ORDER BY recipe_id DESC")
	List<TcmRecipe> selectAll();

	/**
	 * 上下线
	 * @param recipeId
	 * @param isOnline
	 * @return
	 */
	int updateTcmRecipeById(@Param("recipeId") Long recipeId,@Param("isOnline") Integer isOnline);

	/**
	 * 分页
	 * @param page
	 * @return
	 */
	List<TcmRecipeDTO> selectAllDTO(IPage<TcmRecipeDTO> page);

	/**
	 * APP分页
	 * @param page
	 * @return
	 */
	List<TcmRecipeDTO> selectAllDTOAPP(IPage<TcmRecipeDTO> page);

	/**
	 * 查看方剂分类下的数量
	 * @param recipesuperId
	 * @return
	 */
	int selectNumberByrecipesuperId(@Param("recipesuperId") Long recipesuperId);

	/**
	 * 修改方剂表
	 * @param tcmRecipe 方剂表
	 * @return R
	 */
	boolean updatePojoById(@Param("tcmRecipe") TcmRecipe tcmRecipe);
}
