
package com.wyzy.hospital.tcm.kit.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.dto.TcmRecipesuperDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import com.wyzy.hospital.tcm.entity.TcmRecipesuper;
import com.wyzy.hospital.tcm.kit.TcmRecipeKitService;
import com.wyzy.hospital.tcm.kit.TcmRecipesuperKitService;
import com.wyzy.hospital.tcm.mapper.TcmRecipesuperMapper;
import com.wyzy.hospital.tcm.service.TcmRecipesuperService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
@Service
@AllArgsConstructor
public class TcmRecipesuperKitServiceImpl extends ServiceImpl<TcmRecipesuperMapper, TcmRecipesuper> implements TcmRecipesuperKitService {
	private TcmRecipeKitService tcmRecipeKitService;
	private TcmRecipesuperService tcmRecipesuperService;

	/**
	 * 通过方剂父级id删除方剂父级表
	 * @param id id
	 * @return R
	 */
	@Override
	public boolean removeTcmRecipesuperById(Long id) {

		 /**
		  * 删除父级分类需要先查询是否存在方剂表，如果有不许删除
		 * 通过方剂父级ID查询方剂集合
		 * @param recipesuperId
		 * @return
		 */
		 /*根据父级ID查询方剂表集合列表*/
		List<TcmRecipeDTO> tcmRecipeList = tcmRecipeKitService.getAllTcmRecipeByrecipesuperId(id);
		if (tcmRecipeList == null){
			boolean removeById = tcmRecipesuperService.removeById(id);
			return removeById;
		}else {
			return false;
		}
	}

}
