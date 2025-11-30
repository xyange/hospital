
package com.wyzy.hospital.tcm.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import com.wyzy.hospital.tcm.kit.TcmRecipeKitService;
import com.wyzy.hospital.tcm.mapper.TcmRecipeMapper;
import com.wyzy.hospital.tcm.service.TcmRecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-23 11:27:18
 */
@Service
@AllArgsConstructor
public class TcmRecipeKitServiceImpl extends ServiceImpl<TcmRecipeMapper, TcmRecipe> implements TcmRecipeKitService {
	private TcmRecipeService tcmRecipeService;

	/**
	 * 根据父级ID查询方剂表集合列表，所有
	 * @param recipesuperId
	 * @return
	 */
	@Override
	public List<TcmRecipeDTO> getAllTcmRecipeByrecipesuperId(Long id) {
		List<TcmRecipeDTO> tcmRecipeList = tcmRecipeService.selectAllTcmRecipeByrecipesuperId(id);
		if (tcmRecipeList.size() !=0){
			return tcmRecipeList;
		}
		return null;
	}

}
