

package com.wyzy.hospital.tcm.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmRecipesuperDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipesuper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
@Mapper
public interface TcmRecipesuperMapper extends HospitalBaseMapper<TcmRecipesuper> {
	/**
	 * 分页查询所有
	 * @return
	 */
	List<TcmRecipesuperDTO> selectAll();

	TcmRecipesuper selectTcmRecipesuperByName(@Param("recipesuperName") String recipesuperName);

	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	@Delete("delete from tcm_recipesuper where id = #{id}")
	int deleteTcmRecipesuperById(@Param("id") Long id);

	/**
	 * 添加ID
	 * @param tcmRecipesuper
	 * @return
	 */
	int insertTcmRecipesuper(@Param("tcmRecipesuper") TcmRecipesuper tcmRecipesuper);

	@Select("select id,recipesuper_name,introduce,del_flag,create_time,update_time from tcm_recipesuper ORDER BY id DESC")
	List<TcmRecipesuper> selectAllTcmRecipesuper();

	/**
	 * 修改方剂父级表
	 * @param tcmRecipesuper 方剂父级表
	 * @return R
	 */
	boolean updatePojoById(@Param("tcmRecipesuper") TcmRecipesuper tcmRecipesuper);
}
