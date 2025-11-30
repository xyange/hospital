

package com.wyzy.hospital.tcm.kit;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;

import java.util.List;

/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-23 11:27:18
 */
public interface TcmRecipeKitService {

	/**
	 * 根据父级ID查询方剂表集合列表，所有
	 * @param recipesuperId
	 * @return
	 */
	List<TcmRecipeDTO> getAllTcmRecipeByrecipesuperId(Long id);
}
