
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.dto.TcmRecipesuperDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import com.wyzy.hospital.tcm.entity.TcmRecipesuper;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmRecipesuperMapper;
import com.wyzy.hospital.tcm.service.TcmRecipeService;
import com.wyzy.hospital.tcm.service.TcmRecipesuperService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
@Service
@AllArgsConstructor
public class TcmRecipesuperServiceImpl extends ServiceImpl<TcmRecipesuperMapper, TcmRecipesuper> implements TcmRecipesuperService {
	private final TcmRecipeService tcmRecipeService;
	@Override
	public IPage<TcmRecipesuperDTO> getTcmRecipesuperpage(IPage<TcmRecipesuperDTO> page) {
		List<TcmRecipesuperDTO> tcmRecipesuperList =baseMapper.selectAll();
		IPage<TcmRecipesuperDTO> tcmRecipesuperIPage = page.setRecords(tcmRecipesuperList);
		return tcmRecipesuperIPage;
	}

	@Override
	public boolean saveTcmRecipesuper(TcmRecipesuper tcmRecipesuper) {
			TcmRecipesuper recipesuper = baseMapper.selectTcmRecipesuperByName(tcmRecipesuper.getRecipesuperName());
			if (recipesuper != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmRecipesuper);
			if (insert > 0){
				return true;
			}else {
				return false;
			}
	}

	/**
	 * 通过id查询方剂父级表及方剂表集合
	 */
	@Override
	public List<TcmRecipesuperDTO> getTcmRecipesuperList() {
		//查询所有方剂表父级数据
		List<TcmRecipesuper> tcmRecipesuperList = baseMapper.selectAllTcmRecipesuper();
		List<TcmRecipesuperDTO> tcmRecipesuperDTOList = new ArrayList();
		for (TcmRecipesuper tcmRecipesuper:tcmRecipesuperList){
			TcmRecipesuperDTO tcmRecipesuperDTO = new TcmRecipesuperDTO();
			BeanUtils.copyProperties(tcmRecipesuper,tcmRecipesuperDTO);
			tcmRecipesuperDTOList.add(tcmRecipesuperDTO);
		}
		//查询方剂表所有数据
		List<TcmRecipe> recipeList = tcmRecipeService.selectAll();
		if (recipeList == null){
			return tcmRecipesuperDTOList;
		}else {
			for (TcmRecipesuperDTO recipesuperDTO:tcmRecipesuperDTOList){
				Integer number = 0;
				List<TcmRecipeDTO> tcmRecipeDTOList = new ArrayList<>();
				for (TcmRecipe tcmRecipe:recipeList){
					if (tcmRecipe.getRecipesuperId().equals(recipesuperDTO.getId())){
						number++;
						TcmRecipeDTO tcmRecipeDTO = new TcmRecipeDTO();
						BeanUtils.copyProperties(tcmRecipe,tcmRecipeDTO);
						tcmRecipeDTOList.add(tcmRecipeDTO);
					}
				}
				recipesuperDTO.setRecipesuperNumber(number);
				recipesuperDTO.setTcmRecipeDTOList(tcmRecipeDTOList);
			}
		}
		return tcmRecipesuperDTOList;
	}

	/**
	 * 修改方剂父级表
	 * @param tcmRecipesuper 方剂父级表
	 * @return R
	 */
	@Override
	public boolean updatePojoById(TcmRecipesuper tcmRecipesuper) {
		tcmRecipesuper.setDelFlag(0);
		tcmRecipesuper.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		return baseMapper.updatePojoById(tcmRecipesuper);
	}

	/**
	 * 根据姓名查询
	 * @param name
	 * @return
	 */
	@Override
	public TcmRecipesuper selectTcmRecipesuperByName(String name) {
		//查询所有方剂表父级数据
		TcmRecipesuper recipesuper = baseMapper.selectTcmRecipesuperByName(name);
		return recipesuper;
	}
}
